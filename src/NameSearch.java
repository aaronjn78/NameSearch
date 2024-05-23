import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameSearch {

    static String[] nameList = new String[100];

    public static void main(String[] args) throws Exception {

        String searchName;
        Scanner myScanner = new Scanner(System.in);
        int index;
        Boolean exit = false;

        ReadFile();
        SortStringArray.SortList(nameList);

    do {
        System.out.println("Enter name to search for: (Q/q to quit)");
        searchName = myScanner.nextLine();

        if (searchName.compareToIgnoreCase("q") == 0){
            exit = true;
            continue;
        }

        index = SearchList(searchName);

        if (index == -1) {
            System.out.println(searchName + " not found in the list.");
        } else {
            System.out.println(searchName + " found at position: " + index);

        }
    } while (!exit);

    myScanner.close();
}

    public static void ReadFile() {

        int i = 0;

        try {
            File myFile = new File(".\\Names.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                nameList[i] = myReader.nextLine();
                i++;
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    public static int SearchList(String searchName) {

        String name = searchName;
        int top = nameList.length;
        int bottom = 0;

        while (bottom <= top) {

            int middle = bottom + (top - bottom)/2;

            if (name.compareToIgnoreCase(nameList[middle]) == 0) {
                return middle;
            }
            if (name.compareToIgnoreCase(nameList[middle]) > 0) {
                bottom = middle + 1;
            }
            else {
                top = middle -1;
            }             
        }

        return -1;
    }

}
