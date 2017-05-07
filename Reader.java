import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dzet
 * class for help with reading
 * any date from file
 */
public class Reader {

    private Scanner sc;

    public Reader(String fileName) throws FileNotFoundException {
        sc = new Scanner(new File(fileName));
    }

    public int readInt(){
        if(sc.hasNextInt()) return sc.nextInt();
        else return 0;
    }

    public double readDouble(){
        if(sc.hasNext()) return Double.parseDouble(sc.next());
        else return 0;
    }

    public String readWord(){
        if(sc.hasNext())
            return sc.next().toString();
        else
            return null;
    }

    public String readLine(){
        if(sc.hasNextLine())
            return sc.nextLine();
        else
            return readWord();
    }

    public void close(){
        sc.close();
    }

    public boolean hasNext(){
        return sc.hasNext();
    }

    public boolean hasNextDouble(){
        return sc.hasNextDouble();
    }

    public boolean hasNextLine(){return sc.hasNextLine();}
}
