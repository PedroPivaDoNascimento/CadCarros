/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorarquivoscarros.arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class FilePersistence {
    public static void saveToFile(String conteudo, String filePath) throws IOException {
        try (FileWriter arq = new FileWriter(filePath)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(conteudo);
        }
    }
    
    public static String loadFromFile(String filePath) throws FileNotFoundException {
        String conteudo = "";
        
        File file = new File(filePath);
        Scanner scan = new Scanner(file);
        
        // le até o final da linha igual o \n mas é mais preciso
        scan.useDelimiter("\\Z");
        while (scan.hasNext()) {
            conteudo += scan.next();
        }
        
        return conteudo;
    }
}
