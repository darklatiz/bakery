package tech.geekflu.bakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.geekflu.bakery.domain.model.CatalogInformation;

import java.util.List;

public interface ItemRepository extends JpaRepository<CatalogInformation, Long> {
  List<CatalogInformation> findByIsActive(boolean isActive);
}
