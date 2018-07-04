/**
 * 
 */
package com.company.labs.shop.eshop.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.company.labs.shop.eshop.model.Item;
import com.company.labs.shop.eshop.repo.ItemRepository;
import com.company.labs.shop.eshop.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Test Case for Item Controller
 * 
 * @author Nishant.Sonar
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class ItemControllerTest {

	@Autowired
	private ItemController itemController;

	@MockBean
	private ItemService itemService;

	@MockBean
	private ItemRepository itemRepository;

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void Get_AllItem_Test() throws Exception {
		List<Item> items = itemController.getItems(null,null);
		assertThat(items).isNotNull();
	}
	
	@Test
	public void Get_Item_By_Name() throws Exception {
		Item item = new Item("mobile", 1000L);
		given(itemService.findItemByName(anyString())).willReturn(item);
		mockMvc.perform(get("/item/mobile").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		//.andExpect(content().json("{\"name\":\"mobile\",\"price\":1000}"));
		
	}
	
	
	@Test
	public void Post_Item() throws Exception {
		Item item = new Item("Laptop", 100L);
		String jsonString = asJsonString(item);
		Item mItem = new Item("Laptop", 100L);
		mItem.setId(100L);
		given(itemService.save(eq(mItem))).willReturn(mItem);
		mockMvc.perform(post("/item").contentType(MediaType.APPLICATION_JSON).content(jsonString))
		.andExpect(status().isCreated());
		//.andExpect(model().attribute("id", 100L));
		//{"name":"Laptop","price":100L}
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
	
}
