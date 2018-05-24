package dimnjak.hr.zadatakspringbootrest.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "city")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EqualsAndHashCode(exclude = {"country"})
public class City implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "zip_code")
  private String zipCode;


  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "country_id")
  //@JsonBackReference
  private Country country;

  @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
 //@JsonManagedReference
  @JsonIgnore
  private Set<Address> addresses;

  protected City(){

  }

  public City(String name, String zipCode, Country country) {
    this.name = name;
    this.zipCode = zipCode;
    this.country = country;
  }

}
