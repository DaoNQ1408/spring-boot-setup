package com.daonq1408.springbootsetup.service.inter;

import com.daonq1408.springbootsetup.dto.response.BrandResponse;
import com.daonq1408.springbootsetup.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand getBrandById(Long id);
    BrandResponse getBrandResponseById(Long id);
    List<BrandResponse> getAll();
}
