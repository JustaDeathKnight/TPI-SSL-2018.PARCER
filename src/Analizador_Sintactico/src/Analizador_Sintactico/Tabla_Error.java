package Analizador_Sintactico;
/**
 *
 * @author Aceve
 */
public class Tabla_Error {
    String lexema, tipo, descripcion;
    int linea, columna;
    
    public Tabla_Error(String le, int li, int co, String t,String de)
    {
        lexema = le;
        linea = li;
        columna = co;
        tipo = t;
        descripcion = de;
    }
}
