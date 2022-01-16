package com.example.crudspringbootweb.controllers;

import com.example.crudspringbootweb.entity.Useracount;
import org.springframework.ui.ModelMap;

import java.math.BigInteger;


public interface UseracountController {
    public String show(ModelMap model);

    public String getUseracountById(BigInteger id, ModelMap model);

    public void saveUseracount(Useracount useracount);

    public void deleteUseracountById(BigInteger id);

    public void updateUseracount(Useracount useracountNew);
}
