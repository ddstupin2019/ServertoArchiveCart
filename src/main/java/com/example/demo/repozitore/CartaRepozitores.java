package com.example.demo.repozitore;

import com.example.demo.enity.Carta;
import com.example.demo.enity.CartaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CartaRepozitores {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addCardNOV(Carta carta, boolean inp){
        String v="VirificateCart";
        String n="NoVirificateCart";
        String a;
        if (inp){
            a=v;
        }else {
            a=n;
        }
        jdbcTemplate.update("insert into \""+a+"\" (\"id\") values(?)", carta.getId());
        jdbcTemplate.update("insert into \""+a+"\" (\"cart\") values(?)", carta.getCart());
        jdbcTemplate.update("insert into \""+a+"\" (\"mashtab\") values(?)", carta.getMashtab());
        jdbcTemplate.update("insert into \""+a+"\" (\"relef\") values(?)", carta.getRelef());
        jdbcTemplate.update("insert into \""+a+"\" (\"mesto\") values(?)", carta.getMesto());
        jdbcTemplate.update("insert into \""+a+"\" (\"vid\") values(?)", carta.getVid());
        jdbcTemplate.update("insert into \""+a+"\" (\"god\") values(?)", carta.getGod());
        jdbcTemplate.update("insert into \""+a+"\" (\"sezon\") values(?)", carta.getSezon());
        jdbcTemplate.update("insert into \""+a+"\" (\"group\") values(?)", carta.getGroup());
        return carta.getId();
    }
    public void delete(Integer id){
        jdbcTemplate.update("delet from \"NoVirificateCart\" where \"id\" = ?", id);
    }

    public Carta getNoVIrCart(){
        return (Carta) jdbcTemplate.query("select * from \"NoVirificateCart\" where \"id\">?", new CartaMapper(), -1);
    }
}
