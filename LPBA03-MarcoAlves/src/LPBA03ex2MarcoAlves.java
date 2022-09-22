
import javax.swing.JOptionPane;

public class LPBA03ex2MarcoAlves {
    public static void main(String[] args){
        double celsi, fahre; //Variaveis de celsuis e fahrenheit
        
        celsi = Double.parseDouble(JOptionPane.showInputDialog(
                null,
                "Insira a temperatura em Celsius para converter:"));
        
        fahre = (celsi * 1.8) + 32; //Conversão de Celsius para Fahrenheit
        
        //Mostrar resultado da conversão
        
        JOptionPane.showMessageDialog(
                null, 
                "Temperatura informada: " + celsi + "°" + "\n" +
                "A temperatura em Fahrenheit é de: " + fahre + "°", //Mensagem dentro
                "A temperatura em Fahrenheit", //Titulo
                JOptionPane.INFORMATION_MESSAGE //Icone
        ); 
        
    }
}
