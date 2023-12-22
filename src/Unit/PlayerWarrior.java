package Unit;

import java.util.ArrayList;

public class PlayerWarrior extends Player{
	
	public PlayerWarrior(String name, int max, int power, int cnt) {
		super(name, max, power, cnt);
		
	}

	@Override
	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		// 몬스터 한놈 공격력 2배로 공격
		System.out.printf("[%s]에게 2배 데미지[%d]\n",target.getName(),(this.getPower()*2));
		int Hp = target.getCurHp() - this.getPower()*2;
		if(Hp<=0) {
			Hp = 0;
			System.out.printf("[%s] 사망 \n",target.getName());
		}
		target.setCurHp(Hp);
	}
}
