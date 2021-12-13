package com.liasoux.service.impl;

import com.liasoux.pojo.OPGG;
import com.liasoux.service.OPGGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OPGGServiceImpl implements OPGGService {

    @Autowired
    private MongoTemplate template;

    @Override
    public Map<String,List<OPGG>> findAll() {
        List<OPGG> topArr = new ArrayList<>();
        List<OPGG> jugArr = new ArrayList<>();
        List<OPGG> midArr = new ArrayList<>();
        List<OPGG> adcArr = new ArrayList<>();
        List<OPGG> supArr = new ArrayList<>();
        List<OPGG> all = template.findAll(OPGG.class);
        for (OPGG opgg : all) {
            switch (opgg.getPosition()){
                case "上单":
                    topArr.add(opgg);
                    break;
                case "打野":
                    jugArr.add(opgg);
                    break;
                case "中单":
                    midArr.add(opgg);
                    break;
                case "ADC":
                    adcArr.add(opgg);
                    break;
                default:
                    supArr.add(opgg);
            };
        }
        Map<String, List<OPGG>> opggMap = new HashMap<>();
        opggMap.put("top",topArr);
        opggMap.put("jug",jugArr);
        opggMap.put("mid",midArr);
        opggMap.put("adc",adcArr);
        opggMap.put("sup",supArr);
        return opggMap;
    }
}
