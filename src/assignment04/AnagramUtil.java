package assignment04;

import java.util.Comparator;

public class AnagramUtil {
	
	/**
	 * This method sorts the letters in a String by passing them into
	 * the insertionSort method as an array of Characters. Returns as sorted 
	 * version of the word, with original capitalization preserved.
	 * 
	 * @param 	word			Word that's letters are to be sorted. 
	 * @return	sortedWord		Sorted parameter word, with original capitalization.
	 */
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

	/**
	 * Uses the insertion sort algorithm to sort the elements in the parameter
	 * array. Compares value of elements using the parameter comparator. 
	 * 
	 * @param 	list		Generic array that will be sorted.
	 * @param 	comparator	Comparator comparing values of parameter array. 
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> comparator){
		
		for (int index = 1; index < list.length; index ++){		//for each element in parameter array
			int position = index;
			T currentVal = list[position];
			
			//while the value in a previous position is less than the current value
			while (comparator.compare(list[position - 1], currentVal) > 0 && position > 0) {	
				list[position] = list[position - 1];				//moving the lesser value up a position
				position = position - 1;							//moving position back 1
				list[position] = currentVal;						//moving smaller value to new position (1 index back)					
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
	 */
	public static class charComparator implements Comparator<Character> {
		
		/**
		 * Compares the lowercase verions of 2 parameter Characters using 
		 * the .compare() method in the Character class. 
		 * 
		 * @param	previous	First character to be compared.
		 * @param	current		Second character to be compared. 
		 * @return 	Returns a negative number if previous alphabetically before current,
		 * 		 	Returns a positive number if previous is alphabetically after current,
		 * 			Returns 0 if previous and current are the same letter. 
		 */
		@Override
		public int compare(Character previous, Character current) {
			return Character.compare(Character.toLowerCase(previous), Character.toLowerCase(current));
		}
	}
	
}


