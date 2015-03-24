public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode graph,
        Map<UndirectedGraphNode, UndirectedGraphNode> map)
    {
        if (map.containsKey(graph)) return map.get(graph);
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
        map.put(graph, graphCopy);
        for (UndirectedGraphNode neighbor : graph.neighbors) {
            graphCopy.neighbors.add(dfs(neighbor, map));
        }
        return graphCopy;
    }
}