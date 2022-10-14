/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.controle;

import jogovelha.entidade.Jogador;
import jogovelha.entidade.Tabuleiro;
import jogovelha.entidade.Jogada;

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
    private String[][] resultadosAnteriores;

    public JogoVelhaControle() {
        this.numPartida = 0;
        this.tabuleiro = new Tabuleiro();
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.ganhador = new Jogador();
        this.estadoPartida = PARTIDA_PARADA;
        this.resultadosAnteriores = new String[1000][2];

    }

    public void iniciarPartida(Jogador j1, Jogador j2) throws Exception {
        if (j1.getId() != 0 && j2.getId() != 0) {
            if (estadoPartida == PARTIDA_PARADA) {
                ganhador = new Jogador();
                jogador1 = j1;
                jogador2 = j2;
                estadoPartida = PARTIDA_INICIADA;
                numPartida++;
                tabuleiro.limpar();

            } else {
                throw new Exception("Falha ao iniciar a partida. Uma partida já está em andamento!");

            }
        } else {
            throw new Exception("Falha ao iniciar a partida. Os jogadores não estão definidos corretamente!");

        }
    }

    public void realizarJogada(Jogada jgd) throws Exception, FimPartidaException {
        if (estadoPartida == PARTIDA_INICIADA) {
            tabuleiro.registrarJogada(jgd);
            boolean temGanhador = false;

            /**
             * If's para verificar se há um ganhador respectivamente as linhas,
             * colunas, a diagonal principal e a diagonal segundária
             *
             */
            //Repetição para as linhas
            for (int linha = 0; linha <= 2; linha++) {
                if (tabuleiro.obterJogador(linha, 0).equals(jogador1)
                        && tabuleiro.obterJogador(linha, 1).equals(jogador1)
                        && tabuleiro.obterJogador(linha, 2).equals(jogador1)) {
                    temGanhador = true;
                }

                if (tabuleiro.obterJogador(linha, 0).equals(jogador2)
                        && tabuleiro.obterJogador(linha, 1).equals(jogador2)
                        && tabuleiro.obterJogador(linha, 2).equals(jogador2)) {
                    temGanhador = true;
                }

            }

            //Repetição para colunas
            for (int coluna = 0; coluna <= 2; coluna++) {
                if (tabuleiro.obterJogador(0, coluna).equals(jogador1)
                        && tabuleiro.obterJogador(1, coluna).equals(jogador1)
                        && tabuleiro.obterJogador(2, coluna).equals(jogador1)) {
                    temGanhador = true;
                }

                if (tabuleiro.obterJogador(0, coluna).equals(jogador2)
                        && tabuleiro.obterJogador(1, coluna).equals(jogador2)
                        && tabuleiro.obterJogador(2, coluna).equals(jogador2)) {
                    temGanhador = true;
                }

            }

            //Checagem das diagonais
            if (tabuleiro.obterJogador(0, 0).equals(jogador1)
                    && tabuleiro.obterJogador(1, 1).equals(jogador1)
                    && tabuleiro.obterJogador(2, 2).equals(jogador1)) {
                temGanhador = true;
            }

            if (tabuleiro.obterJogador(0, 0).equals(jogador2)
                    && tabuleiro.obterJogador(1, 1).equals(jogador2)
                    && tabuleiro.obterJogador(2, 2).equals(jogador2)) {
                temGanhador = true;
            }
            
            if (tabuleiro.obterJogador(2, 0).equals(jogador1)
                    && tabuleiro.obterJogador(1, 1).equals(jogador1)
                    && tabuleiro.obterJogador(0, 2).equals(jogador1)) {
                temGanhador = true;
            }

            if (tabuleiro.obterJogador(2, 0).equals(jogador2)
                    && tabuleiro.obterJogador(1, 1).equals(jogador2)
                    && tabuleiro.obterJogador(0, 2).equals(jogador2)) {
                temGanhador = true;
            }
            
            if(temGanhador){
                ganhador = jgd.getJogador();
                estadoPartida = PARTIDA_PARADA;
                
                if(ganhador.equals(jogador1)){
                    resultadosAnteriores[numPartida-1][0] = "*"+jogador1.getNome();
                    resultadosAnteriores[numPartida-1][1] = jogador2.getNome();
                            
                } else {
                    resultadosAnteriores[numPartida-1][0] = jogador1.getNome();
                    resultadosAnteriores[numPartida-1][1] = "*"+jogador2.getNome();
                    
                }
                
                throw new FimPartidaException(ganhador);
            }
            
            if(tabuleiro.cheio()){
                estadoPartida = PARTIDA_PARADA;
                resultadosAnteriores[numPartida-1][0] = "*"+jogador1.getNome();
                resultadosAnteriores[numPartida-1][1] = "*"+jogador2.getNome();
                throw new FimPartidaException();
            }
            
            

        } else {
            throw new Exception("Não é possível fazer uma jogada fora de uma partida!");
        }
    }
    
    public void cancelarPartida(){
        if(estadoPartida == PARTIDA_INICIADA){
            estadoPartida = PARTIDA_PARADA;
            resultadosAnteriores[numPartida-1][0] = "*"+jogador1.getNome();
            resultadosAnteriores[numPartida-1][1] = "*"+jogador2.getNome();
            
            
        }
    }
    
    public void mostrarNaConsole(){
        String[][] result = new String[3][3];
        
        for(int x = 0; x <= 2; x++){
            for(int y = 0; y <= 2; y++){
                if(tabuleiro.obterJogador(y, x).equals(jogador1)){
                    result[y][x] = "J1";
                    
                } else if(tabuleiro.obterJogador(y, x).equals(jogador2)){
                    result[y][x] = "J2";
                    
                } else {
                    result[y][x] = "??";
                    
                }

            }
        }
        
        String tabela = String.format(
                """
                      |      |     
                  %s  |  %s  |  %s  
                ______|______|______
                      |      |     
                  %s  |  %s  |  %s  
                ______|______|______
                      |      |     
                  %s  |  %s  |  %s  
                      |      |     
                
                """, 
                result[0][0],
                result[1][0],
                result[2][0],
                result[0][1],
                result[1][1],
                result[2][1],
                result[0][2],
                result[1][2],
                result[2][2]
                );
        
        String informacao = String.format(
                """
                **Partida n°%d**
                J1 = %s
                J2 = %s
                Ganhador = %s
                Estado da partida = %d      
                
                """,
                numPartida,
                jogador1.getNome(),
                jogador2.getNome(),
                ganhador.getNome(),
                estadoPartida);
        
        System.out.print(informacao + tabela);
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
