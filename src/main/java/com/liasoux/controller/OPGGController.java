package com.liasoux.controller;


import cn.hutool.json.JSONUtil;
import com.liasoux.pojo.OPGG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/opgg")
public class OPGGController {

    @Autowired
    private MongoTemplate template;

    @GetMapping("/findAll")
    public String findAll(){
        System.out.println("sadasdsa");
        List<OPGG> all = template.findAll(OPGG.class);
        return JSONUtil.toJsonStr(all);
    }

    @GetMapping("/findByPosition")
    public String findByPosition(){
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("position").is("上单");
        query.addCriteria(criteria);
        List<OPGG> opggs = template.find(query, OPGG.class);
        return "das";
    }


}
