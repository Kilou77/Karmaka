package com.lo02.Karmaka;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Main main;
    private String name;

    public static Main getInstance(){
        if(null == main){
            main = new Main();
        }
        return main;
    }

    public static void main(String[] args) {

    }
}