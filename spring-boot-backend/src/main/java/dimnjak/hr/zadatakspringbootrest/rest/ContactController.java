package dimnjak.hr.zadatakspringbootrest.rest;

import dimnjak.hr.zadatakspringbootrest.domain.Contact;
import dimnjak.hr.zadatakspringbootrest.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController {

  @Autowired
  ContactRepository repository;

  @GetMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
  @Transactional
  public List<Contact> getAll(){
    List<Contact> list = new ArrayList<>();
    Iterable<Contact> contacts = repository.findAll();

    contacts.forEach(list::add);
      return list;
  }

  @PostMapping(value = "/postcontact")
  public Contact postContact(@RequestBody Contact contact){
    repository.save(new Contact(contact.getFirstName(),contact.getLastName(),contact.getPhone(),contact.getEmail(),contact.getSex(),contact.getAddress()));
    return contact;
  }

  @GetMapping(value = "/findbylastname/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Contact> findByLastName(@PathVariable String lastName){
    List<Contact> contacts = repository.findByLastName(lastName);
    return contacts;
  }

  @DeleteMapping(value = "/contact/{id}")
  public void deleteContact(@PathVariable long id){
    repository.delete(id);
  }
}
