package com.puce.CeviSystemBack.security.Entity;

import java.util.List;



public interface UserService {

    List<User> usuarios();
    User buscarUsuarioId(Long id);
    User guardarUsuario(User usuario);
    void cambioEstado(Long id, boolean estado);
    boolean existeCorreoElectronico(String correoElectronico);

}
