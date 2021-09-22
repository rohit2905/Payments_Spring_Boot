package com.payments.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.beans.SDN;

@Repository
public interface SDNRepo extends JpaRepository<SDN, String> {

}
