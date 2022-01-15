package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Comentarios;
import com.example.crudspringbootweb.entity.Img;
import com.example.crudspringbootweb.repository.Restaurante.ImgRepository;
import com.example.crudspringbootweb.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    ImgRepository imgRepository;


    @Override
    public List<Img> findAllImgs() {
        return imgRepository.findAll();
    }

    @Override
    public Optional<Img> findImgById(BigInteger id) {
        return imgRepository.findById(id);
    }

    @Override
    public Img saveImg(Img imgNew) {
        if (imgNew!=null) {
            imgRepository.save(imgNew);
        }
        return new Img();
    }

    @Override
    public void deleteImg(BigInteger id) {
        if (imgRepository.findById(id).isPresent()) {
            imgRepository.deleteById(id);
        }
    }

    @Override
    public void updateImg(Img img) {
        BigInteger id = img.getId_img();
        if (imgRepository.findById(id).isPresent()) {
            Img imgUpdate = new Img();
            imgUpdate.setId_img(img.getId_img());
            imgUpdate.setUrl(img.getUrl());
            imgUpdate.setRestaurant(img.getRestaurant());
            imgRepository.save(imgUpdate);
        }
    }
}
