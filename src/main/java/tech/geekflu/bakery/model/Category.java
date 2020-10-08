package tech.geekflu.bakery.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Category {
  private Long id;
  private String name;
  private boolean isActive;

}
