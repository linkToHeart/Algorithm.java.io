package games;

import java.util.Scanner;
/**
 * 十进制转八进制后把每一位相加
 * @author xclin
 *
 */
public class Octonary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		String output = Integer.toOctalString(input);
		String[] arr = output.split("");
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println(sum);
	}

}
