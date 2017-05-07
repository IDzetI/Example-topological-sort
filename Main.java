import java.io.IOException;

class Main {

    private static Writer writer;
    private static Reader reader;
    //structure for store data
    private static Graph graph;

    /**
     *open reader and writer
     * @throws IOException
     */
    private static void init() throws IOException {
        //System.out.print("Initialisation...");
        writer = new Writer("output.txt");
        reader = new Reader("input.txt");
        //System.out.println("OK");
    }

    /**
     * close reader and writer
     * @throws IOException
     */
    private static void finish() throws IOException {
        //System.out.print("Finishing...");
        writer.close();
        reader.close();
        //System.out.println("OK");
    }

    /**
     * method for read data from
     * file and create graph
     */
    private static void readData() {
        graph = new Graph();
        while (reader.hasNextLine()) {
            String str = reader.readLine();
            //check X=Y+Z or X=int
            if (str.length() > 3) {
                String second = String.valueOf(str.charAt(4));
                //if string contains integer
                if (str.charAt(4) < 58) {
                    int value = Integer.valueOf(String.valueOf(str.charAt(4)));
                    second = String.valueOf(str.charAt(0)) + String.valueOf(value);
                    graph.addVertex(second, value);
                }
                graph.addVertex(String.valueOf(str.charAt(0)),
                        String.valueOf(str.charAt(2)),
                        str.charAt(3),
                        second);
            }else
                if(str.length()>1)
                    graph.addVertex(String.valueOf(str.charAt(0)),
                                    Integer.valueOf(String.valueOf(str.charAt(2))));
        }
    }

    /**
     * main body
     * @throws IOException
     */
    private static void program() throws IOException {
        readData();
        Integer result = graph.calculate("R");
        //if can not calculate
        if(result == null)
            writer.write("ERROR");
        else
            writer.write(result);
    }

    /**
     * start point
     * @param args args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        init();
        program();
        finish();
    }
}
