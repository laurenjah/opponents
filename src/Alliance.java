import java.util.*;

public class Alliance<T>{

	private LinkedList<LinkedList<Node<T>>> adjacencyList;
	
	public Alliance(){
		adjacencyList = new LinkedList<LinkedList<Node<T>>>();
	}
	
	/*precondition: x is the new object to be inserted in the graph
	postcondition: if the insertion is successful, x is in the graph*/
	/*CREATE(x)*/
	public void create(T element){
		/*IF x is NOT contained in the list*/
		if(this.findElement(element) == null) {
			LinkedList<Node<T>> list = new LinkedList<Node<T>>();
			list.add(new Node<T>(element));
			/*ADD x to the list*/
			adjacencyList.add(list);
		}
	/*END*/
	}
	
	/*precondition: x and y are two new objects to be inserted in the graph
	postcondition: if x and y belong to different sides, they will be added to the graph*/
	/*OPPOSE(x,y)*/
	public void oppose(T opponent1, T opponent2){
		boolean added = false;
		for(List<Node<T>> list : adjacencyList){
			/*IF x is contained in the list*/
			if(list.get(0).getData().equals(opponent1)){
				/*ADD y to the end of the list at that index*/
				list.add(new Node<T>(opponent2));
				added = true;
			}
		}
		/*ELSE*/
		if(added == false){
			LinkedList<Node<T>> list = new LinkedList<Node<T>>();
			/*ADD x to the end of the list*/
			list.add(new Node<T>(opponent1));
			/*ADD y as the first element of the new list*/
			list.add(new Node<T>(opponent2));
			adjacencyList.add(list);
		}
	/*END*/
	}
		
	/*precondition: x is the source vertex and y is the target vertex
	postcondition: if y can be reached from x and y is at an odd distance from x, then x and y are opponents*/
	/*OPPONENTS(x,y)*/
	public boolean opponents(T opponent1, T opponent2){
		/*num_edges from x to y = BFS(x,y)*/
		int num_edges = BFS(opponent1, opponent2);
		/*IF y is Reachable from x AND num_edges MOD 2 != 0*/ 
		if((num_edges % 2) != 0)
			/*RETURN true*/
			return true;
		/*ELSE*/
		else
			/*RETURN false*/
			return false;
	/*END*/
	}
	
	/*does a BFS on the adjacencyList with source node opponent1
	 * and target node opponent 2*/
	private int BFS(T opponent1, T opponent2){
		List<T> visited = new ArrayList<T>(sizeOfAdjList(adjacencyList));
		Node<T> source = findElement(opponent1);
		
		LinkedList<Node<T>> queue = new LinkedList<Node<T>>();
		source.distance = 0;
		visited.add(source.getData());
		queue.add(source);
		
		while(queue.size() != 0){
			Node<T> opponent = queue.poll();
			List<Node<T>> neighbors = new ArrayList<Node<T>>();
			neighbors.addAll(getListOfNeighbors(opponent));
			
			for(int i = 0; i < neighbors.size(); i++){
				neighbors.get(i).setDistance(opponent.distance + 1);
				if(neighbors.get(i).getData().equals(opponent2)){
					return neighbors.get(i).getDistance();
				}
				else {
					if(!visited.contains(neighbors.get(i).getData())){
						visited.add(neighbors.get(i).getData());
						queue.add(neighbors.get(i));
					}
				}
			}
		}
		return 0;
	}
	
	/*for the given element, find the corresponding Node for that element*/
	private Node<T> findElement(T opponent){
		for (List<Node<T>> list : adjacencyList){
			if(list.get(0).getData().equals(opponent))
				return list.get(0);
		}		
		return null;
	}
	
	/*for the given node, find all adjacent elements of that node*/
	private List<Node<T>> getListOfNeighbors(Node<T> opponent){
		List<Node<T>> neighbors  = new ArrayList<Node<T>>();
		for (int i = 0; i < adjacencyList.size(); i++){
			if(adjacencyList.get(i).get(0).getData().equals(opponent.getData())){
				for(int k = 1; k < adjacencyList.get(i).size(); k++){
					neighbors.add(adjacencyList.get(i).get(k));
				}
				return neighbors;
			}
		}		
		return neighbors;
	}
	
	/*finds the number of vertices in the adjacencyList*/
	private int sizeOfAdjList(LinkedList<LinkedList<Node<T>>> adjacencyList){
		int numOfVertices = 0;
		for(List<Node<T>> list : adjacencyList){
			numOfVertices += list.size();
		}
		return numOfVertices;
	}
	
	/*private inner class to represent the generic nodes*/
	private class Node<T>{
		
		private T element;
		private int distance;
		
		/*Node constructor*/
		private Node(T element){
			this.element = element;
		}
		
		/*get opponent at this node*/
		private T getData(){
			return this.element;
		}
		
		/*set distance at this node*/
		private void setDistance(int distance){
			this.distance = distance;
		}
		
		/*get distance at this node*/
		private int getDistance(){
			return this.distance;
		}
	}
}







