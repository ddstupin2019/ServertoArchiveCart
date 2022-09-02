package com.example.demo.controller;

import com.example.demo.enity.Carta;
import com.example.demo.repozitore.CartaRepozitores;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("NoVerified")
public class NoVerifiedardsController {

    @Autowired
    CartaRepozitores cartaRepozitores;

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
        cartaRepozitores.addCardNOV(carta,false);

        return 0;

    }

    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public String getCart(){
        String rezout="";
        Carta carts=cartaRepozitores.getNoVIrCart();
        Gson gson = new Gson();
        return gson.toJson(carts);

    }

    @RequestMapping(value = "/deleteCart", method = RequestMethod.DELETE)
    public Integer deleteCart(@RequestParam("id") int id){
        cartaRepozitores.delete(id);
        return 0;
    }
}
