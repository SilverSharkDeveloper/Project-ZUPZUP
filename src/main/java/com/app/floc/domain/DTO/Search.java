package com.app.floc.domain.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Search {
    String type;
    String keyword;
    String order;

//    public Search(String type, String keyword){
//        this(type, keyword, "recent");
//    }
//
//    public Search(String type, String keyword,String order){
//        this.type = type;
//        this.keyword = keyword;
//        this.order = order == null? "recent" : order;
//    }

    public String[] getTypes(){
        return type.split("");
    }
}