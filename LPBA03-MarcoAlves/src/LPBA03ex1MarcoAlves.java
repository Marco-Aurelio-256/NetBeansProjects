

import javax.swing.JOptionPane;

public class LPBA03ex1MarcoAlves {
    public static void main(String[] args){
        double alt, larg, area; //Variaveis de altura, largura e area(resultado)
        
        alt = Double.parseDouble(JOptionPane.showInputDialog(
                null, "Insira a altura do retângulo:"));
        
        larg = Double.parseDouble(JOptionPane.showInputDialog(
                null, "Insira a largura do retângulo:"));
        
        area = larg*alt;
        
        JOptionPane.showMessageDialog(
                null,
                "Altura do retângulo: " + alt + "\n" +
                "Largura do retângulo: " + larg + "\n" +
                "----------------------------------------------" + "\n" +
                "A área desse retângulo é de : " + area, //Mensagem
                "Resultado", //Titulo
                JOptionPane.INFORMATION_MESSAGE //Icone
        );
    }
}
