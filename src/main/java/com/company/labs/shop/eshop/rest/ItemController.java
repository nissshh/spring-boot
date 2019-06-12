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
import org.springframework.web.bind.annotation.RestController;

import com.company.labs.shop.eshop.dto.error.GenericError;
import com.company.labs.shop.eshop.exception.EShopException;
import com.company.labs.shop.eshop.exception.EntityNotSavedException;
import com.company.labs.shop.eshop.model.Item;
import com.company.labs.shop.eshop.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Nishant.Sonar
 *
 */
@Api(value="Order Management System  -  Inventory Itams ", description="A Sample API for managing Items")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "View a list of available items", response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@GetMapping("item")
	public List<Item> getItems(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "price", required = false) Long price) {
		List<Item> items = itemService.getAllItems();
		return items;
	}

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@GetMapping("item/{name}")
	public Item getItem(@PathVariable(name = "name") String name) {
		Item items = itemService.findItemByName(name);
		return items;
	}

	 @ApiOperation(value = "Update an item")
	@PutMapping("item/{name}")
	public void editItem(@ApiParam(value = "Item name to update itememployee object", required = true) @PathVariable(name = "name") String name, 
			@ApiParam(value = "Update item object", required = true) @RequestBody Item item) {
	}

	@ApiOperation(value = "Add an item")
	@PostMapping("item")
	public ResponseEntity<Item> addItem( @ApiParam(value = "Item object store in database table", required = true) @RequestBody Item item) throws EntityNotSavedException {
		Item rItem  = itemService.save(item);
		ResponseEntity<Item> itemEntity  = new ResponseEntity<Item>(rItem, HttpStatus.CREATED);
		return itemEntity;
	}

	@DeleteMapping("item/{name}")
	public void deleteItem(@ApiParam(value = "Item name  from which name 	will delete from database table", required = true) @PathVariable(name = "name") String name, @RequestBody Item item) {

	}

	@ExceptionHandler
	public ResponseEntity<GenericError> exceptionHandler(EShopException e) {
		GenericError body = new GenericError(1001L, "Entity is not created");
		ResponseEntity<GenericError> error = new ResponseEntity<GenericError>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

}
