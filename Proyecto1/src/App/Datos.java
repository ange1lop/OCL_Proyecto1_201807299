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
public class Datos {
    public Nodo raiz;
    public ArrayList<Siguiente> tablaSiguiente;
    public int Aceptacion;
    public String estadoInicial;
    public String nombre;

    public Datos(Nodo raiz, ArrayList<Siguiente> tablaSiguiente, int Aceptacion, String estadoInicial, String nombre) {
        this.raiz = raiz;
        this.tablaSiguiente = tablaSiguiente;
        this.Aceptacion = Aceptacion;
        this.estadoInicial = estadoInicial;
        this.nombre = nombre;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public ArrayList<Siguiente> getTablaSiguiente() {
        return tablaSiguiente;
    }

    public void setTablaSiguiente(ArrayList<Siguiente> tablaSiguiente) {
        this.tablaSiguiente = tablaSiguiente;
    }

    public int getAceptacion() {
        return Aceptacion;
    }

    public void setAceptacion(int Aceptacion) {
        this.Aceptacion = Aceptacion;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String reporteSiguiente(){
        String repo = "<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"  <title>Bootstrap Example</title>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<div class=\"container\">\n" +
"  <h2>"+this.nombre+"/h2>\n" +
"    <thead>\n" +
"      <tr>\n" +
"        <th>ID</th>\n" +
"        <th>VALOR</th>\n" +
"        <th>SIGUIENTES</th>\n" +
"      </tr>\n" +
"    </thead>\n" +
"    <tbody>\n";
        for(Siguiente s:tablaSiguiente){
            repo += "      <tr>\n" +
"        <td>"+s.hoja+"</td>\n" +
"        <td>"+s.valor+"</td>\n" +
"        <td>"+s.getSiguiente()+"</td>\n" +
"      </tr>\n";
        }
        repo += "</tbody>\n" +
"  </table>\n" +
"</div>\n" +
"\n" +
"</body>\n" +
"</html>";
        return repo;
    }
    
}
