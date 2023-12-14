package saur.memebot;

public class GetStoredQuizInfo {

	public static long getChannelID(String s) {
		
		Long l = null;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == ' ') {
				
				l = Long.parseLong(s.substring(0, i));
				
				break;
			}
			
		}
		
		return l;
	}
	
	public static long getAuthorID(String s) {
		
		Long l = null;
		
		int j = 0;
		int subStart = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == ' ' && j == 1) {
				
				l = Long.parseLong(s.substring(subStart, i));
				
				break;
			
			} else if(s.charAt(i) == ' ' && j < 1) {
				
				subStart = i + 1;
				j++;
				
			}
			
		}
		
		return l;
	}
	
	public static long getAnswer(String s) {
		
		Long l = null;
		
		int j = 0;
		int subStart = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == ' ' && j == 2) {
				
				l = Long.parseLong(s.substring(subStart, i));
				
				break;
			
			} else if(s.charAt(i) == ' ' && j < 2) {
				
				subStart = i + 1;
				j++;
				
			}
			
		}
		
		return l;
	}
	
	public static long getQuestionNumber(String s) {
		
		Long l = null;
		
		int j = 0;
		int subStart = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == ' ' && j == 3) {
				
				l = Long.parseLong(s.substring(subStart, i));
				
				break;
			
			} else if(s.charAt(i) == ' ' && j < 3) {
				
				subStart = i + 1;
				j++;
				
			}
			
		}
		
		return l;
	}
	
	public static int getQuizType(String s) {
		
		int l = 0;
		
		int j = 0;
		int subStart = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == ' ' && j == 4) {
				
				l = Integer.parseInt(s.substring(subStart, i));
				
				break;
			
			} else if(s.charAt(i) == ' ' && j < 4) {
				
				subStart = i + 1;
				j++;
				
			}
			
		}
		
		return l;
	}
	
}