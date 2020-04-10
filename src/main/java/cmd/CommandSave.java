package cmd;
import Control.TableController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * save the collection to file .csv
 *
 *
 */

public class CommandSave implements Command {

    @Override
    public void execute(String[] args) {
        if(args != null) {
            try {
                if(!new File(args[0]).exists()){
                    try {
                        if ((new File(args[0]).createNewFile())) {
                            System.out.println("Save file created");
                        } else {
                            System.out.println("Can`t create file.");
                            return;
                        }
                    }
                    catch (IOException e){
                        System.out.println("Illegal Access, try to save with another path.");
                        return;
                    }
                }
                TableController.getCurrentTable().save(new File(args[0]));
                System.out.println("Collection has been saved");
            }
            catch (FileNotFoundException e){
                System.out.println("File not found. Try another path.");
            }
        }
        else{
            try {
                if(!new File("saved.csv").exists()){
                    try {
                        if ((new File("saved.csv").createNewFile())) {
                            System.out.println("Save file created");
                        } else {
                            System.out.println("Can`t create file.");
                            return;
                        }
                    }
                    catch (IOException e){
                        System.out.println("Illegal Access, try to save with another path.");
                        return;
                    }
                }
                TableController.getCurrentTable().save(new File("saved.csv"));
                System.out.println("Collection has been saved");
            }
            catch (FileNotFoundException e){
                System.out.println("Default save file not found. Try to specify path.");
            }
        }
    }

    /**
     * get name of command
     *
     * @return String
     */

    public String toString(){
        return "save";
    }
}
