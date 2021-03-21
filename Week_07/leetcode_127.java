import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class leetcode_127 {
	
	public static void main(String[] args) {
		new leetcode_127().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
	}
	
	//存储单词
	Map<String, Integer> wordMap = new HashMap<String, Integer>();
	List<List<Integer>> edgs = new ArrayList<List<Integer>>();
	int nodeNum = 0;
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	for (String word : wordList) {
			addEdg(word);
		}
    	addEdg(beginWord);
    	if (!wordMap.containsKey(endWord)) {
			return 0;
		}
    	//BFS
    	int[] levels = new int[nodeNum];
    	Arrays.fill(levels, Integer.MAX_VALUE);
    	Queue<Integer> bfsQueue = new ArrayDeque<Integer>();
    	int begin = wordMap.get(beginWord);
    	int end = wordMap.get(endWord);
    	levels[begin] = 0;
    	bfsQueue.offer(begin);
    	while (!bfsQueue.isEmpty()) {
    		int el = bfsQueue.poll();
    		List<Integer> egdsLoop = edgs.get(el);
    		for (Integer edg : egdsLoop) {
    			if (edg == end) {
					return (levels[el] + 1) / 2 + 1;
				}
				if (levels[edg] == Integer.MAX_VALUE) {
					levels[edg] = levels[el]+1;
					bfsQueue.offer(edg);
				}
			}
			
		}
    	return 0;
    }
    
    public void addEdg(String word) {
    	addWordMap(word);
    	int currWordId = wordMap.get(word);
    	//虚拟N个子节点
    	char[] wordchar = word.toCharArray();
    	for (int i = 0; i < wordchar.length; i++) {
			char tmp = wordchar[i];
			wordchar[i] = '*';
			String newEdgWord = new String(wordchar);
			addWordMap(newEdgWord);
			int newEdgWordId = wordMap.get(newEdgWord);
			edgs.get(currWordId).add(newEdgWordId);
			edgs.get(newEdgWordId).add(currWordId);
			wordchar[i] = tmp;
		}
    }
    
    public void addWordMap(String word) {
    	if (!wordMap.containsKey(word)) {
    		wordMap.put(word, nodeNum++);
    		edgs.add(new ArrayList<Integer>());
		}
    }
}
