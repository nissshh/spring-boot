/**
 * 
 */
package com.company.labs.shop.eshop.repo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.labs.shop.eshop.model.Item;
import com.company.labs.shop.eshop.model.LineItem;
import com.company.labs.shop.eshop.model.Order;
import com.company.labs.shop.eshop.model.Payment;

import lombok.Getter;


/**
 * @author Nishant.Sonar
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Getter
public class OrderRepositoryTest {

	@Autowired
	protected TestEntityManager testEntityManager;
	
	@Test
	public void Get_All_Order_Test() throws Exception {
		Date today = Calendar.getInstance().getTime();
		Payment payment = new Payment(1000L,today,"test");
		Item item1 = new Item("Pencil", 5L);
		Item item2= new Item("Box", 50L);
		Item item3= new Item("Bag", 500L);
		LineItem lit1 = new LineItem();
		lit1.setItem(item1);
		lit1.setQuantity(5L);
		LineItem lit2 = new LineItem();
		lit2.setQuantity(50L);
		lit2.setItem(item2);
		LineItem lit3 = new LineItem();
		lit3.setQuantity(500L);
		lit3.setItem(item3);
		List<LineItem> lineItems = Lists.newArrayList(lit1,lit2,lit3);
		Date orderDate = Calendar.getInstance().getTime();
		Order orderSave = new Order(1000L,orderDate, payment, lineItems);
		Order orderReturn = this.getTestEntityManager().persist(orderSave);
		Assert.assertTrue(orderReturn.getAmount()==1000L);
		Assert.assertEquals(orderDate,orderReturn.getDate());
		Assert.assertEquals(orderReturn.getLineItem().size(),lineItems.size());
		Assert.assertEquals(orderReturn.getLineItem().stream().sorted().collect(Collectors.toList()), lineItems.stream().sorted().collect(Collectors.toList()));
	}
	
}
