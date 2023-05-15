package com.example.sorting;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    private int[] arr;
    private EditText inputET;
    private TextView outputTV;
    private TextView outputTV2;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputET = findViewById(R.id.input_array_et);
        outputTV = findViewById(R.id.output_tv);
        outputTV2 = findViewById(R.id.output_tv2);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);

    }

    // Ascending Order
    public void sort(View view) {

// get input array from user input
        String inputStr = inputET.getText().toString();
        String[] inputArrStr = inputStr.split(",");
        arr = new int[inputArrStr.length];
        for (int i = 0; i < inputArrStr.length; i++) {
            arr[i] = Integer.parseInt(inputArrStr[i].trim());
        }

// Start timing
        long startTime = System.nanoTime();

// sort array using 3 different algorithms in parallel
        Thread bubbleSortThread = new Thread(new BubbleSortRunnable());

        long startTime2 = System.nanoTime();
        Thread selectionSortThread = new Thread(new SelectionSortRunnable());

        long startTime3 = System.nanoTime();
        Thread insertionSortThread = new Thread(new InsertionSortRunnable());

        bubbleSortThread.start();
        selectionSortThread.start();
        insertionSortThread.start();

        try {
            bubbleSortThread.join();

            selectionSortThread.join();

            insertionSortThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Stop timing
        //long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        long endTime2 = System.nanoTime();
        long endTime3 = System.nanoTime();

// Calculate the time taken
        long timeTaken = endTime - startTime;
        long timeTaken2 = endTime2 - startTime2;
        long timeTaken3 = endTime3 - startTime3;

// display sorted array in output TextView
        outputTV.setText("Sorted array: " + Arrays.toString(arr));

// Display the time taken
        textView5.setText("BS Time taken: " + timeTaken + " Nanoseconds");
        textView6.setText("SS Time taken: " + timeTaken2 + " Nanoseconds");
        textView7.setText("IS Time taken: " + timeTaken3 + " Nanoseconds");

    }
    private class BubbleSortRunnable implements Runnable {

        @Override
        public void run() {
            bubbleSort(arr);
        }
        private void bubbleSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

    }
    private class SelectionSortRunnable implements Runnable {

        @Override
        public void run() {
            selectionSort(arr);
        }
        private void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

    }
    private class InsertionSortRunnable implements Runnable {

        @Override
        public void run() {
            insertionSort(arr);
        }
        private void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

    }


    // Descending Order
    public void sort2(View view) {
        // get input array from user input
        String inputStr = inputET.getText().toString();
        String[] inputArrStr = inputStr.split(",");
        arr = new int[inputArrStr.length];
        for (int i = 0; i < inputArrStr.length; i++) {
            arr[i] = Integer.parseInt(inputArrStr[i].trim());
        }

// Start timing
        long startTime4 = System.nanoTime();

// sort array using 3 different algorithms in parallel
        Thread bubbleSortThread = new Thread(new BubbleSortRunnable2());

        long startTime5 = System.nanoTime();
        Thread selectionSortThread = new Thread(new SelectionSortRunnable2());

        long startTime6 = System.nanoTime();
        Thread insertionSortThread = new Thread(new InsertionSortRunnable2());

        bubbleSortThread.start();
        selectionSortThread.start();
        insertionSortThread.start();

        try {
            bubbleSortThread.join();

            selectionSortThread.join();

            insertionSortThread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Stop timing
        long endTime4 = System.nanoTime();
        long endTime5 = System.nanoTime();
        long endTime6 = System.nanoTime();

// Calculate the time taken
        long timeTaken4 = endTime4 - startTime4;
        long timeTaken5 = endTime5 - startTime5;
        long timeTaken6 = endTime6 - startTime6;

// display sorted array in output TextView
        outputTV2.setText("Sorted array: " + Arrays.toString(arr));

// Display the time taken
        textView8.setText("BS Time taken: " + timeTaken4 + " Nanoseconds");
        textView9.setText("SS Time taken: " + timeTaken5 + " Nanoseconds");
        textView10.setText("IS Time taken: " + timeTaken6 + " Nanoseconds");


    }
    private class BubbleSortRunnable2 implements Runnable {
        @Override
        public void run() {
            bubbleSort2(arr);
        }

        private void bubbleSort2(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) { // change to "<" instead of ">"
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
    private class SelectionSortRunnable2 implements Runnable {
        @Override
        public void run() {
            selectionSort2(arr);
        }

        private void selectionSort2(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int maxIndex = i; // change variable name to "maxIndex"
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[maxIndex]) { // change to ">" instead of "<"
                        maxIndex = j; // change to "maxIndex" instead of "minIndex"
                    }
                }
                int temp = arr[maxIndex]; // change to "maxIndex" instead of "minIndex"
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    private class InsertionSortRunnable2 implements Runnable {
        @Override
        public void run() {
            insertionSort2(arr);
        }

        private void insertionSort2(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] < key) {// change to "<" instead of ">"
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
    }
}