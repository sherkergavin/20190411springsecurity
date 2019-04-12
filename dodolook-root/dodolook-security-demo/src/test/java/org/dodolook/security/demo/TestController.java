package org.dodolook.security.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestController {

	
	@Autowired
	private MockMvc mvc;




	@Test
	public void exampleTest() throws Exception {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			
		map.set("username", "hahahah");
		map.set("age", "133");
		map.set("password","99999");
		
		 ResultActions result = this.mvc.perform(get("/user").params(map).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(3));
		 
		 System.out.println(result.andReturn().getResponse().getContentAsString());
		 
		 
	}

	
	@Test
	public void whenGenInfoSuccess() throws Exception{
		
		 ResultActions result = mvc.perform(get("/u/1").contentType(MediaType.APPLICATION_JSON_UTF8))
								.andExpect(status().isOk())
								.andExpect(jsonPath("$.name").value("gavin"));
		
		 System.out.println(result.andReturn().getResponse().getContentAsString());
	}
	
	
	@Test
	public void whenCreateSuccess() throws Exception{
		
		 String content ="{\"name\":\"tom\",\"age\":\"55\",\"password\":\"889988\"}";
		
		 ResultActions result = mvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
								.andExpect(status().isOk());
								
		
		 System.out.println(result.andReturn().getResponse().getContentAsString());
	}
	
	
	
	
	

	
	
}
