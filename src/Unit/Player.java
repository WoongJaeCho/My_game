package Unit;

import java.util.ArrayList;

public abstract class Player extends Unit{
	
	private int skillCnt;
	
	public Player(String name, int max , int power, int cnt) {
		super(name, max, power);
		skillCnt = cnt;
	}
}
