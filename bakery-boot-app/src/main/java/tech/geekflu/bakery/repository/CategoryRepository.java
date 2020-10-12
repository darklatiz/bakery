package tech.geekflu.bakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.geekflu.bakery.domain.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findByIsActive(boolean isActive);

  @Query(value = "SELECT nextval('bakery.general_id_sequence')", nativeQuery = true)
  Long getNextSeriesId();


}
