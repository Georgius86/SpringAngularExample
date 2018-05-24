package dimnjak.hr.zadatakspringbootrest.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

  @Data
  @Entity
  @Table(name = "contact")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @EqualsAndHashCode(exclude = {"sex", "address"})
  public class Contact implements Serializable{

    //variable definitions
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sex_id")
    //@JsonBackReference
    private Sex sex;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    //@JsonBackReference
    private Address address;

    //protected contructor
    protected Contact(){
    }

    //public Constructor
    public Contact(String firstName, String lastName, String phone, String email, Sex sex, Address address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.email = email;
      this.sex = sex;
      this.address = address;
    }

    //toString method

  }
