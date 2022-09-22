/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetmat.academico;

/**
 *
 * @author Osvandre
 */
public class Turma {
    
    /** CONSTANTES **/
    public static final int MAX_ALUNOS = 20;
    public static final int MAX_NOTAS = 5;
        
    
    /** ATRIBUTOS **/
    private String nomeTurma;
    private int qtdeMatriculas;
    private String[] nomes = new String[MAX_ALUNOS];
    private float[][] notas = new float[MAX_ALUNOS][MAX_NOTAS];
    
    
    /** CONSTRUTOR **/
    
    /**
     * Instancia uma Turma com base em um nome.
     * @param nomeTurma - String referente ao nome da turma.
     */
    public Turma(String nomeTurma) {
       this.nomeTurma = nomeTurma;
       qtdeMatriculas = 0;
       limpaNomesNotas();
    }
    
    /** DEMAIS METODOS **/
    
    /**
     * Limpa células do vetor de nomes e zera células da matriz de notas
     */
    public void limpaNomesNotas(){
        
        //Limpa o vetor de nomes dos alunos
        for (int i=0; i<MAX_ALUNOS; i++) {
            nomes[i] = "";
        }
        
        //Limpa/zera a matriz de notas
        for (int lin=0; lin<MAX_ALUNOS; lin++) {
            for (int col=0; col<MAX_NOTAS; col++) {
                notas[lin][col] = 0F;
            }
        }
        
    }
    
    /**
     * Registra matrícula de aluno na turma.
     * @param n - string referente ao nome do aluno
     */
    public void matricular(String n) {
        if (qtdeMatriculas<MAX_ALUNOS) { //Verifica se ainda tem vagas
            qtdeMatriculas++;  //Incrementa quantidade de matriculados
            nomes[qtdeMatriculas-1] = n; //registra nome do aluno no vetor
        } else {
            System.err.println("Não há mais vagas na turma! Matrícula na efetivada.");
        }
    }
    
    /**
     * Registra nota para um bimestre e para um determinado aluno conforme o índice
     * @param aluno - int ref. ao número do aluno na turma (de 0 a MAX_ALUNOS-1)
     * @param bimestre - int ref. ao número do bimestre de 0 a 3 (1º ao 4º)
     * @param nota - float referente à nota do aluno no bimestre.
     */
    public void registrarNota(int aluno, int bimestre, float nota) {
        notas[aluno][bimestre] = nota;
    }
    
    //ATENÇÃO - Você deve trabalhar concluindo a implementação do método mostrar notas.
    //Depois você vai completar a classe TestaTurma e rodá-la para verificar se
    //esta classe está funcionando corretamente.
    
    /**
     * Exibe listagem de alunos da turma com suas notas
     */
    public void mostrarNotas() {
        /** MOSTRAR NOTAS **/
        System.out.println("---------------------------------------------------------");
        System.out.println(" Aluno     B1     B2    B3    B4    Media");
        System.out.println("---------------------------------------------------------");
        
        //Exemplo com valores fixos.....mudar para ler os dados do vetor e da matriz
        for(int y = 0; y <= (nomes.length-1); y++){
            System.out.printf("%s   ", nomes[y]);
            
            for(int x = 0; x <= 4; x++){
                System.out.printf("%.01f     ", notas[y][x]);
            }   
                System.out.printf("%n");
        }
            
    }
}
