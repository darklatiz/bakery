package tech.geekflu.bakery.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tech.geekflu.bakery.domain.model.type.OrderType;
import tech.geekflu.bakery.domain.model.type.StatusType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
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
  @Enumerated(EnumType.STRING)
  private OrderType orderType;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusType statusType;

  @Column(name = "reason_status")
  private String comments;

  @Column
  private int quantityOrdered;

  @OneToMany(mappedBy = "order")
  private List<Item> items;

}
