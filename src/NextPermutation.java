/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

====
Method
1. From right to left, find the first digit (PartitionNumber) which violate the increase trend.
2. From right to left, find the first digit which larger than PartitionNumber, call it ChangeNumber.
3. Swap(PartitionNumber, ChangeNumber);
4. Reverse all the digits on the right of Partition index.

*/
public class Solution {
    private void swap(int num[], int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    private void reverse(int[] num, int begin, int end){
        --end;
        while(begin<end) swap(num, begin++, end--);
    }
    public void nextPermutation(int[] num) {
        int size = num.length;
        int i,j;
        for (i = size - 2; i >= 0; --i){
            if (num[i]<num[i+1]) break;
        }
        
        if (i != -1){
            for (j = size -1; num[j]<=num[i]; --j);
            swap(num,i,j);
            reverse(num,i+1,size);
        }else {
            reverse(num,0,size);
        }
    }
}
