package com.daonq1408.springbootsetup.repository;

import com.daonq1408.springbootsetup.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
}
