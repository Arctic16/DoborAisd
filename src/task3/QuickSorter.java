package task3;

public class QuickSorter {

    private int iterationsCount;

    public void sort(int[] array, int low, int high) {
        if (low < high) {
            iterationsCount += 3;
            int pivotIndex = partition(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    public int sort(int[] array) {
        iterationsCount = 0;
        sort(array, 0, array.length - 1);
        return iterationsCount;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        iterationsCount += 2;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                iterationsCount += 2;
            }
        }
        swap(arr, i + 1, high);
        iterationsCount +=2;
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        iterationsCount += 3;
    }

}
