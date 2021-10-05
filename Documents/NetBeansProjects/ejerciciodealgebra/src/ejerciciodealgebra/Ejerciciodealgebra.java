/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodealgebra;

import java.util.Scanner;

/**
 *
 * @author Segintec SAC
 */

public class Ejerciciodealgebra {
    
    Scanner teclado=new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    
    public void Ejercicio1 (){
        int a;
        int b;
        
        System.out.println("Ingrese un numero (a):");
        a=teclado.nextInt();
        
        System.out.println("Ingrese un numero (b):");
        b=teclado.nextInt();
        
        if(a==b){
            System.out.println("El numero "+a+" y el numero "+b+" son iguales");             
        }else if(a>b){
            System.out.println("El numero "+a+" es mayor a "+b);     
        }else{
            System.out.println("El numero "+a+" es menor a "+b);
        }
        
    
    
    }
    public static void main(String[] args) {
        Ejerciciodealgebra al=new Ejerciciodealgebra(); 
        
        al.Ejercicio1();
     
    }
    
}
