package com.gl.iitr.dsalab.a1;

import java.util.Deque;
import java.util.ArrayDeque;


public class BracketsBalancer {
	
	public BracketsBalancer() {
		
	}
	
	/*
	 
	Input String : ([{}])
	Result : Has Balanced Brackets

	Input String : [()]{}{[()()]()}
	Result : Has Balanced Brackets

	Input String : [()]{}{[)()]()}
	Result : Do not contain Balanced Brackets

	Input String : {{{{{{{[[[[[[]]]]]((((((()))))))}}}}}}
	Result : Do not contain Balanced Brackets

	Input String : c{[(a)b]}
	Result : Has Balanced Brackets
			 
	*/
	
	public static boolean isBalancedBracketsExpression(String inputString)  {
		
		if(inputString == null || inputString.length() == 0) {
			return true;
		}
		
		// Using ArrayDeque is faster than using Stack
		Deque<Character> stack = new ArrayDeque<Character>();
		int count = inputString.length();
		int index = 0;
		
		for (; index < count; index++) {
		
			char c = inputString.charAt(index);
			
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			else {
				
				if (c == ')' || c == '}' || c == ']') {
					
					if (stack.isEmpty()) {
						break;
					} else {

						char topc = stack.pop();
						if (c == ')' && topc != '(') {
							break;
						} else if (c == '}' && topc != '{') {
							break;
						} else if (c == ']' && topc != '[') {
							break;
						}
					}
				} else {
					// Some other character. Ignore and continue as program need to check only
					// balanced brackets
					continue;
				}
			}
		}
		
		if(index < count) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		String exprList[] = {
				"([{}])", 
				"[()]{}{[()()]()}",  
				"[()]{}{[)()]()}", 
				"{{{{{{{[[[[[[]]]]]((((((()))))))}}}}}}",
				"c{[(a)b]}"
				};
		
		for(String expr: exprList) { 
		
			System.out.println("\nInput String : " + expr);
			
			if (isBalancedBracketsExpression(expr)) {
				System.out.println("Result : Has Balanced Brackets");
			} else {
				System.out.println("Result : Do not contain Balanced Brackets");
			}
		}
	}
}
