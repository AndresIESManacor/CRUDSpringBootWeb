package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Factura;
import com.example.crudspringbootweb.repository.Restaurante.FacturaRepository;
import com.example.crudspringbootweb.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public List<Factura> findAllFactura() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> findFacturaById(String id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura saveFactura(Factura facturaNew) {
        if (facturaNew != null) {
            return facturaRepository.save(facturaNew);
        }
        return new Factura();
    }

    @Override
    public String deleteFactura(String id) {
        if (facturaRepository.findById(id).isPresent()) {
            facturaRepository.deleteById(id);
            return "Useracount eliminado correctamente.";
        }
        return "Error! El Useracount no existe";
    }

    @Override
    public String updateFactura(Factura factura) {
        String id = factura.getNumFactura();
        if (facturaRepository.findById(id).isPresent()) {
            Factura facturaUpdate = new Factura();
            facturaUpdate.setNumFactura(factura.getNumFactura());
            facturaUpdate.setDireccion(factura.getDireccion());
            facturaUpdate.setImporte(factura.getImporte());
            facturaRepository.save(facturaUpdate);
            return "Useracount modificado";
        }
        return "Error al Useracount el Restaurant";
    }
}
