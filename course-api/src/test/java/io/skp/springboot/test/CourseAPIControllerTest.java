package io.skp.springboot.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseAPIControllerTest {

	MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test1GetAllTopics() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/topics").accept(MediaType.APPLICATION_JSON))
							.andExpect(MockMvcResultMatchers.status().is(200)) 
							.andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is("spring")));
	}
	
	
	@Test
	public void test2GetTopic() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/topics/java").accept(MediaType.APPLICATION_JSON))
									.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
									.andExpect(MockMvcResultMatchers.jsonPath("$.id", is("java")))
									.andExpect(MockMvcResultMatchers.jsonPath("$.description", is("Core Java Description")));
	}
	
	@Test
	public void test3UpdateTopic() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/topics/java").accept(MediaType.APPLICATION_JSON).content("{ \"id\" : \"java\" , \"name\" : \"Updated Core Java\" , \"description\" : \"Updated Core Java Description\" }").contentType("application/json"))
									.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test
	public void test4AddTopic() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/topics").accept(MediaType.APPLICATION_JSON).content("{ \"id\" : \"javaee\" , \"name\" : \"Enterprise Java\" , \"description\" : \"Enterprise Description\" }").contentType("application/json"))
									.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test
	public void test5DeleteTopic() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/topics/java").accept(MediaType.APPLICATION_JSON))
										.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test
	public void test6DeleteTopic_Invalid()throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/topics/dell"))
								.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
}
