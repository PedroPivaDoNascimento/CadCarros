/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorarquivoscarros.classes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author piva
 */
@XmlRootElement(name = "ListCarros")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListCarros {
    @XmlElement(name = "Carro")
    private List<Carro> listCarros;

    public ListCarros() {
        this.listCarros = new ArrayList<>();
    }

    public ListCarros(List<Carro> listCarros) {
        this.listCarros = listCarros;
    }

    public List<Carro> getListCarros() {
        return listCarros;
    }

    public void setListCarros(List<Carro> listCarros) {
        this.listCarros = listCarros;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.listCarros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListCarros other = (ListCarros) obj;
        return Objects.equals(this.listCarros, other.listCarros);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (Carro c : this.listCarros) {
            sb.append(c.toString()).append("\n");
            
        }
        
        return sb.toString();
    }
    
    public Carro findCarroById(String id) {
        for (Carro c : this.listCarros) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        
        return null;
    }
    
    public void add(Carro c) {
        if (findCarroById(c.getId()) == null) 
            this.listCarros.add(c);
    }
    
    public void remove(String id) {
        Carro removido = findCarroById(id);
        
        if (removido != null) 
            this.listCarros.remove(removido);
    }
    
    public void edit (String id, Carro newCarro) {
        Carro editedCarro = this.findCarroById(id);
        
        if (editedCarro != null) {
            editedCarro.copy(newCarro);
        }
    } 
    
    /*public void copy(ListCarros orig) {
        this.listCarros.clear();
        for (Carro c : orig.getListCarros()) {
            this.listCarros.add(c);
        } 
    }*/
    
    
}
