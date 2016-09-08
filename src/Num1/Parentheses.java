package Num1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 练习1.3.4
 * @author lxc
 *
 */
public class Parentheses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String s = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		if(s.length()%2 != 0){
			System.out.println("false");
			return;
		}else{
			for(int i = 0; i<s.length(); i++){
				if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
					stack.push(s.charAt(i));
				}else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
					if(!stack.isEmpty()){
						char c = stack.pop();
						if((c == '('&& s.charAt(i) == ')') || (c == '['&& s.charAt(i) == ']') || (c == '{'&& s.charAt(i) == '}')){	
							continue;
						}else{
							stack.push(c);
						}
					}else{
						System.out.println("false");
						return;
					}
				}
			}
		}
		if(stack.isEmpty()){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}
