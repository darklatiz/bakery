package tech.geekflu.bakery.domain.model.type;

import lombok.Getter;

@Getter
public enum StatusType {
  ORDERED("Ordered"), IN_PROCESS("In Process"), CANCEL("Cancel"), FINISHED("Finished");

  private String status;

  StatusType(String status) {
    this.status = status;
  }
}
