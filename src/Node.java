import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    // List of children
    private List<Node> children;
    private String direction;
    private Map<Integer, String> directionMap = new HashMap<>();

    public Node() {
        children = new ArrayList<>();
        int assignDir = (int) (Math.random()*3);
        
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
                this.addChild(new Node());
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

