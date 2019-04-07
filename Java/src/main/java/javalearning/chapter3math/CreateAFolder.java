package javalearning.chapter3math;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateAFolder {
    private static final String FOLDER = "C:\\testDir";

    public static void main(String[] args) throws IOException {

        /**--------- Code to create a Folder -------- */
        File newFolder = new File(FOLDER); //Create object of File
        if (!newFolder.exists()) { //check if folder exists
            boolean created = false;
            created = newFolder.mkdir(); //Create folder & return true/false
            if (created) {
                System.out.println("Folder is created !");
            }
        } else {
            System.out.println("Folder already exists");
        }

        /**--------- Code to create a File -------- */
        File newFile = new File(FOLDER+"\\javaTest.txt");

        if (!newFile.exists()) {
            newFile.createNewFile();
            System.out.println("File is created");
        }else{
            System.out.println("File already created");
        }

        FileWriter fw = new FileWriter(newFile);

        fw.write("How are you doing today?");
    }
}

