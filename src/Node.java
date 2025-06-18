import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    // List of children
    private List<Node> children;
    private String direction;
    private int x;
    private int y;
    private Map<Integer, String> directionMap = new HashMap<>();

    public Node() {
        x = 0; y = 0;
        children = new ArrayList<>();
        int assignDir = (int) (Math.random()*3); 
        assignDirection();
    }

    public Node(int x, int y) {
        this.x = x; this.y = y;
        children = new ArrayList<>();
        assignDirection();
    }

    private String assignDirection() {
        int assignDir = (int) (Math.random()*3);
        switch (assignDir) {
            case 0: direction = "F"; break;
            case 1: direction = "+"; break;
            case 2: direction = "-"; break;
        }
    }
    
    // Adds a child node to list
    public void addChild(Node n) {
        children.add(n);
    }

    // Gets the list of children
    public List<Node> getChildren() {
        return children;
    }

    // If clicked on --> tell child count
    public void clickEvent() {
        System.out.println("Child count: " + children.size());
    }

    public void createNodes() {
        if (Tree.getLimit() > 0) {
            for (int i = 0; i < ((int) (Math.random()*4)); i++) {
                if (direction.equals("F")) {
                    // since we are drawing on the GUI, down is positive so to go up positive 
                    // according to cartesian coordinates we lessen the y value.
                    this.addChild(new Node(x, y - 1));
                } else if (direction.equals("+")) {
                    this.addChild(new Node(x+1, y));
                } else if (direction.equals("-")) {
                    this.addChild(new Node(x-1, y));
                }
            }
            for (int i = 0; i < this.children.size(); i++) {
                this.children.get(i).createNodes();
                Tree.updateLimit();
            }
        }
    }

    public String getDirection() {
        return direction;
    }

    // Prints children upon toString() call
    @Override
    public String toString() {
        return children.toString();
    }
}

