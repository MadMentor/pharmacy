package com.texas.team1.pharmacy.repo;

import com.texas.team1.pharmacy.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProvinceRepo extends JpaRepository<Province, Integer> {
}
