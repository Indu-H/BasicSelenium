package KeyWordFrameWorkImplementation;

import KeywordDriven.KeyWordExecutors;
import KeywordDriven.KeyWordExecutors2;

public class SauceDemoKeywords {

	public static void main(String[] args) {
		KeyWordExecutors2 e=new KeyWordExecutors2();
		e.executors("LAUNCH_BROWSER");
		e.executors("OPEN_URL");
		e.executors("USER_NAME");
		e.executors("PASSWORD");
		e.executors("LOGIN");
		e.executors("CLOSE_BROWSER");

	}

}
