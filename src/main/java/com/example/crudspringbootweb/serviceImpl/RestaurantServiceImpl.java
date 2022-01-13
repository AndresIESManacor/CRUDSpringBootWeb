package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Restaurant;
import com.example.crudspringbootweb.repository.Restaurante.RestaurantRepository;
import com.example.crudspringbootweb.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findRestaurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurantNew) {
        if (restaurantNew != null) {
            return restaurantRepository.save(restaurantNew);
        }
        return new Restaurant();
    }

    @Override
    public String deleteRestaurant(int id) {
        if (restaurantRepository.findById(id).isPresent()) {
            restaurantRepository.deleteById(id);
            return "Restaurant eliminado correctamente.";
        }
        return "Error! El Restaurant no existe";
    }

    @Override
    public String updateRestaurant(Restaurant restaurantNew) {
        int num = restaurantNew.getId_restaurante();
        if (restaurantRepository.findById(num).isPresent()) {
            Restaurant customerToUpdate = new Restaurant(
                    restaurantNew.getId_restaurante(),
                    restaurantNew.getNombre(),
                    restaurantNew.getDies_anticipacion_reservas(),
                    restaurantNew.getTelefono_restaurante(),
                    restaurantNew.isValidated(),
                    restaurantNew.getLocalidad(),
                    restaurantNew.getMembresia(),
                    restaurantNew.getUseracount(),
                    restaurantNew.isVisible()
            );
            restaurantRepository.save(customerToUpdate);
            return "Restaurant modificado";
        }
        return "Error al modificar el Restaurant";
    }
}
