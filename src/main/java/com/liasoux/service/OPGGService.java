package com.liasoux.service;

import com.liasoux.pojo.OPGG;

import java.util.List;
import java.util.Map;


public interface OPGGService {

    Map<String,List<OPGG>> findAll();

}
