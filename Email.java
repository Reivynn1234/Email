
/**
 * Converts Email to Name   
 *
 * @Reivynn Chiang
 * @3/10/19
 */

import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class Email{
    public static void main(String[] args) {
       
        Scanner userInput = new Scanner(System.in);
        String email = userInput.next();
        String url = ("https://www.ecs.soton.ac.uk/people/" +email);
        // Gets url from first input
        
        printName(url);
    }

    /**
     * Prints name from email
     */
    public static void printName(String url){
        URL page = null;
        Scanner webInput = null;
        String line = null;
        
        try {
            page = new URL(url);
        } catch (MalformedURLException exception) {
            System.out.println(exception);
        }
        try {
            webInput = new Scanner(page.openStream());
        } catch (IOException exception) {
            System.out.println(exception);
        }
        
        while(webInput.hasNext()) {
            line = webInput.nextLine();
            if (line.substring(0,11).equals("    <title>")){
                int count = 11;
                while(line.charAt(count+1) != '|'){
                    System.out.print(line.charAt(count));
                    count++;
                }
                System.out.println();
                break;
            }
        }

    }
}
