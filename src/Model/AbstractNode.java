package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractNode {

	private final HashSet<AbstractNode> connectedNodes = new HashSet<AbstractNode>();

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
	public HashSet<AbstractNode> getConnectedNodes() {
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

		HashSet<AbstractNode> visited = new HashSet<AbstractNode>();
		HashMap<AbstractNode, AbstractNode> parents = new HashMap<>();

		queue.add(this);
		visited.add(this);

		while (!queue.isEmpty()) {
			AbstractNode currentNode = queue.remove();

			if (currentNode == endNode) {
				break;
			} else {
				for (AbstractNode node : currentNode.getConnectedNodes()) {
					if (!visited.contains(node)) {
						queue.add(node);
						parents.put(node, currentNode);
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

		return pathList;
	}
}
