package com.flipfit.io;

import java.util.Scanner;

public class FlipFitScanner {
    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int getInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public static double getDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine());
    }
}
