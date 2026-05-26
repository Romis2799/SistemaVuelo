package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends BaseRepository<Avion, Long> {
}
