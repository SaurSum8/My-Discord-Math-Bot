package saur.memebot;

import java.time.OffsetDateTime;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter {
	
	String quizQuestion = "";
	
	@SuppressWarnings("deprecation")
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent e) {
		
		if(!e.getMember().getUser().equals(e.getJDA().getSelfUser()) && 
				e.retrieveMessage().complete().getAuthor().equals(e.getJDA().getSelfUser())) {
			
			if(e.retrieveMessage().complete().getContentDisplay().toString().startsWith("Select the type of quiz:") && 
					e.retrieveMessage().complete().getTimeCreated().toEpochSecond() + 60 >= OffsetDateTime.now().toEpochSecond()
					&& (e.getReactionEmote().getAsReactionCode().charAt(0) == '1' || e.getReactionEmote().getAsReactionCode().charAt(0) == '2'
					|| e.getReactionEmote().getAsReactionCode().charAt(0) == '3' || e.getReactionEmote().getAsReactionCode().charAt(0) == '4')) {
				
				String[] quizDataArr = new String[MainClass.quizData.size()];
				MainClass.quizData.toArray(quizDataArr);
				
				for(int i = 0; i < quizDataArr.length; i++) {
					
					if(GetStoredQuizInfo.getAuthorID(quizDataArr[i]) == e.getUserIdLong() 
							&& GetStoredQuizInfo.getChannelID(quizDataArr[i]) == e.getChannel().getIdLong()) {
						
						e.retrieveMessage().complete().clearReactions().queue();
						
						String[] qType = {"Arithmetic", "Algebra", "Geometry", "Calculus"};
						
						e.retrieveMessage().complete().editMessage("Selected Quiz Type: " + 
								qType[Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)) - 1]).queue();
						
						MainClass.quizData.remove(quizDataArr[i]);
						
						int[] inputNums = Quizzes.generateQuiz(Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)));
						
						MainClass.quizData.add(quizDataArr[i]
								+ String.valueOf(Quizzes.getQuizAnswer(Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)), 
										inputNums)) + " 1 " + e.getReactionEmote().getAsReactionCode().charAt(0) + " ");
						
				//		e.getChannel().deleteMessageById(e.getMessageIdLong()).queue();
						
						EmbedBuilder embed = new EmbedBuilder();
						embed.setColor(0xf45642);
						embed.setTitle(Quizzes.getQuizQuestion(Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)), inputNums)[0]);
						
						for(int j = 1; j < Quizzes.getQuizQuestion(
								Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)), inputNums).length; j++) {
							
							if(Quizzes.getQuizQuestion(
									Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)), inputNums)[j] != null) {
								
								embed.addField(Quizzes.getQuizQuestion(
										Character.getNumericValue(e.getReactionEmote().getAsReactionCode().charAt(0)), inputNums)[j], "", false);
							}
							
						}
						
						embed.setFooter("Quiz Requested By: " + e.getUser().getName(), e.getUser().getAvatarUrl());
						e.getChannel().sendMessage(embed.build()).queue();
						
						new QuizTimer(e, 60, 1);
						
						break;
					
					}
					
				}
				
			}
			
			if(PollGetter.doesPollExist(e.retrieveMessage().complete().getIdLong())) {
				
				for(int i = 0; i < 10; i++) {
					
					if(e.getReactionEmote().getAsReactionCode().charAt(0) == Integer.toString(i).charAt(0))
						break;
					
					if(i == 9)
						e.getReaction().clearReactions().queue();
					
				}
				
			}
			
		}
		
	}
	
}