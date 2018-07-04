/**
 * 
 */
package com.company.labs.shop.eshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.labs.shop.eshop.exception.EntityNotSavedException;
import com.company.labs.shop.eshop.model.Item;
import com.company.labs.shop.eshop.repo.ItemRepository;

/**
 * 
 * An Item Service class
 * 
 * @author Nishant.Sonar
 *
 */

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		Iterable<Item> iterable = itemRepository.findAll();
		iterable.forEach(i -> {
			items.add(i);
		});
		return items;
	}

	public Item findItemByName(String name) {
		return itemRepository.findByName(name);
	}

	public Item save(Item item) throws EntityNotSavedException {
		Item rItem = itemRepository.save(item);
		if (rItem == null) {
			throw new EntityNotSavedException(item);
		}
		return rItem;
	}

}
