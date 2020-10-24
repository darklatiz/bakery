package tech.geekflu.bakery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import spock.lang.Unroll
import tech.geekflu.bakery.domain.model.Category
import tech.geekflu.bakery.repository.CategoryRepository

@DataJpaTest
class CategoryRepositorySpec extends BasicSpecification{

    @Autowired
    TestEntityManager entityManager

    @Autowired
    CategoryRepository categoryRepository

    @Unroll
    def "spring context loads for data jpa slice"() {
        given: "some existing categories"
        entityManager.persist(new Category(11, "Category 1", true))
        entityManager.persist(new Category(22, "Category 2", true))

        expect: "the correct count is inside the repository"
        categoryRepository.count() == 6L
    }

    @Unroll
    def "insert category"() {
        given: "Some new category"
        entityManager.persist(new Category(45L, "Category nueva 1", true))
        entityManager.persist(new Category(46L, "Category nueva 2", true))

        when: "Query category 2"
        Optional<Category> optCategory = categoryRepository.findById(46L)

        then: "Category found"
        Category category = optCategory.orElse(new Category(100, "Category was null", false))
        category.getId() == 46L
        category.getName() == "Category nueva 2"
        category.isActive()
    }

    @Unroll
    def "delete category"() {
        given: "Some new categories"
        entityManager.persist(new Category(45L, "Category nueva 1", true))
        entityManager.persist(new Category(46L, "Category nueva 2", true))

        when: "Query Category 45"
        int prevCount = (int) categoryRepository.count()
        categoryRepository.deleteById(45L)
        int newCount = (int) categoryRepository.count()

        then: "Category found then delete"
        prevCount == newCount + 1
    }

    @Unroll
    def "update category"() {
        given: "Some new category"
        entityManager.persist(new Category(45L, "Category nueva 1", true))
        entityManager.persist(new Category(46L, "Category nueva 2", true))

        when: "update category 2 to catefory dos"
        Optional<Category> optCategory = categoryRepository.findById(46L)
        Category category1 = optCategory.get()
        category1.setActive(false)
        category1.setName("Category dos")
        categoryRepository.save(category1)
        optCategory = categoryRepository.findById(46L)

        then: "Category found"
        Category category = optCategory.orElse(new Category(100, "Category was null", false))
        category.getId() == 46L
        category.getName() == "Category dos"
        !category.isActive()
    }

    def "get all categories active"() {
        given: "Add some new categories"
        entityManager.persist(new Category(450L, "Category nueva 1", true))
        entityManager.persist(new Category(461L, "Category nueva 2", true))

        when: "finding all active categories"
        List<Category> categories = categoryRepository.findByIsActive(true)

        then: "verified all categories are active"
        categories.size() > 0
        int count = (int) categories.stream().filter(cat -> !cat.isActive()).count()
        count == 0
    }

    def "get all categories are not active"() {
        given: "Add some new categories"
        entityManager.persist(new Category(450L, "Category nueva 1", true))
        entityManager.persist(new Category(461L, "Category nueva 2", false))
        entityManager.persist(new Category(4621L, "Category nueva 12", false))

        when: "finding all not active categories"
        List<Category> categories = categoryRepository.findByIsActive(false)

        then: "verified all categories are active"
        categories.size() > 0
        int count = (int) categories.stream().filter(cat -> !cat.isActive()).count()
        count == 2
    }

    def "delete a category not related with Catalog Information"() {
        given: "Add some new categories"
        Category c1 = entityManager.persist(new Category(450L, "Category nueva 1", true))
        entityManager.persist(new Category(461L, "Category nueva 2", true))

        when: "delete all active categories"
        categoryRepository.delete(c1)
        Optional<Category> qC1 = categoryRepository.findById(450L)

        then: "verified all categories are active"
        qC1 == Optional.empty()
    }

}
