public class Tree {
    public static int x = 0;
    public static int y = 0;
    private static int createLimit = 100000000;
    // F = draw forward
    // + = turn right
    // - = turn left
    public void createNodes() {
        Node root = new Node();
        // until createLimit = 0
        root.createNodes();
    }

    public static void updateLimit() {
        createLimit--;
    }

    public static int getLimit() {
        return createLimit;
    }
}
