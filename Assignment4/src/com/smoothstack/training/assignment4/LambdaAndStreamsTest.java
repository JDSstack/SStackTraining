package com.smoothstack.training.assignment4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LambdaAndStreamsTest {
	public static String[] dragons = { "Drogo", "Rhaegal", "Viserion", "Silverwing", "Sunfyre" };
	
	public static List<Integer> intList = Arrays.asList(1,5,12,18,19,41);
	public static List<String> wordList = Arrays.asList("add", "big", "Valserion", "Unrealistic Words", "Hello", "World");


	public static void main(String[] args) {
		System.out.println("Sorted by Length");
		printThat(sortLength(dragons));
		System.out.println("Inverse Length Sort");
		printThat(invSortLength(dragons));
		System.out.println("Alphabetical Sort");
		printThat(sortFirst(dragons));
		System.out.println("Choosing E Sort");
		printThat(chooseE(dragons));
		
		
		System.out.println("EvenOddList");
		System.out.println(chooseEForEvenAndOForOdd(intList));
		
		System.out.println("Starts with A and has three characters");
		printThat(chooseAAndThree(wordList));
		

	}

	public static List<String> invSortLength(String[] array) {

		List<String> upperCaseNameStreams = Arrays.stream(array).map(String::toUpperCase).collect(Collectors.toList());

		InvLengthComparator invLengthComparator = new InvLengthComparator();
		Collections.sort(upperCaseNameStreams, invLengthComparator);
		return upperCaseNameStreams;

	}

	public static List<String> sortLength(String[] array) {

		List<String> upperCaseNameStreams = Arrays.stream(array).map(String::toUpperCase).collect(Collectors.toList());

		LengthComparator lengthComparator = new LengthComparator();
		Collections.sort(upperCaseNameStreams, lengthComparator);
		return upperCaseNameStreams;

	}

	public static List<String> sortFirst(String[] array) {

		List<String> upperCaseNameStreams = Arrays.stream(array).map(String::toUpperCase).collect(Collectors.toList());

		FirstCharComparator firstComp = new FirstCharComparator();
		Collections.sort(upperCaseNameStreams, firstComp);
		return upperCaseNameStreams;

	}

	public static List<String> chooseE(String[] array) {

		List<String> upperCaseNameStreams = Arrays.stream(array).map(String::toUpperCase).collect(Collectors.toList());

		List<String> tempList = new ArrayList<>();
		List<String> tempListELess = new ArrayList<>();

		upperCaseNameStreams.forEach(n -> {
			if (n.contains("E")) {
				tempList.add(n);
			} else {
				tempListELess.add(n);
			}
		});

		tempList.addAll(tempListELess);
		return tempList;
	}
	
	public static List<String> chooseAAndThree(List<String> array) {

		List<String> names = array;

		List<String> tempList = new ArrayList<>();

		names.forEach(n -> {
			if (n.contains("a") && n.length() == 3) {
				tempList.add(n);
			} 
		});

		return tempList;
	}
	
	public static String chooseEForEvenAndOForOdd(List<Integer> list) {
		
		StringBuilder tempString = new StringBuilder();

		list.forEach(n ->{
			if((n % 2) == 0) {
				tempString.append("e" + n.toString() + ",");
			}
			
			else {
				tempString.append("o" + n.toString() + ",");
			}
		});
		
		return tempString.toString();
	}
	

	
	public static void printThat(List<String> list) {
		list.forEach(n -> System.out.println(n));
	}
}
