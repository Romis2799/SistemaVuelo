package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends BaseRepository<Aerolinea, Long> {
}
