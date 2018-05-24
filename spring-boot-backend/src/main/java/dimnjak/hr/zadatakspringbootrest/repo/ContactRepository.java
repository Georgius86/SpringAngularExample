package dimnjak.hr.zadatakspringbootrest.repo;

import dimnjak.hr.zadatakspringbootrest.domain.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long>{
  List<Contact> findByLastName(String lastName);
}
