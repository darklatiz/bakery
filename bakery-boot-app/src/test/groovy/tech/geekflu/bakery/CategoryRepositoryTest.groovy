package tech.geekflu.bakery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import tech.geekflu.bakery.domain.model.Category
import tech.geekflu.bakery.repository.CategoryRepository

@SpringBootTest
@DataJpaTest
class CategoryRepositoryTest extends BasicSpecification {

    @Autowired
    CategoryRepository categoryRepository;

    def "get all categories"() {
        given: "A Category saved in database"
        Category category = Category.builder()
                .name("Category 1")
                .build()

        categoryRepository.save(category)

        when: "We query all the categories"
        Category ret = categoryRepository.findById(category.getId())

        then:
        ret.getId() == category.getId()

    }

}
