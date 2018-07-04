/**
 * 
 */
package com.company.labs.shop.eshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.labs.shop.eshop.dto.error.GenericError;
import com.company.labs.shop.eshop.exception.EShopException;
import com.company.labs.shop.eshop.exception.EntityNotSavedException;
import com.company.labs.shop.eshop.model.Item;
import com.company.labs.shop.eshop.service.ItemService;

/**
 * 
 * @author Nishant.Sonar
 *
 */

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("item")
	public List<Item> getItems(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "price", required = false) Long price) {
		List<Item> items = itemService.getAllItems();
		return items;
	}

	@GetMapping("item/{name}")
	public Item getItem(@PathVariable(name = "name") String name) {
		Item items = itemService.findItemByName(name);
		return items;
	}

	@PutMapping("item/{name}")
	public void editItem(@PathVariable(name = "name") String name, @RequestBody Item item) {
	}

	@PostMapping("item")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws EntityNotSavedException {
		Item rItem  = itemService.save(item);
		ResponseEntity<Item> itemEntity  = new ResponseEntity<Item>(rItem, HttpStatus.CREATED);
		return itemEntity;
	}

	@DeleteMapping("item/{name}")
	public void deleteItem(@PathVariable(name = "name") String name, @RequestBody Item item) {

	}

	@ExceptionHandler
	public ResponseEntity<GenericError> exceptionHandler(EShopException e) {
		GenericError body = new GenericError(1001L, "Entity is not created");
		ResponseEntity<GenericError> error = new ResponseEntity<GenericError>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		return error;

	}

}
