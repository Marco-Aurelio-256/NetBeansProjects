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
public class TestaTurma {
    public static void main(String[] args) {
        //Cria uma turma
        Turma t1 = new Turma("3º INF - Turma B");
        
        //Matricula alunos
        t1.matricular("Taine"); //0
        t1.matricular("Vitoria Corte"); //1
        
        //Registra notas (bimestres de 0 a 3 - 1º ao 4º)
        t1.registrarNota(0, 0, 10F); //Aluno 0, Bim 0 e nota 10 (Taiane, 1º Bim, 10)
        t1.registrarNota(0, 1, 8F);
        
        
        t1.mostrarNotas();
    }
}
