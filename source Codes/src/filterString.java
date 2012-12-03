import java.util.ArrayList;


public class filterString {

	public filterString()
	{
		
	}
	


	
	//This method will always be called first to compare an input by the user
	public ArrayList<String> removeUselessWords(String str)
	{
		String[] uselessWords = {"i", "me", "that", "pretty", "about", "it", "the", "then", "there", "he", "she", "them", "they", "him", "her", "of", "eh", "oh"};
		String[] words = str.split(" ");
		
		
		//this is just for removing punctuation marks
		int x = words.length;
		
		String lastWord = words[x-1];
		int length = lastWord.length();
		char lastChar = lastWord.charAt(length - 1);
		
		if (lastChar == '!' || lastChar == '?' || lastChar == '.')
		{
			words[x-1] = words[x-1].substring(0, words[x-1].length()-1);
		}
		
		
		ArrayList<String> usefulWords = new ArrayList<String>();
		
		//Compares inputed string of words to the set "useless" words
		for (int i = 0; i < words.length; i++)
		{
			for(int j = 0; j < uselessWords.length ; j++)
			{
				//deletes the "useless" words from the Array
				if (words[i].equalsIgnoreCase(uselessWords[j]))
				{
					words[i] = "";
				}
			}
		}
		
		//Adds all the remaining words to the new ArrayList
		for (int i = 0; i < words.length ; i++)
		{
			if (!words[i].equals(""))
			{
				usefulWords.add(words[i]);
			}
		}
		
		
		return usefulWords;
	}
	
	
	//returns "true" if the user inputed "positive" words to LoLTalk  
	public boolean checkPosWords(ArrayList<String> str)
	{
		String[] positiveWords = {"nice", "course", "awesome", "cool", "good", "gg", "sweet", "stupendous", "fantastic", "great", "lovely", "perfect", "sexy", "love", "to", "like"};
		boolean foundWord = false;
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < positiveWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(positiveWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
	}
	
	//returns true if user inputed "negative" words to LoLTalk 
	public boolean checkNegWords (ArrayList <String> str)
	{
		String[] negativeWords = {"noob", "sucks", "suck", "awful", "disgust", "disgusting", "bad", "fail", "terrible", "lame", "n00b", "noobface", "hate", "dislike"};
		
		boolean foundWord = false;
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < negativeWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(negativeWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
	}
	
	
	//Returns true if it sounds like the user responded as "yes" to a question
	public boolean yesAns(ArrayList<String> str)
	{
		
		String[] yesWords = {"yes", "sure", "yeah", "yea", "yeap", "yup", "yap", "ya", "yah", "course", "please", "okay", "ok", "alright", "aight"};
		
		boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < yesWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(yesWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
		
	}
	
	
	//Returns true if it sounds like the user responded as "no" to a question
	public boolean noAns(ArrayList<String> str)
	{
		
		String[] noWords = {"no", "nope", "never", "nah", "na"};
		
		boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < noWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(noWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
	}
	
	
	//See's if the user "asked" a question
	public boolean isQuestion(ArrayList<String> str)
	{
	
		String[] qWords = {"can", "how", "will", "what", "why", "where", "do"};
		boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < qWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(qWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
	}
	
	//See's if user is saying "goodbye"
	public boolean isGoodbye(ArrayList<String> str)
	{
		String[] byeWords = {"bye", "goodbye", "cya", "see yah", "see yeah", "g2g"};
		boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < byeWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(byeWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
	}
	
	//See's if user is saying "thankyou"
	public boolean isThanks(ArrayList<String> str)
	{
		String[] thankWords = {"thanks", "thankyou", "thank", "ty"};
		boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < thankWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(thankWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
	}
	
	public boolean wantAdvice(ArrayList <String> str)
	{
		String[] adWords = {"advice", "tip", "help", "use", "build", "information", "info", "strategy"};
		
	boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < adWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(adWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
	}

	
	public boolean wantBuild(ArrayList <String> str)
	{
		String[] adWords = {"build", "builds", "strategy", "help", "items", "item", "type", "use", "useful"};
		
	boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < adWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(adWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
	}
	
	public boolean wantTip(ArrayList <String> str)
	{
		String[] tipWords = {"tip", "tips", "playstyle", "style", "play", "advice", "skill", "skills", "styles"};
		
	boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < tipWords.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(tipWords[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
		
	}
	
}
