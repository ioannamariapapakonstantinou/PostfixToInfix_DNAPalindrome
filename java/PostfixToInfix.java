import java.util.NoSuchElementException;
import java.util.Scanner; 



public class PostfixToInfix{	
	public static void main(String[] args){
		try {
			StringDoubleEndedQueueImpl<String> list = new StringDoubleEndedQueueImpl<String>() ;	
			System.out.println("Give Postfix expression: ");
			Scanner p1 = new Scanner (System.in);
			String post = p1.nextLine();
			
			boolean flag1 = checkList(post);// elegxei an h parastash einai egkyrh
			int s=0;
			
			if (flag1 == false ) {//an einai egkyrh
				for (int i=0; i<post.length();i++) {
					char el = post.charAt(i);
					String elm = String.valueOf(el);
					boolean t = isOperator(el);
					
					if (t==true) {
						list.addLast(elm);
						
					}else {
						String hf = list.getLast();
						list.removeLast();
						String hf1 = list.getLast();
						list.removeLast();
						list.addLast("("+ hf1 + elm + hf +")");
					}
				}
				System.out.println("Get Infix expression: ");
				list.printQueue(System.out);
				
			}
		}catch (NoSuchElementException e) {                
			System.err.println(e.toString());
		}
	}

	public static boolean isOperator(char elm) {
		if  ( elm != '+'  && elm != '-' && elm != '*' && elm!='/') {//einai telesteos - operand
			return true;
		}return false;//einai telesths - operator
	}


	private static boolean checkList(String post) { //perissoteres plhrofories gia to ti elegxetai sthn anafora paradoshs sto meros b
		char last='l';
		char first= 'l';
		char second = 'l';
		int noOperators = 0;
		int noOperands = 0;
		int total=0;
		
		for (int i=0; i<post.length();i++) {
			
				char sf = post.charAt(i);
				String r = String.valueOf(sf);
				last = sf ;
				if (Character.isDigit(sf)){
					int h=Integer.parseInt(r); 
					if(h<0 ||h>9){
							System.out.println("The expression is not valid.");
							return true;
					}else {
						noOperands++;
						total++;
						if (total<0) {
							System.out.println("The expression is not valid.");
							return true;
						}
					
					}
				}
				else if(sf != '+'  && sf != '-' && sf != '*' && sf !='/'){
					
					System.out.println("The expression is not valid.");
					return true;
				}else {
					noOperators++;
					total = total - 2;
					if (total<0) {
						System.out.println("The expression is not valid.");
						return true;
					}
					total++;
					if (total<0) { 
						System.out.println("The expression is not valid.");
						return true;
					}


				
				}	
				if (i==0) {first=sf;}
				else if (i==1) {second = sf;}
		}	
		boolean k = false;
		if (total==1) {return k;}
		if (noOperands  != noOperators+1) {System.out.println("The expression is not valid.");return true;}
		if (last != '+'  && last != '-' && last != '*' && last !='/') {
			k= true;
			System.out.println("The expression is not valid.");
			return k ;
		}
		if (first != '+'  && first != '-' && first != '*' && first !='/') {
			if (second != '+'  && second != '-' && second != '*' && second !='/') {
				return k;
			}
		}
		return k;	
	}

	
}