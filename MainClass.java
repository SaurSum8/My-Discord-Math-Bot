package saur.memebot;

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class MainClass {
	
	public static String caller = "%";
	
	static String[] urlsBestMathMemes = new String[3000];
	static String[] urlsBestMathMemesTitles = new String[urlsBestMathMemes.length];
	static String[] urlsBestMathMemesURL = new String[urlsBestMathMemes.length];
	static int bestMathMemesVol = 0;
	
	static String[] urlsBestPhysicsMemes = new String[3000];
	static String[] urlsBestPhysicsMemesTitles = new String[urlsBestPhysicsMemes.length];
	static String[] urlsBestPhysicsMemesURL = new String[urlsBestPhysicsMemes.length];
	static int bestPhysicsMemesVol = 0;
	
	static String[] urlsBestCSMemes = new String[3000];
	static String[] urlsBestCSMemesTitles = new String[urlsBestCSMemes.length];
	static String[] urlsBestCSMemesURL = new String[urlsBestCSMemes.length];
	static int bestCSMemesVol = 0;
	
	static Set<String> quizData = new HashSet<String>();
	static Set<Long> autoAnsweredChannels = new HashSet<Long>();
	
	static Set<String> pollData = new HashSet<String>();
	
	static boolean quizInitReady = true;
	
	static boolean forcePause = false;
	
	public static void main(String[] args) throws LoginException {
		
		JDA jda = JDABuilder.createDefault("AUTHENTICATION TOKEN").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.listening("%help"));
		jda.addEventListener(new BasicCommands());
		jda.addEventListener(new Reactions());
		jda.addEventListener(new QuizAnswerListener());
		
		//Math
		
		ReadFile rf = new ReadFile();
		rf.openFile("BestOfMathImgUrls.txt");
		rf.getURLList(0);
		rf.close();
		
		bestMathMemesVol = rf.numOfUrls;
		
		System.out.println();
		
		rf.openFile("BestOfMathTitles.txt");
		rf.getTitleList(0);
		rf.close();
		
		rf.openFile("UrlNameBestMathImg.txt");
		rf.getRawURLList(0);
		rf.close();
		
		//Physics
		
		rf.openFile("BestOfPhysicsImgUrls.txt");
		rf.getURLList(1);
		rf.close();
		
		bestPhysicsMemesVol = rf.numOfUrls;
		
		rf.openFile("BestOfPhysicsTitles.txt");
		rf.getTitleList(1);
		rf.close();
		
		rf.openFile("UrlNameBestPhysicsImg.txt");
		rf.getRawURLList(1);
		rf.close();
		
		//CS
		
		rf.openFile("BestOfCSImgUrls.txt");
		rf.getURLList(2);
		rf.close();
		
		bestCSMemesVol = rf.numOfUrls;
		
		rf.openFile("BestOfCSTitles.txt");
		rf.getTitleList(2);
		rf.close();
		
		rf.openFile("UrlNameBestCSImg.txt");
		rf.getRawURLList(2);
		rf.close();
		
	}

}