package tech.geekflu.bakery


import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import tech.geekflu.bakery.domain.model.CatalogInformation
import tech.geekflu.bakery.domain.model.type.UOM
import tech.geekflu.bakery.domain.model.Category

@ActiveProfiles("test")
class BasicSpecification extends Specification {

    CatalogInformation getCatalogInformationBean(long id, String name, String desc, Category category) {
        CatalogInformation.builder()
                .isActive(true)
                .id(id)
                .name(name)
                .description(desc)
                .price(123.123f)
                .image("IMAGE Test")
                .uom(UOM.EACH)
                .weight(321.321f)
                .quantityAvailable(111)
                .category(category)
                .fdAdded(new Date())
                .build()
    }

    Category getCategoryBean(int id, String categoryDesc, boolean isActive) {
        new Category(id, categoryDesc, isActive)
    }
}
