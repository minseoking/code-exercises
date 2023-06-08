package com.example.java17.api.repository;

import com.example.java17.api.domain.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Main, Long> {
}
