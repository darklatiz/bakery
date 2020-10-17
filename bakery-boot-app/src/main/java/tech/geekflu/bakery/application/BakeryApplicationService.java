package tech.geekflu.bakery.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.geekflu.bakery.domain.model.CatalogInformation;
import tech.geekflu.bakery.domain.model.Category;
import tech.geekflu.bakery.repository.CategoryRepository;
import tech.geekflu.bakery.repository.ItemRepository;

import java.util.List;

@Component
public class BakeryApplicationService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ItemRepository itemRepository;

  public List<Category> getAllCategoriesInCatalog(boolean includeInactive) {
    return categoryRepository.findByIsActive(includeInactive);
  }

  public List<CatalogInformation> getAllItemsInCatalog(boolean includeInactive) {
    return itemRepository.findByIsActive(includeInactive);
  }

}
