package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends BaseRepository<Tarifa, Long> {
}
