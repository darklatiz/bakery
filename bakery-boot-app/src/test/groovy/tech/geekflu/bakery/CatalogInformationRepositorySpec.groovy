package tech.geekflu.bakery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import spock.lang.Unroll
import tech.geekflu.bakery.domain.model.CatalogInformation
import tech.geekflu.bakery.domain.model.Category
import tech.geekflu.bakery.repository.CatalogInformationRepository
import tech.geekflu.bakery.repository.CategoryRepository

@DataJpaTest
class CatalogInformationRepositorySpec extends BasicSpecification {

    @Autowired
    TestEntityManager entityManager

    @Autowired
    CatalogInformationRepository catalogInformationRepository

    @Autowired
    CategoryRepository categoryRepository


    @Unroll
    def "Save a new Catalog Information"() {
        given: "Some new catalog information entities and a Category 1"
        Category c = categoryRepository.save(getCategoryBean(111, "Category 1", true))
        CatalogInformation catalogInformation = getCatalogInformationBean(44L, "Catalog information TEST", "TEST Description", c)

        when: "Saving the catalog information"
        CatalogInformation cInfoPersisted = catalogInformationRepository.save(catalogInformation)
        Optional<CatalogInformation> cInfoQueried = catalogInformationRepository.findById(44L)

        then:
        cInfoPersisted != null
        cInfoPersisted.getId() != null
        cInfoQueried != Optional.empty()
        cInfoPersisted.getId() == cInfoQueried.get().getId()
        cInfoPersisted.getCategory().getId() == cInfoQueried.get().getCategory().getId()

    }

    def "Update a catalog Information bean"() {
        given: "Some new catalog information entities and a Category 1"
        Category c = categoryRepository.save(getCategoryBean(111, "Category 1", true))
        CatalogInformation catalogInformation = getCatalogInformationBean(44L, "Catalog information TEST", "TEST Description", c)
        CatalogInformation cInfoPersisted = catalogInformationRepository.save(catalogInformation)

        when: "Queried the catalog information and update props"
        Optional<CatalogInformation> cInfoQueriedOpt = catalogInformationRepository.findById(44L)
        CatalogInformation cInfoQueried = cInfoQueriedOpt.get()
        cInfoQueried.setName("New Name")
        cInfoQueried.setDescription("New Description")
        cInfoQueried.setActive(false)
        cInfoQueried.setPrice(0.1f)
        cInfoQueried = catalogInformationRepository.save(cInfoQueried)

        then: "verify data is consistent"
        cInfoQueried != null
        cInfoQueried.getDescription() == "New Description"
        cInfoQueried.getName() == "New Name"
        cInfoQueried.getPrice() == 0.1f
    }

    @Unroll
    def "Delete Catalog Information"(){
        given: "Some new catalog information entities and a Category 1"
        Category c = categoryRepository.save(getCategoryBean(111, "Category 1", true))
        CatalogInformation catalogInformation = getCatalogInformationBean(44L, "Catalog information TEST", "TEST Description", c)
        CatalogInformation cInfoPersisted = catalogInformationRepository.save(catalogInformation)

        when: "We delete the catalog information"
        Optional<CatalogInformation> cInfoQueriedOpt = catalogInformationRepository.findById(44L)
        CatalogInformation cInfoQueried = cInfoQueriedOpt.get()
        int countBefore = catalogInformationRepository.count()
        catalogInformationRepository.delete(cInfoQueried)
        Optional<CatalogInformation> cQueryAgain = catalogInformationRepository.findById(44L)
        int countAfter = catalogInformationRepository.count()

        then:
        cQueryAgain == Optional.empty()
        countBefore == countAfter + 1

    }


}
