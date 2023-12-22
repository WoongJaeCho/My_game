package Stage;

import java.util.ArrayList;

import Manager.GameManager;
import Manager.UnitManager;
import Unit.Player;
import Unit.Unit;

public class Stage_battle implements Stage{
	UnitManager unitManager = new UnitManager();
	ArrayList<Player> playerList = null;
	ArrayList<Unit> monList = null;
	int monDead = 0;
	int playerDead = 0;
	int monCnt = 4;	
	
	@Override
	public void init() {
		unitManager.getMonList().clear();
		unitManager.monsterRandSet(monCnt);
		playerList = null;
		playerList = unitManager.getPlayerList();
		monList = null;
		monList = unitManager.getMonList();
		monDead = monList.size();
		playerDead = playerList.size();
	}
	
	@Override
	public boolean update() {
		
		
		boolean run = true;
		int p_idx=0;
		int m_idx=0;
		boolean turn = true;
		
		while (true) {
			if(turn) {
				print_charater();
				if(p_idx < playerList.size()) {
					player_attack(p_idx++);
				} else {
					turn = !turn;
					p_idx=0;
				}
				for(Player list : playerList) {
					list.setState("normal");
				}
			} else if(!turn) {
				if(m_idx < monList.size()) {
					monster_attack(m_idx++);
				} else {
					turn = !turn;
					m_idx=0;
				}
				for(Unit list : monList) {
					list.setState("normal");
				}
			}
			check_live();
			if(monDead <= 0 ) break;
			if(playerDead <= 0) {
				GameManager.nextStage = "";
				return false;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
	
	private void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i+=1) {
			if (playerList.get(i).getCurHp() <= 0) {
				num += 1;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i+=1) {
			if (monList.get(i).getCurHp() <= 0) {
				num += 1;
			}
		}
		monDead = monList.size() - num;
	}
	
	private void monster_attack(int idx) {
		Unit m = monList.get(idx);
		if (m.getCurHp() <= 0) return;
		int rd = GameManager.getRandomIntValue(0,1);
		if(rd==0) {
			System.out.printf("[%s]의 특수 공격!\n",m.getName());
			int index = GameManager.getRandomIntValue(0, monList.size()-1);
			m.skill(playerList.get(index),monList,playerList);
		} else {
			while (true) {
				int index = GameManager.getRandomIntValue(0, playerList.size());
				if (playerList.get(index).getCurHp() > 0) {
					m.attack(playerList.get(index));
					break;
				}
			}
		}
	}
	
	private void player_attack(int idx) {
		Player p = playerList.get(idx);
		if(p.getCurHp() <= 0) return;
		System.out.println(p.getState());
//		if(!p.getState().equals("normal")) {
//			System.out.printf("[%s]가 [%s]상태이기 때문에 공격할 수 없습니다.\n",p.getName(),p.getState());
//			return;
//		}
		System.out.println("======[메뉴 선택]=====");
		System.out.println("[" + p.getName() + "] [1.어택] [2.스킬]");
		int sel = GameManager.getIntValue("메뉴", 1, 2);
		if(sel==1) {	
			while(true) {
				int index = GameManager.getRandomIntValue(0, monList.size());
				if(monList.get(index).getCurHp() > 0) {
					p.attack(monList.get(index));
					break;
				}
			}
		} else if(sel==2) {
			System.out.printf("[%s]의 Skill 사용!\n",p.getName());
			int index = GameManager.getRandomIntValue(0, monList.size());
			p.skill(monList.get(index),monList,playerList);
		}
	}
	
	private void print_charater() {
		System.out.println("======[BATTLE]======");
		
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < playerList.size(); i++) {
			System.out.println(playerList.get(i));
			//playerList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			System.out.println(monList.get(i));
			//monList.get(i).printData();
		}
	}
	

}
