import java.util.*; 
import java.lang.*; 
import java.io.*;

public class CS60812Aashikari {

    private static final int V=14; 
    static int total = 0;
  
    int minKey(int key[], Boolean mstSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
   
    void printMST(int parent[], int n, int graph[][]) 
    { 
    	char output = 'x';
    	char outputI = 'x';
    	
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) {
        	
        	output = charConv(parent[i]);
        	outputI = charConv(i);
        	
        	System.out.println(output+" - "+ outputI+"\t"+ 
                    graph[i][parent[i]]);
        	total = total + graph[i][parent[i]];
            //System.out.println(parent[i]+" - "+ i+"\t"+ 
            //                graph[i][parent[i]]); 
        }
    } 
  
    void primMST(int graph[][]) 
    { 
        // Array to store constructed MST 
        int parent[] = new int[V]; 
  
        // Key values used to pick minimum weight edge in cut 
        int key[] = new int [V]; 
  
        // To represent set of vertices not yet included in MST 
        Boolean mstSet[] = new Boolean[V]; 
  
        // Initialize all keys as INFINITE 
        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
  
        // Always include first 1st vertex in MST. 
        key[0] = 0;     // Make key 0 so that this vertex is 
                        // picked as first vertex 
        parent[0] = -1; // First node is always root of MST 
  
        // The MST will have V vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            // Pick thd minimum key vertex from the set of vertices 
            // not yet included in MST 
            int u = minKey(key, mstSet); 
  
            // Add the picked vertex to the MST Set 
            mstSet[u] = true; 
  
            // Update key value and parent index of the adjacent 
            // vertices of the picked vertex. Consider only those 
            // vertices which are not yet included in MST 
            for (int v = 0; v < V; v++) 
  
                // graph[u][v] is non zero only for adjacent vertices of m 
                // mstSet[v] is false for vertices not yet included in MST 
                // Update the key only if graph[u][v] is smaller than key[v] 
                if (graph[u][v]!=0 && mstSet[v] == false && 
                    graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
  
        // print the constructed MST 
        printMST(parent, V, graph); 
    }
    
    char charConv(int v) {
    	
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
  
    public static int sum2d (int[ ][ ] array2d)
    {
        int sum = 0;
        for (int row=0; row < array2d.length; row++)
        {
            for (int col=0; col < array2d[row].length; col++)
            {
                sum = sum + array2d [row][col];
            }
        }

        return sum;
    }
    
    public static void main (String[] args) throws Exception
    { 
    	
		Scanner in = new Scanner(new File("inputData12A.txt"));
		int[][] input = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				input[i][j] = in.nextInt();
				//System.out.print(input[i][j] + " ");
			}
			//System.out.println("");
	    }

        CS60812Aashikari t = new CS60812Aashikari(); 
  
        // Print the solution 
        t.primMST(input); 
        
        //sum of all edges
        System.out.println("The total of all edges = " + total);
        
        
        in.close();
    } 
}
	

