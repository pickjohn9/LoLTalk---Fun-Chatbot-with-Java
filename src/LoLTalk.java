import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

public class LoLTalk {

	
	static Scanner scan = new Scanner(System.in);
	static Random generator = new Random();

	
	
	public static void main(String[] args) {
		//Initializes the database of LoLTalk
		dataBase response = new dataBase();
		
		System.out.println("THESE ARE THE CHAMPION NAMES YOU CAN TALK TO THE SYSTEM ABOUT");
		response.displayChampions();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		try
		{
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("chatHistory.txt", true)));
	
			   
	
		
		
	
		
		//Initializes the class used to scan user responses
		filterString analyze = new filterString();
		
		//Initializes the response generator
		responseGenerater resGen = new responseGenerater();
		String retMessage = ""; //stores the output;
		
		String user = ""; //Stores the user name
		String says =""; //Stores the user responses
		ArrayList <String> filteredInput = new ArrayList<String>(); //Stores the input after the "useless" words have been filtered out
		
		//Store's responses for the introduction path
		String[] greeting = new String[2];
			greeting[0] = "Hello fellow LoL player! Who might this be?";
			greeting[1] = "Hello! Who is this again?";
	
		String chatHistory = ""; //variable to export to chatHistory.txt
		
		
		//Initial Greeting Path:
		chatHistory = "LoLTalk: "+greeting[generator.nextInt(2)];
		System.out.println(chatHistory); out.println(chatHistory);
		out.flush(); 
		
		System.out.print("> ");
		
		user = scan.nextLine(); 
		chatHistory = "> "+ user;
		out.println(chatHistory);
		out.flush(); 
		
		String[] metGreeting = new String[2];
			metGreeting[0] = "Hi "+user+"! Nice to talk to you again! :D Have you been playing more LoL?";
			metGreeting[1] = "Oh "+user+"! I hope you're ready to talk about some LoL! :)";
		String[] meetGreeting = new String[2];
			meetGreeting[0] =  "Hi "+user+"! Nice to meet you!";
			meetGreeting[1] =  "Hello "+user+"! You can call me LoLTalk :) I love talking about the League of Legends... nice to meet you!";
		
		
		ReadNames readName = new ReadNames();	
		
		
		
		if(readName.metBefore(user))
		{
			chatHistory = "LoLTalk: "+metGreeting[generator.nextInt(2)];
			System.out.println(chatHistory); out.println(chatHistory);
			out.flush(); 
			
			System.out.print(user+": ");
			says = scan.nextLine();
			chatHistory = user+": "+says;
			out.println(chatHistory);
			out.flush(); 
			
			filteredInput = analyze.removeUselessWords(says);
			
			if(analyze.yesAns(filteredInput))
			{
				retMessage = retMessage + "LoLTalk: Awesome!"; 
				chatHistory = retMessage;
				
			}
			else if (analyze.noAns(filteredInput))
			{
				retMessage = retMessage + "LoLTalk: Oh well that's too bad. But I am!";
				chatHistory = retMessage;
			}
			
		}
		else
		{
			chatHistory = "LoLTalk: "+ meetGreeting[generator.nextInt(2)];
			System.out.println(chatHistory); out.println(chatHistory);
			out.flush(); 
			
			System.out.print(user+": "); says = scan.nextLine();
			chatHistory = user+": "+says;
			out.println(chatHistory);
			out.flush(); 
			
			filteredInput = analyze.removeUselessWords(says);
			
			if(analyze.isThanks(filteredInput))
			{
				retMessage = retMessage + resGen.resToThanks();
				chatHistory = retMessage;
			}
			
			if(analyze.checkPosWords(filteredInput))
			{
				retMessage = retMessage +"LoLTalk: " +  resGen.resToPos()+ " I just got off a game of LoL :D we won of course. :)"; 
				chatHistory = retMessage;
			}
			else if (analyze.checkNegWords(filteredInput))
			{
				retMessage = retMessage +"LoLTalk: " + resGen.resToNeg()+ " Anyway, I just got off a game of LoL :D we won of course";
				chatHistory = retMessage;
			}
			
			
	
		}
		
