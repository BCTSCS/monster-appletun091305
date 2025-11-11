import java.io.*;
import java.net.*;
import java.util.*;
public class FileOperator {
    private File myFile;
    private Scanner fileReader;

    public FileOperator(String s) throws IOException {
        setFile(s);
    }

    public FileOperator(String url, boolean isOnline) throws IOException {
        if (isOnline) {
            setUrl(url);
        } else {
            setFile(url);
        }
    }

    public void setFile(String s) throws IOException {
        myFile = new File(s);
        fileReader = new Scanner(myFile);
    }

    public void setUrl(String url) throws IOException {
        try {
            URL u = new URI(url).toURL();
            fileReader = new Scanner(u.openStream());
        } catch(Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
        }

    }

    public String readLine() {
        if (fileReader.hasNextLine()) {
            return fileReader.nextLine();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        FileOperator f = new FileOperator("https://people.sc.fsu.edu/~jburkardt/data/csv/airtravel.csv", true);
        String line = f.readLine();
        while (line!=null) {
            System.out.println(line);
            line = f.readLine();
        }
    }
}
