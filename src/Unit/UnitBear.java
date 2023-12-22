package Unit;

import java.util.ArrayList;

public class UnitBear extends Unit{
	public UnitBear(){
		super.setName("베어");
	}

	@Override
	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		int power = this.getPower()*2;
		int hp = getCurHp()-power;
		if(hp < 0) hp = 0;
		target.setCurHp(hp);
		target.setState("기절");
	}

}
