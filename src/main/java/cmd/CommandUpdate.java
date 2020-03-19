package cmd;

import Control.Initislizator;
import Control.TableController;
import Control.TableManager;
import cmd.Command;
import productdata.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandUpdate implements Command {

    @Override
    public void execute(String[] args) {
        for(int i = 0;i<TableController.getCurrentTable().getSize();i++) {

        }
    }

    @Override
    public String toString() {
        return "update id";
    }
}
