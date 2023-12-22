package Unit;

import java.util.ArrayList;

public class UnitSnake extends Unit{
	public UnitSnake(){
		super.setName("스네이크");
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
