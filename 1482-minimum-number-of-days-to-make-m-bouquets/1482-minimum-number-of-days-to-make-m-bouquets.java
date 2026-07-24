class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val= (long) m * k;
        if(bloomDay.length<val) return -1;
        int low = minElement(bloomDay);
        int high = maxElement(bloomDay);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(bloomDay,mid,m,k)==false) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0, numOfBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) count++;
            else {
                numOfBouquets += (count / k);
                count = 0;
            }
        }
        numOfBouquets += (count / k);
        if (numOfBouquets >= m) return true;
        else return false;
    }

    public int maxElement(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) max = Math.max(max, bloomDay[i]);
        return max;
    }

    public int minElement(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bloomDay.length; i++) min = Math.min(min, bloomDay[i]);
        return min;
    }
}