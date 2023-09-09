package task3;

import java.util.LinkedList;

public class BucketSorter {

    private QuickSorter quickSorter;

    public BucketSorter() {
        quickSorter = new QuickSorter();
    }

    private int sort(int[] array, int bucketsCount) {

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        int iterationsCount = 2;

        for (int num : array) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            iterationsCount += 2;
        }

        //Инициализируем корзинки
        LinkedList<Integer>[] buckets = new LinkedList[bucketsCount];
        for (int i = 0; i < bucketsCount; i++) {
            buckets[i] = new LinkedList<>();
            iterationsCount++;
        }

        //Определяем диапазон значений корзинок
        int range = maxValue - minValue;
        //Определяем диапазон значений одной корзинки
        int bucketRange = range / bucketsCount + 1;

        iterationsCount += 2;

        //Добавляем элементы в корзинки
        for (int j : array) {
            int index = (j - minValue) / bucketRange;
            buckets[index].add(j);
            iterationsCount += 2;
        }

        //Сортируем корзинки
        //Сортировать будем быстрой сортировкой
        for (int i = 0; i < bucketsCount; i++) {
            //Поскольку быстрая сортировка в качестве параметра принимает массив из примитивов,
            //а у нас список, то будем переводить список в массив примитивов.
            //Чтобы вычисления были более точными будем не будем учитывать сам процесс перевода
            //List в массив примитивов.
            iterationsCount +=
                    quickSorter.sort(buckets[i].stream().mapToInt(integer -> integer).toArray());
            int bucketSize = buckets[i].size();
            iterationsCount += (int) (bucketSize * (Math.log(bucketSize) / Math.log(2)));
        }


        //Достаем элементы из корзинок обратно в массив
        int cursor = 0;

        for (int i = 0; i < bucketsCount; i++) {
            for (int k = 0; k < buckets[i].size(); k++) {
                array[cursor++] = buckets[i].get(k);
                iterationsCount++;
            }
        }

        return iterationsCount;
    }

    public int sort(int[] array) {
        if (array == null || array.length <= 1) return 0;
        return sort(array, array.length);
    }

}
