/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudvector1;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Segintec SAC
 */
public class metodosSistema {
    
    public Vector lista = new Vector();
    public ArrayList<datosPersona> listaPersonas=new ArrayList<>();
    
    
    public void registrarPersona(Object x){
        lista.add(x);
    } 
}
