package com.example.demo.services;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(ICategoryGateway _categoryGateway) {
        this.categoryGateway = _categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
}
