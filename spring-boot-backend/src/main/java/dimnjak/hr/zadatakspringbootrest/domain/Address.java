package dimnjak.hr.zadatakspringbootrest.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "address")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EqualsAndHashCode(exclude = {"city"})
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "street")
  private String street;

  @Column(name = "street_no")
  private String  streetNo;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "city_id")
  //@JsonBackReference
  private City city;

  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  //@JsonManagedReference
  @JsonIgnore
  private Set<Contact> contacts;

  protected Address(){
  }

  public Address(String street, String streetNo, City city) {
    this.street = street;
    this.streetNo = streetNo;
    this.city = city;
  }

}
