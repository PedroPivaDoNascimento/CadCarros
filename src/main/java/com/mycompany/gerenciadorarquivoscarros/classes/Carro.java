/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorarquivoscarros.classes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 *
 * @author piva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Carro {
    @XmlElement
    private String id;
    @XmlElement
    private String marca;
    @XmlElement
    private String modelo;
    @XmlElement
    private int ano;
    @XmlElement
    private double preco;

    public Carro() {
        this.id = "";
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.preco = 0.0;
    }

    public Carro(String id, String marca, String modelo, int ano, double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.marca);
        hash = 37 * hash + Objects.hashCode(this.modelo);
        hash = 37 * hash + this.ano;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
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
        final Carro other = (Carro) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carro{");
        sb.append("id=").append(id);
        sb.append(", marca=").append(marca);
        sb.append(", modelo=").append(modelo);
        sb.append(", ano=").append(ano);
        sb.append(", preco=").append(preco);
        sb.append('}');
        return sb.toString();
    }

    public void copy(Carro orig) {
        this.ano = orig.getAno();
        this.id = orig.getId();
        this.marca = orig.getMarca();
        this.modelo = orig.getModelo();
        this.preco = orig.getPreco();
    }
    
    

    
    
    
    
    
}
