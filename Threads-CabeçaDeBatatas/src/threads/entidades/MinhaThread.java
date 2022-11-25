/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads.entidades;

/**
 *
 * @author Aluno
 */
public class MinhaThread extends Thread{
    
    public MinhaThread(String nomeThread) {
        super(nomeThread);
    }
    
    @Override
    public void run() {
        for(int i = 0; i<10; i++) {
            System.out.println("Nome da Thread: " + this.getName() + "\n" 
                    + "-" + (i+1) + " pessoa a menos no mundo!");
            System.out.println("");
        }
    }
}
