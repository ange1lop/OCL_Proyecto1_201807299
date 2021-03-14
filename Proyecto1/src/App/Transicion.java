/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author Angel
 */
public class Transicion {
    public String estado;
    public String valor;
    public String estadoF;
    public String nombre;
    public String valorI;

    public Transicion(String estado, String valor, String estadoF,String nombre,String valori) {
        this.estado = estado;
        this.valorI = valori;
        this.valor = valor;
        this.estadoF = estadoF;
        this.nombre = nombre;
    }

    public String getValorI() {
        return valorI;
    }

    public void setValorI(String valorI) {
        this.valorI = valorI;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEstadoF() {
        return estadoF;
    }

    public void setEstadoF(String estadoF) {
        this.estadoF = estadoF;
    }
    
    
}
