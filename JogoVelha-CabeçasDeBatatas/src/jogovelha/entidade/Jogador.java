package jogovelha.entidade;

/**
 *
 * @author Aluno
 */

public class Jogador {
    
    private int id;
    private String nome;
    
    public Jogador() {
        this.id = 0;
        this.nome = "INDEFINIDO";
    }

    public Jogador(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void mostrarNaConsole(){
        System.out.println(
            String.format(
                """
                ==JOGADOR==
                ID: %d
                Nome: %s                
                ==========
                """,
                this.id,
                this.nome
            )
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
