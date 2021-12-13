package com.liasoux;

import com.liasoux.pojo.OPGG;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class GameForumApplicationTests {


    @Autowired
    private MongoTemplate template;

    @Test
    void contextLoads() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("position").is("上单");
        query.addCriteria(criteria);
        List<OPGG> opggs = template.find(query, OPGG.class);
        System.out.println(opggs.toArray().length);
    }


    @Test
    void asd(){

//        GroupOperation noRepeatGroup = Aggregation.group( "userId","type")
//                .count().as("num")
//                .sum("totalProduct").as("count");
//        TypedAggregation<Order> noRepeatAggregation =
//                Aggregation.newAggregation(Order.class,noRepeatGroup);
//        AggregationResults<GroupVo> noRepeatDataInfoVos = mongoTemplate.aggregate(noRepeatAggregation, GroupVo.class);
//        List<GroupVo> noRepeatDataList = noRepeatDataInfoVos.getMappedResults();
//        System.out.println(JSON.toJSONString(noRepeatDataList));
//        return noRepeatDataList;



    }

}
