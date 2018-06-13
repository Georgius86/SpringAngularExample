import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, } from '@angular/common/http';

//import 'rxjs/add/operator/toPromise';

//mport 'rxjs/add/operator/catch';
//import 'rxjs/add/observable/throw';


import {Contact} from './model/contact';
import {Address} from './model/address';
import {Sex} from './model/sex';
import {City} from './model/city';
import {Country} from './model/country';
// import {HttpClient} from '@angular/common/http';


@Injectable()
export class DataService {

  private contactsUrl = '/contact';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private httpClient: HttpClient) { }

  // Get all contacts
  getContacts(): Promise<Contact[]> {
    return this.httpClient.get(this.contactsUrl)
      .toPromise()
      .then(response => response as Contact[])
      .catch(this.handleError);
  }

  getContactsByLastName(lastName: string): Promise<Contact[]> {
    const url = `findbylastname/${lastName}`;
    return this.httpClient.get(url).toPromise()
      .then(response => response as Contact)
      .catch(this.handleError);
  }

  create (contact: Contact): Promise<Contact> {
    return this.httpClient.post('postcontact', JSON.stringify(contact), { headers : this.headers})
      .toPromise()
      .then(res => res as Contact)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
  const url = `${this.contactsUrl}/${id}`;
  return this.httpClient.delete(url, {headers: this.headers})
    .toPromise()
    .then(() => null)
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Error');
    return Promise.reject(error.message || error);
 }

}
