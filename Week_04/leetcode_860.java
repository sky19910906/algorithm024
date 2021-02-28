
public class leetcode_860 {

	
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				five ++ ;
				continue;
			}
			if (bills[i] == 10 && five >= 1) {
				five --;
				ten ++;
				continue;
			}
			if (bills[i] == 20) {
				if (ten > 0 && five > 0) {
					five --;
					ten --;
					continue;
				}
				if (five >= 3) {
					five -= 3;
					continue;
				}
			}
			return false;
		}
		return true;
    }
}
