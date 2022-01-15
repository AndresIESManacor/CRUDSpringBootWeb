package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Restaurante_Etiquetas;
import com.example.crudspringbootweb.entity.Restaurante_EtiquetasId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Restaurante_EtiquetasRepository extends JpaRepository<Restaurante_Etiquetas, Restaurante_EtiquetasId> {
}
