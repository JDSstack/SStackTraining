package com.smoothstack.training.assignment4;

import java.util.Comparator;

public class ContainsEComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			if(o1.charAt(0) < o2.charAt(0)){
				return -1;
			}
			if(o1.charAt(0) > o2.charAt(0)){
				return 1;
			}
			return 0;
		}


}
