// A Java program to check if a given graph is Eulerian or not 
import java.io.*; 
import java.util.*; 

// This class represents an undirected graph using adjacency list 
// representation 
class CS60812Bashikari 
{ 
	private int V; 

	private LinkedList<Integer> adj[]; 
 
	CS60812Bashikari(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 
 
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w);// Add w to v's list. 
		adj[w].add(v); //The graph is undirected 
	} 

	void DFSUtil(int v,boolean visited[]) 
	{ 
		// Mark the current node as visited 
		visited[v] = true; 

		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n, visited); 
		} 
	} 

	boolean isConnected() 
	{ 
		// Mark all the vertices as not visited 
		boolean visited[] = new boolean[V]; 
		int i; 
		for (i = 0; i < V; i++) 
			visited[i] = false; 

		// Find a vertex with non-zero degree 
		for (i = 0; i < V; i++) 
			if (adj[i].size() != 0) 
				break; 

		// If there are no edges in the graph, return true 
		if (i == V) 
			return true; 

		// Start DFS traversal from a vertex with non-zero degree 
		DFSUtil(i, visited); 

		// Check if all non-zero degree vertices are visited 
		for (i = 0; i < V; i++) 
		if (visited[i] == false && adj[i].size() > 0) 
				return false; 

		return true; 
	} 

	int isEulerian() 
	{ 
		// Check if all non-zero degree vertices are connected 
		if (isConnected() == false) 
			return 0; 

		// Count vertices with odd degree 
		int odd = 0; 
		for (int i = 0; i < V; i++) 
			if (adj[i].size()%2!=0) 
				odd++; 

		// If count is more than 2, then graph is not Eulerian 
		if (odd > 2) 
			return 0; 

		// If odd count is 2, then semi-eulerian. 
		// If odd count is 0, then eulerian 
		// Note that odd count can never be 1 for undirected graph 
		return (odd==2)? 1 : 2; 
	} 

	void test() 
	{ 
		int res = isEulerian(); 
		if (res == 0) 
			System.out.println("This graph does not contain an Eulerian path. "
					+ "This is because each edge cannot be "
					+ "touched unless at least one has been traveled multiple times. "
					+ "(All edges must be touched once)"); 
		else if (res == 1) 
			System.out.println("This graph contains an Euler path, but not an Eulerian Circuit. "
					+ "This is because each edge can be touched without touching the same one twice. "
					+ "(All edges must be touched once) This is not a circuit, because the "
					+ "starting vertex is not returned to at the end."); 
		else
		System.out.println("This graph contains an Eulerian circuit (means an Eulerian path is present also). This is because each edge can be "
				+ "touched without touching the same one twice. The starting vertex is returned to after each edge has been touched. "
				+ "(All edges must be touched once)"); 
	}
	
    static int findDegree(int[][] g, int ver)  
    { 
        int degree = 0; 
        //char vertex = 'x';
        
        //vertex = charConv(ver);
        
        for (int i = 0; i < 15; i++) 
        	if (g[ver][i] != 0) 
        		degree++;
        
        //System.out.println("The degree of " + charConv(ver) + " is " + degree);
        		
        return degree; 
    } 

    static char charConv(int v) {
    	
    	//convert from number to corresponding character
    	char output = 'x';
    	
    	if (v == 0) {
    		output = 'A';
    	} else if (v == 1){
    		output = 'B';
    	} else if (v == 2){
    		output = 'C';
    	} else if (v == 3){
    		output = 'D';
    	} else if (v == 4){
    		output = 'E';
    	} else if (v == 5){
    		output = 'F';
    	} else if (v == 6){
    		output = 'G';
    	} else if (v == 7){
    		output = 'H';
    	} else if (v == 8){
    		output = 'I';
    	} else if (v == 9){
    		output = 'J';
    	} else if (v == 10){
    		output = 'K';
    	} else if (v == 11){
    		output = 'L';
    	} else if (v == 12){
    		output = 'M';
    	} else if (v == 13){
    		output = 'N';
    	} else {
    		output = 'O';
    	}
    	
    	return output;
    }
    
    static boolean dirac(int[][] g) {
    	
    	//finds the degree of each vertex, 
    	//then checks to see if the degree is smaller than n/2
    	int n = 15;
    	int degree = 0;
    	boolean diracTest = true;
    	
    	for (int i = 0; i < 15; i++) {
    		degree = findDegree(g, i);
    		if (degree < n/2) {
    			diracTest = false;
    			break;
    		}
    	}
    	
    	return diracTest;
    }
    
    static boolean ore(int[][] g) {
    	
    	int n = 15;
    	int degree1 = 0;
    	int degree2 = 0;
    	boolean oreTest = true;
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = i + 1; j < n; j++) {
  
    			degree1 = findDegree(g, i);
    			degree2 = findDegree(g, j);
    			
    			if (i != j && g[i][j] != 0 
    					&& degree1 + degree2 < n) {
    				
    				oreTest = false;
    				break;
    				
    			}
    		}
    	}
    	
    	return oreTest;
    }
    
    public static void main (String[] args) throws Exception
    { 
    	
		Scanner in = new Scanner(new File("inputData12B.txt"));
		int[][] input = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				input[i][j] = in.nextInt();
				//System.out.print(input[i][j] + " ");
			}
			//System.out.println("");
	    }

        CS60812Bashikari g = new CS60812Bashikari(15); 
  
        for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (input[i][j] != 0) {
					g.addEdge(i, j);
	    			//System.out.print(input[i][j] + " ");
				}
			}
			//System.out.println("");
	    }
        
        // Eulerian path and circuit
        System.out.println("Eulerian (covers both path and circuit): ");
        g.test(); 
        
        //Dirac's theorem
        boolean diracTest = false;
        diracTest = dirac(input);
        
        System.out.println("Dirac: ");
        
        if (diracTest == true) {
        	System.out.println("This graph satisfies Dirac's Theorem. "
        			+ "This is because n >= 3 and the degree of each "
        			+ "vertex is greater than half the total number of vertices.");
        } else {
        	System.out.println("This graph does not satisfy Dirac's Theorem. "
        			+ "At least one of the vertices has more degrees than half the total number of vertices.");
        }
        
        
        //Ore's theorem
        boolean oreTest = false;
        oreTest = ore(input);
        
        System.out.println("Ore: ");
        
        if (oreTest == true) {
        	System.out.println("This graph satisfies Ore's Theorem. "
        			+ "This is because n >= 3 and the added degrees "
        			+ "of each pair of non-adjacent vertices is >= the total number of vertices.");
        } else {
        	System.out.println("This graph does not satisfy Ore's Theorem. "
        			+ "At least one pair of non-adjacent vertices has a sum of degrees that is less than the total number of vertices.");
        }
        
        in.close();
    } 
} 

