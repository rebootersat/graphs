package main.java.pathFromSourceToTargetVertex;

import java.util.Iterator;
import java.util.Stack;

import main.java.core.Graph;

/**
 * Finds the path between given values in the graph if values are valid
 * 
 * @author SANDEEP
 *
 * @param <V>
 */
public class PathFromSourceToTarget<V>
{
	private Graph<V> graph;
	private Stack<V> stack;
	private boolean isPathExist;
	
	public PathFromSourceToTarget(Graph<V> graph)
	{
		this.graph = graph;
	}
	
	/**
	 * Gets the path for given src and target value if both exist in the grapg
	 * 
	 * @param src
	 *            source vertex
	 * @param target
	 *            target vertex
	 * @return returns the path for given src and target value
	 */
	public String getPath(V src, V target) {
		if (!graph.contains(src) || !graph.contains(src))
			throw new IllegalArgumentException("Either " + src + " or " + target + " does not exist in the graph");
		
		stack = new Stack<>();
		stack.push(src);
		graph.setVisted(src);
		findPath(target);
		
		StringBuilder result = new StringBuilder();
		for (Iterator<V> iterator = stack.iterator(); iterator.hasNext();)
		{
			V v = (V) iterator.next();
			result.append(v);
		}
		return result.toString();
	}
	
	/**
	 * Performs the DFS on the graph and stores all the elements which are in
	 * path in stack. When target element found, entire process stopped
	 * 
	 * @param target
	 */
	@SuppressWarnings("unchecked")
	private void findPath(V target) {
		while (!stack.isEmpty() && !isPathExist)
		{
			V ele = stack.pop();
			Object[] adjacentValues = graph.getUnVisitedAdjacentValues(ele);
			if (adjacentValues.length > 0)
				stack.push(ele);
			for (int i = 0; i < adjacentValues.length; i++)
			{
				if(isPathExist)
					return;
				V val = (V) adjacentValues[i];
				if (!val.equals(target))
				{
					stack.push(val);
					graph.setVisted(val);
					findPath(target);
				}
				else
				{
					stack.push(val);
					isPathExist = true;
					break;
				}
				
			}
		}
	}
}
