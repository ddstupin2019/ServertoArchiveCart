package com.example.demo.enity;

import java.util.ArrayList;
import java.util.List;

public class Poisk {
    public static Carts poisk(List<Carta> input, String filter){
        List<Carta> rezout=new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (rezout.get(i).getMesto().contains(filter)){
                rezout.add(input.get(i));
            }
        }
        Carts c= (Carts) rezout;
        return c;
    }
}
