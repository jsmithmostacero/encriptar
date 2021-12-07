/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import datos.Encriptar;
import java.util.ArrayList;

/**
 *
 * @author Jsmith
 */
public class prueba {
    
    public static void main(String[] args) {
        Encriptar c  =new Encriptar("Jonáthan Smith Mostacero 1234569");
        System.out.println(c.getCifrado());
        System.out.println(c.getDescifrado());
 
    }

}
