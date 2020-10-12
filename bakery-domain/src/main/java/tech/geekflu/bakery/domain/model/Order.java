package tech.geekflu.bakery.domain.model;

import tech.geekflu.bakery.domain.model.type.OrderType;
import tech.geekflu.bakery.domain.model.type.StatusType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order", schema = "bakery")
public class Order {

  @Id
  private Long id;

  @Column
  private String name;

  @Column
  private BigDecimal total;

  @Column(name = "tax_percentage")
  private BigDecimal taxPercentage;

  @Column(name = "tax_amount")
  private BigDecimal taxAmount;

  @Column(name = "fd_ordered")
  private Date fdOrdered;

  @Column(name = "order_type")
  @Enumerated(EnumType.ORDINAL)
  private OrderType orderType;

  @Column(name = "status")
  @Enumerated(EnumType.ORDINAL)
  private StatusType statusType;

  @Column(name = "reason_status")
  private String comments;

}
