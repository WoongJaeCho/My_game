package Manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Stage.Stage;
import Stage.Stage_battle;
import Stage.Stage_lobby;
import Stage.Stage_title;

public class GameManager {
	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	public static String nextStage = "";
	private String curStage = "";
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	public GameManager() {
		stageList.put("TITLE", new Stage_title());
		stageList.put("LOBBY", new Stage_lobby());
		stageList.put("BATTLE", new Stage_battle());
		
		nextStage = "TITLE";
	}
	
	public static int getIntValue(String msg, int start, int end) {
		System.out.printf("▶ %s 선택 (%d~%d) >> ",msg,start,end);
		while(true) {
			try {
				int input = scan.nextInt();
				if(input<start || input>end) {
					System.out.printf("%d ~ %d 사이 값 입력 할 것.\n",start,end);
					continue;
				}
				return input;
			} catch (Exception e) {
				System.out.println("정수 값 입력 할 것.");
			} finally {
				scan.nextLine();
			}
		}
	}
	
	public static String getStringValue(String msg) {
		System.out.printf("%s 입력 : ",msg);
		return scan.next();
	}
	
	public static int getRandomIntValue(int start, int range) {
		return rand.nextInt(range)+start;
	}
	
	public boolean changeStage() {
		System.out.println("cur_Stage : "+curStage);
		System.out.println("nextStage : "+nextStage);
		
		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();
		
		boolean run = true;
		while(run) {
			run = stage.update();
		}
		
		if(nextStage.equals("")) return false;
		else return true;
	}
}
