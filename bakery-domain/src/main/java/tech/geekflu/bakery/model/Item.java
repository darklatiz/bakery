package tech.geekflu.bakery.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {

  private Long id;
  private String name;
  private String description;
  private float price;
  private String image;
  private boolean isActive;
  private Category category;


}
