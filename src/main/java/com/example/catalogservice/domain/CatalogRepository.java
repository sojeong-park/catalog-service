package com.example.catalogservice.domain;

import com.example.catalogservice.dto.CatalogDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {
}
