package dimnjak.hr.zadatakspringbootrest.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "sex")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@EqualsAndHashCode
public class Sex implements Serializable {

  //variable definitions
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "sex", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  //@JsonManagedReference
  @JsonIgnore
  private Set<Contact> contacts;

  //Constructor
  protected Sex() {
  }

  //public constructor
  public Sex(String name) {
    this.name = name;
  }


}
