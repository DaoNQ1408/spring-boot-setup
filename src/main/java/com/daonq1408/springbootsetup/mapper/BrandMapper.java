package com.daonq1408.springbootsetup.mapper;

import com.daonq1408.springbootsetup.dto.request.BrandRequest;
import com.daonq1408.springbootsetup.dto.response.BrandResponse;
import com.daonq1408.springbootsetup.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {

    BrandResponse toResponse(Brand brand);

    @Mapping(target = "id", ignore = true)
    Brand toEntity(BrandRequest brandRequest);
}
