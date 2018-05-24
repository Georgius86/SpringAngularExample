package dimnjak.hr.zadatakspringbootrest.rest;

import dimnjak.hr.zadatakspringbootrest.domain.City;
import dimnjak.hr.zadatakspringbootrest.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

  @Autowired
  CityRepository repository;

  @GetMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<City>getAll(){
    List<City> list = new ArrayList<>();
    Iterable<City> cities = repository.findAll();

      cities.forEach(list::add);
      return  list;
  }

  @PostMapping(value = "/postcity")
  public City postCity(@RequestBody City city){
    repository.save(new City(city.getName(),city.getZipCode(),city.getCountry()));
    return city;
  }

  @GetMapping(value = "/findbycity/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<City> findByNameAndZipCode(@PathVariable String name, @PathVariable String zipCode){
    List<City>cities = repository.findByNameAndZipCode(name, zipCode);
    return cities;
  }

  @DeleteMapping(value = "/city/{id}")
  public void deleteCity(@PathVariable long id){
    repository.delete(id);
  }
}
