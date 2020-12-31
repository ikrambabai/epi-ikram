package com.babai.primitives.arrays;

import java.util.Set;

public class AddSpacesToSpaceless {
	
	static Set<String> words = Set.of("brown", "fox", "jumped", "over", "the", "lazy", "dog");
	static StringBuffer sb = new StringBuffer();
	
	public static void addSpaces(String str) {
		
		if(str == null || str.length() == 0) {
			System.out.println("Cannot find any words in sentence - " + str);
			return;
		}
		int newWordStart = 0;
		
		String word;
		for(int i = 0; i < str.length(); i++) {
			word = str.substring(newWordStart, i+1);
			if (!words.contains(word.toLowerCase()))
				continue;
			
			sb.append(word).append(" ");
			newWordStart = i+1;
		}
		
		System.out.println("words = " + sb.toString());
	}
	public static void main(String[] args) {
		String sentence = "Lazythedoglazydogthe";
		addSpaces(sentence);
	}
}
