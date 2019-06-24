package net.iliabvf.fixedFifoCollection;

import java.util.LinkedList;
import java.util.Scanner;

public class FixedFifoCollection {

    static final String WELCOME_STRING =  "FixedFifoCollection by Budeanu Vasile. v.1.0";
    static final String INPUT_STRING =  "Enter integer number or (Q - quit, A - add, S - change collection size): ";
    static final String INPUT_STRING_A =  "Enter integer number to add: ";
    static final String ERROR_NUM_DIGITS_STRING =  "Error: Please enter integer number (ex.1).";
    static final String ARRAY_STRING = "Array values: ARRAY";
    static final String ADDED_STRING = "Item ADDEDNUM added.";
    static final String INPUT_STRING_F = "Enter integer number for new size: ";
    static final String NEW_SIZE_STRING = "New size set to NEWSIZE.";

    static private Scanner scanner = new Scanner(System.in);

    static String userInput(String message){
        System.out.println();
        System.out.print(message);
        try {
            return scanner.nextLine();
        } catch (Exception e)
        {
            return "";
        }
    }

    static Integer validateInput(String input, String mode){
        if (mode.toUpperCase().equals("")) {
            if (input.toUpperCase().equals("Q") || input.toUpperCase().equals("A") || input.toUpperCase().equals("S")) {
                return 0;
            }
        }

        if (input.length() == 0) {
            System.out.println(ERROR_NUM_DIGITS_STRING);
            return 0;
        }

        try {
            return Integer.parseInt(input);
        } catch (Exception e){
            System.out.println(ERROR_NUM_DIGITS_STRING);
            return 0;
        }

    }

    public static void main(String[] args){
        String input = "";
        int inputResult = 0;
        LinkedList<Integer> intList = new LinkedList<Integer>();
        int maxSize = 16;

        // main cycle
        while (true) {
            input = userInput(INPUT_STRING);
            inputResult = validateInput(input, "");

            if (input.toUpperCase().equals("Q")) {
                return;

            } else if (input.toUpperCase().equals("A")) { // Add operation

                while (true) {
                    input = userInput(INPUT_STRING_A);
                    inputResult = validateInput(input, "A");
                    if (inputResult == 0){
                        continue;
                    }

                    if(intList.size() < maxSize)
                        intList.add(inputResult);
                    else
                    {
                        intList.removeFirst();
                        intList.add(inputResult);
                    }

                    System.out.println(ADDED_STRING.replace("ADDEDNUM", String.valueOf(inputResult)));
                    System.out.println(ARRAY_STRING.replace("ARRAY", intList.toString()));
                    break;
                }

            } else if (input.toUpperCase().equals("S")) { // Change size operation

                while (true) {
                    input = userInput(INPUT_STRING_F);
                    inputResult = validateInput(input, "S");
                    if (inputResult == 0){
                        continue;
                    }

                    maxSize = inputResult;

                    System.out.println(NEW_SIZE_STRING.replace("NEWSIZE", String.valueOf(inputResult)));

                    break;
                }


            } else if (inputResult == 0) {
                continue;

            }

        }

    }
}
