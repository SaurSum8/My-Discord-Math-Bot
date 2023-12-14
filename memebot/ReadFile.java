package saur.memebot;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

	private Scanner s;
	int numOfUrls = 0;
	
	public void openFile(String fileName) {
		
		try {
			numOfUrls = 0;
			s = new Scanner(new File(fileName));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Math: 0, Physics: 1, CS: 2
	public void getURLList(int type) {
		
		while(s.hasNextLine()) {
			
			if(type == 0)
				MainClass.urlsBestMathMemes[numOfUrls] = s.nextLine();
			else if(type == 1)
				MainClass.urlsBestPhysicsMemes[numOfUrls] = s.nextLine();
			else if(type == 2)
				MainClass.urlsBestCSMemes[numOfUrls] = s.nextLine();
				
			numOfUrls++;
			
		}
		
	}
	
	public void getTitleList(int type) {
		
		while(s.hasNextLine()) {
			
			if(type == 0)
				MainClass.urlsBestMathMemesTitles[numOfUrls] = s.nextLine();
			else if(type == 1)
				MainClass.urlsBestPhysicsMemesTitles[numOfUrls] = s.nextLine();
			else if(type == 2)
				MainClass.urlsBestCSMemesTitles[numOfUrls] = s.nextLine();
				
			numOfUrls++;
			
		}
		
	}
	
	public void getRawURLList(int type) {
		
		while(s.hasNextLine()) {
			
			if(type == 0)
				MainClass.urlsBestMathMemesURL[numOfUrls] = s.nextLine();
			else if(type == 1)
				MainClass.urlsBestPhysicsMemesURL[numOfUrls] = s.nextLine();
			else if(type == 2)
				MainClass.urlsBestCSMemesURL[numOfUrls] = s.nextLine();
			
			numOfUrls++;
			
		}
		
	}
	
	public void close() {
		s.close();
	}
	
}
