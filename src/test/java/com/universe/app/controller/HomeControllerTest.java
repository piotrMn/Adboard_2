package com.universe.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HomeController.class)
@AutoConfigureMockMvc(secure=false)
public class HomeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenGetContextRoot_thenReturnHomepage() throws Exception {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/");
		MvcResult result = mockMvc.perform(request).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		assertTrue(modelAndView.getStatus().is2xxSuccessful());
		assertEquals("homepage", modelAndView.getViewName());
		
	}

}
