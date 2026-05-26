package com.sistema.vuelo.Repository;

import com.sistema.vuelo.Model.Tarjeta;
import com.sistema.vuelo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
}
