package dimnjak.hr.zadatakspringbootrest.rest;

import dimnjak.hr.zadatakspringbootrest.domain.Country;
import dimnjak.hr.zadatakspringbootrest.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CountryController {

  @Autowired
  CountryRepository repository;

  @GetMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Country> getAll(){
    List<Country> list = new ArrayList<>();
    Iterable<Country> countries = repository.findAll();

    countries.forEach(list::add);
      return list;

  }

  @PostMapping(value = "/postcountry")
  public Country postCountry(@RequestBody Country country){
    repository.save(new Country(country.getName(),country.getAlpha2(),country.getAlpha2()));
    return country;
  }

  @GetMapping(value = "/findbyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Country> findByName(@PathVariable String name){
    List<Country> countries = repository.findByName(name);
    return countries;
  }

  @DeleteMapping(value = "/country/{id}")
  public void deleteCountry(@PathVariable Long id){
    repository.delete(id);
  }
}
