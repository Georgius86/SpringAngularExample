package dimnjak.hr.zadatakspringbootrest.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "country")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Country implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "alpha_2")
  private String alpha2;

  @Column(name = "alpha_3")
  private  String alpha3;

  @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
  //@JsonManagedReference
  @JsonIgnore
  private Set<City> cities;

  protected Country(){

  }

  public Country(String name, String alpha2, String alpha3) {
    this.name = name;
    this.alpha2 = alpha2;
    this.alpha3 = alpha3;
  }

}
