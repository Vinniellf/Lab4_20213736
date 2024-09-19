package com.example.tareagtics.Models.Repositories;

import com.example.tareagtics.Models.Entities.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloresRepository extends JpaRepository<Flores, Integer> {

}
