import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class sorts {

    //Merge Sort
    public static void mergeSort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(List<Integer> arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            leftArray.add(arr.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.add(arr.get(middle + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                arr.set(k, leftArray.get(i));
                i++;
            } else {
                arr.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, leftArray.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }

    //Quick Sort
    public static class QuickSort {

        public static void quickSort(List<Integer> arr, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }

        public static int partition(List<Integer> arr, int low, int high) {
            int pivot = arr.get(high);
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (arr.get(j) < pivot) {
                    i++;
                    int temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }

            int temp = arr.get(i + 1);
            arr.set(i + 1, arr.get(high));
            arr.set(high, temp);

            return i + 1;
        }
    }

    //Bubble Sort
    public static class BubbleSort {

        public static void bubbleSort(List<Integer> arr) {
            int n = arr.size();
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr.get(j) > arr.get(j + 1)) {
                        int temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
            }
        }
    }

    //Insertion Sort
    public static class InsertionSort {
        public static void insertionSort(List<Integer> arr) {
            int n = arr.size();
            for (int i = 1; i < n; i++) {
                int key = arr.get(i);
                int j = i - 1;

                while (j >= 0 && arr.get(j) > key) {
                    arr.set(j + 1, arr.get(j));
                    j = j - 1;
                }
                arr.set(j + 1, key);
            }
        }
    }

    //Selection Sort
    public static class SelectionSort {
        public static void selectionSort(List<Integer> arr) {
            int n = arr.size();

            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;

                for (int j = i + 1; j < n; j++) {
                    if (arr.get(j) < arr.get(minIndex)) {
                        minIndex = j;
                    }
                }

                int temp = arr.get(minIndex);
                arr.set(minIndex, arr.get(i));
                arr.set(i, temp);
            }
        }
    }

}
