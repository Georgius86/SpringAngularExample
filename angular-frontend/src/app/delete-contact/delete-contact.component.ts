


import {DataService} from '../data.service';
import {Component, Input} from '@angular/core';
import {Contact} from '../model/contact';

@Component({
  template: '<div></div>',
  providers: [DataService]
})

export class  DeleteContactComponent{

  @Input() contact: Contact;

  constructor(private dataService: DataService){}

  delete(): void{
    this.dataService.delete(this.contact.id).then(() => this.goBack());
  }

  private goBack() {
    window.location.replace('');
  }
}
