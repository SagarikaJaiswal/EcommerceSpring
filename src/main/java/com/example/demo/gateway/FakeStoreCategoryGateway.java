package com.example.demo.gateway;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.FakeStoreCategoryResponseDTO;
import com.example.demo.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi _fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = _fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response =  this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        if( response == null) {
            throw new IOException("failed to fetch categories from api");
        }
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
