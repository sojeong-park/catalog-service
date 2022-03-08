package com.example.catalogservice.service;

import com.example.catalogservice.domain.Catalog;
import com.example.catalogservice.domain.CatalogRepository;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService{
    private CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Iterable<Catalog> findAllCatalogs() {
        return catalogRepository.findAll();
    }
}
