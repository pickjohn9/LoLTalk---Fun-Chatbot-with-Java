import java.util.ArrayList;
import java.util.Random;


public class dataBase 
{	
	String[] Champions = new String[8];
	String[] Builds = new String[8];
	String[] Tips = new String[8];
	String[] Comment = new String[8];
	
	//Inputs data into Response "database"  
	public dataBase()
	{
		Champions[0] = "Ahri";
		Builds[0] = "Ahri, is an AP Carry, she is very squishy so you'd want to start off with some doran rings and a Rod of Ages. Afterwards rush magic damage, go straight for a Rabadons deathcap and finish with a Rylais Scepter.";
		Tips[0] = "Use 'Charm' to set your combos, it'll make landing the rest of your skill shots easier! :)";
		Comment[0] = "You're playing Ahri? I think Ahri is very pretty. :D Definitely a great addition to the League!";
		
		Champions[1] = "Draven";
		Builds[1] = "Draven is an ADC so you'd simply build attack damage items. He benefits with more attack damage so I would start off with some doran blades and then rush for a Blood Thirster before getting attack speed items like the Phantom Dancer";
		Tips[1] = "Trying to catch his spinning axes may seem difficult, but the trick is if you don't move after throwing one it will land near you or directly on top of you! :)";
		Comment[1] = "Oh so you play Draven! I LOVE DRAVEN! :D He can really only be played as an ADC.";
		
		Champions[2] = "Alistar";
		Builds[2] = "Alistar is a great support! Generally I would build pure support items starting with a Philospher's stone and then a Heart of Gold before building aura granting items. However you can also build him pure tank just rush a Sheen and go straight for tank items! Powerful!";
		Tips[2] = "Use Pulverise to give you better positioning for your headbutt attack!. Also remember movement speed is very important for alistar so consider what boots to buy carefully...";
		Comment[2] = "Alistar eh? He's a very strong cow :P He's actaully one of my most favorite supports! Glad you brought him up!";
		
		Champions[3] = "Ashe";
		Builds[3] = "Ashe is an ADC, as such you'd simply build attack damage items. She benefits most with critical strike damage so you should rush the infinity edge after starting off with some doran blades. Afterwards get your Phantom Dancer. Oh and don't forget your boots! :)";
		Tips[3] = "Try to fire the Enchanted Crystal Arrow in the same direction enemies are moving so you're more likely to land a hit! Ouch to them! ";
		Comment[3] = "You've played as Ashe the Frost Archer! Love that champions! She's one of the easier champions to play in my opinion. ";
		
		Champions[4] = "Diana";
		Builds[4] = "Diana may look like an AP carry but she is quite unique compared to the standared AP build :P I would advise you build between a bruiser and AP carry items. That means after you build the doran blade you should rush items such as the Rod of Ages and the Abbysal Scepter. Because of this you can even send her to farm in the jungle!";
		Tips[4] = "Landing her crescent strike is critically important, but don't be afraid to miss. The cooldown is short and the mana cost is low :) Use it to follow up your moon rush, its the most devestating thing you can do to your opponents";
		Comment[4] = "Diana is a new champion to me but she is a really fun one! I like using her in the twisted treeline or in the jungle. She snowballs out of control if she gets those early kills xD";
		
		Champions[5] = "Darius";
		Builds[5] = "Blech, if you want to be a painful top laner then yes you can use darius as an AD Bruiser. Just by the phage and turn it into a frozen mallet. Your skills will do the rest.";
		Tips[5] = "What can I say? Just harras them with your abilities -_- its what always gets me.";
		Comment[5] = "Ohh man Darius is an annoying Champion. I don't even own him, I find him really unfair and cheap to use. I do know his mechanics though...";
		
		Champions[6] = "Gangplank";
		Builds[6] = "Gangplank is a great top laner. Some may say you can jungle with him but I'd forget that. Just grab the top lane and rush either a trinity force if you want to damage your oppenents or rush a frozen mallet if you want to defent againts them.";
		Tips[6] = "Remember that your Parley applies the hit on affects from your items. Use it! Also try to use your canon barage on escaping enemies, it slows them down! Don't let them get away!";
		Comment[6] = "Yarhar! Gangplank is a fun pirate. He was one of my first champions to play as. His quotes are also hilarious! Everyone loves pirates! xD";
		
		Champions[7] = "Teemo";
		Builds[7] = "Gee.. if you must play Teemo he's most powerful (and annoying) with an AP hybrid build. Its quite unique from most champions but you'd want to rush the nashors tooth first. You would go for both AP damage and attack speed. This makes both his auto attack and his damn mushrooms to be extremely powerful -_-";
		Tips[7] = "A reason I hate facing Teemo is that he can place his mushrooms on key locations of the map. It always gets me when I'm trying to do something sneaky.. then I get revealed! Every Teemo should do this. Not only that, you can clear creepwaves effectively with hsi mushrooms";
		Comment[7] = "Oh noo Teemo! -_- I really realllly hate that champion. His mushrooms are SO ANNOYING. :( Whenever I think I'm doing something awesome for my team its BOOM. Teemo mushroom... ";
		
	}

	
	//Gives build advice
	public String giveBuild(String champ)
	{
		for (int i = 0; i<Champions.length; i++)
		{
			if (Champions[i].equalsIgnoreCase(champ))
			{
				return Builds[i];
			}
		}
		
		return "I don't actually know how to build that Champion.. :/";
	}
	
	
	//Gives a tip on that champion
	public String giveTip(String champ)
	{
		for (int i = 0; i<Champions.length; i++)
		{
			if (Champions[i].equalsIgnoreCase(champ))
			{
				return Tips[i];
			}
		}
		
		return "I don't actually have any tips for that Champion.. :/";
	}
	
	
	//Gives a comment on the champion
	public String giveComment(String champ)
	{
		for (int i = 0; i<Champions.length; i++)
		{
			if (Champions[i].equalsIgnoreCase(champ))
			{
				return Comment[i];
			}
		}
		
		return "I don't actually know how to build that Champion.. :/";
	}
	
	
	//see's if user mentioned a champion name
	public boolean isChamp(ArrayList<String> str)
	{
		
		boolean foundWord = false;
		
		
		for (int i = 0; i<str.size() ; i++)
		{
			for (int j = 0; j < Champions.length; j++)
			{
				if (str.get(i).equalsIgnoreCase(Champions[j]))
				{
					foundWord = true;
				}
					
			}
		}
		
		return foundWord;
	}
	
	
	
	//checks which champion the user has mentioned
	public String whichChamp (ArrayList<String> str)
	{
		String champion = "";
		
		for (int i = 0; i < Champions.length ; i++)
		{
			for(int j = 0; j<str.size();j++)
			{
				if (Champions[i].equalsIgnoreCase(str.get(j)))
				{
					champion = str.get(j);
				}
			}
		}
		
		return champion;
	}
	
	public void displayChampions()
	{
		for(int i = 0; i < Champions.length; i++)
		System.out.println(Champions[i]);
	}
	
}
