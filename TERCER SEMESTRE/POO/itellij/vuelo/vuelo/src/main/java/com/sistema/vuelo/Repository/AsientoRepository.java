package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends BaseRepository<Asiento, Long> {
}
