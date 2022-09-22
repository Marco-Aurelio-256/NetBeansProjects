
import javax.swing.JOptionPane;

public class LPBA03ex4MarcoAlves {
    public static void main(String[] args){
        //Variaveis Quantidade de reais, cotação do dólar e resultado em dólar
        double quantReal, cotaDolar, resDolar; 
        
        quantReal = Double.parseDouble(JOptionPane.showInputDialog(
                null, //Parent
                "Insira a quantidade de reais para a conversão:", //Args AKA Mensagem 
                "Conversão de real para dólar", //Titulo
                JOptionPane.INFORMATION_MESSAGE //Icone
        ));
        
        cotaDolar = Double.parseDouble(JOptionPane.showInputDialog(
                null, //Parent
                "Insira a cotação atual do dólar em relação ao real:", //Args AKA Mensagem 
                "Conversão de real para dólar", //Titulo
                JOptionPane.INFORMATION_MESSAGE //Icone
        ));
        
        resDolar = quantReal / cotaDolar;
        
        JOptionPane.showMessageDialog(
                null, 
                quantReal + " reais equivalem a " + resDolar + " dólares!", 
                "Conversão de real para dólar", 
                JOptionPane.INFORMATION_MESSAGE
        );
        
        
        
        
    }
}
