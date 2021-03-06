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

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class AnagramUtilTest {
	//Comparators for testing from AnagrmUtil class
	Comparator<Character> charCompare = new AnagramUtil.charComparator();
	Comparator<String> stringCompare = new AnagramUtil.stringComparator();
	Comparator<Integer> intCompare = new AnagramUtil.intComparator();
	
	//basic String comparator that will compare strings without sorting their letters first
	Comparator<String> noSortStringCompare = new Comparator<String>() {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareToIgnoreCase(arg1);
		}	
	};
	
	@Test
	public void testSort(){		
		//tests if the sort method can alphabetically order letters in a word
		String backwardsAlphabet = "cba";
		String alphabet = "abc";
		assertEquals(alphabet, AnagramUtil.sort(backwardsAlphabet));
	}
	
	@Test
	public void testSortCapitalized(){
		//tests if the sort method can sort letters regardless of capitalization
		//and return them in their original capitalization state
		String backwardsCapAlphabet = "CbA";
		String capAlphabet = "AbC";
		assertEquals(capAlphabet, AnagramUtil.sort(backwardsCapAlphabet));
	}
	
	@Test
	public void testInsertionSortStrings() {		
		//tests if insertionSort can put list of words in alphabetical order
		String[] backwardsAlphabetical = {"zebra", "yak", "rat", "cat", "baboon", "ant"};
		String[] alphabetical =  {"ant", "baboon", "cat", "rat", "yak", "zebra"};
		AnagramUtil.insertionSort(backwardsAlphabetical, noSortStringCompare);
		assertArrayEquals(alphabetical, backwardsAlphabetical);
	}
	
	@Test
	public void testInsertionSortIntegers(){
		Integer[] test = new Integer[] {4, 5, 2, 1, 0};
		AnagramUtil.insertionSort(test, intCompare);
		assertArrayEquals(test, new Integer[] {0, 1, 2, 4, 5});
	}
	
	@Test
	public void testInsertionSortIntegers1(){
		Integer[] test = new Integer[] {1, 5, 2, 1, 0};
		AnagramUtil.insertionSort(test, intCompare);
		assertArrayEquals(test, new Integer[] {0, 1, 1, 2, 5});
	}
	
	@Test
	public void testInsertionSortCharacters(){
		Character[] test = new Character[] {'a', 'e', 'd', 'c'};
		AnagramUtil.insertionSort(test, charCompare);
		assertArrayEquals(test, new Character[] {'a', 'c', 'd', 'e'});
	}

	@Test
	public void testInsertionSortCharacters1(){
		Character[] test = new Character[] {'b', 'e', 'c', 'c'};
		AnagramUtil.insertionSort(test, charCompare);
		assertArrayEquals(test, new Character[] {'b', 'c', 'c', 'e'});
	}
	
	@Test
	public void testInsertionSortEmpty(){
		//testing if a null array is passed into insertion sort
		String[] nullArray = new String[0];
		String[] empty = new String[0];
		AnagramUtil.insertionSort(nullArray, stringCompare);
		assertArrayEquals(empty, nullArray);
	}
	
	@Test
	public void testGetLargestAnagramGroup(){
		String[] threeAnagrams = {"cat", "rice", "cire", "dog", "irce"};
		String[] anagramsOfRice = {"rice", "cire", "irce"}; 
		assertArrayEquals(anagramsOfRice, AnagramUtil.getLargestAnagramGroup(threeAnagrams));
	}
}
