package com.daonq1408.springbootsetup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.daonq1408.springbootsetup.dto.request.v1.CategoryRequest;
import com.daonq1408.springbootsetup.dto.response.v1.CategoryResponse;
import com.daonq1408.springbootsetup.entity.Category;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryResponse toResponse(Category category);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    Category toEntity(CategoryRequest categoryRequest);
}
// khi tách version: tạo thêm các hàm mapper cho request và response
