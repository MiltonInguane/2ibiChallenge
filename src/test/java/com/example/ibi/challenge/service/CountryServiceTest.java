package com.example.ibi.challenge.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.ibi.challenge.model.Country;
import com.example.ibi.challenge.repository.CountryRepositoryI;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CountryService.class})
@ExtendWith(SpringExtension.class)
public class CountryServiceTest {
    @MockBean
    private CountryRepositoryI countryRepositoryI;

    @Autowired
    private CountryService countryService;

    @Test
    public void testItCanSave() {
        Country country = new Country();
        country.setArea(10.0);
        country.setRegion("us-east-2");
        country.setId(123L);
        country.setName("Name");
        country.setCapital("Capital");
        country.setSubRegion("us-east-2");
        when(this.countryRepositoryI.save((Country) any())).thenReturn(country);
        assertSame(country, this.countryService.save(new Country()));
        verify(this.countryRepositoryI).save((Country) any());
    }

    @Test
    public void testItCanFindById() {
        Country country = new Country();
        country.setArea(10.0);
        country.setRegion("us-east-2");
        country.setId(123L);
        country.setName("Name");
        country.setCapital("Capital");
        country.setSubRegion("us-east-2");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryRepositoryI.findById((Long) any())).thenReturn(ofResult);
        assertSame(country, this.countryService.findById(123L));
        verify(this.countryRepositoryI).findById((Long) any());
    }

    @Test
    public void testItCanFindAll() {
        PageImpl<Country> pageImpl = new PageImpl<Country>(new ArrayList<Country>());
        when(this.countryRepositoryI.findAll((Pageable) any())).thenReturn(pageImpl);
        Page<Country> actualFindAllResult = this.countryService.findAll(null);
        assertSame(pageImpl, actualFindAllResult);
        assertTrue(actualFindAllResult.toList().isEmpty());
        verify(this.countryRepositoryI).findAll((Pageable) any());
    }

    @Test
    public void testItCanDeleteById() {
        doNothing().when(this.countryRepositoryI).deleteById((Long) any());
        this.countryService.deleteById(123L);
        verify(this.countryRepositoryI).deleteById((Long) any());
    }
}

