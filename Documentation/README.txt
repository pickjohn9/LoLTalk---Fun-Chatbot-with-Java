LoLTalk.jar was exported from eclipse and should run on any OS. It runs on the console so if it cannot be played by simply clicking the file it must be called using the command lines. 

For example on Windows you would Run the CMD (DOS) and access the file using the following command:
'java -jar LoLTalk.jar'

If this does not work for whatever reason the program can still be simply run by opening in Eclipse and running it off the built in console. The main class is called 'LoLTalk.java' 

Features:
The system attempts to mimic having a personal conversation about a person who is an expert at the computer game "League of Legends". His main role will be to give you tips and advice on how to play the various champions of the  
game. You are encourage to try and naturally respond to him the way you would talking to a normal person you are trying to get tips and advice from. There is a list of LoL champions you can discuss with him that is displayed before any conversation happens which allows you to reference.

Two text documents are exported from using LoLTalk, one is called userNames.txt that logs the previous users of LoLTalk so when you input your name LoLTalk will "remember" you or not. The second document is called chatHistory.txt. This document records all conversations you have with LoLTalk the purpose of this was to act as a function that allows you to look back at the "Advice" he gives you for playing the game. 

Some known bugs are it cannot have any spelling mistakes... The keywords are set and hardcoded so it will always look for those when filtering the user inputs. Another bug is sometimes punctuations in the middle of the inputted string will throw off the filtering. Punctuations next to keywords in particular (besides ending punctuation such as periods) Comma's usually throw it off. Also, Sometimes some of the randomly generated responses get re-regenerating making the flow less fluent.