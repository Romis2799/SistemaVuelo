package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends BaseRepository<Vuelo, Long> {
}
