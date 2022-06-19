package com.example.demoboot2.repository;

import com.example.demoboot2.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository <Province, Long>{
    List<Province> findAllByNameContaining(String name);
    @Query (value = "select * from province order by name limit 3",nativeQuery = true)
    List<Province> findTopName();
}
