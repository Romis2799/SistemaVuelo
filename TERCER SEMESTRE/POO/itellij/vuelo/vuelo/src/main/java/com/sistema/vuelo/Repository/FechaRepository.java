package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Fecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechaRepository extends BaseRepository<Fecha, Long> {
}
