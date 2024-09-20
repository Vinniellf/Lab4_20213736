package com.example.tareagtics.Models.Repositories;

import com.example.tareagtics.Models.Entities.Ocasion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcasionRepository extends JpaRepository<Ocasion, Long> {
}
