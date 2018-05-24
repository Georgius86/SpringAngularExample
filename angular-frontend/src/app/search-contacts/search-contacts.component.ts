/*

import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {DataService} from '../data.service';

  @Component ({
  selector: 'app-search-contacts',
  templateUrl: './search-contacts.component.html'
})

export class SearchContactComponent implements OnInit {
    lastName: string;
    contacts: Contact[];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.lastName = '';
  }

  private searchContacts() {
    this.dataService.getContactsByLastName(this.lastName).then(contacts => this.contacts = contacts);
  }

  onSubmit() {
    this.searchContacts();
  }
}
 */
