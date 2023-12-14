package saur.memebot;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BasicCommands extends ListenerAdapter {

	Random rand = new Random();
	
//	String[] abcs = {"🇦", "🇧", "🇨", "🇩", "🇪", "🇫", "🇬", "🇭", "🇮", "🇯", "🇰", "🇱", 
//			"🇲", "🇳", "🇴", "🇵", "🇶", "🇷", "🇸", "🇹"};
	
	String[] numString = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
	
	@SuppressWarnings("deprecation")
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
	/*	System.out.println("\n" + event.getAuthor());
		
		String g = "";
		
		for(int i = 0; i < args.length; i++) {
			System.out.print(" " + args[i]);
		
			g = g + args[i] + " ";
		}
		
		if(event.getMember().getIdLong() != event.getJDA().getSelfUser().getIdLong())
	//		event.getChannel().sendMessage("Happy Birthday To This Server!").queue();
		
		System.out.println();
	*/
		if(args.length > 1)
			args[1].toLowerCase();
		
	//	if(!event.getMember().getUser().equals(event.getJDA().getSelfUser()))
	//		event.getChannel().sendMessage("Fuck y'all, y'all suck").queue();
		
		final long captainID = 388903444737425409L;
		
		if(event.getAuthor().getIdLong() == captainID) {
			
			if(args[0].startsWith(MainClass.caller + "forcepause")) {
				
				if(!MainClass.forcePause) {
					event.getChannel().sendMessage("Pausing processing of command requests!").queue();				
					MainClass.forcePause = true;
					System.out.println("Command processing paused by force commands!");
				
				} else {
					event.getChannel().sendMessage("The bot has already paused processing command requests!").queue();
				}
				
			}
			
			if(args[0].startsWith(MainClass.caller + "forceresume")) {
				
				if(MainClass.forcePause) {
					event.getChannel().sendMessage("Resuming processing of command requests!").queue();		
					MainClass.forcePause = false;
					System.out.println("Command processing resumed by force commands!");
					
				} else {
					event.getChannel().sendMessage("The bot is already processing command requests!").queue();
				}
				
				
			}
			
			if(args[0].startsWith(MainClass.caller + "forcequit")) {
				event.getChannel().sendMessage("Adios Amigos! Shutting Down...").complete();
				System.out.println("Bot closed by force commands!");
				
				System.exit(0);
				
			}
			
		}
		
		if(!MainClass.forcePause || (event.getMember().getUser().getIdLong() == captainID && !args[0].startsWith(MainClass.caller + "force"))) {
		
		if(args[0].startsWith(MainClass.caller + "hello")) {
			event.getChannel().sendMessage("Hello World!").queue();
		
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "test")) {
			event.getChannel().sendMessage("Yes, I should be working properly...").queue();
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "sex")) {
			event.getChannel().sendMessage("_Coming_ soon :flushed: ").queue();
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "amogus")) {
			event.getChannel().sendMessage("when the imposter is sus :scream: ").queue();
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "help")) {
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(0xf45642);
			embed.setTitle("Available Commands:");
			embed.addField(">> Remember to add '%' symbol before the command! <<", "", false);
			
			//Fields
			
			embed.addField("meme", "Gives a highly rated, random math meme!", false);
			
			embed.addField("meme physics", "Gives a highly rated, random physics meme!", false);
			
			embed.addField("meme cs", "Gives a highly rated, random computer science meme!", false);
			
			embed.addField("quiz", "Simple Arithmetic, Algebraic and Calculus type quizzes available! A round of five questions, with a 60 second time "
					+ "limit per question!", false);
			
			embed.addField("", "Please note that this bot is still under development!", false);
			
		//	embed.setImage("https://www.giastinchi.com/assets/work-in-progress.jpg");
			
			//Footer + Send it
			
			embed.setFooter("Requested By: " + event.getMember().getUser().getName(), event.getMember().getUser().getAvatarUrl());
			event.getChannel().sendMessage(embed.build()).queue();
			
			System.out.println("Help For Commands Requested By: " + event.getAuthor());
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "meme") && args.length > 1 && args[1].startsWith("physic")) {
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(0xf45642);
			
			System.out.println("Physics Meme Requested By: " + event.getAuthor());
			
			int rInt = rand.nextInt(MainClass.bestPhysicsMemesVol - 2) + 1;
			
			embed.setTitle(MainClass.urlsBestPhysicsMemesTitles[rInt], MainClass.urlsBestPhysicsMemesURL[rInt]);
				
			embed.setImage(MainClass.urlsBestPhysicsMemes[rInt]);
			
			embed.setFooter("Best Of Physics Memes", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendMessage(embed.build()).queue(success -> {
				success.addReaction("👍").queue();
				success.addReaction("👎").queue();
				success.addReaction("♻").queue();
			});
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "meme") && args.length > 1 && args[1].startsWith("cs")) {
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(0xf45642);
			
			System.out.println("Cs Meme Requested By: " + event.getAuthor());
			
			int rInt = rand.nextInt(MainClass.bestCSMemesVol - 2) + 1;
			
			embed.setTitle(MainClass.urlsBestCSMemesTitles[rInt], MainClass.urlsBestCSMemesURL[rInt]);
			
			embed.setImage(MainClass.urlsBestCSMemes[rInt]);
			
			embed.setFooter("Best Of Computer Science Memes", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendMessage(embed.build()).queue(success -> {
				success.addReaction("👍").queue();
				success.addReaction("👎").queue();
				success.addReaction("♻").queue();
				
			});
			
		} else if((args.length == 1 && args[0].equalsIgnoreCase(MainClass.caller + "meme")) || (args.length > 1 && 
				args[0].equalsIgnoreCase(MainClass.caller + "meme") && args[1].startsWith("math"))) {
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(0xf45642);
			
			System.out.println("Math Meme Requested By: " + event.getAuthor());
			
			int rInt = rand.nextInt(MainClass.bestMathMemesVol - 2) + 1;
			
			embed.setTitle(MainClass.urlsBestMathMemesTitles[rInt], MainClass.urlsBestMathMemesURL[rInt]);
				
			embed.setImage(MainClass.urlsBestMathMemes[rInt]);
			
			embed.setFooter("Best Of Math Memes", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendMessage(embed.build()).queue(success -> {
				success.addReaction("👍").queue();
				success.addReaction("👎").queue();
				success.addReaction("♻").queue();
				
			});
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "quiz")) {
			
			while(!MainClass.quizInitReady) {} // <-- fix/optimize whatever this shit is TODO
			
			MainClass.quizInitReady = false;
			
			String[] quizDataArr = new String[MainClass.quizData.size()];
			MainClass.quizData.toArray(quizDataArr);
			
			boolean isRunning = false;
			
			for(int i = 0; i < quizDataArr.length; i++) {
				
				if(GetStoredQuizInfo.getChannelID(quizDataArr[i]) == event.getChannel().getIdLong()) {
					isRunning = true;
					
					event.getChannel().sendMessage("Sorry, " + event.getAuthor().getAsMention() + 
							" but it looks like there is already a quiz running in this channel!").queue();
					break;
				
				} else if(GetStoredQuizInfo.getChannelID(quizDataArr[i]) != event.getChannel().getIdLong() 
						&& GetStoredQuizInfo.getAuthorID(quizDataArr[i]) == event.getAuthor().getIdLong()) {
					isRunning = true;
					
					event.getChannel().sendMessage(
							event.getMember().getAsMention() + ", you have already requested a quiz in a different channel/server!").queue();
					break;
				
				}
				
			}
			
			if(!isRunning) {
				
				try {
					
					EmbedBuilder embed = new EmbedBuilder();
					embed.setColor(0xf45642);
					embed.setTitle("Available Quizzes and their Codes:");
					
					embed.addField("", "React with: ", false);
					
					embed.addField(":one: for Arithmetic Quiz", "\n> Addition\n> Subtraction\n> Multiplication\n> Division", false);
					
					embed.addBlankField(false);
					
					embed.addField(":two: for Algebra Quiz", "\n> Sum of Arithmetic Sequences\n> Solutions to Pair of Linear Equations "
							+ "\n> Absolute Values of Complex Numbers\n> Zeros of Quadratic Equation\n> Modelling and Evaluating "
							+ "Sinusoidal Functions", false);
					
					embed.addBlankField(false);
					
					embed.addField(":three: for Geometry Quiz", "\n> Surface Area of Cylinder, Cube and Cuboid\n> Volume of Cylinder", false);
					
					embed.addBlankField(false);
					
					embed.addField(":four: for Calculus Quiz", "\n> Power Rule", false);
					
					event.getChannel().sendMessage(embed.build()).queue();
					
					event.getChannel().sendMessage("Select the type of quiz: ").queue(success -> {
							
							success.addReaction("U+0031 U+20E3").queue();
							success.addReaction("U+0032 U+20E3").queue();
							success.addReaction("U+0033 U+20E3").queue();
							success.addReaction("U+0034 U+20E3").queue();
							
							MainClass.quizData.add(String.valueOf(success.getChannel().getIdLong()) + " " + 
									String.valueOf(event.getAuthor().getIdLong()) + " ");
							
							new QuizSelectTimer(success, event, 60);
							
						});
				
				} catch(Exception exp) {}
				
			}
			
			System.out.println("Quiz Initiated - Requested By: " + event.getAuthor());
			
			MainClass.quizInitReady = true;
			
		} else if(args[0].equalsIgnoreCase(MainClass.caller + "pfp")) {
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(0xf45642);
			
			if(args.length > 1) {
				
				args[1] = args[1].replace("<", "");
				args[1] = args[1].replace("!", "");
				args[1] = args[1].replace("@", "");
				args[1] = args[1].replace(">", "");
				
				embed.setImage(event.getJDA().retrieveUserById(Long.parseLong(args[1])).complete().getAvatarUrl());
				
				embed.setTitle(event.getJDA().retrieveUserById(Long.parseLong(args[1])).complete().getName(), 
						event.getJDA().retrieveUserById(Long.parseLong(args[1])).complete().getAvatarUrl());
				
			} else {
				embed.setTitle(event.getAuthor().getName(), event.getAuthor().getAvatarUrl());
				embed.setImage(event.getAuthor().getAvatarUrl());
			}
			
			embed.setFooter("Profile Picture");
			
			event.getChannel().sendMessage(embed.build()).queue();
			
		} else if(args[0].toUpperCase().startsWith(MainClass.caller + "SCP")) {
			
			if(args.length > 1) {
				
				event.getChannel().sendMessage("https://scp-wiki.wikidot.com/scp-" + args[1]).queue();
				
			} else {
				
				event.getChannel().sendMessage("Usage: %scp [scp item number]").queue();
				
			}
			
		} else if(args[0].toUpperCase().startsWith(MainClass.caller + "POLL")) {
			
			EmbedBuilder embedUse = new EmbedBuilder();
			embedUse.setColor(0xf45642);
			
			embedUse.setTitle("Poll Usage");
			embedUse.addField("Call Format:", "> %poll \\Poll Title  \\Poll Text  \\Option 1  \\Option 2  ...  \\Option 9 \\Option 0"
					+ " |TimeLimit(in seconds, max 86400s) QuizCode", false);
			
			embedUse.addField("Quiz Codes:", "> 1: Voters can vote for MULTIPLE options \n> 2: Voters can only vote for ONE option, voters cannot "
					+ "change or remove their vote", false);
			
			embedUse.addField("Note:", "> Do NOT use: \" \\ \" or \" | \" in the text for the options\n> \n"
					+ "> You can have up to 10 options, Option 10 will be labeled as 0\n> \n> A poll result/summary will be made after the given time "
					+ "limit ends", false);
			
			embedUse.addField("Example:", "> %poll \\Game Night \\What should we play for game night? \\GTA Online \\CSGO \\Rocket League |3600 2", false);
			
			if(args.length > 1) {
				
				try {
					
					String[] allValues = new String[28];
					int allValIter = 0;
					int lastSubS = 0;
					
					EmbedBuilder embed = new EmbedBuilder();
					embed.setColor(0xf45642);
					
					for(int i = 0; i < event.getMessage().getContentDisplay().length(); i++) {
						
						if(event.getMessage().getContentDisplay().charAt(i) == '\\') {
							
							for(int j = i + 1; j < event.getMessage().getContentDisplay().length(); j++) {
								
								lastSubS = j;
								
								if(event.getMessage().getContentDisplay().charAt(j) == '\\')
									break;
								
								if(j == event.getMessage().getContentDisplay().length() - 1)
									lastSubS++;
								
							}
							
							allValues[allValIter] = event.getMessage().getContentDisplay().substring(i + 1, lastSubS);
							allValIter++;
							
						}
						
					}
				
					embed.setTitle(allValues[0]);
					embed.addField(allValues[1], "", false);
					
					for(int i = 2; i < allValIter; i++) {
						embed.addField(":" + numString[i - 2] + ": : " + allValues[i], "", false);
					}
					
					embed.setFooter("Poll Requested By: " + event.getAuthor().getName(), event.getMember().getUser().getAvatarUrl());
					
					final int succeIsDumb = allValIter;
					
					event.getChannel().sendMessage(embed.build()).queue(success -> {
						
						for(int i = 2; i < succeIsDumb; i++) {
							
							if(i == 11)
								success.addReaction("U+0030 U+20E3").queue();
							
							else
								success.addReaction("U+003" + (i - 1) + " U+20E3").queue();
							
							MainClass.pollData.add(Long.toString(success.getIdLong()) + " " + event.getMessage().getContentDisplay());
						}
						
					});
					
					System.out.println("Poll Requested By: " + event.getAuthor());
					
				} catch(Exception e) {
					
					System.out.println(e);
					
					event.getChannel().sendMessage("Some error occured while creating the poll!").queue();
				/*	event.getChannel().sendMessage("Usage: %poll \\Poll Title  \\Poll Text  \\Option 1  \\Option 2  ...  \\Option 9 \\Option 0"
							+ " |TimeLimit(in seconds, max 86400s) QuizCode").queue();*/
					
					event.getChannel().sendMessage(embedUse.build()).queue();
					
				}
				
				
			} else {
			/*	event.getChannel().sendMessage("Usage: %poll \\Poll Title  \\Poll Text  \\Option 1  \\Option 2  ...  \\Option 9 \\Option 0"
						+ " |TimeLimit(in seconds, max 86400s) QuizCode").queue();*/
				
				event.getChannel().sendMessage(embedUse.build()).queue();
			}
			
		} else if(args[0].startsWith(MainClass.caller) && event.getMember().getUser().getIdLong() != captainID) {
			event.getChannel().sendMessage("Sorry, that command does not exist.").queue();
			
		}
		
		}
		
	}
	
}