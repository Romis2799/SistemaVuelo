package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends BaseRepository<Consulta, Long> {
}
