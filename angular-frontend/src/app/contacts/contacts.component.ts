import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {DataService} from '../data.service';

@Component({
  selector: 'app-contacts-list',
  templateUrl: './contacts.component.html'
})

export class ContactsComponent implements OnInit {

  contacts: Contact[];
  selectedContact: Contact;


  constructor(private dataService: DataService) {

  }

  getContacts() {
    this.dataService.getContacts().then(contacts => this.contacts = contacts);
  }


  ngOnInit(): void {
    this.getContacts();
  }

  onSelect(cont: Contact): void {
    this.selectedContact = cont;
  }
}
