import {Component, OnInit} from '@angular/core';
// import {SearchContactComponent} from './search-contacts/search-contacts.component';
import {Contact} from './model/contact';
import {DataService} from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent /*implements OnInit*/ {
  title = 'app';
  display = 'none';
  /*lastName: string;
  contacts: Contact[];
  constructor(private dataService: DataService) {
  }*/
/*
  onCloseHandled() {
    this.display = 'none';
  }

  openModal() {
    this.display = 'block';
  }


  ngOnInit() {
    this.lastName = '';
  }
// umjesto u search-contacts.componenent.ts ovdje sam stavio searchContacts()
  private searchContacts() {
    this.dataService.getContactsByLastName(this.lastName).then(contacts => this.contacts = contacts);
  }

  onSubmit() {
    this.searchContacts();
  } */
}
