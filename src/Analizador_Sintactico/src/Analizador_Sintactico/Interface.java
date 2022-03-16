/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador_Sintactico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Aceve
 */
public class Interface extends javax.swing.JFrame {
    //----> Contenido de File Chooser
    JFileChooser seleccionar= new JFileChooser();
    File archivo;
    FileInputStream entrada;
    
    //----> Metodo Abrir Archivo
    public String Abrir_Archivo (File archivo)
    {
        String documento ="";
        try
        {
            entrada =new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read()) !=-1)
            {
                char caracter=(char)ascci;
                documento+=caracter;
            }
        }
        catch (IOException e)
            {   }
        return documento;
    }
    
    
    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Texto_de_Entrada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area_de_Resultado = new javax.swing.JTextArea();
        Texto_Cuadro_Result = new javax.swing.JLabel();
        Boton_Analizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Area_De_Texto = new javax.swing.JEditorPane();
        B_ABRIR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Sintáctico");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("AcadEref", 0, 10)); // NOI18N

        Texto_de_Entrada.setText("Texto a Analizar:");

        Area_de_Resultado.setColumns(20);
        Area_de_Resultado.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Area_de_Resultado.setRows(5);
        Area_de_Resultado.setSelectionColor(new java.awt.Color(0, 153, 255));
        jScrollPane1.setViewportView(Area_de_Resultado);

        Texto_Cuadro_Result.setText("Resultado:");

        Boton_Analizar.setText("Analizar");
        Boton_Analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AnalizarActionPerformed(evt);
            }
        });

        Area_De_Texto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(Area_De_Texto);

        B_ABRIR.setText("Abrir Archivo..");
        B_ABRIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ABRIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto_de_Entrada)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(B_ABRIR, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_Analizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Texto_Cuadro_Result)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Texto_de_Entrada)
                    .addComponent(Texto_Cuadro_Result))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_ABRIR)
                            .addComponent(Boton_Analizar)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * 
     * @param evt, en esta parte se ejecuta la prueba del lexer 
     * 
     */
    
    //----> Metodo Ejecutor de Análisis
    private void Boton_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AnalizarActionPerformed
        try
        {
            ProbarLexer();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_Boton_AnalizarActionPerformed

    //----> Metodo del boton Abrir Archivo 
    private void B_ABRIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ABRIRActionPerformed
        // TODO add your handling code here:
        if (seleccionar.showDialog(null, "Abrir Archivo")==JFileChooser.APPROVE_OPTION)
        {
            archivo=seleccionar.getSelectedFile();
            if (archivo.canRead())
            {
                if(archivo.getName().endsWith("txt"))
                {
                    String documento=Abrir_Archivo(archivo);
                    //----> Escrive el contenido del archivo en el area de entrada
                    Area_De_Texto.setText(documento);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Archivo NO COMPATIBLE");
                }
            }
        }
    }//GEN-LAST:event_B_ABRIRActionPerformed

    /**
     * @param args the command line arguments
     */
    
    //----> Incluye gestor de Tema
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
 
    /**
     * 
     * @throws IOException, Metodo para probar el lexer
     */
    /*    public String resultado="";*/
    
    public void ProbarLexer() throws IOException
    {
        File fichero = new File  ("entrada.txt");
        PrintWriter writer;
        try 
        {
            writer = new PrintWriter (fichero);
            writer.print(Area_De_Texto.getText());
            writer.close();
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        *En esta parte se almacena el contenido escrito en el cuadro de ingreso 
        *en un archivo *.txt para pasarlo al analizador
        */
        Reader reader = new BufferedReader(new FileReader("entrada.txt"));
        /*
        *Abro el archivo fichero.txt
        */
        Lexer lexer = new Lexer (reader);
        Parser parser = new Parser (lexer); 
        
        Area_de_Resultado.setText("Resultado del Análisis: \n \n");
        
        try 
        {
            parser.parse();
            //Area_de_Resultado.append("aceptado");

        } 
        catch (java.lang.Exception e) 
        {
            Area_de_Resultado.append("\n \n**Error Sintactico, La Sentencia de Entrada no está completa**");
                
        }
        
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Area_De_Texto;
    public static javax.swing.JTextArea Area_de_Resultado;
    private javax.swing.JButton B_ABRIR;
    private javax.swing.JButton Boton_Analizar;
    private javax.swing.JLabel Texto_Cuadro_Result;
    private javax.swing.JLabel Texto_de_Entrada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}