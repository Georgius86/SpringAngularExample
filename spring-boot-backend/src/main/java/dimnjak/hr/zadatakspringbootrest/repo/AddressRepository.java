package dimnjak.hr.zadatakspringbootrest.repo;

import dimnjak.hr.zadatakspringbootrest.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findByStreetAndStreetNo(String street, String streetNo);
}
