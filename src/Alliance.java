import java.util.*;

public class Alliance<T>{

	private Map<T, LinkedList<T>> adjacencyList;
	//private int numOfVertices;
	
	public Alliance(){
		adjacencyList = new HashMap<T, LinkedList<T>>();
		//adjacencyList.
	}
	/*precondition: x is the new object to be inserted in the graph
	postcondition: if the insertion is successful, x is in the graph*/
	/*CREATE(x)*/
	public void create(T element){
		/*IF x is NOT contained in the list*/
		if(!adjacencyList.containsKey(element)){
			/*ADD x to the list*/
			adjacencyList.put(element, new LinkedList<T>());
		}
	/*END*/
	}
	
	/*precondition: x and y are two new objects to be inserted in the graph
	postcondition: if x and y belong to different sides, they will be added to the graph*/
	/*OPPOSE(x,y)*/
	public void oppose(T opponent1, T opponent2){
		/*IF x is contained in the list*/
		if(adjacencyList.containsKey(opponent1)){
			/*ADD y to the end of the list at that index*/
			LinkedList<T> targetList = adjacencyList.get(opponent1);
			targetList.addLast(opponent2);
		}
		/*ELSE*/
		else{
			/*ADD x to the end of the list*/
			adjacencyList.put(opponent1, new LinkedList<T>());
			/*ADD y as the first element of the new list*/
			LinkedList<T> targetList = adjacencyList.get(opponent1);
			targetList.addFirst(opponent2);
		}
	/*END*/
	}
		
	/*precondition: x is the source vertex and y is the target vertex
	postcondition: if y can be reached from x and y is at an odd distance from x, then x and y are opponents*/
	/*OPPONENTS(x,y)*/
	public boolean opponents(T opponent1, T opponent2){
		/*num_edges from x to y = BFS(x,y)*/
		int num_edges = BFS(opponent1, opponent2);
		/*IF y is Reachable from x2 AND num_edges MOD 2 != 0*/ 
			/*RETURN true*/
		/*ELSE*/
			/*RETURN false*/
		return false;
	/*END*/
	}
	
	private int BFS(T opponent1, T opponent2){
		LinkedList<T> target = adjacencyList.get(opponent1);
		for(int i = 0; i < target.size(); i++){
			
		}
		
		return 0;
	}
}







