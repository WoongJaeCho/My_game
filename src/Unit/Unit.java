package Unit;

import java.util.ArrayList;

public abstract class Unit {
	private int curHp;
	private int maxHp;
	private int power;
	private String name;
	private String state = "normal";
	
	public Unit() {}
	
	public Unit(String name, int max, int power) {
		this.name = name;
		this.curHp = max;
		this.maxHp = max;
		this.power = power;
	}
	
	public void init(int max, int power) {
		this.curHp = max;
		this.maxHp = max;
		this.power = power;
	}
	
	public void init(String name, int max, int power) {
		this.name = name;
		this.curHp = max;
		this.maxHp = max;
		this.power = power;
	}
	
	public void attack(Unit target) {
		if(!state.equals("normal")) {
			System.out.printf("[%s]가 [%s]상태이기 때문에 공격할 수 없습니다.\n",name,state);
			return;
		}
		target.curHp -= power;
		System.out.printf("[%s]가 [%s]를 공격, 데미지 [%d]\n",name,target.name,power);
		if(target.curHp <= 0) {
			System.out.printf("[%s] 사망 \n",target.name);
			target.curHp = 0;
		}
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getPower() {
		return power;
	}

	public String getName() {
		return name;
	}

	public int getCurHp() {
		return curHp;
	}

	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "[%-4s] [%4d / %4d] [%-2d]".formatted(name,curHp,maxHp,power);
	}

	public void skill(Unit target, ArrayList<Unit> monList, ArrayList<Player> playerList) {
		
	}


}