		if(retMessage.equals(""))
		{
			chatHistory = "LoLTalk: "+retMessage+ "Whatever. So I like to play League of Legends all the time. In fact I just got off an epic win! ;) I'm sure you already know much about LoL. What Champions do you like to play?";
			System.out.println(chatHistory); out.println(chatHistory);
			out.flush(); 
		}
		else
		{
			chatHistory = retMessage +" "+ resGen.reqChamp();
			System.out.println(chatHistory); out.println(chatHistory);
			out.flush(); 
		}
		
		
		//Determine the path to take from here:
		do
		{
			System.out.print(user+": "); says = scan.nextLine();
			chatHistory = user+": "+says;
			out.println(chatHistory);
			out.flush(); 
			
			filteredInput = analyze.removeUselessWords(says);
			retMessage = "";
			
			//The default 'unsure' response
			if (analyze.noAns(filteredInput))
			{
				retMessage = "LoLTalk: " + retMessage + resGen.defaultRes(); 
				chatHistory= retMessage;
				System.out.println(chatHistory); out.println(chatHistory);
				out.flush(); 
			}
			
			//Discussing a champion response
			else if (response.isChamp(filteredInput))
			{
				String champ = response.whichChamp(filteredInput);
				
				if (analyze.wantAdvice(filteredInput) || analyze.isQuestion(filteredInput))
				{
					retMessage = "LoLTalk: "+response.giveBuild(champ);
					chatHistory = retMessage;
					System.out.println(chatHistory); out.println(chatHistory);
					out.flush(); 
				}
				else
				{
					retMessage = "LoLTalk: "+response.giveComment(champ) + " Would you like any advice on playing that Champion?";
					chatHistory = retMessage;
					System.out.println(chatHistory); out.println(chatHistory);
					out.flush();
					
					System.out.print(user+": "); says = scan.nextLine();
					chatHistory = user+": "+ says;
					out.println(chatHistory);
					out.flush(); 
					
					filteredInput = analyze.removeUselessWords(says);
					retMessage = "";
					
					if (analyze.noAns(filteredInput))
					{
						chatHistory = resGen.noAdvice();
						System.out.println(chatHistory); out.println(chatHistory);
						out.flush(); 
						
						System.out.print(user+": "); says = scan.nextLine();
						chatHistory = user+": "+says;
						out.println(chatHistory);
						out.flush(); 
						
						filteredInput = analyze.removeUselessWords(says);
						if (analyze.checkPosWords(filteredInput) || analyze.yesAns(filteredInput))
						{
							retMessage = "LoLTalk: "+retMessage + resGen.resToPos() + " " + resGen.reqChamp();
							chatHistory = retMessage;
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
						}
						else if (analyze.checkNegWords(filteredInput) || analyze.noAns(filteredInput))
						{
							retMessage = "LoLTalk: "+retMessage + resGen.resToNeg() + " " + resGen.reqChamp();
							chatHistory = retMessage;
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
						}
						else if (!analyze.isGoodbye(filteredInput))
						{
							retMessage = "LoLTalk: "+resGen.defaultRes();
							chatHistory = retMessage;
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
						}
						
					}
					else if(analyze.yesAns(filteredInput))
					{
						retMessage = "LoLTalk: " + resGen.resToPos() + " So what sort of advice would you like? A build strategy? Or maybe some tips on playstyle?";
						chatHistory = retMessage;
						System.out.println(chatHistory); out.println(chatHistory);
						out.flush(); 
						
						System.out.print(user+": "); says = scan.nextLine();
						chatHistory = user+": "+says;
						out.println(chatHistory);
						out.flush(); 
						
						filteredInput = analyze.removeUselessWords(says);
						if(analyze.wantBuild(filteredInput))
						{
							chatHistory = "LoLTalk: "+response.giveBuild(champ);
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
							
							System.out.print(user+": "); says = scan.nextLine();
							chatHistory = user+": "+says;
							out.println(chatHistory);
							out.flush(); 
							
							
							filteredInput = analyze.removeUselessWords(says);
							retMessage = "LoLTalk: ";
							
							if (analyze.isThanks(filteredInput))
							{
								 retMessage = retMessage + resGen.resToThanks();
								 chatHistory = retMessage;
							}
							if (analyze.checkPosWords(filteredInput))
							{
								retMessage = retMessage + resGen.resToPos();
								chatHistory = retMessage;
							}
							else if (analyze.checkNegWords(filteredInput))
							{
								retMessage = resGen.resToNeg();
								chatHistory = retMessage;
							}
							
							retMessage = retMessage + " " + resGen.reqChamp();
							chatHistory = retMessage;
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
							
						}
						else if (analyze.wantTip(filteredInput))
						{
							chatHistory = "LoLTalk: "+response.giveTip(champ);
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
							
							System.out.print(user+": "); says = scan.nextLine();
							chatHistory = user+": "+says;
							out.println(chatHistory);
							out.flush(); 
							
							filteredInput = analyze.removeUselessWords(says);
							retMessage = "LoLTalk: ";
							
							if (analyze.isThanks(filteredInput))
							{
								 retMessage = retMessage + resGen.resToThanks();
								 chatHistory = retMessage;
							}
							if (analyze.checkPosWords(filteredInput))
							{
								retMessage = retMessage + resGen.resToPos();
								chatHistory = retMessage;
							}
							else if (analyze.checkNegWords(filteredInput))
							{
								retMessage = resGen.resToNeg();
								chatHistory = retMessage;
							}
							
							retMessage = retMessage + " " + resGen.reqChamp();
							chatHistory = retMessage;
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
							
						} 
						else if (!analyze.isGoodbye(filteredInput))
						{
							chatHistory = "LoLTalk: "+resGen.defaultRes();
							System.out.println(chatHistory); out.println(chatHistory);
							out.flush(); 
						}
					}
					else if (!analyze.isGoodbye(filteredInput))
					{
						chatHistory = "LoLTalk: "+ resGen.defaultRes();
						System.out.println(chatHistory); out.println(chatHistory);
						out.flush(); 
					}
					
				}
				
			}
			else if (analyze.yesAns(filteredInput))
			{
				chatHistory = "LoLTalk: "+resGen.reqChamp();
				System.out.println(chatHistory); out.println(chatHistory);
				out.flush(); 
			}
			else if (!analyze.isGoodbye(filteredInput))
			{
				chatHistory = "LoLTalk: "+resGen.defaultRes();
				System.out.println(chatHistory); out.println(chatHistory);
				out.flush(); 
			}
		
		
		}
		while(!analyze.isGoodbye(filteredInput));
		
		chatHistory = "LoLTalk: "+resGen.sayBye();
		System.out.println(chatHistory); out.println(chatHistory);
		out.flush(); 
		
		
	    try
	    {
	    out.close();
	    }
	    
	    catch (Exception e)
	    {
	    	System.out.println("chatHistory.txt did not close after writing");
	    }
	
	}
	catch(IOException e)
	{
		System.out.println("IO Error");
	}
	
		
	}
}
