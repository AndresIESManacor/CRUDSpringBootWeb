package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Membresia;
import com.example.crudspringbootweb.repository.Restaurante.MembresiaRepository;
import com.example.crudspringbootweb.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class MembresiaServiceImpl implements MembresiaService {

    @Autowired
    MembresiaRepository membresiaRepository;

    @Override
    public List<Membresia> findAllMembresia() {
        return membresiaRepository.findAll();
    }

    @Override
    public Optional<Membresia> findMembresiaById(BigInteger id) {
        return membresiaRepository.findById(id);
    }

    @Override
    public List<Membresia> findMembresiaByNum_Factura(String num_factura) {
        return membresiaRepository.findMembresiaByNum_Factura(num_factura);
    }

    @Override
    public Membresia saveMembresia(Membresia membresiaNew) {
        if (membresiaNew != null) {
            return membresiaRepository.save(membresiaNew);
        }
        return new Membresia();
    }

    @Override
    public String deleteMembresia(BigInteger id) {
        if (membresiaRepository.findById(id).isPresent()) {
            membresiaRepository.deleteById(id);
            return "Membresia eliminado correctamente.";
        }
        return "Error! El Membresia no existe";
    }

    @Override
    public String updateMembresia(Membresia membresia) {
        BigInteger num = membresia.getId_membresia();
        if (membresiaRepository.findById(num).isPresent()) {
            Membresia membresiaUpdate = new Membresia(
                    membresia.getId_membresia(),
                    membresia.getFecha_inicio(),
                    membresia.getFecha_fin(),
                    membresia.getFactura()
            );
            membresiaRepository.save(membresiaUpdate);
            return "Useracount modificado";
        }
        return "Error al Useracount el Restaurant";
    }
}
