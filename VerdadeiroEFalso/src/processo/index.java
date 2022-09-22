
package processo;

import javax.swing.JOptionPane;

public class index {   
    public static void main(String[] args){
        int soma;
        String VF;
        String[] VFarray;
        
        
        soma = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "aaaaaaa"));
        
        VF = decimalParaVF(soma);       
        VFarray = VF.split("");
        System.out.println(VFarray.length);
        
        for(int i = 0; i > VFarray.length; i++){
        }
        
        
    }
    
    public static String decimalParaVF(int n){
        String result = "";
        
        if(n > 0){
            decimalParaVF(n/2);
            result = result + Integer.toString(n%2);
        }
        
        return result;
    }
}
