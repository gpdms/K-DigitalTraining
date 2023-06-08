package com.study.algorithm;

public class InsertSort {
    public static void main (String[] args){
        int a[] = {10,3,1,4,2};
        //정렬되지 않은 부분에서 차례대로 하나씩 꺼냄
        for (int i=1; i<a.length; i++){
            //삽입할 값을 임시로 tmp에 넣음
            int tmp = a[i];
            //삽입할 위치 변수를 초기화
            int ins = 0;
            //값을 어디에 삽입할지 뒤에서부터 차례대로 조사함
            for(int j=i-1; j>=0; j--){
                //만약 삽입할 값이 정렬되어 있는 부분의 값보다 작으면
                if(a[j] > tmp){
                    //그 위치에 조사한 값을 삽입할 수 있도록 배열을 하나씩 뒤로 밀어냄
                    a[j+1] = a[j];
                } else{
                    //만약 삽입할 값이 정렬되어 있는 부분의 값보다 크다면
                    ins = j+1;
                    break;
                }
            }
            //밀어내는 처리가 끝난 위치에 삽입할 값을 넣음
            a[ins] = tmp;
        }
        //정렬결과 표시
        for (int i:a){
            System.out.println(i);
        }
    }
}
