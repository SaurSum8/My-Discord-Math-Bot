package saur.memebot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;

public class QuizTimer implements ActionListener {

	Timer t = new Timer(1000, this);
	int timeLimit = 60;
	int setTime = 60;
	long questionNumber = 1;
	
	GuildMessageReactionAddEvent event;
	
	public QuizTimer(GuildMessageReactionAddEvent e, int timeLim, long qNum) {
		
		event = e;
		timeLimit = timeLim;
	//	timeLimit = 130;
		setTime = timeLim;
	//	setTime = 130;
		questionNumber = qNum;
		t.start();
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		timeLimit--;
		
		String[] quizDataArr = new String[MainClass.quizData.size()];
		MainClass.quizData.toArray(quizDataArr);
		
		for(int i = 0; i < quizDataArr.length; i++) {
			
			if(event.getChannel().getIdLong() == GetStoredQuizInfo.getChannelID(quizDataArr[i])) {
				
				try {
				
					if(questionNumber != GetStoredQuizInfo.getQuestionNumber(quizDataArr[i])) {
						
						questionNumber++;
						timeLimit = setTime;
						
						if(questionNumber > 5)
							t.stop();
						
					} else if(timeLimit <= 0) {
						
						EmbedBuilder embed = new EmbedBuilder();
						embed.setColor(0xf45642);
						embed.setTitle("No one answered correctly, the correct answer was " + GetStoredQuizInfo.getAnswer(quizDataArr[i]));
						embed.setFooter("Automatic Answer System", event.getJDA().getSelfUser().getAvatarUrl());
						
						event.getChannel().sendMessage(embed.build()).queue();
						
						questionNumber++;
						timeLimit = setTime;
						
						MainClass.quizData.remove(quizDataArr[i]);
					
						if(questionNumber > 5) {
							
							embed.setTitle("Thank You for Playing!");
							embed.setFooter("Quiz Completed", event.getJDA().getSelfUser().getAvatarUrl());
							event.getChannel().sendMessage(embed.build()).queue();
							
							System.out.println("Quiz Completed - Requested By: " + String.valueOf(GetStoredQuizInfo.getAuthorID(quizDataArr[i])));
							
							t.stop();
							
						} else {
						
							int[] inputNums = Quizzes.generateQuiz(GetStoredQuizInfo.getQuizType(quizDataArr[i]));
							
							MainClass.quizData.add(String.valueOf(GetStoredQuizInfo.getChannelID(quizDataArr[i])) + " " + 
													String.valueOf(GetStoredQuizInfo.getAuthorID(quizDataArr[i])) + " " +
													String.valueOf(Quizzes.getQuizAnswer(GetStoredQuizInfo.getQuizType(quizDataArr[i]), inputNums)) + " " +
													String.valueOf(GetStoredQuizInfo.getQuestionNumber(quizDataArr[i]) + 1) + " " +
													String.valueOf(GetStoredQuizInfo.getQuizType(quizDataArr[i])) + " ");
							
							embed.setTitle(Quizzes.getQuizQuestion(GetStoredQuizInfo.getQuizType(quizDataArr[i]), inputNums)[0]);
							
							for(int j = 1; j < Quizzes.getQuizQuestion(GetStoredQuizInfo.getQuizType(quizDataArr[i]), inputNums).length; j++) {
								
								if(Quizzes.getQuizQuestion(GetStoredQuizInfo.getQuizType(quizDataArr[i]), inputNums)[j] != null) {
									
									embed.addField(Quizzes.getQuizQuestion(GetStoredQuizInfo.getQuizType(quizDataArr[i]), inputNums)[j], "", false);
									
								}
								
							}
							
							embed.setFooter("Question " + String.valueOf(GetStoredQuizInfo.getQuestionNumber(quizDataArr[i]) + 1), 
									event.getJDA().getSelfUser().getAvatarUrl());
							event.getChannel().sendMessage(embed.build()).queue();
						
						}
					
					}
					
				} catch(Exception ex) {
					
					t.stop();
					break;
					
				}
				
				break;
				
			} 
			
			if(i == quizDataArr.length - 1) {
				t.stop();
			}
			
		}
		
	}
	
}