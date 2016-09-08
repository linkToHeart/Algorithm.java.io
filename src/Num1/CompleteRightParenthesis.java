package Num1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1.3.9补全右括号')'
 * 1+2)*3-4)*5-6))) ==> ((1+2)*((3-4)*(5-6)))
 * @author lxc
 *
 */
public class CompleteRightParenthesis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'){
				ops.push(String.valueOf(s.charAt(i)));
			}else if(s.charAt(i)==')'){
				String src = ")" + vals.pop() + ops.pop() + vals.pop() + "(";
				vals.push(src);
			}else{
				vals.push(String.valueOf(s.charAt(i)));
			}
		}
		String result = vals.pop();
		System.out.println("result: " + result);
		//字符串反转
		String end = "";
		for(int i=result.length()-1; i>=0; i--){
			end += String.valueOf(result.charAt(i));
		}
		System.out.println("end: " + end);
	}
}
