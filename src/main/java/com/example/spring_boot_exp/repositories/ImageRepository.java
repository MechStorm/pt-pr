package com.example.spring_boot_exp.repositories;

import com.example.spring_boot_exp.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
