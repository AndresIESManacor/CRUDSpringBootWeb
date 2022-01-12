package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.entity.Useracount;
import com.example.crudspringbootweb.repository.Restaurante.LocalidadRepository;
import com.example.crudspringbootweb.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocaliadadServiceImpl implements LocalidadService {

    @Autowired
    LocalidadRepository localidadRepository;

    @Override
    public List<Localidad> findAllLocalidad() {
        return localidadRepository.findAll();
    }

    @Override
    public Optional<Localidad> findLocalidadById(int id) {
        return localidadRepository.findById(id);
    }

    @Override
    public Localidad saveLocalidad(Localidad localidadNew) {
        if (localidadNew != null) {
            return localidadRepository.save(localidadNew);
        }
        return new Localidad();
    }

    @Override
    public String deleteLocalidad(int id) {
        if (localidadRepository.findById(id).isPresent()) {
            localidadRepository.deleteById(id);
            return "Localidad eliminado correctamente.";
        }
        return "Error! El Localidad no existe";
    }

    @Override
    public String updateLocalidad(Localidad localidad) {
        int num = localidad.getIdLocalidad();
        if (localidadRepository.findById(num).isPresent()) {
            Localidad localidadUpdate = new Localidad(
                    localidad.getIdLocalidad(),
                    localidad.getNombreLocalidad(),
                    localidad.getCodigoPostal()
            );
            localidadRepository.save(localidadUpdate);
            return "Useracount modificado";
        }
        return "Error al Useracount el Restaurant";
    }
}
