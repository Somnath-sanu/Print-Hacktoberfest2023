public class Quicksort {
    static void displayArr(int[] arr){
        for(int value : arr){
            System.out.print(value + " ");
        }

    }

    static void swap(int[] arr , int x , int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int partition(int[] arr, int st,int end){
        int pivot = arr[st];
        int cnt = 0;
        for(int i = st+1;i<=end;i++){
            if(arr[i] <= pivot) cnt++;  
        }

        int pivotIdx = st + cnt;
        swap(arr,st,pivotIdx);

        int i = st , j = end;
        while (i < pivotIdx && j > pivotIdx){
            while(arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;


               if(i < pivotIdx && j > pivotIdx){
                   swap(arr,i,j);
                   i++;
                   j--;

               }
        }

        return  pivotIdx;
    }

    static void quickShort(int[] arr, int st, int end){

        if(st >= end) return;

        int pi = partition(arr,st,end);

        quickShort(arr,st,pi-1);
        quickShort(arr,pi+1,end);



    }




    public static void main(String[] args) {
        int[] arr = {6,3,9,3,1,76,32,11};
        System.out.println("Array before sorting");
        displayArr(arr); // 6 3 1 5 4
        System.out.println();
        quickShort(arr,0,arr.length-1);

        System.out.println("Array after sorting");
        displayArr(arr); // 1 3 4 5 6

    }
}
