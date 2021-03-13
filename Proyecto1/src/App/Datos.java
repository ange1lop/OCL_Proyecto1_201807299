/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.List;

/**
 *
 * @author Angel
 */
public class Datos {
    public Nodo raiz;
    public List<Siguiente> tablaSiguiente;
    public int Aceptacion;
    public String estadoAceptacion;

    public Datos(Nodo raiz, List<Siguiente> tablaSiguiente, int Aceptacion, String estadoAceptacion) {
        this.raiz = raiz;
        this.tablaSiguiente = tablaSiguiente;
        this.Aceptacion = Aceptacion;
        this.estadoAceptacion = estadoAceptacion;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public List<Siguiente> getTablaSiguiente() {
        return tablaSiguiente;
    }

    public void setTablaSiguiente(List<Siguiente> tablaSiguiente) {
        this.tablaSiguiente = tablaSiguiente;
    }

    public int getAceptacion() {
        return Aceptacion;
    }

    public void setAceptacion(int Aceptacion) {
        this.Aceptacion = Aceptacion;
    }

    public String getEstadoAceptacion() {
        return estadoAceptacion;
    }

    public void setEstadoAceptacion(String estadoAceptacion) {
        this.estadoAceptacion = estadoAceptacion;
    }
    
    
}
