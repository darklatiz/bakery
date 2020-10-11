package tech.geekflu.bakery.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "item", schema = "bakery")
public class Item {

  @Id
  private Long id;
  @Column
  private String name;
  @Column
  private String description;
  @Column
  private float price;
  @Column
  private String image;
  @Column
  private boolean isActive;
  @Transient
  private Category category;


}
