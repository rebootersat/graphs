package main.java.BFS;

import java.util.Queue;

import main.java.core.Graph;
import main.java.queue.UnorderedQueue;

public class BFS
{
	private Graph<String> graph;
	
	public BFS(Graph<String> graph)
	{
		if (graph == null)
			throw new NullPointerException("Graph cannot be null");
		this.graph = graph;
	}
	
	public Queue<String> execute() {
		Queue<String> queue = new UnorderedQueue<>();
		Queue<String> rQ = new UnorderedQueue<>();
		queue.offer(graph.getSource());
		
		while (!queue.isEmpty())
		{
			String ele = queue.poll();
			rQ.offer(ele);
			graph.setVisted(ele);
			Object[] adjacentVertices = graph.getUnvisitedAdjacentVertices(ele);
			for (int i = 0; i < adjacentVertices.length; i++)
			{
				String val = (String) adjacentVertices[i];
				if (!graph.isVisited(val))
				{
					graph.setVisted(ele, val);
					queue.offer(val);
				}
			}
		}
		return rQ;
	}
	
}
