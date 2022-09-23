/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.teste;

import jogovelha.entidade.Jogada;
import jogovelha.entidade.Jogador;
import jogovelha.entidade.Tabuleiro;

/**
 *
 * @author Aluno
 */
public class TestaEntidades {
    public static void main(String args[]) {
        //@param jog3 apenas para testar os erros
        Jogador jog1 = new Jogador();
        Jogador jog2 = new Jogador();
        Jogador jog3 = new Jogador();
        
        System.out.println(jog3.getNome());
        
        jog1.setNome("Salve");
        jog1.setId(1);
        
        jog2.setNome("Salve2");
        jog2.setId(2);
        
        jog1.mostrarNaConsole();
        jog2.mostrarNaConsole();
        jog3.mostrarNaConsole();
        
        try{
            Jogada jogada1 = new Jogada(1, 1, jog1);
            Jogada jogada2 = new Jogada(2, 1, jog2);
            Jogada jogada3 = new Jogada(1, 1, jog3);

            jogada1.mostrarNaConsole();
            jogada2.mostrarNaConsole();
            jogada3.mostrarNaConsole();

            Tabuleiro tab = new Tabuleiro();

            tab.registrarJogada(jogada1);
            tab.registrarJogada(jogada2);
            
            tab.mostrarNaConsole();
       
            System.out.println("Tabela está cheia: " + tab.cheio());
            
        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }
    
}
