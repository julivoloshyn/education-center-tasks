package com.knubisoft.tasks.algorithm.search;

public class SearchImpl implements Search {

    @Override
    public int binarySearch(long[] array, long v) {

        if (array.length == 0) {
            throw new NullPointerException();
        }

        int low = 0;
        int high = array.length - 1;

        while (high - low > 1) {
            int mid = (high + low) / 2;

            if (array[mid] < v) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (array[low] == v) {
            return low;
        } else if (array[high] == v) {
            return high;
        }

        return -1;
    }
}
