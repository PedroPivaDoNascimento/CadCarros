/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorarquivoscarros.arquivos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.gerenciadorarquivoscarros.classes.Carro;
import java.util.List;

/**
 *
 * @author piva
 */
public class JSONService {
    public static String toJSON(List<Carro> listCarros) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(listCarros);
            
            return jsonString;
        } catch (JsonProcessingException e){
            return null;
        }
    }
    
    public static List<Carro> fromJSON(String jsonString) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Carro> listCarros = mapper.readValue(jsonString, new TypeReference<List<Carro>>() {});
            
            return listCarros;
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
