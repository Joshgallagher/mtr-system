package Model;

import java.util.HashSet;
import java.util.LinkedList;

public abstract class AbstractNode {

    private final HashSet<AbstractNode> CONNECTED_NODES = new HashSet<AbstractNode>();
    
    /**
     * 
     * @param node
     */
    public void addConnectedNode(AbstractNode node) {
        CONNECTED_NODES.add(node);
    }
    
    /**
     * 
     * @return
     */
    public HashSet<AbstractNode> getConnectedNodes() {
        return CONNECTED_NODES;
    }
    
    /**
     * 
     * @param endNode
     * @return
     */
    public String bfsFromHere(AbstractNode endNode) {
        LinkedList<AbstractNode> queue = new LinkedList<AbstractNode>();
        HashSet<AbstractNode> visited = new HashSet<AbstractNode>();

        queue.add(this);
        visited.add(this);

        while(!queue.isEmpty()) {
            AbstractNode currentNode = queue.remove();

            if(currentNode == endNode) {
                return "PATH FOUND - SOMEONE IMPLEMENT THE PATH TRACE. IM UNDER THE NODE CLASS";
            } else {
                if(currentNode.getConnectedNodes().isEmpty()) {
                    return "PATH NOT FOUND";
                } else {
                    for (AbstractNode node : currentNode.getConnectedNodes()) {
                        if (!visited.contains(node)) {
                            queue.add(node);
                        }
                    }
                }
                visited.add(currentNode);
            }
        }
        return "PATH NOT FOUND";
    }
}
