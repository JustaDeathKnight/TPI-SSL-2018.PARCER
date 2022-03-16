package Generadores;

import java.io.File;

public class G_Lexico 
{
    public static void main(String[] args) 
    {
        String path="src/Analizador_Sintactico/Lexer.flex";
        ConstruirLEXER(path);
    } 
    
    public static void ConstruirLEXER(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
}
