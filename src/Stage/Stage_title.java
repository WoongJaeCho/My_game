package Stage;

import Manager.GameManager;

public class Stage_title implements Stage{

	@Override
	public boolean update() {
		System.out.println("==== [ TEXT RPG ] ====");
			while(true) {
			String start = GameManager.getStringValue("Insert coin (500)");
			if(!start.equals("500")) {
				continue;
			}
			GameManager.nextStage = "LOBBY";
			return false;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
