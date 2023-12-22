package Unit;

import java.util.ArrayList;

public class UnitWolf extends Unit{
	public UnitWolf(){
		super.setName("울프");
	}

	@Override
	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		int power = this.getPower()/2;
		for(Player list : playerList) {
			int hp = getCurHp()-power;
			if(hp < 0) hp = 0;
			list.setCurHp(hp);
		}
	}
	

}
