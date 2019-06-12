package com.company.labs.shop.eshop;


import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.labs.shop.eshop.model.Item;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * This test case will test the whole application on load, using in mem DB.	
 * @author Nishant.Sonar
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes= {EshopApplication.class})
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EshopApplicationTests {

	
	@Autowired
	private TestRestTemplate restTemplate;

	
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void Post_Items_Test() throws Exception {
		Item item = new Item("mobile", 1000L);
		RequestEntity request = RequestEntity.post(new URI("/item")).accept(MediaType.APPLICATION_JSON).body(item);
		ResponseEntity<Item> response = restTemplate.exchange(request, Item.class);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isNotNull();
	}

}
