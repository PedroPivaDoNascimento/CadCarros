package com.mycompany.gerenciadorarquivoscarros.arquivos;

import com.mycompany.gerenciadorarquivoscarros.classes.ListCarros;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author piva
 */
public class XMLService {
    //Serializa um objeto para XML
    public static String toXML(ListCarros listCarros) throws JAXBException {
        try {
           JAXBContext context = JAXBContext.newInstance(ListCarros.class);
           Marshaller marshaler = context.createMarshaller();
           marshaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
           
           StringWriter writer = new StringWriter();
           marshaler.marshal(listCarros, writer);
           return writer.toString();
       } catch (JAXBException e){
           return null;
       }
    }
    
    public static ListCarros fromXML(String xmlString) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(ListCarros.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            
            return (ListCarros) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            return null;
        }
    }
}
