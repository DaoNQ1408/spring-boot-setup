package com.daonq1408.springbootsetup.controller.v1;

import com.daonq1408.springbootsetup.dto.api.ApiResponse;
import com.daonq1408.springbootsetup.dto.request.v1.BrandRequest;
import com.daonq1408.springbootsetup.dto.response.v1.BrandResponse;
import com.daonq1408.springbootsetup.service.inter.BrandService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BrandController {

    private final BrandService brandService;


    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ApiResponse<List<BrandResponse>> getAllBrands() {

        List<BrandResponse> brands = brandService.getAll();

        return ApiResponse.success(HttpStatus.OK, "Get all brands success", brands, null);
    }


    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ApiResponse<BrandResponse> getBrandById(@PathVariable Long id) {

        BrandResponse brand = brandService.getBrandResponseById(id);

        return ApiResponse.success(HttpStatus.OK, "Get brand success", brand, null);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    public ApiResponse<BrandResponse> createBrand(@RequestBody @Valid BrandRequest request) {

        BrandResponse newBrand = brandService.create(request);

        return ApiResponse.success(HttpStatus.CREATED, "Create brand success", newBrand, null);
    }


    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ApiResponse<BrandResponse> updateBrand(@PathVariable Long id,
                                                  @RequestBody @Valid BrandRequest request) {
        BrandResponse updatedBrand = brandService.update(id, request);

        return ApiResponse.success(HttpStatus.OK, "Update brand success", updatedBrand, null);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ApiResponse<BrandResponse> deleteBrand(@PathVariable Long id) {

        BrandResponse deletedBrand = brandService.delete(id);

        return ApiResponse.success(HttpStatus.OK, "Delete brand success", deletedBrand, null);
    }
}