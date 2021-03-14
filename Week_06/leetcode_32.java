import java.util.Stack;

public class leetcode_32 {
	
	public int longestValidParentheses(String s) {
		//尝试用栈解决一下
		Stack<Integer> stack = new Stack<Integer>();
		char[] schar = s.toCharArray();
		int result = 0;
		stack.push(-1);
		for (int i = 0; i < schar.length; i++) {
			//1、左括号 入栈
			//2、右括号
			if (schar[i] == '(') {
				stack.push(i);
			}else {
				stack.pop();
				//不能成对 则入栈
				if (stack.isEmpty()) {
					stack.push(i);
				}else {
					//成对则更新最大值
					result = Math.max(result, i - stack.peek());
				}
			}
		}
        return result;
        //((((((((((())(()
    }
	
	//动态规划
	public int longestValidParentheses1(String s) {
		//dp[i]为以i结尾的最大有效括号
		//只能以)结尾
		//若 i-1 为( ,dp[i] = dp[i-2] + 2
		//若 i-1 为) ,dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2] ( i - dp[i-1] -1 处为 '(' )
		char[] schar = s.toCharArray();
		int[] dp = new int[schar.length];
		int result = 0;
		for (int i = 1; i < schar.length; i++) {
			if (schar[i] == ')') {
				if (schar[i-1] == '(') {
					dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
				}else if(i > dp[i-1] && schar[i - dp[i-1] -1] == '(') {
					dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
				}
				result = Math.max(result, dp[i]);
			}
		}
        return result;
        //((((((((((())(()
    }
}
