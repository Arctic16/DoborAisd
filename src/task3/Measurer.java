package task3;

import java.util.Arrays;

//Класс для измерения производительности сортировок
public class Measurer {

    public static void main(String[] args) {
        TreeSorter treeSorter = new TreeSorter();
        BucketSorter bucketSorter = new BucketSorter();
        DataGenerator dataGenerator = new DataGenerator();

        int[] array1 = dataGenerator.generateIntArray(1000, -1_000_000, 1_000_000);
        int[] array2 = dataGenerator.generateIntArray(1000, -1_000_000, 1_000_000);

        int treeSortIterationsCount = treeSorter.sort(array1);
        int bucketSortIterationsCount = bucketSorter.sort(array2);


        if (treeSortIterationsCount < bucketSortIterationsCount) {
            System.out.printf("Tree sort has less iterations count: %d < %d%n",
                    treeSortIterationsCount, bucketSortIterationsCount);
        } else {
            System.out.printf("Bucket sort has less iterations count: %d < %d%n",
                    bucketSortIterationsCount, treeSortIterationsCount);
        }
    }

}
