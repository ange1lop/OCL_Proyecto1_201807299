package Analizadores;
import java_cup.runtime.*;
import App.*;

%%

%class Lexico
%cupsym sym
%cup 
%public
%unicode
%line 
%column
%ignorecase

%init{
    
%init}

/*
2.65, 2.5, 100
*, +, -, /
2+5+4*3-2/1
              +
           5      *
                4   3

*/

blancos = [ \t\r\n]+

//letras
letra = [a-zA-Z]
entero = [0-9]+  //0,1,2,3,4,5,6,7,8,9 -> 1111, 125
//suma = "+"

//Identificadores
identificador = {letra}({letra}|{entero}|"_")*

unilinea = ("//".*\n)|("//.*\r")
multilinea = ("<""!"[^\!]*"!"">")
cadena = "\""[^\"]*"\""
especiales = ("\\""n"|"\\""\'"|"\\""\"")

%{
    public void AddError(String tipo, String lexema, int fila, int columna){
        Errores nuevoE= new Errores(tipo, lexema, fila+1, columna+1);
        App.Aplicacion.listaErrores.add(nuevoE);
    }
%}

%%

"CONJ" {return new Symbol(sym.conj,yycolumn,yyline,yytext());}
"~" {return new Symbol(sym.colocho,yycolumn,yyline,yytext());}
//ASCII CODE
"!" {return new Symbol(sym.a33,yycolumn,yyline,yytext());}
"\"" {return new Symbol(sym.a34,yycolumn,yyline,yytext());}
"#" {return new Symbol(sym.a35,yycolumn,yyline,yytext());}
"$" {return new Symbol(sym.a36,yycolumn,yyline,yytext());}
"%" {return new Symbol(sym.a37,yycolumn,yyline,yytext());}
"&" {return new Symbol(sym.a38,yycolumn,yyline,yytext());}
"'" {return new Symbol(sym.a39,yycolumn,yyline,yytext());}
"(" {return new Symbol(sym.a40,yycolumn,yyline,yytext());}
")" {return new Symbol(sym.a41,yycolumn,yyline,yytext());}
"*" {return new Symbol(sym.a42,yycolumn,yyline,yytext());}
"+" {return new Symbol(sym.a43,yycolumn,yyline,yytext());}
"," {return new Symbol(sym.a44,yycolumn,yyline,yytext());}
"-" {return new Symbol(sym.a45,yycolumn,yyline,yytext());}
"." {return new Symbol(sym.a46,yycolumn,yyline,yytext());}
"/" {return new Symbol(sym.a47,yycolumn,yyline,yytext());}
":" {return new Symbol(sym.a58,yycolumn,yyline,yytext());}
";" {return new Symbol(sym.a59,yycolumn,yyline,yytext());}
"<" {return new Symbol(sym.a60,yycolumn,yyline,yytext());}
"=" {return new Symbol(sym.a61,yycolumn,yyline,yytext());}
">" {return new Symbol(sym.a62,yycolumn,yyline,yytext());}
"?" {return new Symbol(sym.a63,yycolumn,yyline,yytext());}
"@" {return new Symbol(sym.a64,yycolumn,yyline,yytext());}
"[" {return new Symbol(sym.a91,yycolumn,yyline,yytext());}
"\\" {return new Symbol(sym.a92,yycolumn,yyline,yytext());}
"]" {return new Symbol(sym.a93,yycolumn,yyline,yytext());}
"^" {return new Symbol(sym.a94,yycolumn,yyline,yytext());}
"_" {return new Symbol(sym.a95,yycolumn,yyline,yytext());}
"`" {return new Symbol(sym.a96,yycolumn,yyline,yytext());}
"{" {return new Symbol(sym.a123,yycolumn,yyline,yytext());}
"|" {return new Symbol(sym.a124,yycolumn,yyline,yytext());}
"}" {return new Symbol(sym.a125,yycolumn,yyline,yytext());}

\n {yycolumn=1;}
{blancos} {/*Se ignoran*/}
{unilinea} {/*Se ignoran*/}
{multilinea} {/*Se ignoran*/}
//45+98
{identificador} {return new Symbol(sym.identificador,yycolumn,yyline,yytext());}
{especiales} {return new Symbol(sym.especiales,yycolumn,yyline,yytext());}
{cadena} {return new Symbol(sym.cadena,yycolumn,yyline,yytext());}

{entero} {return new Symbol(sym.entero,yycolumn,yyline,yytext());} // almacenando un valor entero en la tabla de simbolos



//CUALQUIER ERROR:           SIMBOLOS NO DEFINIDOS DENTRO DEL LENGUAJE
.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn));
        AddError("Error Léxico",yytext(),yyline,yycolumn);
    }

/*   . {
    addError("tipo lexico", yytext(), yyline, yycolumn)

}

class name{

}

{

}

*/

