package com.adm.magicanswers;

import java.util.Random;

public class Generate_Answer {
	private String[] magic_answers = {
			"What did you say?",
			"My senses say, yes",
			"Ummm Yeah.",
			"Yes definitely",
			"Ask your mother.",
			"As I see it, yes",
			"Definetly",
			"What you ask, will be",
			"Most likely",
			"I have nothing to say",
			"It looks like a good outlook",
			"Yes",
			"Ask your friend.",
			"My mind hurts",
			"Are you seriously asking me?",
			"I do not want to tell you.",
			"I can't answer that now.",
			"Ask me again, but in a different context",
			"Don't count on it",
			"My reply is no",
			"No Way!",
			"It is not a good question!",
			"Very doubtful"	
		
	};

	private String hold_answer;
	
	Generate_Answer(){
		hold_answer = "";
		
	}
	
	public String get_answer(){
		
		Random rand = new Random();
		
		int num = rand.nextInt(magic_answers.length);
		
		hold_answer = magic_answers[num];
		
		return hold_answer;
		
	}

}
