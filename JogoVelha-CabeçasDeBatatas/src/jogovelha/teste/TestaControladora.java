/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.teste;

import jogovelha.controle.JogoVelhaControle;
import jogovelha.entidade.Jogada;
import jogovelha.entidade.Jogador;
/**
 *
 * @author Marco
 */
public class TestaControladora {
    public static void main(String args[]){
        JogoVelhaControle jvc = new JogoVelhaControle();
        
        Jogador j1 = new Jogador(1, "Jogador 1");
        Jogador j2 = new Jogador(2, "Jogador 2");
        
        //Vitória do Jogador 1
        try {
            jvc.iniciarPartida(j1, j2);
            
            Jogada j1jgd1 = new Jogada(0, 0, j1);
            Jogada j1jgd2 = new Jogada(0, 1, j1);
            Jogada j1jgd3 = new Jogada(0, 2, j1);
            Jogada j2jgd1 = new Jogada(2, 0, j2);
            Jogada j2jgd2 = new Jogada(2, 2, j2);
            
            jvc.realizarJogada(j1jgd1);
            jvc.realizarJogada(j2jgd1);
            
            jvc.realizarJogada(j1jgd2);
            jvc.realizarJogada(j2jgd2);
            
            jvc.realizarJogada(j1jgd3);
            
            
        } catch(Exception e){
            System.err.println(e.getMessage());
            
        } finally{
            jvc.mostrarNaConsole();
        }
        
        //Vitória do Jogador 2
        try {
            jvc.iniciarPartida(j1, j2);
            
            Jogada j2jgd1 = new Jogada(0, 0, j2);
            Jogada j2jgd2 = new Jogada(0, 1, j2);
            Jogada j2jgd3 = new Jogada(0, 2, j2);
            Jogada j1jgd1 = new Jogada(2, 0, j1);
            Jogada j1jgd2 = new Jogada(2, 2, j1);
            
            jvc.realizarJogada(j2jgd1);
            jvc.realizarJogada(j1jgd1);
            
            jvc.realizarJogada(j2jgd2);
            jvc.realizarJogada(j1jgd2);
            
            jvc.realizarJogada(j2jgd3);
            
            
        } catch(Exception e){
            System.err.println(e.getMessage());
            
        } finally{
            jvc.mostrarNaConsole();
        }
        
        //Velha
        
        try {
            jvc.iniciarPartida(j1, j2);
            
            Jogada jgd;
            boolean turno = false;
            
            for(int x = 0; x <= 2; x++){
                for(int y = 0; y <= 2; y++){
                    
                    if(y==2){
                        if(turno){
                            jgd = new Jogada(y, x, j2);
                            turno = !turno;
                        } else {
                            jgd = new Jogada(y, x, j1);
                            turno = !turno;
                        }
                        
                    } else if(turno){
                        jgd = new Jogada(y, x, j1);
                        turno = !turno;
                    } else {
                        jgd = new Jogada(y, x, j2);
                        turno = !turno;
                    }
                    
                    jvc.realizarJogada(jgd);
                    
                }
            }
            
            
        } catch(Exception e){
            System.err.println(e.getMessage());
            
        } finally{
            jvc.mostrarNaConsole();
        }
        
    }
}
