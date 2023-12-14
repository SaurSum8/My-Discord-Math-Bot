package saur.memebot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class QuizAnswerListener extends ListenerAdapter {
	
	@SuppressWarnings("deprecation")
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		String[] quizDataArr = new String[MainClass.quizData.size()];
		MainClass.quizData.toArray(quizDataArr);
		
		for(int i = 0; i < quizDataArr.length; i++) {
			
			if(GetStoredQuizInfo.getChannelID(quizDataArr[i]) == event.getChannel().getIdLong()) {
				
				try {
					
					if(Integer.parseInt(args[0]) == GetStoredQuizInfo.getAnswer(quizDataArr[i])) {
						
						event.getMessage().addReaction("✔️").queue();
						
						EmbedBuilder embed = new EmbedBuilder();
						embed.setColor(0xf45642);
						embed.setTitle("Excellent Work! The correct answer is " + GetStoredQuizInfo.getAnswer(quizDataArr[i]));
						embed.setFooter("Correctly Answered By: " + event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
						event.getChannel().sendMessage(embed.build()).queue();
						
						MainClass.quizData.remove(quizDataArr[i]);
						
						if(GetStoredQuizInfo.getQuestionNumber(quizDataArr[i]) >= 5) {
							
							System.out.println("Quiz Completed - Requested By: " + String.valueOf(GetStoredQuizInfo.getAuthorID(quizDataArr[i])));
							
							embed.setTitle("Thank You for Playing!");
							embed.setFooter("Quiz Completed", event.getJDA().getSelfUser().getAvatarUrl());
							event.getChannel().sendMessage(embed.build()).queue();
							
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
						
					} else {
						event.getMessage().addReaction("❌").queue();
					}
					
				} catch(Exception e) {}
				
			}
			
		}
		
	}
	
}