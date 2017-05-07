/**
 * Created by User on 21.04.2017.
 */
public class Vertex {

    // data for stored information about vertex
    private String name;
    private String first;
    private String second;
    private char operator;
    private int value;
    private boolean isValue;

    /**
     * create new node
     * @param name
     * @param first
     * @param operator
     * @param second
     */
    Vertex(String name, String first, char operator, String second){
        this.name = name;
        this.first = first;
        this.second = second;
        this.operator = operator;
        this.value = 0;
        this.isValue = false;
    }

    /**
     * create new node if it's value
     * @param name
     * @param value
     */
    Vertex(String name, int value){
        this.name = name;
        this.value = value;
        this.isValue = true;
    }

    /**
     * solve tis node
     * @param firstValue
     * @param secondValue
     */
    void calculateValue(int firstValue, int secondValue){
        if(operator == '+') value = firstValue + secondValue;
        if(operator == '*') value = firstValue * secondValue;
        isValue = true;
    }

    /**
     * print all information about node
     */
    public void print(){
        System.out.print(name+"=");
        System.out.print(first+" ");
        System.out.print(operator+" ");
        System.out.print(second+" ");
        System.out.print(value+" ");
        System.out.println(isValue);
    }

    /**
     * get vertex name
     * @return vertex name
     */
    public String getName() {
        return name;
    }

    /**
     * get vertex first parent
     * @return vertex first parent
     */
    public String getFirst() {
        return first;
    }

    /**
     * get vertex second parent
     * @return vertex second parent
     */
    public String getSecond() {
        return second;
    }

    /**
     * get vertex value if vertex is value
     * @return vertex value
     */
    public int getValue() {
        if(isValue)return value;
        else return 0;
    }

    /**
     * is value
     * @return is value
     */
    public boolean isValue() {
        return isValue;
    }
}
