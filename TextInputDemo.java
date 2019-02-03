import java.util.*;
import java.io.*;

public class TextInputDemo{
    public static void main(String[] args){
        String fileName = "out.txt";
        Scanner inputStream = null;
        System.out.println("The file " + fileName + " \ncontains the following lines:\n");

        try {
            inputStream = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
        }

        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            System.out.println(line);
        }
        inputStream.close();
    }
}
