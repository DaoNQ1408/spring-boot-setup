package com.daonq1408.springbootsetup.service.impl;

import com.daonq1408.springbootsetup.dto.response.BrandResponse;
import com.daonq1408.springbootsetup.entity.Brand;
import com.daonq1408.springbootsetup.mapper.BrandMapper;
import com.daonq1408.springbootsetup.repository.BrandRepository;
import com.daonq1408.springbootsetup.service.inter.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;


    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
    }


    @Override
    public BrandResponse getBrandResponseById(Long id) {
        return brandRepository.findById(id)
                .map(brandMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
    }


    @Override
    public List<BrandResponse> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toResponse)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
