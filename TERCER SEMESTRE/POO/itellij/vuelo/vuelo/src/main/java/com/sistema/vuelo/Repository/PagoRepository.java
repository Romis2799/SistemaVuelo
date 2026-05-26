package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends BaseRepository<Pago, Long> {
}
