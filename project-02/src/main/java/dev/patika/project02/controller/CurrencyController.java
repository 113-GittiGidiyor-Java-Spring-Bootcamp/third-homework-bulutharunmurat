package dev.patika.project02.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import dev.patika.project02.entity.Currency;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final static String ENDPOINT = "http://data.fixer.io/api/latest?access_key=f1b969a26905afa978b827d1375e1471&format=1";

    @Autowired
    RestTemplate restTemplate;


    @SneakyThrows
    @GetMapping("/getstr/{id}")
    public String getJsonFromRemoteWebsiteString (@PathVariable int id) throws JSONException {
        ResponseEntity<String>  str = restTemplate.getForEntity(ENDPOINT, String.class);
        JSONObject obj = new JSONObject(str.getBody().toString());
        JSONObject rates = obj.getJSONObject("rates");

        float rate = (float) rates.getInt("TRY");
        float converted = rate * id;
        return id + " TRY is equal to " + converted + " EURO";
    }
}
