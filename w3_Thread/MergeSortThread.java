package w3_Thread;

import java.util.Arrays;

class MergeSortThread extends Thread {

    private int[] ar;

    public MergeSortThread(int[] ar) {
        this.ar = ar;
    }

    public void run() {
        mergeSort(ar);
    }

    private void mergeSort(int[] arr) {
        if (arr.length < 2)
            return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        MergeSortThread leftThread = new MergeSortThread(left);
        MergeSortThread rightThread = new MergeSortThread(right);

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join(); // Wait for left half to be sorted
            rightThread.join(); // Wait for right half to be sorted
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(arr, left, right);
    }

    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
    }
}
