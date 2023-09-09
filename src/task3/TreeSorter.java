package task3;

public class TreeSorter {

    private int iterationsCount;

    private class Node {
        public int value;
        public Node right;
        public Node left;
        public Node(Node right, Node left, int value) {
            this.right = right;
            this.left = left;
            this.value = value;
        }

        public Node(int value) {
            this(null, null, value);
        }

    }

    private Node insert(Node node, int value) {
        if (node == null) {
            iterationsCount++;
            return new Node(value);
        }
        if (value < node.value) {
            iterationsCount++;
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            iterationsCount++;
            node.right = insert(node.right, value);
        }
        iterationsCount++;
        return node;
    }

    private Node buildTree(int[] arr) {
        Node root = null;
        iterationsCount++;
        for (int num : arr) {
            iterationsCount++;
            root = insert(root, num);
        }
        iterationsCount++;
        return root;
    }

    private int inOrderTraversal(Node root, int[] arr, int index) {
        iterationsCount++;
        if (root == null) {
            iterationsCount++;
            return index;
        }
        index = inOrderTraversal(root.left, arr, index);
        arr[index++] = root.value;
        index = inOrderTraversal(root.right, arr, index);
        iterationsCount += 4;
        return index;
    }


    public int sort(int[] array) {

        iterationsCount = 0;

        Node root = buildTree(array);
        inOrderTraversal(root, array, 0);
        iterationsCount += 2;
        return iterationsCount;
    }

}
