// Реализовать алгоритм сортировки слиянием

public class Ex2 {

    static void MergeSort(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }

    static void MergeSortRecursion(int[] arr,int size){
        if(size < 2){
            return;
        }
        int HalfSize = size/2;
        int[] LeftPart = new int[HalfSize];
        int[] RightPart = new int[size - HalfSize];
        for(int i = 0; i < LeftPart.length; i++){
            LeftPart[i] = arr[i];
        }
        for(int j = 0; j < RightPart.length; j++){
            RightPart[j] = arr[(size-1) - j];
        }

        MergeSortRecursion(LeftPart,HalfSize);
        MergeSortRecursion(RightPart, size - HalfSize );

        MergeSort(arr,LeftPart,RightPart,HalfSize, size - HalfSize);

    }

    static void PrintArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,2,8,1,7,6};

        PrintArray(arr);

        MergeSortRecursion(arr,arr.length);

        System.out.println();
        PrintArray(arr);

    }


}



