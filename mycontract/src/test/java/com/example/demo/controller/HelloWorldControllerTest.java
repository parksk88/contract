package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class HelloWorldControllerTest {
	
	@Autowired
	private HelloWorldController helloWorldController;
	
	private MockMvc mockMvc;
	
	@Test
	void helloworld() {
		System.out.println(helloWorldController.Hello());
		
		assertThat(helloWorldController.Hello()).isEqualTo("hello");
	}
	
	@Test
	void mockMvnTest() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/helloworld"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello"));
		
	}
	

}
