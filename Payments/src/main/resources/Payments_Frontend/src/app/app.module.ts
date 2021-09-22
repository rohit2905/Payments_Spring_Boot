import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import {MatDialogModule} from '@angular/material/dialog';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import {MatIconModule} from '@angular/material/icon'
@NgModule({
  declarations: [
    AppComponent,
    DialogBoxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
  providers: [AppComponent],
  bootstrap: [AppComponent],
  entryComponents:[DialogBoxComponent]
})
export class AppModule { }
