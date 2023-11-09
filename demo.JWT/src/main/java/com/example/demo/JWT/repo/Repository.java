package com.example.demo.JWT.repo;

import com.example.demo.JWT.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<ImageData, Long> {

    Optional<ImageData> findByName(String filename);
}
