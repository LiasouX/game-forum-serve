package com.liasoux.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("opgg")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OPGG {

    private String _id;
    private String level;
    private String name;
    private String pick;
    private String position;
    private String winner;
}
