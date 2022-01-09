package level6_function;

public class pb2_4673 {

	public static void main(String[] args) {

		boolean[] num = new boolean[10000];
		for (int i = 1; i < num.length; i++) {
			if(d(i)<10000)
				num[d(i)] = true;
			if(num[i] == false)
				System.out.println(i);
		}
		

	}
	
	public static int d(int i) {
		int value = i;
		int result = i;
		
		while(true) {
			if(value<10) {
				result += value;
				break;
			}
			result += value%10;
			value /= 10;
				
		}
		return result;
	}

}
