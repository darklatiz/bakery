package tech.geekflu.bakery.domain.model;

import tech.geekflu.bakery.domain.model.type.OrderType;
import tech.geekflu.bakery.domain.model.type.StatusType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "item", schema = "bakery")
public class Item {

  @Id
  private Long id;

  @Column(name = "fd_created")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fdCreated;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusType status;

  @Column(name = "order_by")
  private String employee;

  @Column(name = "order_type")
  @Enumerated(EnumType.STRING)
  private OrderType orderType;



}
