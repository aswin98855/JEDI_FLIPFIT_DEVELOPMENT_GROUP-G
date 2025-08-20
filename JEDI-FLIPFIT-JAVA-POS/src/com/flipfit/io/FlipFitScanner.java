package com.flipfit.io;
import com.flipfit.client.ApplicationClient;

import java.util.Scanner;

public class FlipFitScanner {
    public static void main(String args[]) {
        ApplicationClient applicationClient = new ApplicationClient();
        final Scanner in = new Scanner(System.in);
        System.out.println("Welcome to flip fit application\n");

        while(true){
            System.out.println("Menu for operation:");
            System.out.println("1. Login");
            System.out.println("2. Register as Customer");
            System.out.println("3. Register as Owner");
            System.out.println("4. Exit");
            int op = in.nextInt();
            switch(op){
                case 1: applicationClient.login();
                    break;
                case 2: applicationClient.registerCustomer();
                    break;
                case 3: applicationClient.registerOwner();
                    break;
                case 4: System.out.println("Application exited");
                    System.exit(0);
            }
        }
    }

}
