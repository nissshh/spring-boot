package com.company.labs.shop.eshop.exception;

import com.company.labs.shop.eshop.model.Item;

public class EntityNotSavedException extends EShopException {

	Item item;

	public EntityNotSavedException(Item item) {
		super();
		this.item = item;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7005746604150546750L;

}
