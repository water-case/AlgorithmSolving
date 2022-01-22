package level18_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pb4_4949 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			Stack a = new Stack();
			boolean check = true;
			String s = br.readLine();
			if(s.equals(".")) {
				break;
			}
			while(true) {
				if(s.charAt(s.length()-1) != '.') {
					s=s.concat(br.readLine());
				} else {
					break;
				}
			}
			for(int i=0; i<s.length();i++) {
				if(s.substring(i, i+1).equals("(")) a.push("(");
				else if(s.substring(i, i+1).equals("[")) a.push("[");
				else if(s.substring(i, i+1).equals(")")) check = a.pop(")");
				else if(s.substring(i, i+1).equals("]")) check = a.pop("]");
				if(!check) break;
			}
			if(!check) {
				sb.append("no\n");
				continue;
			}
			if(a.result()){
				sb.append("yes\n");
			} else{
				sb.append("no\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
}

class Stack {
	private int top = -1;
	private String[] arr = new String[100];
	
	public void push(String s) {
		arr[top+1] = s;
		top++;
	}
	public boolean pop(String s) {
		if(top>-1) {
			if(s.equals(")")) {
				if(arr[top].equals("(")) {
					top--;
					return true;
				} else {
					return false;
				}
			}
			else if(s.equals("]")) {
				if(arr[top].equals("[")) {
					top--;
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	public boolean result() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
}