import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class idReader {
    public static void main(String[] args) throws Exception{
        // Takes email id input
        InputStreamReader id = new InputStreamReader(System.in);
        BufferedReader bufferID = new BufferedReader(id);
        System.out.println("Enter id: ");
        String idOutput = bufferID.readLine();

        // Constructs URL and makes it readable
        URL newURL = new URL("https://www.ecs.soton.ac.uk/people/" + idOutput);
        InputStreamReader webpage = new InputStreamReader(newURL.openStream());
        BufferedReader bufferWeb = new BufferedReader(webpage);

        // Searches for line containing the person's name
        String line;
        while ((line = bufferWeb.readLine()) != null) {
            if (line.contains("og:title")) {
                int start = line.indexOf("content=\"") + 9;
                int end = line.indexOf("\"", start);
                System.out.println(line.substring(start,end));
            }
        }

        bufferWeb.close();
    }
}
