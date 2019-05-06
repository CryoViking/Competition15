/**
 * Author: Nathan van der Velde
 * Date Created: 2019-05-07
 */

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Main
{
    //Get Details
    //Confirm Details
    //If Details wrong - repeat
    public static void main(String[] args)
    {
        boolean repeat = true;
        int counter = 0;
        do
        {
            Account newAccount = getDetails();
            repeat = verifyAccount(newAccount);
            counter++;
        }while(repeat && counter < 3);
        if(counter==3)
        {
            out.println("You attempted 3 times to create an Account, process terminating because of to many failed attempts");
        }//ENDIF
    }//END main

    public static boolean verifyAccount(Account account)
    {
        out.println("Are these details correct?\n");
        out.println(account.toString());
        boolean grabConfirmAgain = false;
        char result;
        do
        {
            result = getCharInput("\nYes or No? [y/n]");
            grabConfirmAgain = doRepeat(result);
        }while(grabConfirmAgain);
        return isConfirmed(result);
    }//END verifyAccount

    public static boolean isConfirmed(char subject)
    {
        boolean ret = true;
        switch(subject)
        {
            case 'y': case 'Y':
                ret = false;
                break;
            case 'n': case 'N':
                ret = true;
                break;
        }//END switch
        return ret;
    }//END isConfirmed

    public static boolean doRepeat(char subject)
    {
        switch(subject)
        {
            case 'y': case 'Y': case 'n': case 'N':
                return false;
            default:
                out.println("This char is invalid please input either");
            return true;
        }//END Switch
    }//END doRepeat

    public static Account getDetails()
    {
        String name  = getStringInput("Please input your name: ");
        int age = getIntegerInput("Please enter in your age (greater than 0):");
        String programmingLang = getStringInput("Please enter in your favourite programming language:");
        return new Account(name, age, programmingLang);
    }//END getDetails

    public static String getStringInput(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        out.println(prompt);
        return sc.nextLine();
    }//END getStringInput


    public static char getCharInput(String prompt)
    {
        char ret = ' ';
        boolean invalid = true;
        do
        {
            String result = getStringInput(prompt);
            if(result.length() != 1)
            {
                out.println("Please enter in only one character");
            }
            else
            {
                ret = result.charAt(0);
                invalid = false;
            }
        }while(invalid);
        return ret;
    }//END getCharInput

    public static int getIntegerInput(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        boolean invalid = true;
        int value = 0;
        do
        {
            try
            {
                String num = getStringInput(prompt);
                value = Integer.parseInt(num);
                invalid = false;
            }//END TRY
            catch(NumberFormatException nfex)
            {
                out.println("The input provided was not a valid integer greater than 0");
            }//END CATCH
        }while(invalid && value <= 0);//END DO-WHILE
        return value;
    }//END getIntegerInput
}//END main