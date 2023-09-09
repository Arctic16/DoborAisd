package task3;

public class DataGenerator {

    public int generateInt(int rangeFrom, int rangeTo) {
        return (int) (Math.random() * (rangeTo - rangeFrom)) + rangeFrom;
    }

    public int[] generateIntArray(int length, int rangeFrom, int rangeTo) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = generateInt(rangeFrom, rangeTo);
        }
        return array;
    }

}
