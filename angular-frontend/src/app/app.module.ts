import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {CreateContactComponent} from './create-contact/create-contact.component';
import {ContactsComponent} from './contacts/contacts.component';
import {DeleteContactComponent} from './delete-contact/delete-contact.component';
// import {SearchContactComponent} from './search-contacts/search-contacts.component';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {DataService} from './data.service';


@NgModule({
  declarations: [
    AppComponent,
    CreateContactComponent,
    ContactsComponent,
    DeleteContactComponent,
   // SearchContactComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
