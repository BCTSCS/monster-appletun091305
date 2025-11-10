import java.io.*;
import java.util.*;
public class FileOperator {
    private File myFile;
    private Scanner fileReader;

    public FileOperator(String s) throws IOException {
        setFile(s);
    }

    public void setFile(String s) throws IOException {
        myFile = new File(s);
        fileReader = new Scanner(myFile);
    }

    public String readLine() {
        return fileReader.nextLine();
    }
}
