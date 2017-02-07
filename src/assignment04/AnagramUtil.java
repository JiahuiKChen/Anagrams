package assignment04;

import java.util.Comparator;

public class AnagramUtil {
	
	// This method returns the sorted version of the input string. The
	// sorting must be accomplished using an insertion sort.  
	public static String sort(String word){
		String sortedWord = "";
		Character[] charArray = new Character[word.length()];	//Character array holding letters of word	
		
		for(int i = 0; i < word.length(); i++) {				//putting each letter in parameter word into
			charArray[i] = word.charAt(i);						//a Character array that will be sorted
		}
		insertionSort(charArray, new charComparator());			//insertion sorting the Character array
		
		sortedWord = charArray.toString();					
		return sortedWord;										//returning sorted letters of word
	}

	// This generic method sorts the input array using an insertion sort and
	// the input Comparator object.
	public static <T> void insertionSort(T[] list, Comparator<? super T> comparator){
		
		for (int index = 1; index < list.length; index ++){		//for each element in parameter array
			int position = index;
			T currentVal = list[position];
			
			//while the value in a previous position is alphabetically after the current char
			//while (list[position - 1] > currentVal && position > 0){	
				list[position] = list[position - 1];				//moving the alphabetically later character up a position
				position = position - 1;							//moving position back 1
				list[position] = currentVal;						//moving smaller char to new position (1 index back)					
			}
		}
		
	}

	// This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	public static boolean areAnagrams(String word1, String word2){
		
	}

	// This method returns the largest group of anagrams in the input
	// array of words, in no particular order. It returns an empty array if
	// there are no anagrams in the input array.
	public static String[] getLargestAnagramGroup(String[] wordArray){
		
	}

	// Behaves the same as the previous method, but reads the list of
	// words from the input filename. It is assumed that the file contains
	// one word per line. If the file does not exist or is empty, the method
	// returns an empty array because there are no anagrams.
	public static String[] getLargestAnagramGroup(String word){
		
	}

	/**
	 * Class that defines the character comparator, used to sort each letter
	 * in a word. 
	 *
	 */
	public static class charComparator implements Comparator<Character> {
		
		@Override
		public int compare(Character o1, Character o2) {
			return Character.compare(Character.toLowerCase(o1), Character.toLowerCase(o2));
		}
	}
	
}


