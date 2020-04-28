package com.generate.alphanumeric.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.generate.alphanumeric.components.GenerateText;
import com.generate.alphanumeric.models.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphanumericControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;

  ObjectMapper om = new ObjectMapper();

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void getAlphanumerics() throws Exception  {
    GenerateText generateText = new GenerateText("23", 1, 5);


    MvcResult result = mockMvc
            .perform(get("http://localhost:8080/generate/alphanumeric/23/1").content(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk()).andReturn();
    String resultContent = result.getResponse().getContentAsString();
    Response response = om.readValue(resultContent, Response.class);

    Assert.assertEquals(response.getCount(), generateText.getCount());
  }
}