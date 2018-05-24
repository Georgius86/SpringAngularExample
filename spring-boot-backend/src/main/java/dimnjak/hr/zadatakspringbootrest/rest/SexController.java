package dimnjak.hr.zadatakspringbootrest.rest;

import dimnjak.hr.zadatakspringbootrest.domain.Sex;
import dimnjak.hr.zadatakspringbootrest.repo.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SexController {

  @Autowired
  SexRepository repository;

  @GetMapping(value="/sex",  produces=MediaType.APPLICATION_JSON_VALUE)
  public List<Sex> getAll() {
    List<Sex> list = new ArrayList<>();
    Iterable<Sex> sexes = repository.findAll();

    sexes.forEach(list::add);
    return list;
  }

  @PostMapping(value="/postsex")
  public Sex postSex(@RequestBody Sex sex) {

    repository.save(new Sex(sex.getName()));
    return sex;
  }

  @GetMapping(value="/findbysex/{name}",  produces=MediaType.APPLICATION_JSON_VALUE)
  public List<Sex> findByName(@PathVariable String name) {

    List<Sex> sexes = repository.findByName(name);
    return sexes;
  }

  @DeleteMapping(value="/sex/{id}")
  public void deleteSex(@PathVariable long id){

    repository.delete(id);
  }
}
