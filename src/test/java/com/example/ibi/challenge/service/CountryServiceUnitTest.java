package com.example.ibi.challenge.service;

import com.example.ibi.challenge.AbstractTest;
import com.example.ibi.challenge.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CountryServiceUnitTest extends AbstractTest {

    @MockBean
    CountryService countryService;

    @Test
    void shouldCreateCountry() {
        //given
        Country country = anyCountry();
        Country newCountry = new Country();
        //when
        when(countryService.save(country)).thenReturn(newCountry);
        //then
        Assertions.assertNotNull(newCountry);
    }

    @Test
    void shouldFindCountryById() {
        //given
        List<Country> countries = new ArrayList<>();
        countries.add(anyCountry());
        countries.add(anyCountry());
        countries.add(anyCountry());
        Country country = new Country();
        //when
        when(countryService.findById(anyCountry().getId())).thenReturn(country);
        //then
        Assertions.assertNotNull(country);

    }

    @Test
    void shouldDeleteCountryById() {
        //given
        Country country = anyCountry();
        Country newCountry = new Country();
        //when
        when(countryService.save(country)).thenReturn(newCountry);
        countryService.deleteById(newCountry.getId());
        //then
        Assertions.assertNull(newCountry.getId());
    }
}