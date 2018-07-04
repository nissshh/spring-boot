/**
 * 
 */
package com.company.labs.shop.eshop.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.labs.shop.eshop.model.Item;

/**
 * @author Nishant.Sonar
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
    private TestEntityManager testEntityManager;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void find_all_3_items() throws Exception {
		Item item1 = new Item("Mobile1", 10000L);
		Item item2 = new Item("Mobile2", 20000L);
		Item item3 = new Item("Mobile3", 30000L);
		testEntityManager.persist(item1);
		testEntityManager.persist(item2);
		testEntityManager.persist(item3);

		List<Item> items = itemRepository.findAll();

		assertThat(items).isNotNull();
		assertThat(items.size()).isEqualTo(3);
		assertThat(items).contains(item1, item2, item3);
	}

	@Test
	public void test_find_by_name() throws Exception {
		Item item1 = new Item("Mobile1", 10000L);
		testEntityManager.persist(item1);
		Item item = itemRepository.findByName("Mobile1");
		assertThat(item).isNotNull();
		assertThat(item.getPrice()).isEqualTo(item1.getPrice());
	}
}
