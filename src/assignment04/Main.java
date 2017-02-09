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
import java.util.Random;

public class Main {
	public static double totalTime;
	

	public static void main(String[] args) {
		getAreAnagramsCompTimeWithMultiThreading();
	}
	
	// True or false, areAnagrams will take the same computational time.
	public static void getAreAnagramsCompTime() {
		
		for(double charCount = 1; charCount < 15000; charCount *= 1.5) {
			int intCharCount = (int) charCount;
			totalTime = 0;

			String word1 = "";
			String word2 = "";
			
			for(int iteration = 0; iteration < 100; iteration++) {
				for(int addChar = 0; addChar < intCharCount; addChar++) {
					word1 += ((char) (97 + new Random().nextInt(26)));
					word2 += ((char) (97 + new Random().nextInt(26)));
				}
				
				double startTime = System.nanoTime();
				AnagramUtil.areAnagrams(word1, word2);
				double endTime = System.nanoTime();
				
				totalTime += ((endTime - startTime) / 1_000_000_000);
			}

			totalTime /= 100;
			System.out.println(intCharCount + "\t" + totalTime);
		}
	}
	
	
	// An attempt to compute the times faster by utilizing multiple threads,
	// which can utilize all of the cores in a multi-core processor.
	public static void getAreAnagramsCompTimeWithMultiThreading() {
		for(double charCount = 1; charCount < 15000; charCount *= 1.5) {
			int intCharCount = (int) charCount;
			totalTime = 0;
			
			Thread[] threadArr = new Thread[Runtime.getRuntime().availableProcessors()];
			
			for(int threadCount = 0; threadCount < threadArr.length; threadCount++) {
				threadArr[threadCount] = new Thread(new Runnable() {
					public void run() {
						String word1 = "";
						String word2 = "";
						
						for(int iteration = 0; iteration < ((int) 100 / Runtime.getRuntime().availableProcessors()); iteration++) {
							for(int addChar = 0; addChar < intCharCount; addChar++) {
								word1 += ((char) (97 + new Random().nextInt(26)));
								word2 += ((char) (97 + new Random().nextInt(26)));
							}
							
							double startTime = System.nanoTime();
							AnagramUtil.areAnagrams(word1, word2);
							double endTime = System.nanoTime();
							addToTotalTime((endTime - startTime) / 1_000_000_000);
						}
					}
				});
				
				threadArr[threadCount].start();
			}
			
			// This ensures all thread complete before starting another interation.
			for(int i = 0; i < threadArr.length; i++) {
				try {
					threadArr[i].join();
				} 
				catch(Exception e) {
					System.out.println("lol");
				}
			}
			
			totalTime /= ((int) 100 / Runtime.getRuntime().availableProcessors()) * Runtime.getRuntime().availableProcessors();
			System.out.println(intCharCount + "\t" + totalTime);
		}
	}

	public static synchronized void addToTotalTime(double time) {
		totalTime += time;
	}
}
