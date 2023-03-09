package basicjava;

import java.util.ArrayList;


public class CCArrayList {

	/**
	 * This method gives us the position of a String from the ArrayList
	 * @param strs the Arraylist provided to us
	 * @param toFind the String to be found in the Arraylist
	 * @return the position of the string in the Arraylist based on its presence
	 */
	public static int indexOfIgnoreCase(ArrayList<String> strs, String toFind) {
		int i;
		String ret;
	    for (i = 0; i < strs.size(); i++) {
	        ret = strs.get(i);
	        if (ret.equalsIgnoreCase(toFind)) {
	            return i;
	        }
	    }
	    return -1;
	}

    /**
     * This method is there to add an element to the arraylist at the given index
     * @param nums is the ArrayList provided to us
     * @param numToInsert is the Number which has to be inserted in the arraylist
     * @param insertAtIndex is the position at which the number is to be inserted
     */
	public static void insert(ArrayList<Double> nums, double numToInsert, int insertAtIndex) {
	    if (insertAtIndex < 0 || insertAtIndex > nums.size()) 
	        return;
	    if (nums.size() == insertAtIndex) 
	        nums.add(numToInsert);
	    else {
	        double currentNum = nums.get(insertAtIndex);
	        nums.set(insertAtIndex, numToInsert);
	        insert(nums, currentNum, insertAtIndex + 1);
	    }
	}

}
