package com.example.ibi.challenge.controller.v1;

import com.example.ibi.challenge.model.Country;
import com.example.ibi.challenge.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "country", path = "/api/v1/country")
@Api(tags = "Country", description = "Country endpoint (save, update, delete, findAll, findById, findAllBySort)")
@RequiredArgsConstructor
public class CountryRestController {

    @Autowired
    CountryService countryService;

    @PostMapping
    @ApiOperation("Create new country")
    public ResponseEntity<Country> create(@RequestBody Country country) {
        return  new ResponseEntity<Country>(countryService.save(country), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Updated created country")
    public ResponseEntity<Country> update(@RequestBody Country country) {
        countryService.findById(country.getId());
        return  ResponseEntity.ok(countryService.save(country));
    }

    @GetMapping
    @ApiOperation("List paginated countries")
    public ResponseEntity<Page<Country>> findAll(Pageable pageable) {
        return ResponseEntity.ok(countryService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation("Get country by id")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete country")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{sortValue}/{direction}")
    @ApiOperation("List sorted countries")
    public ResponseEntity<List<Country>> findAllBySort(@PathVariable String sortValue, @PathVariable String direction) {
        return ResponseEntity.ok(countryService.findAllBySort(sortValue, direction));
    }
}
