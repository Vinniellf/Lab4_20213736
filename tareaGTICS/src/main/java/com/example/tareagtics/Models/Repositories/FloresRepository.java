package com.example.tareagtics.Models.Repositories;

import com.example.tareagtics.Models.Entities.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloresRepository extends JpaRepository<Flores, Integer> {
    @Query("SELECT f FROM Flores f WHERE (:tipo = 0 OR f.tipo.id = :tipo) AND (:color = 0  OR f.color.id = :color) AND (:ocasion = 0 OR f.ocasion.id = :ocasion)")
    List<Flores> findByTipoColorOcasion(@Param("tipo") Long  tipo, @Param("color") Long  color, @Param("ocasion") Long  ocasion);
}
