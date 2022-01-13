package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Restaurant;
import com.example.crudspringbootweb.entity.Useracount;
import org.apache.catalina.User;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface UseracountController {
    public String getAllUseracount(ModelMap model);

    public String getUseracountById(int id, ModelMap model);

    public Useracount saveUseracount(Useracount useracount);

    public String deleteUseracountById(int id);

    public String updateUseracount(Useracount useracountNew);
}
