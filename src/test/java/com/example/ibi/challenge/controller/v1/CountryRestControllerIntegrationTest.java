package com.example.ibi.challenge.controller.v1;

import com.example.ibi.challenge.model.Country;
import com.example.ibi.challenge.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CountryRestController.class})
@ExtendWith(SpringExtension.class)
public class CountryRestControllerIntegrationTest {
    @Autowired
    private CountryRestController countryRestController;

    @MockBean
    private CountryService countryService;

    @Test
    public void testCreate() throws Exception {
        Country country = new Country();
        country.setArea(10.0);
        country.setRegion("us-east-2");
        country.setId(123L);
        country.setName("Name");
        country.setCapital("Capital");
        country.setSubRegion("us-east-2");
        String content = (new ObjectMapper()).writeValueAsString(country);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.countryRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testDeleteById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.countryRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testFindAll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.countryRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testFindAllBySort() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sortValue}/{direction}", "value",
                "value");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.countryRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testFindById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.countryRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testUpdate() throws Exception {
        Country country = new Country();
        country.setArea(10.0);
        country.setRegion("us-east-2");
        country.setId(123L);
        country.setName("Name");
        country.setCapital("Capital");
        country.setSubRegion("us-east-2");
        String content = (new ObjectMapper()).writeValueAsString(country);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.countryRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

