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
        t1.matricular("Osvaldo Marcos"); //0
        t1.matricular("Andrea Duqui"); //1
        t1.matricular("Maura Duqui");//2
        t1.matricular("Alex Alves");//3
        
        //Registra notas (bimestres de 0 a 3 - 1º ao 4º)
        t1.registrarNota(0, 0, 10F); 
        t1.registrarNota(0, 1, 9F); 
        t1.registrarNota(0, 2, 7.9F); 
        t1.registrarNota(0, 3, 8F); 
        
        t1.registrarNota(1, 0, 5F);
        t1.registrarNota(1, 1, 6F); 
        t1.registrarNota(1, 2, 10F); 
        t1.registrarNota(1, 3, 9F); 
        
        t1.registrarNota(2, 0, 8.4F);
        t1.registrarNota(2, 1, 9F);
        t1.registrarNota(2, 2, 7F);
        t1.registrarNota(2, 3, 8.8F);
        
        t1.registrarNota(3, 0, 4F);
        t1.registrarNota(3, 1, 6F);
        t1.registrarNota(3, 2, 6.2F);
        t1.registrarNota(3, 3, 8F); 
        
        
        t1.mostrarNotas();
    }
}
