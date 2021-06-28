import java.util.Scanner;
public class HelloWorld
{
    private int distances[];
    private int numberofvertices;
    public static final int MAX_VALUE = 999;
 
    public HelloWorld(int numberofvertices)
    {
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }
 
    public void BellmanFordEvaluation(int source,String Sourname, int adjacencymatrix[][], String []names)
    {
        for (int node = 1; node <= numberofvertices; node++)
        {
            distances[node] = MAX_VALUE;
        }
 
        distances[source] = 0;
        for (int node = 1; node <= numberofvertices - 1; node++)
        {
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
            {
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
                {
                    if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                    {
                        if (distances[destinationnode] > distances[sourcenode] 
                                + adjacencymatrix[sourcenode][destinationnode])
                            distances[destinationnode] = distances[sourcenode]
                                + adjacencymatrix[sourcenode][destinationnode];
                    }
                }
            }
        }
 
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
            {
                if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE)
                {
                    if (distances[destinationnode] > distances[sourcenode]
                           + adjacencymatrix[sourcenode][destinationnode])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
        System.out.println(" Using Bellmon Ford Algorithm :"
                + "");
        for (int vertex = 1; vertex <= numberofvertices; vertex++)
        {
                        
            System.out.println("distance of Sourname  " + Sourname + " to "
                      + names[vertex-1] + " is " + distances[vertex]);
        }
    }
 
    public static void main(String... arg)
    {
        
        System.out.println(" This program Takes input parameters for BellMan Ford Algorithm such as "
                + "\n number of vertices, "
                + " \n names of the Vertices,"
                + "\n Adjescency matrix for the distances between vertices. "
        );
        System.out.println(" ");
        System.out.println(" ");
        int numberofvertices = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Please enter the number of vertices");
        numberofvertices = scanner.nextInt();
        String a[]= new String[numberofvertices];
        int noOfVertices=numberofvertices;
          System.out.println(" ");
        System.out.println("Enter name for Vertices");
        
        for(int i=0;i<noOfVertices;i++){
            System.out.print( " position "+(i+1)+" vertex name is ");
            a[i]=scanner.next();
        }
        System.out.println(" ");
        int adjacencymatrix[][] = new int[numberofvertices + 1][numberofvertices + 1];
        System.out.println("Enter the adjacency matrix");
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++)
            {
                adjacencymatrix[sourcenode][destinationnode] = scanner.nextInt();
 	        if (sourcenode == destinationnode)
                {
                    adjacencymatrix[sourcenode][destinationnode] = 0;
                    continue;
                }
                if (adjacencymatrix[sourcenode][destinationnode] == 0)
                {
                    adjacencymatrix[sourcenode][destinationnode] = MAX_VALUE;
                }
            }
        }
 
       
       
       for( String str:a){
        int temp=0;
        int len=a.length;
        for (int j = 0; j < len; j++) {
           
            if(str.equalsIgnoreCase(a[j])){
           
                temp=j+1;
            }
        }
        
       
        source=temp;
 
 if(temp!=0){
        HelloWorld bellmanford = new HelloWorld(numberofvertices);
        bellmanford.BellmanFordEvaluation(source,str ,adjacencymatrix , a);
        scanner.close();	
        
        System.out.println(" ----------------->>>>>>");
                
 }
 else{
     System.out.println(" Please Re run the program and check the source name you have entered.");
 }
    }
}
}
