package assignment04;

import java.util.Comparator;

public class AnagramUtil {
	
	// This method returns the sorted version of the input string. The
	// sorting must be accomplished using an insertion sort.  
	public static String sort(String word){
		word.toLowerCase();								//all lowercase letters to be compared
		String sortedWord = "";
		
		Character[] charArray = new Character[word.length()];		
		for(int i = 0; i < word.length(); i++) {
			charArray[i] = word.charAt(i);
		}
		
		insertionSort(charArray, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return Character.compare(o1, o2);
			}
			
		});
		
		for (int index = 1; index < charArray.length; index ++){
			int position = index;
			char currentChar = charArray[position];
			
			//while the char in a previous position is alphabetically after the current char
			while (charArray[position - 1] > currentChar && position > 0){	
				charArray[position] = charArray[position - 1];			//moving the alphabetically later character up a position
				position = position - 1;								//moving position back 1
				charArray[position] = currentChar;						//moving smaller char to new position (1 index back)					
			}
		}
		
		
		
		return sortedWord;
	}

	// This generic method sorts the input array using an insertion sort and
	// the input Comparator object.
	public static <T> void insertionSort(T[] words, Comparator<? super T> comparator){
		
		
	}

	// This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	public static boolean areAnagrams(String, String){
		
	}

	// This method returns the largest group of anagrams in the input
	// array of words, in no particular order. It returns an empty array if
	// there are no anagrams in the input array.
	public static String[] getLargestAnagramGroup(String[]){
		
	}

	// Behaves the same as the previous method, but reads the list of
	// words from the input filename. It is assumed that the file contains
	// one word per line. If the file does not exist or is empty, the method
	// returns an empty array because there are no anagrams.
	public static String[] getLargestAnagramGroup(String){
		
	}
	
}


