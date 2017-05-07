import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by User on 21.04.2017.
 */
public class Graph {

    //store data
    private static ArrayList<Vertex> vertices;
    private static ArrayList<Edge<String>> edges;

    /**
     * create empty graph
     */
    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * add new vertex
     * @param name
     * @param first
     * @param operator
     * @param second
     */
    public void addVertex(String name, String first, char operator, String second){
        vertices.add(new Vertex(name,first,operator,second));
        edges.add(new Edge<>(first,name));
        edges.add(new Edge<>(second,name));
    }

    /**
     * add new vertex if it's integer
     * @param name
     * @param value
     */
    public void addVertex(String name, int value){
        vertices.add(new Vertex(name, value));
    }

    /**
     * BFS algorithm for check path
     * @param start start vertex
     * @param end end vertex
     * @return is exist path
     */
    public boolean dfs(String start, String end){
        if(start.compareTo(end)==0)return true;
        Stack<String> stack = new Stack<>();
        List<String> colored = new ArrayList<>();

        stack.add(start);
        colored.add(start);

        while(!stack.isEmpty()) {
            boolean notAdd = true;
            for (Edge<String> edge : edges) {
                if (stack.peek().compareTo(edge.getEnd()) == 0 && !colored.contains(edge.getStart())) {
                    if(edge.getStart().compareTo(end)==0)return true;
                    stack.add(edge.getStart());
                    colored.add(edge.getStart());
                    notAdd = false;
                    break;
                }
            }
            if(notAdd)stack.pop();
        }
        return false;
    }


    /**
     * delete disconnect nodes
     * @param protect protected node
     */
    private void rejectUseless(String protect){
        ArrayList<Vertex> delete = new ArrayList<>();

        for(Vertex vertex: vertices){
            if(!dfs(protect,vertex.getName()))delete.add(vertex);
        }
        for(Vertex vertex: delete){
            vertices.remove(vertex);
        }
    }

    /**
     * search Sink
     * @param buffVertices List of vertices
     * @return Sink node
     */
    private Vertex searchSink(List<Vertex> buffVertices ){
        for(Vertex vertex: buffVertices){
            boolean needed = true;
            for(Edge<String> edge: edges){
                if(vertex.getName().compareTo(edge.getStart())==0){
                    needed = false;
                    break;
                }
            }
            if(needed)return vertex;
        }
        return null;
    }

    /**
     * remove edge
     * @param end end of deleted edge
     */
    private void removeEdge(String end){
        ArrayList<Edge<String>> delete = new ArrayList<>();
        for(Edge<String> edge: edges){
            if(edge.getEnd().compareTo(end)==0) delete.add(edge);
        }
        for(Edge<String> edge: delete){
            edges.remove(edge);
        }
    }

    /**
     * topological sorting
     * @param startPoint first sink
     * @return sequence
     */
    private Stack<Vertex> topSort(String startPoint){
        rejectUseless(startPoint);
        Stack<Vertex> stack = new Stack<>();

        //create buffer for vertices
        ArrayList<Vertex> buffVertices = new ArrayList<>();
        for (Vertex vertex: vertices) buffVertices.add(vertex);

        while(!buffVertices.isEmpty()){
            Vertex sink = searchSink(buffVertices);
            if(sink==null)return null;
            removeEdge(sink.getName());
            buffVertices.remove(sink);
            stack.push(sink);
        }

        return stack;
    }

    /**
     * solve this graph
     * @param startPoint needed variable
     * @return integer answer or null if can't calculate it
     */
    Integer calculate(String startPoint){
        Stack<Vertex> stack = topSort(startPoint);
        if(stack == null)return null;
        Vertex current = new Vertex("",0);

        while (!stack.isEmpty()){
            current = stack.pop();
            if(!current.isValue()){
                Vertex first = new Vertex("",0);
                Vertex second = new Vertex("",0);
                for(Vertex vertex: vertices){
                    if(vertex.getName().compareTo(current.getFirst())==0)
                        first = vertex;
                    if(vertex.getName().compareTo(current.getSecond())==0)
                        second = vertex;
                }
                current.calculateValue(first.getValue(),second.getValue());
            }
        }
        return current.getValue();
    }
}
