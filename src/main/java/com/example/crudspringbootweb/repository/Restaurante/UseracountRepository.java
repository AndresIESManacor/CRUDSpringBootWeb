package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Useracount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UseracountRepository extends JpaRepository<Useracount, BigInteger> {
    Void save(Optional<Useracount> useracountOptional);

    @Query(value = "SELECT * FROM user_acount WHERE correo = ?1",nativeQuery = true)
    List<Useracount> findUseracountsByCorreo(String correo);

    @Query(value = "SELECT * FROM user_acount WHERE nombre_usuario = ?1",nativeQuery = true)
    List<Useracount> findUseracountsByUsername(String username);
}
