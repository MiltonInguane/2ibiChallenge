package com.example.ibi.challenge.service;

import com.example.ibi.challenge.model.Country;
import com.example.ibi.challenge.repository.CountryRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    @Autowired
    CountryRepositoryI countryRepositoryI;

    public Country save(Country country) {
        return countryRepositoryI.save(country);
    }
    public Country findById(Long id) {
        return countryRepositoryI.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public Page<Country> findAll(Pageable pageable) {
        return countryRepositoryI.findAll(pageable);
    }
    public void deleteById(Long id) {
        countryRepositoryI.deleteById(id);
    }
    public List<Country> findAllBySort(String sortValue, String direction) {
        return countryRepositoryI.findAll(Sort.by(Sort.Direction.fromString(direction.toUpperCase(Locale.ROOT)), sortValue));
    }
}
