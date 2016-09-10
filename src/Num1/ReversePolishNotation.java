package Num1;

import java.util.Stack;

/**
 * 练习1.3.10
 * @author lxc
 *
 */
public class ReversePolishNotation {
	//数据栈
	private Stack<String> val;
	
	public ReversePolishNotation(){
		val = new Stack<String>();
	}
	
	/**
	 * 中序表达式转逆波兰式 a+b*(c+d/e)===>abcde/+*+
	 * @param str
	 * @return
	 */
	public String infixToPostfix(String str){
		int len = str.length();
		StringBuffer result = new StringBuffer();
		for(int i=0; i<len; i++){
			String temp = str.charAt(i) + "";
			if(!isOps(temp) && !temp.equals("(") && !temp.equals(")")){
				//如果是数字或者字母直接拼接到新的字符串中
				result.append(temp);
			}else if(isOps(temp)){
				//如果是操作符
				if(val.isEmpty()){
					//栈为空可以直接进栈
					val.push(temp);
				}else if(opsPriority(temp)==1){
					//如果栈不为空则判断遍历到的操作符的优先级，如果是＂+＂或者＂-＂则说明是最低优先级的，如果栈顶是＂（＂，则直接进栈
					if(val.peek().equals("(")){
						val.push(temp);
					}else{
						//如果栈顶不为＂（＂，则判断栈顶操作符优先级和所遍历操作符优先级，如果栈顶优先级大于所遍历到的操作符，
						//则进行出栈操作，直到遇到＂（＂，＂（＂不会拼接到结果字符串中
						String top = val.pop();
						boolean next = true;
						while(opsPriority(top) > opsPriority(temp) && next){
							result.append(top);
							top = val.pop();
							next = !val.isEmpty();
						}
						//出栈完成后将新操作符压入栈中
						val.push(temp);
					}
				}else{
					//＂*＂、＂/＂直接进栈
					val.push(temp);
				}
			}else if(temp.equals("(")){
				//"("直接进栈
				val.push(temp);
			}else if(temp.equals(")")){
				//当遇到")"时，从栈顶依次出栈直到遇到"("为止
				String top = val.pop();
				boolean next = true;
				while(!top.equals("(") && next){
					result.append(top);
					top = val.pop();
					next = !val.isEmpty();
				}
			}
		}
		//如果栈中还有操作符则进行出栈
		while(!val.isEmpty()){
			result.append(val.pop());
		}
		return result.toString();
	}
	
	/**
	 * 判断是否操作符
	 * @param ch
	 * @return
	 */
	public boolean isOps(String str){
		switch(str){
			case "+":
			case "-":
			case "*":
			case "/":
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * 判断操作符优先级
	 * @param str
	 * @return
	 */
	public int opsPriority(String str){
		switch(str){
			//这里把“（”都加进来是因为“（”也会在栈中，在出栈操作的时候遇到“（”时候就会停止
			case "(":
				return 0;
			case "+":
			case "-":
				return 1;
			case "*":
			case "/":
				return 2;
			default:
				return -1;
		}
	}
}
