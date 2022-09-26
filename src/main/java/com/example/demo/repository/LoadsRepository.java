package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Load;

@Repository
public interface LoadsRepository extends JpaRepository<Load,Long>{

}
