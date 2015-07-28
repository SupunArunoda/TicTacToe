/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac2;

import java.util.Random;

/**
 *
 * @author Supun
 */
public class TICTAC2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random r=new Random();
        int x=r.nextInt(3);
        System.out.println(x);
    }
    
}
