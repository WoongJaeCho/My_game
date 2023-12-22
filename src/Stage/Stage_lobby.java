package Stage;

import Manager.GameManager;

public class Stage_lobby implements Stage{

	@Override
	public boolean update() {
		System.out.println("==== [ LOBBY ] ====");
		System.out.println("[1.전투] [2.종료]");
		int sel = GameManager.getIntValue("메뉴", 1, 2);
		if(sel == 1) {
			GameManager.nextStage = "BATTLE";
		} else if(sel == 2) {
			GameManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}


}
