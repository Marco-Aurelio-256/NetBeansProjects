/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads.testa;

import threads.entidades.MinhaThread;

/**
 *
 * @author Aluno
 */
public class TestaParalelismo {
    public static void main(String[] args){
        MinhaThread mt1 = new MinhaThread("Nome legal");
        MinhaThread mt2 = new MinhaThread("Nome AINDA MAIS LEGAL");
        
        mt2.start();
        mt1.start();
        
    }
    
}
