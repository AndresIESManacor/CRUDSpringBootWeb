package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Useracount;
import com.example.crudspringbootweb.repository.Restaurante.UseracountRepository;
import com.example.crudspringbootweb.service.UseracountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UseracountServiceImpl implements UseracountService {

    @Autowired
    UseracountRepository useracountRepository;

    @Override
    public List<Useracount> findAllUseracount() {
        return useracountRepository.findAll();
    }

    @Override
    public Optional<Useracount> findUseracountById(int id) {
        return useracountRepository.findById(id);
    }

    @Override
    public Useracount saveUseracount(Useracount useracountnew) {
        if (useracountnew != null) {
            return useracountRepository.save(useracountnew);
        }
        return new Useracount();
    }

    @Override
    public String deleteUseracount(int id) {
        if (useracountRepository.findById(id).isPresent()) {
            useracountRepository.deleteById(id);
            return "Useracount eliminado correctamente.";
        }
        return "Error! El Useracount no existe";
    }

    @Override
    public String updateUseracount(Useracount useracount) {
        int num = useracount.getId_user();
        if (useracountRepository.findById(num).isPresent()) {
            Useracount useracountUpdate = new Useracount(
                    useracount.getId_user(),
                    useracount.getNombre_usuario(),
                    useracount.getPassword(),
                    useracount.getCorreo(),
                    useracount.getTelefono(),
                    useracount.getNombre(),
                    useracount.getApellido1(),
                    useracount.getApellido2(),
                    useracount.getDni(),
                    useracount.isAdmin()
            );
            useracountRepository.save(useracountUpdate);
            return "Useracount modificado";
        }
        return "Error al Useracount el Restaurant";
    }
}
