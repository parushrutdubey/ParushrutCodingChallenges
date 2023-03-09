package basicjava;

import java.util.ArrayList;


public class CCArrayList {

	public static int indexOfIgnoreCase(ArrayList<String> strs, String string) {
		return 0;
	}

	public static void insert(ArrayList<Double> nums, double numToInsert, int insertAtIndex) {
	    if (insertAtIndex < 0 || insertAtIndex > nums.size()) {
	        // insertAtIndex is not within the valid range of indices
	        return;
	    }

	    if (nums.size() == insertAtIndex) {
	        // if the index to insert is the same as the size of the list, add the number to the end
	        nums.add(numToInsert);
	    } else {
	        double currentNum = nums.get(insertAtIndex);
	        nums.set(insertAtIndex, numToInsert);
	        insert(nums, currentNum, insertAtIndex + 1);
	    }
	}

}
