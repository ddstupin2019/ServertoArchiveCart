package com.example.demo.repozitore;

import com.example.demo.enity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterRepozitores {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Carts getCart(Filters filters){
        String a=" and ";
        String zapros = "select * from VirificateCart where \"sezon\"="+filters.getSezon();
        if (filters.getGod()!=0){
            zapros+=a;
            zapros+="\"god\">"+filters.getGod();
        }if (!filters.getGroup().equals("")){
            zapros+=a;
            zapros+="\"group\"="+filters.getGroup();
        }if (filters.getMashtab()!=0){
            zapros+=a;
            zapros+="\"mashtab\"="+filters.getMashtab();
        }if (filters.getRelef()!=0){
            zapros+=a;
            zapros+="\"relef\"="+filters.getRelef();
        }if (filters.getVid()!=-1){
            zapros+=a;
            zapros+="\"vid\"="+filters.getVid();
        }
        List<Carta> persons = jdbcTemplate.query(zapros, new CartaMapper());

        return Poisk.poisk(persons, filters.getMesto());
    }
}
