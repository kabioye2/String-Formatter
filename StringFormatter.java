package homework;

import java.util.ArrayList;

public class StringFormatter {
	public static int totalLetters(ArrayList<String> wordList) {
		int totalLetters = 0;
		if (wordList.size() >= 2) {
			for (String str : wordList) {
				if (str.matches("[a-xA-Z]+")) {
					// System.out.printf(wordList.get(i)+" ");
					totalLetters += str.length();
				} else {
					return 0;
				}
			}
		}
		// System.out.println(totalLetters);
		return totalLetters;
	}

	public static int basicGapWidth(ArrayList<String> wordList, int formattedLen) {
		int basicGapWidth = 1;
		int spaces = wordList.size() - 1;
		int leftoverWithGaps = 0;

		leftoverWithGaps = formattedLen - totalLetters(wordList) - spaces;

		if (leftoverWithGaps >= 0) {
			basicGapWidth += (leftoverWithGaps / spaces);
			return basicGapWidth;
		} else {
			return 0;
		}
	}

	public static int leftoverSpaces(ArrayList<String> wordList, int formattedLen) {
		int leftoverSpaces = 0;
		int spaces = wordList.size() - 1;
		int leftoverWithGaps = formattedLen - totalLetters(wordList) - spaces;

		leftoverSpaces = leftoverWithGaps % spaces;

		return leftoverSpaces;
	}

	public static String format(ArrayList<String> wordList, int formattedLen) {
		int gapWidth = basicGapWidth(wordList, formattedLen);
		int remainingSpaces = leftoverSpaces(wordList, formattedLen);
		String formattedStr = "";

		for (int i = 0; i < wordList.size(); i++) {
			formattedStr += wordList.get(i);

			for (int j = 1; j <= gapWidth; j++) {
				formattedStr += " ";
			}
			if (remainingSpaces > 0) {
				formattedStr += " ";
				remainingSpaces--;
			}

		}
		
		return formattedStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> wordList = new ArrayList<String>();

		// add 4 different values to list
		wordList.add("Ap");
		wordList.add("Comp");
		wordList.add("Sci");
		wordList.add("Rocks");
		int formattedLen = 19;
		int listSize = wordList.size()-1;

		if (totalLetters(wordList) > 0) {
			System.out.println("Total number of letters in words: " + totalLetters(wordList));
			
			System.out.println("Number of gaps between words: "+ listSize);

			if (basicGapWidth(wordList, formattedLen) > 0) {
				System.out.println("Basic gap width: " + basicGapWidth(wordList, formattedLen));

				System.out.println("Leftover spaces: " + leftoverSpaces(wordList, formattedLen));
				
				System.out.println(format(wordList, formattedLen));
			} else {
				System.out.println("*Need larger number for length");
			}
		} else {
			System.out.println("*Words should contain only letters\n*There should be at least two words");
		}


	}

}
