package com.example.tareagtics.Models.Repositories;

import com.example.tareagtics.Models.Entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
}
