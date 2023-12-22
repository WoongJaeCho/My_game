package Unit;

import java.util.ArrayList;

public class UnitBat extends Unit{
	
	public UnitBat(){
		super.setName("박쥐");
	}

	@Override
	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		target.setState("침묵");
	}
	

}
