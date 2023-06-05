package com.study.algorithm;

public class Test {
    public static void main(String[] args){
        System.out.println("test 한글");
        int a[] = {1,3, 10, 2, 8}; //배열: 자바 중괄호. 파이썬은 대괄호.
        int sum = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
        }
        double average = (double)sum/a.length;
        System.out.println("평균:"+average);

        int max = a[0];
        for (int i=1;i<a.length; i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        System.out.println("최댓값:"+max);
    }
}
