package saur.memebot;

public class PollGetter {
	
	public static boolean doesPollExist(long ID) {
		
		String[] array = new String[MainClass.pollData.size()];
		
		MainClass.pollData.toArray(array);
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[i].startsWith(Long.toString(ID)))
				return true;
			
		}
		
		return false;
	}

}