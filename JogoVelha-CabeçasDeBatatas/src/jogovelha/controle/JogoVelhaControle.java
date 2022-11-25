/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.controle;

import jogovelha.entidade.Jogador;
import jogovelha.entidade.Tabuleiro;
import jogovelha.entidade.Jogada;
import jogovelha.entidade.Resultados;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class JogoVelhaControle {

    public static final int PARTIDA_INICIADA = 0;
    public static final int PARTIDA_PARADA = 1;
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JogoVelha-Cabe_asDeBatatasPU");
    EntityManager em = emf.createEntityManager();
    
    private Integer numPartida;
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador ganhador;
    private int estadoPartida;
    private int modoGanho;
    
    public JogoVelhaControle() {
        this.numPartida = 1;
        modoGanho = 9;
        this.tabuleiro = new Tabuleiro();
        this.jogador1 = new Jogador();
        this.jogador2 = new Jogador();
        this.ganhador = new Jogador();
        this.estadoPartida = PARTIDA_PARADA;

    }

    public void iniciarPartida(Jogador j1, Jogador j2) throws Exception {
        if (j1.getId() != 0 && j2.getId() != 0) {
            if (estadoPartida == PARTIDA_PARADA) {
                ganhador = new Jogador();
                jogador1 = j1;
                jogador2 = j2;
                estadoPartida = PARTIDA_INICIADA;
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
                    modoGanho = linha;
                }

                if (tabuleiro.obterJogador(linha, 0).equals(jogador2)
                        && tabuleiro.obterJogador(linha, 1).equals(jogador2)
                        && tabuleiro.obterJogador(linha, 2).equals(jogador2)) {
                    temGanhador = true;
                    modoGanho = linha;
                }

            }

            //Repetição para colunas
            for (int coluna = 0; coluna <= 2; coluna++) {
                if (tabuleiro.obterJogador(0, coluna).equals(jogador1)
                        && tabuleiro.obterJogador(1, coluna).equals(jogador1)
                        && tabuleiro.obterJogador(2, coluna).equals(jogador1)) {
                    temGanhador = true;
                    modoGanho = coluna+3;
                }

                if (tabuleiro.obterJogador(0, coluna).equals(jogador2)
                        && tabuleiro.obterJogador(1, coluna).equals(jogador2)
                        && tabuleiro.obterJogador(2, coluna).equals(jogador2)) {
                    temGanhador = true;
                    modoGanho = coluna+3;
                }

            }

            //Checagem das diagonais
            if (tabuleiro.obterJogador(0, 0).equals(jogador1)
                    && tabuleiro.obterJogador(1, 1).equals(jogador1)
                    && tabuleiro.obterJogador(2, 2).equals(jogador1)) {
                temGanhador = true;
                modoGanho = 6;
            }

            if (tabuleiro.obterJogador(0, 0).equals(jogador2)
                    && tabuleiro.obterJogador(1, 1).equals(jogador2)
                    && tabuleiro.obterJogador(2, 2).equals(jogador2)) {
                temGanhador = true;
                modoGanho = 6;
            }
            
            if (tabuleiro.obterJogador(2, 0).equals(jogador1)
                    && tabuleiro.obterJogador(1, 1).equals(jogador1)
                    && tabuleiro.obterJogador(0, 2).equals(jogador1)) {
                temGanhador = true;
                modoGanho = 7;
            }

            if (tabuleiro.obterJogador(2, 0).equals(jogador2)
                    && tabuleiro.obterJogador(1, 1).equals(jogador2)
                    && tabuleiro.obterJogador(0, 2).equals(jogador2)) {
                temGanhador = true;
                modoGanho = 7;
            }
            
            if(temGanhador){
                ganhador = jgd.getJogador();
                estadoPartida = PARTIDA_PARADA;
                String statsJ1;
                String statsJ2;
                
                if(ganhador.equals(jogador1)){
                    statsJ1 = "*";
                    statsJ2 = "";
                } else {
                    statsJ1 = "";
                    statsJ2 = "*";
                }
                
                try{
                    inserirResultado(numPartida,statsJ1+jogador1.getNome(),statsJ2+jogador2.getNome());
                    
                } catch(Exception e){
                    System.err.print(e.getMessage());
                }
                
                throw new FimPartidaException(ganhador);
            }
            
            if(tabuleiro.cheio()){
                modoGanho = 8;
                estadoPartida = PARTIDA_PARADA;
                
                try{
                    inserirResultado(numPartida,"*"+jogador1.getNome(),"*"+jogador2.getNome());
                    
                } catch(Exception e){
                    System.err.print(e.getMessage());
                }
                throw new FimPartidaException();
            }
            
            

        } else {
            throw new Exception("Não é possível fazer uma jogada fora de uma partida!");
        }
    }
    
    public void cancelarPartida(){
        if(estadoPartida == PARTIDA_INICIADA){
            estadoPartida = PARTIDA_PARADA;
            
        }
    }
    
    public void inserirResultado(Integer numPartida, String j1, String j2) throws Exception{
        Resultados resultados = new Resultados();
                    
        resultados.setNpartida(numPartida);
        resultados.setJogador1(j1);
        resultados.setJogador2(j2);
        
        resultados.criaResultado(resultados);
        
        resultados.encerrarConexaoDB();
    }
    
    public void deletarResultado(Resultados resultados) throws Exception{
        resultados.deletar(resultados);
        
        resultados.encerrarConexaoDB();
        
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
    
    public int getModoDoGanho() {
        return modoGanho;
    }

    public void setModoDoGanho(int modoDoGanho) {
        this.modoGanho = modoDoGanho;
    }
    
    public Integer getNumPartida() {
        return numPartida;
    }

    public void setNumPartida(Integer numPartida) {
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

}
