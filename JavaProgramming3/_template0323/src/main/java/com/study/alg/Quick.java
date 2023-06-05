package com.study.alg;

public class Quick {

    public static void main(String[]args){
        int nums[] = {10, 3, 1, 9, 7, 6, 8, 2, 4, 5};
        quickSort(nums, 0, nums.length-1);
        System.out.print("Quick sort = ");
        for (int i : nums){
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right){
            //partition 메소드에서 pivot을 선택하고, pivot보다 작은 값은 왼쪽으로, 큰값은 오른쪽으로 분할하는 작업을 수행
            //이렇게 분할된 부분 배열에 대해서 quickSort 메소드를 재귀적으로 호출하여 각 부분 배열을 정렬
            int pivotIndex = partition(arr, left, right);
            //첫번째 quickSort 메소드 호출에서는 pivot을 기준으로 분할된 왼쪽 부분 배열을 재귀적으로 정렬
            //pivot은 기준값으로서 제외되므로, pivotIndex -1까지의 부분 배열이 재귀적으로 정렬
            quickSort(arr, left, pivotIndex - 1);
            //두번째 quickSort 메소드 호출에서는 pivot을 기준으로 분할한 오른쪽 부분 배열을 재귀적으로 정렬
            //이번에는 pivot을 다시 기준값으로 고려해야하므로, pivotIndex부터 끝까지의 부분 배열이 재귀적으로 정렬
            quickSort(arr, pivotIndex,right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; //pivot을 배열의 중간값으로 설정
        //pivot을 기준으로 분할하는 부분
        //왼쪽 인덱스(left)와 오른쪽 인덱스(right)가 서로 교차할 때까지 반복
        //이렇게 되면 왼쪽 인덱스와 오른쪽 인덱스는 pivot을 기준으로 분할된 부분 배열에서 각각의 반대편에 위치
        while (left <= right){
            //왼쪽에서부터 pivot보다 큰 값이 나올 때까지 left를 증가
            while(arr[left] < pivot) left++;
            //오른쪽에서부터 pivot보다 작은 값이 나올 때까지 right를 감소
            while (arr[right] > pivot) right--;

            if (left <= right){
                //left와 right를 서로 교환
                //pivot을 기준으로 작은 값은 pivot의 왼쪽으로, 큰 값은 pivot의 오른쪽으로 이동
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; //한 칸씩 인덱스 이동 (오른쪽으로)
                right--; //한 칸씩 인덱스 이동 (왼쪽으로)

            }
        }
        return left; //left를 파티션 인덱스로 리턴
    }
}
