package task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class ArraysUnionTask {

    public static int[] getUnion(int[] array1, int[] array2) {
        //В карту будем перемещать элементы из первого массива
        HashMap<Integer, Integer> map = new HashMap<>();
        //Здесь будет сохранен результирующий массив
        LinkedList<Integer> list = new LinkedList<>();

        //Сначала добавляем элементы на карту.
        //Ключ - сам элемент массива, а значение - количество этих элементов.
        //Сложность доступа к карте равна ~O(1), в итоге сложность O(k).
        for (int i = 0; i < array1.length; i++) {
            if (map.containsKey(array1[i])) {
                map.put(array1[i], map.get(array1[i]) + 1);
            } else {
                map.put(array1[i], 1);
            }
        }

        //Итерируемся по второму массиву и ищем совпадения на карте.
        //Как только нашли совпадение, добавляем этот элемент в результирующий список
        //Сложность добавления в список O(1), доступа к карте - ~O(1).
        //Итоговая слонжность O(l)
        for (int i = 0; i < array2.length; i++) {
            if (map.containsKey(array2[i])) {
                list.add(array2[i]);
                map.put(array2[i], map.get(array2[i]) - 1);
            }
        }
        //Переводим список в массив примитивов за O(min(k, l))
        //Сложность всего алгоритма равна O(k) + O(l) + O(min(k, l)) = O(k + l)
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {1, 1, 5, 10, 91, 7, 49};
        int[] array2 = new int[] {1, 5, 5, 101, 48, 0};
        int[] union = getUnion(array1, array2);
        Arrays.stream(union).forEach(System.out::println);
    }

}
