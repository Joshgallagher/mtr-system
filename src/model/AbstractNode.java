package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Joshua Gallagher Thomas Geraghty Dimitar Stoynev
 * @version 15/10/2017
 */
public abstract class AbstractNode {

	private final Set<AbstractNode> connectedNodes = new HashSet<>();

	/**
	 * 
	 * @param node
	 */
	public void addConnectedNode(AbstractNode node) {
		connectedNodes.add(node);
	}

	/**
	 * 
	 * @return
	 */
	public Set<AbstractNode> getConnectedNodes() {
		return connectedNodes;
	}

	/**
	 * 
	 * @param endNode
	 * @return
	 */
	public List<AbstractNode> bfsFromHere(AbstractNode endNode) {

		List<AbstractNode> pathList = new LinkedList<>();
		LinkedList<AbstractNode> queue = new LinkedList<>();

		Set<AbstractNode> visited = new HashSet<>();
		Map<AbstractNode, AbstractNode> parents = new HashMap<>();

		queue.add(this);
		visited.add(this);

		while (!queue.isEmpty()) {
			AbstractNode currentNode = queue.remove();

			for (AbstractNode node : currentNode.getConnectedNodes()) {
				if (!visited.contains(node)) {
					queue.add(node);
					parents.put(node, currentNode);
				}
			}
			visited.add(currentNode);
		}

		if (parents.get(endNode) == null)
			return null;

		for (AbstractNode curNode = endNode; curNode != null;) {
			pathList.add(0, curNode);
			curNode = parents.get(curNode);
		}

		return pathList;
	}
}