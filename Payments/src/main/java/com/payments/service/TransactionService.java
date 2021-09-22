package com.payments.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.beans.Customer;
import com.payments.beans.MessageResponse;
import com.payments.beans.SDN;
import com.payments.beans.Transaction;
import com.payments.dao.TransactionRepo;


@Service
public class TransactionService implements ITransactionService {
	
	@Autowired
	TransactionRepo transactionRepo;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ISDN sdnService;
	
	@Override
	public MessageResponse addTransaction(Transaction transaction)
	{
		
		//Creating a new transaction record
		Transaction t =  new Transaction();
		
		//Checking for invalid submissions
		if(transaction.getAcc_no()==0)
		{
			return new MessageResponse("Transaction REJECTED","Provide Your Account Number");
		}
		if(transaction.getBIC().isEmpty())
		{
			return new MessageResponse("Transaction REJECTED"," Invalid BIC");
		}
		if(transaction.getReceiver_name().isEmpty())
		{
			return new MessageResponse("Transaction REJECTED","Provide Receiver Name");
		}
		if(transaction.getReceiver_acc_no()==0)
		{
			return new MessageResponse("Transaction REJECTED","Enter Receiver Account Number");
		}
		if(transaction.getTransaction_type().isEmpty())
		{
			return new MessageResponse("Transaction REJECTED"," Wrong Transaction Type");
		}
		if(transaction.getMessage_code().isEmpty())
		{
			return new MessageResponse("Transaction - REJECTED"," Wrong Transaction Type");
		}
		if(transaction.getAmount()==0)
		{
			return new MessageResponse("Transaction - REJECTED"," Enter Amount");
		}
		
		
		//Referencing the sender (customer)
		Customer sender = customerService.findByAccNo(transaction.getAcc_no());
		
		//calculating the transaction fee
		long amount=transaction.getAmount();
		long transfer_fee=(long) (amount*0.25);
		
		if(amount > sender.getCredit_balance() && sender.getOverdraft().equalsIgnoreCase("no"))
		{
			return new MessageResponse("Transaction - REJECTED"," Amount Not Available");
		}
		
		
		
		
		//Checking name with SDN List
		List<SDN> sname = sdnService.getNames();
		List<String> sdn_name=new ArrayList<String>(); 
		for(SDN n: sname) {
			String[] st=n.getSdn_name().split(",");
			sdn_name.add(st[0].trim());
			if(st.length==2)
			sdn_name.add(st[1].trim());
		}
		Collections.sort(sdn_name);
		List<Double> accuracy=new ArrayList<Double>();
		for(int i=0;i<sdn_name.size();i++) {
			 accuracy.add(jaro_Winkler(sdn_name.get(i).replace("BANK", ""),transaction.getReceiver_name().toUpperCase()));
			//System.out.println("*****************************"+(accuracy).get(i)+"***********");	
		}
		if(Collections.max(accuracy)> 0.83) {
			System.out.println("*************in if****************"+Collections.max(accuracy)+"***********");
			return new MessageResponse("Transaction REJECT","Sanction Screening");
		}
		
		
		
		
		
		//Date and Time of Transaction
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   t.setT_Date(dtf.format(now));
		 
		
		
		
		
		
		//setting the transaction data received from form (front-end)
		t.setAmount(amount);
		t.setTransaction_fee(transfer_fee);
		
		//deducting sender balance
		sender.setCredit_balance(sender.getCredit_balance()-(transfer_fee+amount));
		
		//saving senders account 
		customerService.updateCustomer(sender, sender.getacc_no());
		
		//transaction record 
		t.setAcc_no(sender.getacc_no());
		t.setReceiver_acc_no(transaction.getReceiver_acc_no());
		t.setTransaction_type(transaction.getTransaction_type());
		t.setBIC(transaction.getBIC());
		t.setMessage_code(transaction.getMessage_code());
		t.setReceiver_name(transaction.getReceiver_name());
		t.setAmount(amount);
		
		//saving the transaction record in database
		 transactionRepo.save(t);
		 
		 //success response to front-end
		 return new MessageResponse("Transaction Accepted","Transaction ID: "+t.getTransaction_id());
		
	}
	@Override
	public Transaction findById(int id)
	{
		return transactionRepo.getById(id);
	}
	
	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return transactionRepo.findAll();	
		}



	@Override
	public Transaction updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepo.save(transaction);
	}
	
	//Jaro-Wrinkler Algorithm for name search
	
	public static double jaro_distance(String s1, String s2)
	{
		// If the Strings are equal
		if (s1 == s2)
			return 1.0;

		// Length of two Strings
		int len1 = s1.length(),
			len2 = s2.length();

		// Maximum distance upto which matching
		// is allowed
		int max_dist = (int) (Math.floor(Math.max(len1, len2) / 2) - 1);

		// Count of matches
		int match = 0;

		// Hash for matches
		int hash_s1[] = new int[s1.length()];
		int hash_s2[] = new int[s2.length()];

		// Traverse through the first String
		for (int i = 0; i < len1; i++)
		{

			// Check if there is any matches
			for (int j = Math.max(0, i - max_dist);
				j < Math.min(len2, i + max_dist + 1); j++)

				// If there is a match
				if (s1.charAt(i) == s2.charAt(j) && hash_s2[j] == 0)
				{
					hash_s1[i] = 1;
					hash_s2[j] = 1;
					match++;
					break;
				}
		}

		// If there is no match
		if (match == 0)
			return 0.0;

		// Number of transpositions
		double t = 0;

		int point = 0;

		// Count number of occurrences
		// where two characters match but
		// there is a third matched character
		// in between the indices
		for (int i = 0; i < len1; i++)
			if (hash_s1[i] == 1)
			{

				// Find the next matched character
				// in second String
				while (hash_s2[point] == 0)
					point++;

				if (s1.charAt(i) != s2.charAt(point++) )
					t++;
			}

		t /= 2;

		// Return the Jaro Similarity
		return (((double)match) / ((double)len1)
				+ ((double)match) / ((double)len2)
				+ ((double)match - t) / ((double)match))
			/ 3.0;
	}
	
	static double jaro_Winkler(String s1, String s2)
    {
        double jaro_dist = jaro_distance(s1, s2);
     
        // If the jaro Similarity is above a threshold
        if (jaro_dist > 0.90)
        {
     
            // Find the length of common prefix
            int prefix = 0;
     
            for (int i = 0;
                i < Math.min(s1.length(), s2.length()); i++)
            {
                 
                // If the characters match
                if (s1.charAt(i) == s2.charAt(i))
                    prefix++;
     
                // Else break
                else
                    break;
            }
     
            // Maximum of 4 characters are allowed in prefix
            prefix = Math.min(4, prefix);
     
            // Calculate jaro winkler Similarity
            jaro_dist += 0.1 * prefix * (1 - jaro_dist);
        }
        return jaro_dist;
    }


}
