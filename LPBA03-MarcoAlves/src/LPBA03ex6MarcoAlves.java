
import javax.swing.JOptionPane;

public class LPBA03ex6MarcoAlves {
    public static void main(String[] args){
        //Variaveis da quantidade de aulas ministradas, valor por aula
        //e porcentagem de desconto do inss
        double valorAula;
        int aulaMin, porcInss;
        
        //Variaveis resultantes
        //Salario bruto e liquido e o total do desconto do inss
        double salBru, salLiq, totalInss;
        
        //constante para o título das janelas
        //porque eu tenho preguiça de escrever toda hora
        String TITLE_MSG = "Calcular o salário líquido de um professor";
        
        aulaMin = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Insira a quantidade de aulas ministradas no mês:",
                TITLE_MSG,
                JOptionPane.INFORMATION_MESSAGE
            ));
        
        valorAula = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Insira a valor pago por aula:",
                TITLE_MSG,
                JOptionPane.INFORMATION_MESSAGE
            ));
        
        porcInss = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                """
                Insira o porcentual de desconto de INSS:
                (sem o símbolo de porcentagem, claro)
                """,
                TITLE_MSG,
                JOptionPane.INFORMATION_MESSAGE         
            ));
        
        //Calcular Salario bruto, o total do INSS e o salário líquido
        salBru = aulaMin * valorAula;
        totalInss = (salBru * porcInss) / 100;
        salLiq = salBru - totalInss;
        
        JOptionPane.showMessageDialog(
                null, 
                "(+) Salário Bruto......: R$ " + salBru + "\n" +
                "(-)   INSS.....................: R$ " + totalInss + "\n" +
                "---------------------------------------\n" +
                "    Salário Líquido....: R$ " + salLiq,
                TITLE_MSG,
                JOptionPane.INFORMATION_MESSAGE
        );
        
        
        
    }             
}
