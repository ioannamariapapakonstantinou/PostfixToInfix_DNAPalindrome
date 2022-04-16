import java.util.NoSuchElementException;
import java.util.Scanner;

public class DNAPalindrome {
    public static void main(String[] args) {
        try {
            Scanner eisodos = new Scanner(System.in);
            boolean isDNA = false;
            boolean isPalindrome = false;
            System.out.println("Give a DNA sequence: ");
            String dna = eisodos.nextLine();
            eisodos.close();
            StringDoubleEndedQueueImpl<String> queue = new StringDoubleEndedQueueImpl<String>();
    
            for (int i = 0; i < dna.length(); i++) { //Diatrexei thn akolouthia DNA kai topothetei kathe xarakthra ths sto antikeimeno ouras queue
                char c = dna.charAt(i);
                if (c == 'A' || c == 'T' || c == 'G' || c == 'C') { //Elegxos gia to an einai egkyrh akolouthia DNA
                    isDNA = true;
                }
                else {
                    isDNA = false;
                    break;
                }
                queue.addLast(String.valueOf(c));
            }
           
            if (dna.length() == 0 ){ //Elegxos gia to an einai egkyrh akolouthia DNA
                    isDNA = true;
            }
            
            if (isDNA) { //Elegxos gia to an einai symplhrwmatika palindromh
                
                if (queue.size() == 0) {
                    isPalindrome = true;
                }
                else if (queue.size() == 1) {
                    isPalindrome = false;
                }
            }
            else {
                isPalindrome = false;
            }
            String newqueue = "";
            if (queue.size() > 1 && isDNA) {
                for (int i = 0; i < dna.length(); i++) { //Tautoxrona xtizetai kai antistrefetai to symplhrwma ths akolouthias DNA
                    char c = dna.charAt(i);
                
                    switch (c) {
                        case 'A':
                            c = 'T';
                            break;
                        case 'T':
                            c = 'A';
                            break;
                        case 'C':
                            c = 'G';
                            break;
                        case 'G':
                            c = 'C';
                            break;
                    }
                 
                    newqueue = c + newqueue ;
                  
                }
             
            }
            
            if (newqueue.equals(dna) ){ //Epistrefetai to sxetiko apotelesma
                System.out.println("This DNA sequence is a Watson-Crick complemented palindrome.");
            }
            else if (dna.length() == 0){
                System.out.println("This DNA sequence is a Watson-Crick complemented palindrome.");
            }
            else if (isDNA && !isPalindrome) {
                System.out.println("This DNA sequence is not a Watson-Crick complemented palindrome.");
            }
            else {
                System.out.println("Invalid input.");
            }
            
        }catch (NoSuchElementException e) {                
            System.err.println(e.toString());
        }    
       
    }
}
