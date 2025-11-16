package com.daonq1408.springbootsetup.repository;

import com.daonq1408.springbootsetup.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    List<Brand> findAllByIsDeletedFalse();
    Optional<Brand> findByIdAndIsDeletedFalse(Long id);
    boolean existsByBrandCodeAndIdNotAndIsDeletedFalse(String brandCode, Long brandId);
    boolean existsByBrandCodeAndIsDeletedFalse(String brandCode);
}
