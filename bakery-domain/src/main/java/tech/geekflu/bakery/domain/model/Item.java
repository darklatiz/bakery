package tech.geekflu.bakery.domain.model;

import lombok.*;
import tech.geekflu.bakery.domain.model.type.UOM;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalog_information", schema = "bakery")
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
  @Enumerated(EnumType.ORDINAL)
  private UOM uom;
  @Column
  private float weight;
  @Column
  private int quantityAvailable;
  @Column
  private Date fdAdded;
  @Transient
  private Category category;
}
