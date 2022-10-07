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
        
        try{
            jvc.iniciarPartida(j1, j2);
            Jogada j1gd1 = new Jogada(0, 0, j1);
            Jogada j1gd2 = new Jogada(0, 1, j1);
            Jogada j1gd3 = new Jogada(0, 2, j1);
            Jogada j2gd1 = new Jogada(2, 0, j2);
            Jogada j2gd2 = new Jogada(2, 2, j2);
            
            jvc.realizarJogada(j1gd1);
            jvc.realizarJogada(j2gd1);
            jvc.realizarJogada(j1gd2);
            jvc.realizarJogada(j2gd2);
            jvc.realizarJogada(j1gd3);
            
            
        } catch(Exception e){
            System.err.println(e.getMessage());
            
        } finally{
            jvc.mostrarNaConsole();
        }
        
        
    }
}
