/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.entidade;

/**
 *
 * @author Aluno
 */
public final class Tabuleiro {
    private Jogador[][] matrizControle = new Jogador[3][3];
    
    public Tabuleiro() {
        limpar();
        
    }
    
    public void limpar() {
        for(int x = 0; x <= 2; x++){
            for(int y = 0; y <= 2; y++){
                matrizControle[x][y] = new Jogador();
                
            }
        }
    }
    
    public void registrarJogada(Jogada jogada) {
        try{
            int linha = jogada.getLinha();
            int coluna = jogada.getColuna();
            Jogador jogador = jogada.getJog();

            if(matrizControle[linha][coluna].getId() == 0){
                matrizControle[linha][coluna] = jogador;

            } else {
                System.err.println("Posição da jogada já está registrada!");
            }  
        } catch(Exception e) {
            System.err.println("Erro ao registrar jogada no tabuleiro");
        }
    }
    
    public Jogador obterJogador(int linha, int coluna) {
        return matrizControle[linha][coluna];
    }
    
    public boolean cheio() {
        boolean result = true;
        
        for(int x = 0; x <= 2; x++){
            for(int y = 0; y <= 2; y++){
                if(matrizControle[x][y].getId() != 0) {
                    result = false;
                }
            }
        }
        
        return result;
    }
    
    public void mostrarNaConsole(){
        String posicoesOcupadas = "==Lugares Ocupados na Tabela==\n";
        
        for(int x = 0; x <= 2; x++){
            for(int y = 0; y <= 2; y++){
                if(matrizControle[x][y].getId() != 0) {
                    String posicao = String.format(
                            "[%s] Linha: %d; Coluna: %d\n", 
                            matrizControle[x][y].getNome(),
                            x,
                            y);
                    
                    posicoesOcupadas = posicoesOcupadas + posicao;
                }
            }
        }
        
        posicoesOcupadas += "==============";
        
        System.out.println(posicoesOcupadas);
    }

    public Jogador[][] getMatrizControle() {
        return matrizControle;
    }
    
    
    
}
