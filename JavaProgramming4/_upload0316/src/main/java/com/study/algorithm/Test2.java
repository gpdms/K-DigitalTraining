package com.study.algorithm;

public class Test2 {
    public static void main(String[]args){
        int a[] = {10,3,1,4,2};
        //시작위치를 하나씩 뒤로 하는 반복
        for (int i=0; i<a.length; i++){
            //시작위치를 하나씩 앞으로 하는 반복
            for (int j=a.length-1; j>i; j--){
                //만일 이웃하는 두 값 중에서 뒤쪽 값이 더 작다면
                if(a[j] < a[j-1]){
                    //교환 알고리즘
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
        for (int i : a){
            System.out.println(i);
        }
    }
}
