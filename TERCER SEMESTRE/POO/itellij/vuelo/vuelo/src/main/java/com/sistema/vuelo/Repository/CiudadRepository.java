package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends BaseRepository<Ciudad, Long> {
}
