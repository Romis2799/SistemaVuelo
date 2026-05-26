package com.sistema.vuelo.Controller;


import com.sistema.vuelo.Model.Usuario;
import com.sistema.vuelo.Service.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController extends BaseController<Usuario, Long> {

    public UsuarioController (UsuarioService usuarioService) {
        super(usuarioService);
    }
}
