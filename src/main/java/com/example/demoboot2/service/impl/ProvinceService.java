package com.example.demoboot2.service.impl;

import com.example.demoboot2.model.Province;
import com.example.demoboot2.repository.ProvinceRepository;
import com.example.demoboot2.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
  @Service
public class ProvinceService implements IProvinceService {
   @Autowired
   ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);

    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);

    }
      public List<Province> findByName(String name) { return provinceRepository.findAllByNameContaining(name);}


      public List<Province> findTopName() {
        return provinceRepository.findTopName();
      }
}
