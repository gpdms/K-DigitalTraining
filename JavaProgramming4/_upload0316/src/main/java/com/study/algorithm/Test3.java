package com.study.algorithm;

public class Test3 {
    public static void main(String[]args){
        int a[] = {10,3,1,4,2};
        for (int i=0; i<a.length-1;i++){
            int min = a[i]; //임시 최소값
            int k = i; //임시 최소값의 위치 선정
            for(int j=i+1; j<a.length; j++) { //최소값 찾기
                if (min > a[j]) {
                    min = a[j]; //최소값 변경
                    k = j; //최소값 위치
                }
            }
            //교환 알고리즘(swqp)
            int tmp = a[i];
            a[i] = a[k];
            a[k] = tmp;
        }
        for (int i:a){
            System.out.println(i);
        }
    }
}
