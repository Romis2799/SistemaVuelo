package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends BaseRepository<Tarjeta, Long> {
}
