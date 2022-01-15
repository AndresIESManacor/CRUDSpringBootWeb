package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Comentarios;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ComentariosService {
    public List<Comentarios> findAllComentarios();

    public Optional<Comentarios> findComentarioById(BigInteger id);

    public Comentarios saveComentario(Comentarios comentariosNew);

    public void deleteComentario(BigInteger id);

    public void updateComentario(Comentarios comentarios);
}
