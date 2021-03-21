import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_433 {
	
	public int minMutation(String start, String end, String[] bank) {
		Set<String> bankSet = new HashSet<String>(Arrays.asList(bank));
		if(!bankSet.contains(end)) return -1;
		Set<String> beginSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		beginSet.add(start);
		endSet.add(end);
		int len = 0;
		while(!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> tmp = beginSet;
				beginSet = endSet;
				endSet = tmp;
			}
			Set<String> bankTmpSet = new HashSet<String>();
			for(String target : beginSet) {
				char[] targetchar = target.toCharArray();
				for (int i = 0; i < targetchar.length; i++) {
					char tmpchar = targetchar[i];
					for(char change : new char[] {'A','C','G','T'}) {
						targetchar[i] = change;
						String newBank = new String(targetchar);
						if(endSet.contains(newBank)) return len + 1;
						if(!visited.contains(newBank) && bankSet.contains(newBank)) {
							visited.add(newBank);
							bankTmpSet.add(newBank);
						}
					}
					targetchar[i] = tmpchar;
				}
			}
			beginSet = bankTmpSet;
			len ++;
		}
		return -1;
    }
}
