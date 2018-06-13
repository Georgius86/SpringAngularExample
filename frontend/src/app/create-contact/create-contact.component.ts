
import {Component, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {DataService} from '../data.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-create-contact',
  templateUrl: 'create-contact.component.html'
})

export class CreateContactComponent implements OnInit {
  contact = new Contact;
  submitted = false;
  constructor(private dataService: DataService,
              private location: Location) {}

              ngOnInit() {}

              newContact(): void {
    this.submitted = false;
    this.contact = new Contact();
              }

              private save(): void {
    this.dataService.create(this.contact);
              }

              onSubmit() {
    this.submitted = true;
    this.save();
              }

              goBack(): void {
    this.location.back();
              }
}
