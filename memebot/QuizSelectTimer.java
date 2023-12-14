package saur.memebot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class QuizSelectTimer implements ActionListener {

	Timer t = new Timer(1000, this);
	int timeLimit = 60;
	
	Message message;
	GuildMessageReceivedEvent event;
	
	public QuizSelectTimer(Message m, GuildMessageReceivedEvent e, int timeLim) {
		
		message = m;
		timeLimit = timeLim;
		event = e;
		
		t.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		timeLimit--;
		
		if(timeLimit <= 0) {
			
			if(MainClass.quizData.contains(String.valueOf(message.getChannel().getIdLong()) + " " + 
					String.valueOf(event.getAuthor().getIdLong()) + " ")) {
				
				MainClass.quizData.remove(String.valueOf(message.getChannel().getIdLong()) + " " + 
						String.valueOf(event.getAuthor().getIdLong()) + " ");
				
				System.out.println("Quiz Suspended - Requested By: " + event.getAuthor());
				
				message.clearReactions().queue();
				message.editMessage("It has been 60+ seconds and since no decision was taken, this quiz was suspended to conserve resources.").queue();
				
			}
			
			t.stop();
			
		}
		
	}
	
}
