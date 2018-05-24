package dimnjak.hr.zadatakspringbootrest.repo;

import dimnjak.hr.zadatakspringbootrest.domain.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
  List<City>findByNameAndZipCode(String name, String zipCode);
}
