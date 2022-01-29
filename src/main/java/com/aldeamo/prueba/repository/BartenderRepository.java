package com.aldeamo.prueba.repository;

import com.aldeamo.prueba.entity.ArraysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BartenderRepository extends JpaRepository<ArraysEntity, Integer> {
}
