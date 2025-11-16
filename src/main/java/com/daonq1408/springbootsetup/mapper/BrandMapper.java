package com.daonq1408.springbootsetup.mapper;

import com.daonq1408.springbootsetup.dto.request.v1.BrandRequest;
import com.daonq1408.springbootsetup.dto.response.v1.BrandResponse;
import com.daonq1408.springbootsetup.entity.Brand;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {

    BrandResponse toResponse(Brand brand);


    @Mapping(target = "id", ignore = true)
    Brand toEntity(BrandRequest brandRequest);


    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(BrandRequest brandRequest,@MappingTarget Brand brand);
}
// khi tách version: tạo thêm các hàm mapper cho request và response