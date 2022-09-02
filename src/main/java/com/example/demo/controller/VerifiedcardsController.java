package com.example.demo.controller;

import com.example.demo.enity.Carta;
import com.example.demo.enity.Carts;
import com.example.demo.enity.Filters;
import com.example.demo.repozitore.CartaRepozitores;
import com.example.demo.repozitore.FilterRepozitores;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Verified")
public class VerifiedcardsController {

    @Autowired
    CartaRepozitores cartaRepozitores;
    @Autowired
    FilterRepozitores filterRepozitores;

    @RequestMapping(value = "/setCart", method = RequestMethod.POST,
            consumes = "text/plain")
    public Integer setCart(@RequestBody String param){
        JSONObject jsonObject = new JSONObject(param);
        Carta carta=new Carta();
        carta.setCart(jsonObject.getString("cart"));
        carta.setSezon(jsonObject.getBoolean("sezon"));
        carta.setMesto(jsonObject.getString("mesto"));
        carta.setGroup(jsonObject.getString("group"));
        carta.setVid(jsonObject.getInt("vid"));
        carta.setRelef(jsonObject.getInt("relef"));
        carta.setMashtab(jsonObject.getInt("mashtab"));
        carta.setId(-1);
        cartaRepozitores.addCardNOV(carta,true);
        return 0;

    }

    @RequestMapping(value = "/getCart", method = RequestMethod.POST,
            consumes = "text/plain")
    public String getCart(@RequestBody String param){
        JSONObject jsonObject = new JSONObject(param);
        Filters filters=new Filters();
        filters.setGroup(jsonObject.getString("group"));
        filters.setMashtab(jsonObject.getInt("mashtab"));
        filters.setMesto(jsonObject.getString("mesto"));
        filters.setRelef(jsonObject.getInt("relef"));
        filters.setSezon(jsonObject.getBoolean("sezon"));
        filters.setVid(jsonObject.getInt("vid"));
        filters.setGod(jsonObject.getInt("god"));

        Carts carts=filterRepozitores.getCart(filters);
        Gson gson = new Gson();
        String root = gson.toJson(carts);
        return root;

    }

    @RequestMapping(value = "/deleteCart", method = RequestMethod.DELETE)
    public Integer deleteCart(@RequestParam("id") int id){

        return 0;
    }

}
