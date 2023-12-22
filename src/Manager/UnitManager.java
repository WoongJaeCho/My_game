package Manager;

import java.util.ArrayList;

import Unit.Player;
import Unit.PlayerHealer;
import Unit.PlayerMagician;
import Unit.PlayerWarrior;
import Unit.Unit;

public class UnitManager {
	
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Unit> monList = new ArrayList<Unit>();
	private String path = Unit.class.getPackageName()+".";
	private String mons[] = {"UnitWolf", "UnitBat", "UnitBear", "UnitSnake"};
	
	public UnitManager() {
		Player warrior = new PlayerWarrior("전사",1000,70,4);
		Player magician = new PlayerMagician("마법사",800,60,3);
		Player healer = new PlayerHealer("힐러",500,45,2);
		
		playerList.add(warrior);
		playerList.add(magician);
		playerList.add(healer);
	}
	
	
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}



	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}



	public ArrayList<Unit> getMonList() {
		return monList;
	}



	public void setMonList(ArrayList<Unit> monList) {
		this.monList = monList;
	}



	public void monsterRandSet(int size) {
		for(int i =0; i<size ; i+=1) {
			int rd = GameManager.getRandomIntValue(0, mons.length);
			try {
				Class<?> clazz = Class.forName(path+mons[rd]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				
				Unit temp = (Unit) obj;
				int hp = GameManager.getRandomIntValue(100,100);
				int power = GameManager.getRandomIntValue(10,10);
				temp.init(hp, power);
				monList.add(temp);
			} catch (Exception e) {
			}
		}
	}
}
