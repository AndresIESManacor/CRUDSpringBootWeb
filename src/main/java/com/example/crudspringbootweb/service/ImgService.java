package com.example.crudspringbootweb.service;


import com.example.crudspringbootweb.entity.Img;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ImgService {
    public List<Img> findAllImgs();

    public Optional<Img> findImgById(BigInteger id);

    public Img saveImg(Img imgNew);

    public void deleteImg(BigInteger id);

    public void updateImg(Img img);

    // QUERY

    public List<Img> findImgByUrl(String url);
}
