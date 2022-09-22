
import javax.swing.JOptionPane;

public class LPBA03ex5MarcoAlves {
    public static void main(String[] args){
        
        //Nota ao professor: Não usamos vetores no 2° ano, isso é fruto da minha pesquisa, 
        //resumindo não é conhecimento de todos da sala
        
        //Os vetores começam no 0, por isso "3" se refere ao quarto elemento
        
        //Variaveis vetores das notas das provas e notas dos trabalhos do 1° ao 4° bimestre
        double[] notaProva = new double[4];
        double[] notaTrab = new double[4];
        
        //Variavel vetor da media de cada bimestre e a media final
        double[] mediaBim = new double[4];
        double mediaFin;
       
        //Estou dando uns pulos aqui para tudo dar certinho, meu deus kkk
        
        ////////////////////////////////////////
        //Estrutura de repetição pros vetores//
        //////////////////////////////////////
        
        String TITLE_MSG = "Calcular média final do aluno"; //Preguiça de escrever toda vez
        
        //bimLog = Bimestre lógico, a variavel que vai controlar a posição dos vetores, 
        //é necessário que ela comece no 0 pois aqui os vetores começam no 0
        
        //Aquele (bimLog+1) é apenas para que a informação na tela esteja correto
        for(int bimLog = 0; bimLog <= 3; bimLog++){
                notaTrab[bimLog] = Double.parseDouble(JOptionPane.showInputDialog(
                    null, //Parent
                    "Insira a nota dos trabalhos do " + (bimLog+1) + "° bimestre:", //Mensagem
                    TITLE_MSG, //Titulo
                    JOptionPane.INFORMATION_MESSAGE //Icone
                ));
                
                notaProva[bimLog] = Double.parseDouble(JOptionPane.showInputDialog(
                        null, //Parent
                        "Insira a nota da prova do " + (bimLog+1) + "° bimestre:", //Mensagem
                        TITLE_MSG, //Titulo
                        JOptionPane.INFORMATION_MESSAGE //Icone
                ));
                
                mediaBim[bimLog] = (notaProva[bimLog] * 0.7) + (notaTrab[bimLog] * 0.3);
        }
        
        mediaFin = (mediaBim[0]+mediaBim[1]+mediaBim[2]+mediaBim[3]) / 4;
        
        //Peço desculpas pelos textos gigantes abaixo
        //Eu só quero que todos os dados estejam visiveis
        
        
        if(mediaFin >= 6.00){
            JOptionPane.showMessageDialog(null, 
                "Nota dos Trabalhos - 1° bimestre: " + notaTrab[0] + "\n" +
                "Nota da Prova - 1° bimestre: " + notaProva[0] + "\n" +
                "Média - 1° bimestre: " + mediaBim[0] + "\n \n" +
                
                "Nota dos Trabalhos - 2° bimestre: " + notaTrab[1] + "\n" +
                "Nota da Prova - 2° bimestre: " + notaProva[1] + "\n" +
                "Média - 2° bimestre: " + mediaBim[1] + "\n \n" +
                        
                "Nota dos Trabalhos - 3° bimestre: " + notaTrab[2] + "\n" +
                "Nota da Prova - 3° bimestre: " + notaProva[2] + "\n" +
                "Média - 3° bimestre: " + mediaBim[2] + "\n \n" +
                
                "Nota dos Trabalhos - 4° bimestre: " + notaTrab[3] + "\n" +
                "Nota da Prova - 4° bimestre: " + notaProva[3] + "\n" +
                "Média - 4° bimestre: " + mediaBim[3] + "\n \n" +
                 
                "Média Final: " + mediaFin + "\n \n" +
                        
                "Este aluno passou com uma média acima de 6.00. Não é necessário recuperação",
                TITLE_MSG,
                JOptionPane.INFORMATION_MESSAGE
            );
            
            
        } else if(mediaFin <= 6.00){
            JOptionPane.showMessageDialog(null, 
                "Nota dos Trabalhos - 1° bimestre: " + notaTrab[0] + "\n" +
                "Nota da Prova - 1° bimestre: " + notaProva[0] + "\n" +
                "Média - 1° bimestre: " + mediaBim[0] + "\n \n" +
                
                "Nota dos Trabalhos - 2° bimestre: " + notaTrab[1] + "\n" +
                "Nota da Prova - 2° bimestre: " + notaProva[1] + "\n" +
                "Média - 2° bimestre: " + mediaBim[1] + "\n \n" +
                        
                "Nota dos Trabalhos - 3° bimestre: " + notaTrab[2] + "\n" +
                "Nota da Prova - 3° bimestre: " + notaProva[2] + "\n" +
                "Média - 3° bimestre: " + mediaBim[2] + "\n \n" +
                
                "Nota dos Trabalhos - 4° bimestre: " + notaTrab[3] + "\n" +
                "Nota da Prova - 4° bimestre: " + notaProva[3] + "\n" +
                "Média - 4° bimestre: " + mediaBim[3] + "\n \n" +
                    
                "Média Final: " + mediaFin + "\n \n" +
                        
                "Este aluno não passou com uma média acima de 6.00. Recuperação Final necessária",
                TITLE_MSG,
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
