package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.repository.Restaurante.LocalidadRepository;
import com.example.crudspringbootweb.service.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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
    public Optional<Localidad> findLocalidadById(BigInteger id) {
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
    public void deleteLocalidad(BigInteger id) {
        if (localidadRepository.findById(id).isPresent()) {
            localidadRepository.deleteById(id);
        }
    }

    @Override
    public void updateLocalidad(Localidad localidad) {
        BigInteger num = localidad.getId_localidad();
        if (localidadRepository.findById(num).isPresent()) {
            Localidad localidadUpdate = new Localidad(
                    localidad.getId_localidad(),
                    localidad.getNombre_localidad(),
                    localidad.getCodigo_postal()
            );
            localidadRepository.save(localidadUpdate);
        }
    }

    public List<Localidad> findLocalidadByNombre_localidad(String nombre) {
        return localidadRepository.findLocalidadByNombre_localidad(nombre);
    }
}
