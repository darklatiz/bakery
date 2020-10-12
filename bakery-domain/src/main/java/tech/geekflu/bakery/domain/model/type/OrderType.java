package tech.geekflu.bakery.domain.model.type;

import lombok.Getter;

@Getter
public enum OrderType {
  TAKE_OUT("Take Out"), TAKE_IN("Take In"), UBER_EATS("Uber Eats"), DOOR_DASH("Door Dash");

  private String description;

  OrderType(String desc) {
    this.description = desc;
  }
}
