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
@Table(name = "client", schema = "bakery")
public class Client {

  @Id
  private Long id;

  @Column
  private String fullName;

  @Column
  private String email;

  @Column
  private String comments;

}
