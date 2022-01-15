package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Restaurante_Etiquetas;
import com.example.crudspringbootweb.entity.Restaurante_EtiquetasId;
import com.example.crudspringbootweb.repository.Restaurante.Restaurante_EtiquetasRepository;
import com.example.crudspringbootweb.service.Restaurante_EtiquetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Restaurante_EtiquetasServiceImpl implements Restaurante_EtiquetasService {
    @Autowired
    Restaurante_EtiquetasRepository restaurante_etiquetasRepository;

    @Override
    public List<Restaurante_Etiquetas> findAllRestaurante_Etiquetas() {
        return restaurante_etiquetasRepository.findAll();
    }

    @Override
    public Optional<Restaurante_Etiquetas> findRestaurante_EtiquetasById(Restaurante_EtiquetasId id) {
        return restaurante_etiquetasRepository.findById(id);
    }

    @Override
    public Restaurante_Etiquetas saveRestaurante_Etiquetas(Restaurante_Etiquetas etiquetas) {
        if (etiquetas!=null) {
            restaurante_etiquetasRepository.save(etiquetas);
        }
        return new Restaurante_Etiquetas();
    }

    @Override
    public void deleteRestaurante_Etiquetas(Restaurante_EtiquetasId id) {
        if (restaurante_etiquetasRepository.findById(id).isPresent()) {
            restaurante_etiquetasRepository.deleteById(id);
        }
    }

    @Override
    public void updateRestaurante_Etiquetas(Restaurante_Etiquetas etiquetas) {
        Restaurante_EtiquetasId num = etiquetas.getId();
        if (restaurante_etiquetasRepository.findById(num).isPresent()) {
            Restaurante_Etiquetas restaurante_etiquetas = new Restaurante_Etiquetas (
                    etiquetas.getId()
            );
            restaurante_etiquetasRepository.save(restaurante_etiquetas);
        }
    }
}
