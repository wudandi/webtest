package com.example.webtest1.model;

import lombok.Data;

@Data
public class User {
    private String point;
    private String explanation;
    private String ID;

    public User(){

    }

    public User(String id, String point, String explannation){
        this.setID(id);
        this.setExplanation(explannation);
        this.setPoint(point);
    }

}
