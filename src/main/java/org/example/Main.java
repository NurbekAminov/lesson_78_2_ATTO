package org.example;

import org.example.Controller.MenuController;
import org.example.DBInit.DBInit;

public class Main {
    public static void main(String[] args) {
        DBInit.createTableProfile();
        DBInit.createTableCard();
        DBInit.createTableTerminal();
        // DBInit.createTableTransaction();
//       DBInit.createAdmin();
        MenuController menuController = new MenuController();
        menuController.start();

    }
}