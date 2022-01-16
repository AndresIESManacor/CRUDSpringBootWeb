package com.example.crudspringbootweb.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restaurante_etiquetas")
public class Restaurante_Etiquetas implements Serializable {
    @EmbeddedId
    cat.iesmanacor.backend_private.entities.Restaurante_EtiquetasId id;

    public Restaurante_Etiquetas(cat.iesmanacor.backend_private.entities.Restaurante_EtiquetasId id) {
        this.id = id;
    }
    public Restaurante_Etiquetas(){}
}
