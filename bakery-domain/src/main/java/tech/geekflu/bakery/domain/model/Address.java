package tech.geekflu.bakery.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Entity
@Table(name = "address", schema = "bakery")
public class Address {

  @Id
  private Long id;

  @Column(name = "address_1")
  private String address1;

  @Column(name = "address_2")
  private String address2;

  @Column
  private String zip;

  @Column
  private String city;

  @Column
  private String state;
}
