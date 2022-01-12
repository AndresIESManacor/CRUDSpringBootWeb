package com.example.crudspringbootweb;

import com.example.crudspringbootweb.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class CrudSpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootWebApplication.class, args);
    }
//
//    public static Restaurant getRestaurant() {
//        Restaurant restaurant = new Restaurant();
//
//        restaurant.setNombre("Andres");
//        restaurant.setDiesAnticipacionReservas(15);
//        restaurant.setTelefonoRestaurante(1111000);
//        restaurant.setVisible(true);
//        restaurant.setValidated(true);
//
//        restaurant.setUseracount(getUseracount());
//        restaurant.setMembresia(getMembresia());
//        restaurant.setLocalidad(getLocalidad());
//
//        return restaurant;
//    }
//
//    public static Useracount getUseracount() {
//        //Insert into the table
//        Useracount useracount = new Useracount();
//        useracount.setUser(getUser());
////        useracount.setNombre("Andres");
////        useracount.setApellido1("Garcia");
////        useracount.setApellido2("Bauza");
////        useracount.setCorreo("militaxx5@gmail.com");
////        useracount.setDni("41615421A");
////        useracount.setTelefono(23414);
//
//        return useracount;
//    }
//
//    public static User getUser() {
//        //Insert into the table
//        User user = new User();
//        user.setIdUser(1);
//        user.setNombreUsuario("Andres");
//        user.setContraseña("ANDRESito555");
//
//        return user;
//    }
//
//    public static Localidad getLocalidad() {
//        //Insert into the table
//        Localidad localidad = new Localidad();
//        localidad.setNombreLocalidad("Arta");
//        localidad.setCodigoPostal(3960);
//
//        return localidad;
//    }
//
//    public static Membresia getMembresia() {
//        //Insert into the table
//        Membresia membresia = new Membresia();
//        membresia.setIdMembresia(1);
//        membresia.setFechaInicio(new Timestamp(System.currentTimeMillis()));
//        membresia.setFechaFin(new Timestamp(System.currentTimeMillis()));
//        membresia.setFactura(getFactura());
//
//        return membresia;
//    }
//    public static Factura getFactura() {
//        //Insert into the table
//        Factura factura = new Factura();
//        factura.setNumFactura("1");
//        factura.setDireccion("Mi Direccion");
//        factura.setImporte(555);
//
//        return factura;
//    }
}
