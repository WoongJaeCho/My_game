package Unit;

import java.util.ArrayList;

public class PlayerMagician extends Player{
	
	public PlayerMagician(String name, int max, int power, int cnt) {
		super(name, max, power,cnt);
	}

	@Override
	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		// 공격력 50%로 몬스터 전체 공격
		int power = this.getPower()/2;
		System.out.printf("전체에게 데미지[%d]로 공격!\n",power);
		for(Unit list : monList) {
			int hp = list.getCurHp()-power;
			if(hp<=0) {
				hp=0;
				System.out.printf("[%s] 사망 \n",list.getName());
			}
			list.setCurHp(hp);
		}
		
		
	}

}
