/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.controle;

import jogovelha.entidade.Jogador;

/**
 *
 * @author Aluno
 */
public class FimPartidaException extends Exception {
    private Jogador ganhador;
    
    public FimPartidaException(){
        super("O jogo não teve vencedor. Ambos foram vitoriosos!");
        
        this.ganhador = new Jogador();
        
    }
    
    public FimPartidaException(Jogador ganhador){
        super(
            String.format(
                """
                Fim de jogo! %s Ganhou!
                """,
                ganhador.getNome()
            ));
    }
}
