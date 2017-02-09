/**
 * @author Jiahui Chen  
 * @uID    u0980890
 * @author Emerson Ford
 * @uID	   u0407846	
 * CS 2420
 * Assignment 4
 * I pledge that the work done here was my own and that I have learned how to write this program, 
 * such that I could throw it out and restart and finish it in a timely manner. I am not turning in 
 * any work that I cannot understand, describe, or recreate. Jiahui Chen & Emerson Ford
 */
package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Class holding methods for insertion sort, determining whether or not 2 
 * words are anagrams, and finding largest group of anagrams in a list of words.
 * Also holds inner classes for String and Character comparators.
 * 
 * @author Jiahui Chen
 * @author Emerson Ford
 */
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
		
		if (word == null){	//if the parameter is null
			return null;
		}
		
		String sortedWord = "";
		Character[] charArray = new Character[word.length()];	//Character array holding letters of word	
		
		for(int index = 0; index < word.length(); index++) {				//putting each letter in parameter word into
			charArray[index] = word.charAt(index);						//a Character array that will be sorted
		}
		
		insertionSort(charArray, new charComparator());			//insertion sorting the Character array
		
		for (int index = 0; index < charArray.length; index ++){
			sortedWord += charArray[index];
		}
		
		return sortedWord;										//returning sorted letters of word
	}

	/**
	 * Uses the insertion sort algorithm to sort the elements in the parameter
	 * array. Compares value of elements using the parameter comparator. 
	 * 
	 * @param 	list		Generic array that will be sorted.
	 * @param 	comparator	Comparator comparing values of parameter array. 
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> comparator) {
		
		for (int index = 1; index < list.length; index ++){		//for each element in parameter array
			int position = index;
			T currentVal = list[position];
			
			//while the value in a previous position is less than the current value
			while (position > 0 && comparator.compare(list[position - 1], currentVal) > 0) {	
				list[position] = list[position - 1];				//moving the lesser value up a position
				position = position - 1;							//moving position back 1
				list[position] = currentVal;						//moving smaller value to new position (1 index back)					
			}
		}
	}

	/**
	 * Method that returns a boolean indicating if the 2 parameter words are anagrams of each other.
	 * 
	 * @param 	word1		String word compared to determine if it's an anagram of word2.
	 * @param 	word2		String word compared to determine if it's an anagram of word1.
	 * @return	boolean		true or false based on if the 2 parameters are anagrams.
	 */
	public static boolean areAnagrams(String word1, String word2) {
		
		if (sort(word1).equalsIgnoreCase(sort(word2))){
			return true;
		}
		return false;
	}

	/**
	 * Finds and returns the largest group of anagrams in a parameter String array.
	 * Returns and empty array if the parameter array is empty. 
	 * 
	 * @param 	wordArray					String array that will be looked through to find largest group of anagrams. 
	 * @return	largestGroupOfAnagrams		String array holding the largest group of anagrams.
	 */
	public static String[] getLargestAnagramGroup(String[] wordArray){
		
		if (wordArray == null){			//if the input array is null, return an empty array
			String[] empty = {};
			return empty;
		}
		
		insertionSort(wordArray, new stringComparator());			//sorting words in input array
		ArrayList<String> largestGroup = new ArrayList<String>();	//ArrayList holding largest group of anagrams
		ArrayList<String> currentGroup = new ArrayList<String>();	//ArrayList holding current group of anagrams
		
		for (int index = 0; index < wordArray.length; index ++){
			
			if (index != 0){				//if there is a previous index in the array
				
				//if the previous word and current word in the sorted array are not anagrams of each other
				if (!areAnagrams(wordArray[index], wordArray[index - 1])){	

					//if the current list of anagrams is larger than the largest list of anagrams
					if (largestGroup.size() < currentGroup.size()){
						largestGroup.clear();
						largestGroup.addAll(currentGroup);		//the current list becomes the largest list
					}
					currentGroup.clear(); 				//the current list is cleared if current word is not anagram with previous word
				}
			}
			currentGroup.add(wordArray[index]);		//current word is added to current list regardless of whether it's an anagram or not
		}
		
		//checks if current list is larger than largest list after all elements are iterated over in case current is now larger
		if (currentGroup.size() > largestGroup.size()){
			largestGroup.clear();
			largestGroup.addAll(currentGroup);		//if current list is larger it becomes the largest list
		}
		String[] largestGroupOfAnagrams = new String[largestGroup.size()];	//array to be returned
		largestGroupOfAnagrams = largestGroup.toArray(largestGroupOfAnagrams);						//adding all words in largest list of anagrams to array
		return largestGroupOfAnagrams;
	}

	// Behaves the same as the previous method, but reads the list of
	// words from the input filename. It is assumed that the file contains
	// one word per line. If the file does not exist or is empty, the method
	// returns an empty array because there are no anagrams.
	public static String[] getLargestAnagramGroup(String word){
		ArrayList<String> strArray = new ArrayList<>();
		
		Scanner scanner = new Scanner(word);
		while(scanner.hasNext()) {
			String token = scanner.next();
			strArray.add(token);
		}
		scanner.close();
		
		String[] objectStr = new String[strArray.size()];
		
		return getLargestAnagramGroup(strArray.toArray(objectStr));
	}

	/**
	 * Class that defines the character comparator, used to compare each letter
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
	
	/**
	 * Class that defines the String comparator, used to compare each word
	 * in a list. 
	 */
	public static class stringComparator implements Comparator<String> {

		/**
		 * Compares the sorted version of the parameter Strings and 
		 * ignores the case of the letters, uses .compareToIgnoreCase() method in String class. 
		 * 
		 * @param		previous	String first word to be compared.
		 * @param		current		String second word to be compared.
		 * @return		order		integer indicating the compared values of the parameter Strings.
		 */
		@Override
		public int compare(String previous, String current) {
			int order = sort(previous).compareToIgnoreCase(sort(current));	//compares Strings with sorted letters
			return order;
		}
	}
}