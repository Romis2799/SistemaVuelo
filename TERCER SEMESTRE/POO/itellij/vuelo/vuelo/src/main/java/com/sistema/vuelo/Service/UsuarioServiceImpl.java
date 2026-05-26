package com.sistema.vuelo.Service;


import com.sistema.vuelo.Model.Tarjeta;
import com.sistema.vuelo.Model.Usuario;
import com.sistema.vuelo.Repository.BaseRepository;
import com.sistema.vuelo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    public UsuarioServiceImpl (UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }


}
