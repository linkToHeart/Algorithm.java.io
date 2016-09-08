package Num1;
import java.util.Scanner;
import java.util.Stack;
/**
 * 根据括号计算
 * @author lxc
 *
 */
public class Stacki {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		System.out.println("请输入数学公式：");
		Scanner sc=new Scanner(System.in); 
		String s=sc.nextLine();//接受键盘字符串 
		for(int i=0; i<s.length(); i++){
			String str = String.valueOf(s.charAt(i));
			if(str.equals("("));
			else if(str.equals("+")){
				ops.push(str);
			}else if(str.equals("-")){
				ops.push(str);
			}else if(str.equals("*")){
				ops.push(str);
			}else if(str.equals("/")){
				ops.push(str);
			}else if(str.equals(")")){
				String op = ops.pop();
				double val = vals.pop();
				if(op.equals("+")){
					val = vals.pop() + val;
				}else if(op.equals("-")){
					val = vals.pop() - val;
				}else if(op.equals("*")){
					val = vals.pop() * val;
				}else if(op.equals("/")){
					val = vals.pop() / val;
				}
				vals.push(val);
			}else{
				vals.push(Double.parseDouble(str));
			}
		}
		System.out.println("结果：" + vals.pop());
	}
}
