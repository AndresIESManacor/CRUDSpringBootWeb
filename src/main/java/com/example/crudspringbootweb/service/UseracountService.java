package com.example.crudspringbootweb.service;

import com.example.crudspringbootweb.entity.Useracount;

import java.util.List;
import java.util.Optional;

public interface UseracountService {
    public List<Useracount> findAllUseracount();

    public Optional<Useracount> findUseracountById(int id);

    public Useracount saveUseracount(Useracount useracountnew);

    public List<Useracount> findUseracountsByEmail(String correo);

    public List<Useracount> findUseracountByUsername(String correo);

    public String deleteUseracount(int id);

    public String updateUseracount(Useracount useracount);
}
