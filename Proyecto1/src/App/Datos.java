/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.ArrayList;
import java.util.Collections;

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
    public ArrayList<Transicion> tablaTransiciones;
    public ArrayList<String> terminales;
    public int contador = 0;
    public ArrayList<String> estados;

    public Datos(Nodo raiz, ArrayList<Siguiente> tablaSiguiente, int Aceptacion, String estadoInicial, String nombre) {
        this.raiz = raiz;
        this.tablaSiguiente = tablaSiguiente;
        this.Aceptacion = Aceptacion;
        this.estadoInicial = estadoInicial;
        this.nombre = nombre;
        this.tablaTransiciones = new ArrayList<Transicion>();
        this.terminales = new ArrayList<String>();
        this.estados=new ArrayList<String>();
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
"  <h2>Basic Table</h2>\n" +
"  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            \n" +
"  <table class=\"table\">\n" +
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
    public void calcularTerminales(){
        for(Siguiente s:tablaSiguiente){
            boolean ingreso = true;
            for(String terminal :terminales){
                if(s.getValor().equals(terminal)){
                    ingreso = false;
                    break;
                }
            }
            if(ingreso){
                terminales.add(s.getValor());
            }
        }
    }
    
    public void calcularEstados(){
        for(Transicion s:tablaTransiciones){
            boolean ingreso = true;
            for(String terminal :estados){
                if(s.getEstado().equals(terminal)){
                    ingreso = false;
                    break;
                }
            }
            if(ingreso){
                estados.add(s.getEstado());
            }
        }
    }
    
    public void calcularTransicion(String estado){
        String[] estadosI = estado.split(",");
        ArrayList<String> estadosCalculados = new ArrayList<String>();
        for(String terminal: terminales){
            String estadoF = "";
            for(String estadoI:estadosI){
                for(Siguiente siguiente:tablaSiguiente){
                    if (!estadoI.equals("") && siguiente.getHoja() == Integer.parseInt(estadoI) && siguiente.getValor().equals(terminal)){
                        if (estadoF.equals("")){
                            estadoF = siguiente.getSiguiente();
                        }else{
                            String[] partsEstadoF = estadoF.split(",");
                            String[] partsSiguiente = siguiente.getSiguiente().split(",");
                            for(String ps:partsSiguiente){
                                boolean ingresar = true;
                                for(String pef:partsEstadoF){
                                    
                                    if(ps == pef){
                                        ingresar = false;
                                    }
                                }
                                if(ingresar){
                                    estadoF += ps;
                                }
                            }
                        }
                    }
                }
            }
            
            if(!estadoF.equals("")){
                estadoF = ordenarEstados(estadoF);
                boolean ingreso = true;
                String nombreEstado = "";
                String nomI = "";
                if (contador == 0){
                    nomI = "S0";
                }
                for(Transicion tran:tablaTransiciones){
                    if(contador != 0){
                        if(tran.getEstado().equals(estado)){
                            nomI = tran.getNombre();
                        }
                    }
                    if(tran.getEstado().equals(estadoF)){
                        ingreso = false;
                        nombreEstado = tran.getNombre();
                        break;
                    }
                }
                
                boolean aumentarconteo = false;
                if(ingreso){
                    nombreEstado = "S"+this.contador;
                    aumentarconteo = true;
                }
                ingreso = true;
                for(Transicion tran:tablaTransiciones){
                    if(tran.getEstado().equals(estado) && tran.getEstadoF().equals(estadoF) && tran.getValor().equals(terminal)){
                        ingreso = false;
                        aumentarconteo = false;
                        break;
                    }
                }
                if(ingreso){
                    Transicion nuevo = new Transicion(estado,terminal,estadoF,nombreEstado,nomI);
                    estadosCalculados.add(estadoF);
                    if(aumentarconteo){
                        this.contador++;
                    }
                    tablaTransiciones.add(nuevo);
                }
                
            }
            
        }
        for(String es:estadosCalculados){
            calcularTransicion(es);
        }
    }
    public String ordenarEstados(String estados){
        String[] st = estados.split(",");
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(String in:st){
            if(!in.equals("")){
                temp.add(Integer.parseInt(in));
            }
        }
        Collections.sort(temp);
        String retorno = "";
        for(int s:temp){
            if(retorno.equals("")){
                retorno += s;
            }else{
                retorno += ","+s;
            }
        }
        return retorno;
    }
    public String generarTablaTransicion(){
        calcularTerminales();
        calcularTransicion(this.estadoInicial);
        calcularEstados();
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
"  <h2>Basic Table</h2>\n" +
"  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            \n" +
"  <table class=\"table\">\n" +
"    <thead>\n" +
"      <tr>\n" +
"        <th>Estado</th>\n" ;

        for(String terminal: terminales){
            repo += "        <th>"+terminal+"</th>\n";
        }
        repo +="      </tr>\n" +
"    </thead>\n" +
"    <tbody>\n";int contador4 = 0;
        for(String estado:estados){
            repo += "      <tr>\n";
            String nombreEstado = "S"+contador4;
            repo +="        <td>"+nombreEstado+"</td>\n" ;
            for(String terminal :terminales){
                boolean ingresot = true;
                for(Transicion s:tablaTransiciones){
                    if(s.getEstado().equals(estado) && s.getValor().equals(terminal)){
                        for(Transicion s2: tablaTransiciones){
                            if(s2.getEstadoF().equals(s.getEstadoF())){
                                repo +="        <td>"+s2.getNombre()+"</td>\n" ;
                                ingresot = false;
                                break;
                            }
                        }
                        break;
                    }
                
                }
                if(ingresot){
                    repo +="        <td>------</td>\n" ;
                }
            }
            contador4++;
            repo += "      </tr>\n";
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
