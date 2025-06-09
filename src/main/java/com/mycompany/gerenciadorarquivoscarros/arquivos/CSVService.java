/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorarquivoscarros.arquivos;

import com.mycompany.gerenciadorarquivoscarros.classes.Carro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author piva
 */
public class CSVService {
    public static String toCSV(List<Carro> listCarros) {
        String csv = "ID;Marca;Modelo;Ano;Preço;\n";
        
        for (Carro c : listCarros) {
            csv += c.getId() + ";" +
                   c.getMarca() + ";" +
                   c.getModelo() + ";" +
                   c.getAno() + ";" + 
                   c.getPreco() + ";\n";
        }
        
        return csv;
    }
    
    public static List<Carro> fromCSV(String data) {
        List<Carro> listCarros = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 5) {
                Carro carro = new Carro();
                carro.setId(partes[0]);
                carro.setMarca(partes[1]);
                carro.setModelo(partes[2]);
                carro.setAno(Integer.parseInt(partes[3]));
                carro.setPreco(Double.parseDouble(partes[4]));
                
                listCarros.add(carro);
            }
        }
        
        return (List<Carro>) listCarros;
    }
}
