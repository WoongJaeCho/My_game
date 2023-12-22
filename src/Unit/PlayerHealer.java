package Unit;

import java.util.ArrayList;

public class PlayerHealer extends Player{
	
	public PlayerHealer(String name, int max, int power, int cnt) {
		super(name, max, power, cnt);
	}

	@Override
	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		// player 전체 MaxHp 30% 회복
		System.out.println("전체에게 HP 30% 회복!");
		for(Player list : playerList) {
			double hp = list.getMaxHp() * 0.3;
			list.setCurHp(getCurHp()+(int)hp);
		}
	}

}
