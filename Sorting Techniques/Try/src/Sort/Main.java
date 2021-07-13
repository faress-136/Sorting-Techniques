package Sort;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    static long startTime;
    static long endTime;
    static long timeElapsed;


    public static void createArray(int [] Array ) {
        Random rd = new Random(); // creating Random object
        for (int i = 0; i < Array.length; i++) {
            Array[i] = rd.nextInt(); // storing random integers in an array
//            System.out.println(i+1 + "." +Array[i]); // printing each array element
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    // Start Selection Sort
    static void Ssort(int [] SelectionArray) {
        for (int i = 0; i < SelectionArray.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < SelectionArray.length ; j++)
                if (SelectionArray[j] < SelectionArray[min_idx])
                    min_idx = j;
            swap(SelectionArray, min_idx, i);
        }

    }
    // End Selection Sort


    // Start Heap Sort
    public static void Hsort(int heapArray[]) {
        int n = heapArray.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(heapArray, n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(heapArray, 0, i);
            // call max heapify on the reduced heap
            heapify(heapArray, i, 0);
        }
    }

    static void heapify(int[] heapArray, int n, int i) {
        int largest = i ; // Initialize largest as root
        int l = 2 * i + 1 ;
        int r = 2 * i + 2 ;
        // If left child is larger than root
        if (l < n && heapArray[l] > heapArray[largest])
            largest = l;
        // If right child is larger than largest so far
        if (r < n && heapArray[r] > heapArray[largest])
            largest = r;
        // If largest is not root
        if (largest != i) {
            swap(heapArray, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(heapArray, n, largest);
        }
    }
// End Heap Sort


    //Start Insertion Sort
    static void iSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
//End Insertion Sort

    // Start Bubble Sort
    static void bSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
// End Bubble Sort




    // Start Merge Sort
    static void merge(int[] mergeArray, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = mergeArray[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = mergeArray[m + 1 + j];
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                mergeArray[k] = L[i];
                i++;
            } else {
                mergeArray[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            mergeArray[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            mergeArray[k] = R[j];
            j++;
            k++;
        }
    }
    static void Msort(int[] mergeArray, int l, int r) {
//        int [] mergeArray = Array.clone();
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            Msort(mergeArray, l, m);
            Msort(mergeArray, m + 1, r);
            // Merge the sorted halves
            merge(mergeArray, l, m, r);
        }
    }
// End Merge Sort


    // Start Quick Sort
    public static int partition(int quickArray[], int low, int high) {
        int pivot = quickArray[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (quickArray[j] < pivot) {
                i++;
                swap(quickArray, i, j);
            }
        }
        swap(quickArray, i + 1, high);
        return (i + 1);
    }

    public static void Qsort(int quickArray[], int low, int high) {
        if (low < high) {
            int pi = partition(quickArray, low, high);
            Qsort(quickArray, low, pi - 1);
            Qsort(quickArray, pi + 1, high);
        }
    }
// End Quick Sort


    static void printArray(int [] array) {
        int n = array.length;
        for (int i = 0; i < array.length ; i++ )
            System.out.println(i + 1 + "." + array[i]);
    }


    public static void main(String[] args) {

        System.out.println("Enter Number of Elements :");
        Scanner ASwitch = new Scanner(System.in);
        int X = ASwitch.nextInt();
        
        int[] Array = new int[X];
        createArray(Array);
        int l = Array.length;
        int[] quickArray = Array.clone()     ;
        int[] heapArray = Array.clone()      ;
        int[] mergeArray = Array.clone()     ;
        int[] bubbleArray = Array.clone()    ;
        int[] insertionArray = Array.clone() ;
        int[] selectionArray = Array.clone() ;

        System.out.println("Sorting " + l + " Elements : " );


        startTime = System.currentTimeMillis();
        Qsort(quickArray, 0, l - 1);
        endTime=System.currentTimeMillis();
//        System.out.println("Quick Sorted Array: ");
//        printArray(quickArray);
        timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed Quick Sort= " + timeElapsed + " Milliseconds");

        startTime = System.currentTimeMillis();
        Msort(mergeArray, 0, l - 1);
        endTime=System.currentTimeMillis();
//        System.out.println("Merge Sorted Array : ");
//        printArray(mergeArray);
        timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed Merge Sort= " + timeElapsed + " Milliseconds");

        startTime = System.currentTimeMillis();
        Hsort(heapArray);
        endTime=System.currentTimeMillis();
//        System.out.println("Heap Sorted Array : ");
//        printArray(heapArray);
        timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed Heap Sort= " + timeElapsed + " Milliseconds");

        startTime = System.currentTimeMillis();
        iSort(insertionArray);
        endTime=System.currentTimeMillis();
//        System.out.println("Insertion Sorted Array : ");
//        printArray(insertionArray);
        timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed Insertion Sort= " + timeElapsed + " Milliseconds");

        startTime = System.currentTimeMillis();
        Ssort(selectionArray);
        endTime=System.currentTimeMillis();
//        System.out.println("Selection Sorted Array : ");
//        printArray(selectionArray);
        timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed Selection Sort= " + timeElapsed + " Milliseconds");

        startTime = System.currentTimeMillis();
        bSort(bubbleArray);
        endTime=System.currentTimeMillis();
//        System.out.println("Bubble Sorted Array : ");
//        printArray(bubbleArray);
        timeElapsed = endTime - startTime;
        System.out.println("Time Elapsed Bubble Sort= " + timeElapsed + " Milliseconds");

//        System.out.println();
//        System.out.println("Not Sorted Array : ");
//        printArray(Array);
//
//        timeElapsed = endTime - startTime;
//        System.out.println("Time Elapsed  Selection Sort= " + timeElapsed);
            }
        }


