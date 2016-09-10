package Num1;

import java.util.Stack;
/**
 * 练习1.3.11
 * @author lxc
 *
 */
public class EvaluatePostifix {
	public Stack<Double> vals;
	
	public EvaluatePostifix(){
		vals = new Stack<Double>();
	}
	
	/**
	 * 计算逆波兰式
	 * @param str
	 * @return
	 */
	public double calculate(String str){
		int len = str.length();
		for(int i=0; i<len; i++){
			String temp = str.charAt(i)+"";
			if(isOps(temp)){
				vals.push(computer(temp));
			}else{
				vals.push(Double.valueOf(temp));
			}
		}
		return vals.pop();
	}
	
	public boolean isOps(String str){
		return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
	}
	
	public double computer(String ops){
		double temp = vals.pop();
		switch(ops){
			case "+":
				return vals.pop() + temp;
			case "-":
				return vals.pop() - temp;
			case "*":
				return vals.pop() * temp;
			case "/":
				return vals.pop() / temp;
			default:
				return 0;
		}
	}
}
