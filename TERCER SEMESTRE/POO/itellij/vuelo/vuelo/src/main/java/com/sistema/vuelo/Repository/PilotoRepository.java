package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends BaseRepository<Piloto, Long> {
}
