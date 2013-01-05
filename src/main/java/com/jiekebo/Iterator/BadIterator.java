package com.jiekebo.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BadIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> testList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			testList.add(i);
		}
//		Will unleash an error because the underlying array is changed while
//		using the iterator.		
//		Iterator<Integer> it = testList.iterator();
//		while (it.hasNext()) {
//			if(it.next() == 5)
//				testList.remove(0);
//		}
		// Instead use the iterator to remove the element being pointed to.
		for (Iterator<Integer> iterator = testList.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			if(integer.intValue() == 3) {
				iterator.remove();
			}
		}
		for (Integer integer : testList) {
			System.out.println(integer);
		}
	}

}
