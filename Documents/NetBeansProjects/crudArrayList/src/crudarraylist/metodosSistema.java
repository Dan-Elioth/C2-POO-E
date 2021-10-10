/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudarraylist;

import com.sun.jdi.InterfaceType;
import java.util.ArrayList;

/**
 *
 * @author Segintec SAC
 */
public class metodosSistema {
    
 
    public ArrayList<datosPersona> lista=new ArrayList<datosPersona>();
    
    public void registrarPersona(datosPersona x){
    
        lista.add(x);
    }
    
    public void eliminarPerson(String nombre,String codigo){
        
        for(int i = 0; i< lista.size();i++){
            datosPersona dp = lista.get(i);
                if(nombre.equals(dp.nombre)&& codigo.equals(dp.codigo)){
            
            lista.remove(i);
        
            }
        } 
    } 
}
