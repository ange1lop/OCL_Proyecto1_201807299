/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public class Siguiente {
    public int hoja;
    public String valor;
    public String siguiente;

    public Siguiente(int hoja, String valor, String siguiente) {
        this.hoja = hoja;
        this.valor = valor;
        this.siguiente = siguiente;
        
    }

    
    public int getHoja() {
        return hoja;
    }

    public void setHoja(int hoja) {
        this.hoja = hoja;
    }

    public String getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(String siguiente) {
        this.siguiente = siguiente;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
