package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Useracount;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UseracountService {
    public List<Useracount> findAllUseracount();

    public Optional<Useracount> findUseracountById(BigInteger id);

    public Useracount saveUseracount(Useracount useracountnew);

    public String deleteUseracount(BigInteger id);

    public String updateUseracount(Useracount useracount);

    // QUERY

    public List<Useracount> findUseracountsByEmail(String correo);

    public List<Useracount> findUseracountByUsername(String correo);
}
