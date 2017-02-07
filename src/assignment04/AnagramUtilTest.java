/**
 * @author Jiahui Chen 
 * @uID    u0980890
 * @author Emerson Ford
 * @uID			
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

	@Test
	public void testSortCharacters(){
		Comparator<Character> charCompare = new AnagramUtil.charComparator();
		
		String backwardsAlphabet = "cba";
		String alphabet = "abc";
		assertEquals(alphabet, AnagramUtil.sort(backwardsAlphabet));
	}
	
	@Test
	public void testInsertionSortStrings() {
		//creating String comparater 
		Comparator<String> stringCompare = new AnagramUtil.stringComparator();
		
		//simple alphabetical test of insertionSort
		String[] backwardsAlphabetical = {"zebra", "yak"}; //"rat", "cat", "baboon", "ant"};
		String[] alphabetical =  {"yak", "zebra"};//{"ant", "baboon", "cat", "rat", "yak", "zebra"};
		AnagramUtil.insertionSort(backwardsAlphabetical, stringCompare);
		assertArrayEquals(alphabetical, backwardsAlphabetical);
	}
	
	

}
