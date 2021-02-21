import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode_77 {
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (k <= 0 || n <=0 || k > n) {
			return results;
		}
		Deque<Integer> result = new ArrayDeque<Integer>();
		dfs(n, k, 1, results, result);
		return results;
    }
	
	public void dfs(int n, int k,int index,List<List<Integer>> results,Deque<Integer> result) {
		if (result.size() == k) {
			results.add(new ArrayList<Integer>(result));
			return;
		}
		for (int i = index; i <= n - (k-result.size()) + 1; i++) {
			result.addLast(i);
			dfs(n, k, i+1, results, result);
			result.removeLast();
		}
	}
}
