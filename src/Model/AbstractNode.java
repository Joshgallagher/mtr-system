package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
    	
        List<AbstractNode> pathList = new LinkedList<>();
        LinkedList<AbstractNode> queue = new LinkedList<>();
        
        HashSet<AbstractNode> visited = new HashSet<AbstractNode>();
        HashMap<AbstractNode, AbstractNode> parents = new HashMap<>();

        queue.add(this);
        visited.add(this);

        while(!queue.isEmpty()) {
            AbstractNode currentNode = queue.remove();

            if(currentNode == endNode) {
                break;
            } else {
                if(currentNode.getConnectedNodes().isEmpty()) {
                    return "Sorry, a path could not be foound";
                } else {
                    for (AbstractNode node : currentNode.getConnectedNodes()) {
                        if (!visited.contains(node)) {
                            queue.add(node);
                            parents.put(node, currentNode);
                        }
                    }
                }
                visited.add(currentNode);
            }
        }
        
        if (parents.get(endNode) == null) {
        		return null;
        }
        
        AbstractNode curNode = endNode;
        
        while (curNode != null) {
        		pathList.add(0, curNode);
        		curNode = parents.get(curNode);
        }
        
        return pathList.toString();
    }
}
