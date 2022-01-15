package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Comentarios;
import org.springframework.ui.ModelMap;

public interface ComentariosController {
    public String show(ModelMap model);

    public String findComentarioById(String id, ModelMap model);

    public void saveComentario(Comentarios comentarios);

    public void deleteComentarioById(String id);

    public void updateComentario(Comentarios comentariosNew);
}
