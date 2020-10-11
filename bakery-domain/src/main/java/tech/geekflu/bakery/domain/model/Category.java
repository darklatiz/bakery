package tech.geekflu.bakery.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "bakery", name = "category")
public class Category {
  @Id
  private Long id;
  @Column
  private String name;
  @Column
  private boolean isActive;
}
