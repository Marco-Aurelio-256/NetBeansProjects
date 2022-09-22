/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetmat.exemploaula;

/**
 *
 * @author Osvandre
 */
public class ExemploSlides {
    
    public static void main(String[] args) {
                        //  0        1          2         3        4  
        String nomes[] = {"Ana", "Beatriz", "Carlos", "Cícero", "Denise"};
                            //C0 C1  C2  C3  C4
        float notas[][] = { {6F, 8F, 7F, 9F, 0F},  //L0  
                            {7F, 9F, 6F, 10F,0F},  //L1
                            {8F, 8F, 7F, 8F, 0F},  //L2
                            {9F, 7F, 9F, 7F, 0F},  //L3
                            {6F, 7F, 8F, 9F, 0F} }; //L4      

        /** CALCULAR MÉDIAS **/
        //Popderia ser com várias linhas (5 - de 0 a 4) como esta...
        //notas[0][4] = (notas[0][0]+notas[0][1]+notas[0][2]+notas[0][3])/4;
        
        for (int aluno=0; aluno<5; aluno++) {
            notas[aluno][4] = (notas[aluno][0]+notas[aluno][1]+notas[aluno][2]+notas[aluno][3])/4;
        }

        /** MOSTRAR NOTAS **/
        
        //Cabeçalho
        System.out.println("---------------------------------------------------------");
        System.out.println(" Aluno     B1     B2    B3    B4    Media");
        System.out.println("---------------------------------------------------------");
        
        //ATENÇÃO----- Você deve completar neste ponto.......
        //Itens de relatório (alunos e suas notas)
        // Use for  de 0 até 4 (como no for para cáçculo das médias)
        //Exemplo com valores fixos.....mudar para ler os dados do vetor e da matriz
        
        for(int y = 0; y <= 4; y++){
            System.out.printf("%s   ", nomes[y]);
            for(int x = 0; x <= 4; x++){
                System.out.printf("%.01f     ", notas[y][x]);
            }
            System.out.printf("%n");
        }       
    }
    
}
