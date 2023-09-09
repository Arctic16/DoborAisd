package task2;

public class EuclidAlgorithm {

    public static int getNod(int a, int b) {
        if (b == 0) return a;
        return getNod(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(getNod(6, 3));
        System.out.println(getNod(17, 9));
        System.out.println(getNod(100, 45));
        System.out.println(getNod(507, 0));
        System.out.println(getNod(100, 400));
    }

}
