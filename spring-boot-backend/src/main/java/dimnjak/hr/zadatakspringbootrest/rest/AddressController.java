package dimnjak.hr.zadatakspringbootrest.rest;

import dimnjak.hr.zadatakspringbootrest.domain.Address;
import dimnjak.hr.zadatakspringbootrest.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

  @Autowired
  AddressRepository repository;

  @GetMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Address> getAll() {
    return repository.findAll();
  }

  @PostMapping(value = "/postaddress")
  public Address postAddress(@RequestBody Address address) {
    repository.save(address);
    return address;
  }

  @GetMapping(value = "/findbystreet/{street}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Address> findByStreetAndStreetNo(@PathVariable String street, @PathVariable String streetNo) {
    List<Address> addresses = repository.findByStreetAndStreetNo(street, streetNo);
    return addresses;
  }

  @DeleteMapping(value = "/address/{id}")
  public void deleteAddress(@PathVariable long id) {
    repository.delete(id);
  }
}
