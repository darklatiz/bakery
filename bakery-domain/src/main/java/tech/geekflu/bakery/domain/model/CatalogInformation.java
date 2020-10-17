package tech.geekflu.bakery.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.geekflu.bakery.domain.model.type.UOM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalog_information", schema = "bakery")
public class CatalogInformation {
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
  @Enumerated(EnumType.STRING)
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
