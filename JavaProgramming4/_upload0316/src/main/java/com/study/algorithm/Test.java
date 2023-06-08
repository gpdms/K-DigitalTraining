package com.study.algorithm;

public class Test {
    public static void main (String[] args){
        int a[] = {1,2,4,5,10};
        int searchValue = 4;
        int findID = -1;
        int left = 0;
        int right = a.length-1;
        while(left <= right){
            int middle = (int)((left+right)/2);
            if(a[middle] == searchValue){
                findID = middle;
            } else if (a[middle] < searchValue) {
                left = middle + 1;
            } else{
                right = middle -1;
            }
        }
        System.out.printf("%s: %d/n", "result", findID);
    }
}
