package com.company.labs.shop.eshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes= {EshopApplication.class})
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EshopApplicationTests {

	
	@Autowired
	private TestRestTemplate restTemplate;

	
	
	@Test
	public void contextLoads() {
	}
	
	
	public void Get_All_Items_Test() throws Exception {
		Object urlVars = null;
		/*this.webClient.get().uri("/item").exchange().expectStatus().isOk()
		.expectBody(String.class)
		.isEqualTo("{}");
		List<Item> body = this.restTemplate.getForEntity("/item", List.class,urlVars).getBody();
		assertThat(body).isNotEmpty();*/
	}

}
