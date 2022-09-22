import javax.swing.JOptionPane;

public class LPBA03ex3MarcoAlves {
    public static void main(String[] args){
        String a, b, a2, b2; //Variaveis Principais: a e b; Variavel para auxilio: a2 e b2  
        
        a = JOptionPane.showInputDialog(
                null,
                "Insira um valor qualquer para a variável A:");
        
        b = JOptionPane.showInputDialog(
                null,
                "Insira um valor qualquer para a variável B:");
        
        //Troca de valores entre as variveis a e b
        a2 = a;
        b2 = b;
        
        a = b2;
        b = a2;
        
        
        JOptionPane.showMessageDialog(
                null,
                
                "Valores informados anteriormente: \n" +
                "A = " +  a2  + "; B = " + b2 + "\n" +
                "----------------------------------- \n" +
                "Valores depois da troca: \n" +
                "A = " + a + "; B = " + b,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);
        
        
    }
}
