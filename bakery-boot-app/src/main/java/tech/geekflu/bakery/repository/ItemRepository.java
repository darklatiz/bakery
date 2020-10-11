package tech.geekflu.bakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.geekflu.bakery.domain.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
  List<Item> findByIsActive(boolean isActive);
}
