import java.util.Random;

//Class for generating appropriate responses to the user


public class responseGenerater {

	Random generater = new Random();
	
	public responseGenerater()
	{
		
	}
	
	
	public String resToThanks()
	{
		String[] responses = new String[3];
		responses[0] = "You're welcome! :)";
		responses[1] = "No problem! :D";
		responses[2] = "Happy to help!";
		
		return responses[generater.nextInt(3)];
	}
	
	
	public String resToPos()
	{
		String[] responses = new String[3];
		responses[0] = "Thanks!";
		responses[1] = "=)";
		responses[2] =  "Cool!";
		
		return responses[generater.nextInt(3)];
		
	}
	
	
	public String resToNeg()
	{
		String[] responses = new String[3];
		responses[0] = "Oh, that's too bad...";
		responses[1] = "I'm sorry you feel that way :(";
		responses[2] = "That's not cool.";
		
		return responses[generater.nextInt(3)];		
			
	}
	
	
	public String reqChamp()
	{
		String[] responses = new String[4];
		responses[0] = "Any champions you've been playing with?";
		responses[1] = "Which champion did you last play as?";
		responses[2] = "What champion do you usually play as? :P";
		responses[3] = "Who is your favorite champion? :)";
		
		return responses[generater.nextInt(4)];		
		
	}
	
	public String defaultRes()
	{
		String[] responses = new String[3];
		
		responses[0] = "I'm not sure about that, we're talking about LoL right? :D";
		responses[1] = "What are you talking about? Forget that :P Don't you want to talk about LoL?";
		responses[2] = "Huh? Was that topic about LoL?";
		
		return responses[generater.nextInt(3)];	
	}
	
	public String noAdvice()
	{
		String[] responses = new String[3];
		
		responses[0] = "Oh... do you like that Champion?";
		responses[1] = "Alright that's fine. Do you enjoy playing as that Champion?";
		responses[2] = "You're missing out! What do you think of that Champion?";
		
		return responses[generater.nextInt(3)];
	}
	
	public String sayBye()
	{
		String[] responses = new String[3];
		
		responses[0] = "Nice talking with you! See you!";
		responses[1] = "Goodbye!! :)";
		responses[2] = "See ya on LoL! ;)";
		
		return responses[generater.nextInt(3)];
	}
	
	
}
