package com.example.catalogservice.controller;

import com.example.catalogservice.domain.Catalog;
import com.example.catalogservice.service.CatalogService;
import com.example.catalogservice.vo.CatalogResponse;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("catalog-service")
public class CatalogController {
    private CatalogService catalogService;
    private Environment env;

    public CatalogController(CatalogService catalogService, Environment env) {
        this.catalogService = catalogService;
        this.env = env;
    }

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's working in User service ont PORT %s",
                env.getProperty("local.server.port"));
    }

    @GetMapping("catalogs")
    public ResponseEntity<List<CatalogResponse>> getAllCatalogs() {
        Iterable<Catalog> catalogs = catalogService.findAllCatalogs();
        List<CatalogResponse> result = new ArrayList<>();
        Map<CatalogResponse, String> test = new HashMap();
        List<Catalog> test2 = new ArrayList<>();
        catalogs.forEach(v -> {
            result.add(new ModelMapper().map(v, CatalogResponse.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/health-check/test")
    public String testApi() {
        return String.format("test %s", env.getProperty("local.server.port"));
    }
}
