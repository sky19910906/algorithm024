import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_127_double {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		//双向BFS
		Set<String> wordSet = new HashSet<String>(wordList);
		if(!wordSet.contains(endWord)) return 0;
		Set<String> beginSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		int len = 1;
		while(!beginSet.isEmpty() && !endSet.isEmpty()) {
			//遍历小的set
			if (beginSet.size() > endSet.size()) {
				Set<String> tmp = beginSet;
				beginSet = endSet;
				endSet = tmp;
			}
			Set<String> tmpSet = new HashSet<String>();
			for (String word : beginSet) {
				//变换'a' - 'z'
				char[] wordchar = word.toCharArray();
				for (int i = 0; i < wordchar.length; i++) {
					char tmpchar = wordchar[i];
					for(char nchar = 'a'; nchar <= 'z'; nchar ++) {
						if(nchar == tmpchar) continue;
						wordchar[i] = nchar;
						String newWord = new String(wordchar);
						if(endSet.contains(newWord)) return len + 1;
						if (wordSet.contains(newWord) && !visited.contains(newWord)) {
							visited.add(newWord);
							tmpSet.add(newWord);
						}
					}
					wordchar[i] = tmpchar;
				}
			}
			beginSet = tmpSet;
			len ++;
		}
		return 0;
	}
}
