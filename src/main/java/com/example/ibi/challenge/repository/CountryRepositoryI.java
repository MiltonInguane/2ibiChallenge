package com.example.ibi.challenge.repository;

import com.example.ibi.challenge.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoryI extends JpaRepository<Country, Long> {
}
