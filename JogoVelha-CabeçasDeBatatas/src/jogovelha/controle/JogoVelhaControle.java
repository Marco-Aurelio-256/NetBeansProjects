/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.controle;

import jogovelha.entidade.Jogador;
import jogovelha.entidade.Tabuleiro;

/**
 *
 * @author Aluno
 */
public class JogoVelhaControle {
    public static final int PARTIDA_INICIADA = 0;
    public static final int PARTIDA_PARADA = 1;
    
    private int numPartida;
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador ganhador;
    private int estadoPartida;
    private String[][] resultadosAnteriores = new String[1000][2];
    
    public JogoVelhaControle(){
        this.numPartida = 0;
        this.tabuleiro = 0;
        this.jogador1 = 0;
        this.jogador2 = 0;
        this.ganhador = 0;
        this.estadoPartida = 0;
        this.resultadosAnteriores = 0;
        
    }

    public int getNumPartida() {
        return numPartida;
    }

    public void setNumPartida(int numPartida) {
        this.numPartida = numPartida;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Jogador getGanhador() {
        return ganhador;
    }

    public void setGanhador(Jogador ganhador) {
        this.ganhador = ganhador;
    }

    public int getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(int estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public String[][] getResultadosAnteriores() {
        return resultadosAnteriores;
    }

    public void setResultadosAnteriores(String[][] resultadosAnteriores) {
        this.resultadosAnteriores = resultadosAnteriores;
    }
    
    
}
