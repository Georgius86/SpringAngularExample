package dimnjak.hr.zadatakspringbootrest.repo;

import dimnjak.hr.zadatakspringbootrest.domain.Sex;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SexRepository extends CrudRepository<Sex, Long> {
  List<Sex> findByName(String name);
}
