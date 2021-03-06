package dimnjak.hr.zadatakspringbootrest.repo;

import dimnjak.hr.zadatakspringbootrest.domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
  List<Country> findByName(String name);
}
