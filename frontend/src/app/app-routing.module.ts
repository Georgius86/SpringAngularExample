import {RouterModule, Routes} from '@angular/router';
import {ContactsComponent} from './contacts/contacts.component';
import {CreateContactComponent} from './create-contact/create-contact.component';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {SearchContactComponent} from "./search-contacts/search-contacts.component";


const routes: Routes =  [
  {path: '', redirectTo: 'contact', pathMatch: 'full'},
  {path: 'contact', component: ContactsComponent},
  {path: 'findbylastname', component: SearchContactComponent},
  {path: 'add', component: CreateContactComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
