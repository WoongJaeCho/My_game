package _Main;

import Manager.GameManager;

public class _Main {

	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		
		boolean run = true;
		while(run) {
			run = gameManager.changeStage();
		}
		System.out.println("[ Game Over ]");
	}

}
