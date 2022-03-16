/*---------------- Area1: Codigo de Usuario -----------------*/

//----> Paquetes e Importaciones
package Analizador_Sintactico;
import java_cup.runtime.*;
import java.util.LinkedList;


//---import static Analizador_Sintactico.Token.*;

/*------------- Area2: Opciones y Declaraciones -------------*/
%%

%{
//----> Codigo de Usuario
    public static LinkedList<Tabla_Error> Tabla_ERROR_LEXICO = new LinkedList<Tabla_Error>(); 
    public String resultado ="";
%}

//----> Directivas de Jflex
%public
%class Lexer
%cupsym Token
%cup
%char
%column
%full   
%ignorecase
%line
%unicode
//----> %type Token VER ESTA SENTENCIA llama al conjunto ENUM TOKEN

//----> Expresiones Regulares

Letras = [a-zA-z_ñÑ]
Digito = [0-9]
White = [ \t\r\n]

//----> Estados

%%

/*------------------ Area3: Reglas Lexicas ------------------*/

//----> Contexto General

    {White} {/*Ignore*/}
    "//".* {/*Ignore*/}

//----> Palabras Reservadas

<YYINITIAL>    "CREATE" {return new Symbol(Token.TKN_CREATE, yycolumn, yyline, yytext());}
<YYINITIAL>    "TABLE" {return new Symbol(Token.TKN_TABLE, yycolumn, yyline, yytext());}
<YYINITIAL>    "SELECT" {return new Symbol(Token.TKN_SELECT, yycolumn, yyline, yytext());}
<YYINITIAL>    "FROM" {return new Symbol(Token.TKN_FROM, yycolumn, yyline, yytext());}
<YYINITIAL>    "WHERE" {return new Symbol(Token.TKN_WHERE, yycolumn, yyline, yytext());}
<YYINITIAL>    "GROUP" {return new Symbol(Token.TKN_GROUP, yycolumn, yyline, yytext());}
<YYINITIAL>    "ORDER" {return new Symbol(Token.TKN_ORDER, yycolumn, yyline, yytext());}
<YYINITIAL>    "BY" {return new Symbol(Token.TKN_BY, yycolumn, yyline, yytext());}
<YYINITIAL>    "NOT" {return new Symbol(Token.TKN_NOT, yycolumn, yyline, yytext());}
<YYINITIAL>    "*" {return new Symbol(Token.TKN_TODO, yycolumn, yyline, yytext());}
<YYINITIAL>    "PRIMARY" {return new Symbol(Token.TKN_PRIMARY, yycolumn, yyline, yytext());}
<YYINITIAL>    "KEY" {return new Symbol(Token.TKN_KEY, yycolumn, yyline, yytext());}
<YYINITIAL>    "NULL" {return new Symbol(Token.TKN_NULL, yycolumn, yyline, yytext());}

//----> Funciones SQL

<YYINITIAL>    "COUNT" {return new Symbol(Token.TKN_COUNT, yycolumn, yyline, yytext());}
<YYINITIAL>    "AVG" {return new Symbol(Token.TKN_AVG, yycolumn, yyline, yytext());}
<YYINITIAL>    "SUM" {return new Symbol(Token.TKN_SUM, yycolumn, yyline, yytext());}
<YYINITIAL>    "MIN" {return new Symbol(Token.TKN_MIN, yycolumn, yyline, yytext());}
<YYINITIAL>    "MAX" {return new Symbol(Token.TKN_MAX, yycolumn, yyline, yytext());}

//----> Tipos de Datos

<YYINITIAL>    "VARCHAR" {return new Symbol(Token.TKN_VARCHAR, yycolumn, yyline, yytext());}
<YYINITIAL>    "CHAR" {return new Symbol(Token.TKN_CHAR, yycolumn, yyline, yytext());}
<YYINITIAL>    "STRING" {return new Symbol(Token.TKN_STRING, yycolumn, yyline, yytext());}
<YYINITIAL>    "INTEGER" {return new Symbol(Token.TKN_INTEG, yycolumn, yyline, yytext());}
<YYINITIAL>    "INT" {return new Symbol(Token.TKN_INTEG, yycolumn, yyline, yytext());}
//<YYINITIAL>    "FLOAT" {return new Symbol(Token.TKN_FLOAT, yycolumn, yyline, yytext());}

//----> Simbolos

<YYINITIAL>    "(" {return new Symbol(Token.TKN_APAR, yycolumn, yyline, yytext());}
<YYINITIAL>    ")" {return new Symbol(Token.TKN_CPAR, yycolumn, yyline, yytext());}
<YYINITIAL>    ";" {return new Symbol(Token.TKN_PTOCOMA, yycolumn, yyline, yytext());}
<YYINITIAL>    "." {return new Symbol(Token.TKN_PTO, yycolumn, yyline, yytext());}
<YYINITIAL>    "," {return new Symbol(Token.TKN_COMA, yycolumn, yyline, yytext());}
<YYINITIAL>    "<" {return new Symbol(Token.TKN_MEN, yycolumn, yyline, yytext());}
<YYINITIAL>    ">" {return new Symbol(Token.TKN_MAY, yycolumn, yyline, yytext());}
<YYINITIAL>    ">=" {return new Symbol(Token.TKN_MAYIGU, yycolumn, yyline, yytext());}
<YYINITIAL>    "<=" {return new Symbol(Token.TKN_MENIGU, yycolumn, yyline, yytext());}
<YYINITIAL>    "=" {return new Symbol(Token.TKN_IGUAL, yycolumn, yyline, yytext());}
<YYINITIAL>    "!=" {return new Symbol(Token.TKN_DIST, yycolumn, yyline, yytext());}
<YYINITIAL>    "and" {return new Symbol(Token.TKN_AND, yycolumn, yyline, yytext());}
<YYINITIAL>    "or" {return new Symbol(Token.TKN_OR, yycolumn, yyline, yytext());}
<YYINITIAL>    "'" {return new Symbol(Token.TKN_APOST, yycolumn, yyline, yytext());}
//<YYINITIAL>    "+" {return new Symbol(Token.TKN_PLUS, yycolumn, yyline, yytext());}
//<YYINITIAL>    "-" {return new Symbol(Token.TKN_MINUS, yycolumn, yyline, yytext());}
//<YYINITIAL>    "/" {return new Symbol(Token.TKN_DIVID, yycolumn, yyline, yytext());}

//----> Expresiones Regulares

<YYINITIAL>    {Letras} ({Letras}|{Digito})* {return new Symbol(Token.TKN_ID, yycolumn, yyline, yytext());}
<YYINITIAL>    [-+]?{Digito}+ {return new Symbol(Token.TKN_INT, yycolumn, yyline, yytext());}

//----> Error Lexico
    .   {System.out.println("Error, el simbolo o sentencia "+yytext() +"no fue recnocido \n");
        Tabla_Error datos = new Tabla_Error(yytext(), yyline, yycolumn, "Error Lexico, ", "Simbolo no pertenece al lenguaje");
        Tabla_ERROR_LEXICO.add(datos);}
