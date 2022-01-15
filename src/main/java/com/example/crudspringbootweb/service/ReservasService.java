package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Reservas;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ReservasService {
    public List<Reservas> findAllReservass();

    public Optional<Reservas> findReservaById(BigInteger id);

    public Reservas saveReserva(Reservas reservasNew);

    public void deleteReserva(BigInteger id);

    public void updateReserva(Reservas reservas);
}
