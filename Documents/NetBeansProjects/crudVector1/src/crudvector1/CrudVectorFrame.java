/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudvector1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Segintec SAC
 */
public class CrudVectorFrame extends JFrame {
    
    metodosSistema metodos= new metodosSistema();
    JLabel lb_nombre= new JLabel("Nombre");
    JTextField txt_nombre= new JTextField();
    
    JLabel lb_apellido_paterno = new JLabel("Ap. Paterno");
    JTextField txt_apellido_paterno= new JTextField();
    
    JLabel lb_apellido_materno = new JLabel("Ap. Materno");
    JTextField txt_apellido_materno= new JTextField();
    
    JLabel lb_codigo = new JLabel("Codigo");
    JTextField txt_codigo= new JTextField();
    
    
    public CrudVectorFrame(){
        
    
    JMenuBar menuBar                 =new JMenuBar();
    JMenu menuFile                   =new JMenu();
    JMenu menuMantenimiento          =new JMenu();
    JMenu menuReportes               =new JMenu();
    
    JMenuItem menuFile_Exit                       =new JMenuItem();
    JMenuItem menuMantenimiento_Ingresar          =new JMenuItem();
    JMenuItem menuMantenimiento_Eliminar          =new JMenuItem();
    JMenuItem menuReportes_General                =new JMenuItem();
    JMenuItem menuReportes_Detallado              =new JMenuItem();
    
    menuFile.setText("File");
    menuFile_Exit.setText("Salir");
    menuMantenimiento.setText("Crud");
    menuMantenimiento_Ingresar.setText("Resgistrar");
    menuMantenimiento_Eliminar.setText("Eliminar");
    
    menuReportes.setText("Reportes");
    menuReportes_General.setText("Global");
    menuReportes_Detallado.setText("Detalle");
    
    menuFile.add(menuFile_Exit);
    menuMantenimiento.add(menuMantenimiento_Eliminar);
    menuMantenimiento.add(menuMantenimiento_Ingresar);
    menuReportes.add(menuReportes_General);
    menuReportes.add(menuReportes_Detallado);
    menuBar.add(menuFile);
    menuBar.add(menuMantenimiento);
    menuBar.add(menuReportes);
    setTitle("Practicando Crud con Vector");
    setJMenuBar (menuBar);
    setSize(new Dimension(700,700));
    
    menuFile_Exit.addActionListener
    (   new ActionListener(){
            public void actionPerformed (ActionEvent e){
                //CrudVectorFrame.this.windowClosed();
                System.exit(0);
              }
        }
    );
    
    menuMantenimiento_Ingresar.addActionListener
    (   new ActionListener(){
            public void actionPerformed (ActionEvent e){
                //CrudVectorFrame.this.windowClosed();
                JPanel pan1 =new JPanel (new GridLayout(1,2)); 
                pan1.add(lb_nombre);
                pan1.add(txt_nombre);
                
                JPanel pan2 =new JPanel(new GridLayout(1,2));
                pan2.add(lb_apellido_paterno);
                pan2.add(txt_apellido_paterno);
                
                JPanel pan3 =new JPanel(new GridLayout(1,2));
                pan3.add(lb_apellido_materno);
                pan3.add(txt_apellido_materno);
                
                JPanel pan4 =new JPanel(new GridLayout(1,2));
                pan4.add(lb_codigo);
                pan4.add(txt_codigo);
                
                
                Object msg []={pan1, pan2, pan3, pan4};
                
                if(JOptionPane.showOptionDialog(null, msg, "Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                    
                    datosPersona dp=new datosPersona();
                    
                    dp.nombres= txt_nombre.getText();
                    dp.ap_paterno=txt_apellido_paterno.getText();
                    dp.ap_materno=txt_apellido_materno.getText();
                    dp.codigo=txt_codigo.getText();
                    
                    System.out.print("Insertando"+dp.nombres);
                    metodos.registrarPersona(dp);
                    
                    JOptionPane.showMessageDialog(
                            null,"Se registro con exito", "Registro", 
                            JOptionPane.INFORMATION_MESSAGE );
                    
               

                        System.out.print("holasss");
                   }
                //System.exit(0);
              }
        }
    );
    
    menuReportes_General.addActionListener 
    (  new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
            String columnas []={"Nombres","Paterno","Materno","Codigo"};
            Object filas[][]=new Object[metodos.lista.size()][4];
            
            Vector nuevoVector= metodos.lista;
            for(int i=0;i<nuevoVector.size();i++){
            datosPersona v= (datosPersona)metodos.lista.get(i);
            filas[i][0]=v.nombres;
            filas[i][1]=v.ap_paterno;
            filas[i][2]=v.ap_materno;
            filas[i][3]=v.codigo;
            }
            JTable tabla=new JTable(filas, columnas);
            JScrollPane tabla1=new  JScrollPane(tabla);
            
            JPanel reporte=new JPanel();
            reporte.add(tabla1);
            
            Object msg []={reporte};
            JOptionPane.showMessageDialog(null,msg,"Reporte",JOptionPane.QUESTION_MESSAGE);
            
        }
    }
    );
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }   
}
