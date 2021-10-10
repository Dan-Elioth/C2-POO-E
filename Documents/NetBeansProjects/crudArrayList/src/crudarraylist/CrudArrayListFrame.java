/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudarraylist;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Segintec SAC
 */
public class CrudArrayListFrame extends JFrame{
    
    metodosSistema system=new metodosSistema();
        
        JLabel lb_nombre=new JLabel("Primer_Nombre");
        JTextField txt_nombre=new JTextField();
        
        JLabel lb_apPaterno=new JLabel("Ap.Paterno");
        JTextField txt_apPaterno=new JTextField();
        
        JLabel lb_apMaterno=new JLabel("Ap.Materno");
        JTextField txt_apMaterno=new JTextField();
        
        JLabel lb_codigo=new JLabel("Codigo");
        JTextField txt_codigo=new JTextField();
        
    public CrudArrayListFrame(){
        
        //decretando
        
        JMenuBar menuBar              =new  JMenuBar();
        JMenu menuFile                =new  JMenu();
        JMenu menuMantenimiento       =new  JMenu();
        JMenu menuReportes            =new  JMenu();

        
        
        //items 
        
        JMenuItem menuFile_Exit                        =new JMenuItem();
        JMenuItem menuMantenimiento_Ingresar       =new JMenuItem();
        JMenuItem menuMantenimiento_Eliminar       =new JMenuItem();
        JMenuItem menuReportes_General             =new JMenuItem();
        JMenuItem menuReportes_Detallado           =new JMenuItem();
        
        
        
        menuFile.setText("File");
        menuFile_Exit.setText("Salir");
        
        menuMantenimiento.setText("Crud");
        menuMantenimiento_Ingresar.setText("Registrar");
        menuMantenimiento_Eliminar.setText("Eliminar");
        
        menuReportes.setText("Reporte");
        menuReportes_General.setText("Global");
        menuReportes_Detallado.setText("Detalle");
        
        
        //agregando lista a la barra de acciones
        menuFile.add(menuFile_Exit);
        
        menuMantenimiento.add(menuMantenimiento_Ingresar);
        menuMantenimiento.add(menuMantenimiento_Eliminar);
        
        menuReportes.add(menuReportes_General);
        menuReportes.add(menuReportes_Detallado);
        
        
        //agregando al menuBar /barrade acciones
        menuBar.add(menuFile);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuReportes);
        
        // titulo a la ventana emergente
        setTitle("Practicando Crud con ArrayList");
        setJMenuBar(menuBar);
        
        
        // dimension a la ventana emergente
        setSize(new Dimension(800,800));
        
        menuFile_Exit.addActionListener
        ( new ActionListener(){
            
            public void actionPerformed (ActionEvent e){
                System.exit(0);
                }
            } 
        );
        
        
        menuMantenimiento_Ingresar.addActionListener
        ( new ActionListener(){
            
            public void actionPerformed (ActionEvent e ){
                
                JPanel pan1 =new JPanel (new GridLayout(1,2));
                pan1.add(lb_nombre);
                pan1.add(txt_nombre);
                
                JPanel pan2 =new JPanel (new GridLayout(1,2));
                pan2.add(lb_apPaterno);
                pan2.add(txt_apPaterno);
                
                JPanel pan3 =new JPanel (new GridLayout(1,2));
                pan3.add(lb_apMaterno);
                pan3.add(txt_apMaterno);
                
                JPanel pan4 =new JPanel (new GridLayout(1,2));
                pan4.add(lb_codigo);
                pan4.add(txt_codigo);
                
                Object msg[]={pan1,pan2,pan3,pan4};
                
                if(JOptionPane.showOptionDialog(null, msg, "Registrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                
                    datosPersona dp=new datosPersona();
                    
                    dp.nombre=txt_nombre.getText();
                    dp.ap_paterno=txt_apPaterno.getText();
                    dp.ap_materno=txt_apMaterno.getText();
                    dp.codigo=txt_codigo.getText();
                    
                    
                    
                    System.out.print("Insertando"+dp.nombre);
                    system.registrarPersona(dp);
                    
                    JOptionPane.showMessageDialog(null,"Se Registro Exitosamente","Registro",
                            JOptionPane.INFORMATION_MESSAGE );
       
                
                    }
     
                }
        
            }
 
        );
        
        menuMantenimiento_Eliminar.addActionListener
        ( new ActionListener(){
            public void actionPerformed (ActionEvent e){
                
                
                JPanel tier1 = new JPanel(new GridLayout(1,2));
                tier1.add(lb_nombre);
                tier1.add(txt_nombre);

                JPanel tier2 = new JPanel(new GridLayout(1,2));
                tier2.add(lb_codigo);
                tier2.add(txt_codigo);
                
                Object msg[]={tier1,tier2};
                

                if(JOptionPane.showOptionDialog(null, msg, "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,null,null)==JOptionPane.OK_OPTION){
                
                    datosPersona d=new datosPersona();
                    
                    d.nombre=txt_nombre.getText();
                    d.codigo=txt_codigo.getText();
                    
                
               
                if(txt_nombre.getText().equals("") && txt_codigo.getText().equals("") ){
                   
                   
                }else{
                 system.eliminarPerson(txt_nombre.getText(), txt_codigo.getText());
                }
                JOptionPane.showMessageDialog(null,"Se Elimimno Exitosamente","Eliminar",
                            JOptionPane.INFORMATION_MESSAGE );
         
                
                }
                txt_nombre.getText();
                txt_codigo.getText();
             
            
                }
            }
        );
        
        
        
        
        menuReportes_General.addActionListener
        ( new ActionListener(){
            
            public void actionPerformed (ActionEvent e){
                
                String columnas []={"Nombres","Paterno","Materno","Codigo"};
                Object filas[][]=new Object[system.lista.size()][4];
                
                
                ArrayList newArrayList=system.lista;
                
                for(int i=0; i<newArrayList.size();i++){
                    
                    datosPersona v=(datosPersona)system.lista.get(i);
                    /*system.lista.add(i, v.nombre);
                    system.lista.add(i, v.ap_paterno);
                    system.lista.add(i, v.ap_materno);
                    system.lista.add(i, v.condigo);*/
                    
                    filas[i][0]=v.nombre;
                    filas[i][1]=v.ap_paterno;
                    filas[i][2]=v.ap_materno;
                    filas[i][3]=v.codigo;
                    }
  
            
                    
                    JTable tabla=new JTable(filas,columnas);
                    JScrollPane tabla1=new JScrollPane(tabla);
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
