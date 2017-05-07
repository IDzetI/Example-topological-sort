/**
 * Created by User on 21.04.2017.
 */
class Edge<V extends Comparable<V>> {

    //data for store edge
    private V start;
    private V end;

    /**
     * create new edge
     * @param start
     * @param end
     */
    Edge(V start, V end){
        this.start = start;
        this.end = end;
    }

    /**
     * get start vertex
     * @return start vertex
     */
    V getStart() {
        return start;
    }

    /**
     * get end vertex
     * @return end vertex
     */
    V getEnd() {
        return end;
    }
}
