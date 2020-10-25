package tech.geekflu.bakery

import tech.geekflu.bakery.application.BakeryApplicationService
import tech.geekflu.bakery.domain.model.CatalogInformation
import tech.geekflu.bakery.domain.model.Category
import tech.geekflu.bakery.repository.CatalogInformationRepository
import tech.geekflu.bakery.repository.CategoryRepository


class BakeryApplicationServiceSpec extends BasicSpecification {

    CategoryRepository categoryRepository
    CatalogInformationRepository catalogInformationRepository
    BakeryApplicationService bakeryApplicationService


    def setup() {
        categoryRepository = Mock()
        catalogInformationRepository = Mock()
        bakeryApplicationService = new BakeryApplicationService(categoryRepository: categoryRepository, catalogInformationRepository: catalogInformationRepository)
    }

    def "Get Categories by isActive = #isActive"() {
        given:
        categoryRepository.findByIsActive(isActive) >> [
                getCategoryBean(23, "Cat DESC1", isActive),
                getCategoryBean(24, "Cat DESC2", isActive),
                getCategoryBean(25, "Cat DESC3", isActive),
        ]

        when:
        List<Category> categories = bakeryApplicationService.getAllCategoriesInCatalog(isActive)

        then:
        categories.size() == count

        where:
        isActive | count
        true     | 3
        false    | 3
    }

    def "Get All Catalog Information Beans isActive = #isActive"() {
        given:
        Category c = getCategoryBean(23, "Cat DESC1", isActive)
        Category c1 = getCategoryBean(24, "Cat DESC1", isActive)
        catalogInformationRepository.findByIsActive(isActive) >> [
                getCatalogInformationBean(33, "Name Catalof Info01", "Desc 01", c, isActive),
                getCatalogInformationBean(34, "Name Catalof Info02", "Desc 02", c1, isActive),
                getCatalogInformationBean(35, "Name Catalof Info03", "Desc 03", c, isActive)
        ]

        when:
        List<CatalogInformation> catalogInformationList = bakeryApplicationService.getAllItemsInCatalog(isActive)

        then:
        catalogInformationList.size() == count

        where:
        isActive | count
        true     | 3
        false    | 3
    }

}
