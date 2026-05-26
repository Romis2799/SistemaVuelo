package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends BaseRepository<Reserva, Long> {
}
