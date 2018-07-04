/**
 * 
 */
package com.company.labs.shop.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.labs.shop.eshop.model.Item;

/**
 * @author Nishant.Sonar
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	public Item findByName(String name);
}
