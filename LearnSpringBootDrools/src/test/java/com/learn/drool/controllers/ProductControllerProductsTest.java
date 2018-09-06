package com.learn.drool.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerProductsTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testProductDiamond() throws Exception {
		mockMvc.perform(get("/products/10"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price", is(15)))
				.andExpect(jsonPath("$.name", is("diamond")))
				.andExpect(jsonPath("$.id", is(10)));
	}
}
