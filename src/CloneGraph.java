/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, 
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neighbor: node.neighbors){
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                if (newNeighbor == null)
                    newNeighbor = cloneGraph(neighbor, map);
                
                newNode.neighbors.add(newNeighbor);
                
        }
        return newNode;
    }
}
