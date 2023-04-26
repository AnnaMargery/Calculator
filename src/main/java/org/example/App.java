package org.example;

/* Napisz program, który odczytuje od użytkownika dwie liczby oraz znak działania,
a następnie oblicza i wyświetla wynik.
Program powinien wspierać dodawanie, odejmowanie, mnożenie i dzielenie.
Wynik powinien być przedstawiany w formie A + B = C, np 2 + 2 = 4.
 */

// Dekompozycja zadania i programu:
// 1. Wyswietlic prosbe o podanie dwoch liczb- Scanner
// 2. Odczytac te dwie liczby i przypisac je jako zmienne
// 3. Wyswietlic prosbe o podanie znaku dzialania- scanner i znak "char" - instrukcje war w zaleznosci od podanego znaku- weryfikacja czy uzytkownik podal poprawny znak
// 4. Odczytanie podanego dzialania i odwolanie do konkretnej metody
// 5. Utworzenie metod : dodawania, odejmowania, mnozenia i dzielenia z warunkami
// 6. Utworzenie instrukcji warunkowej, gdy podana liczba to 0, a uzytkownik wybral np dzielenie
// 7. Utworzenie metody prezentacji wyniku.


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        Float numberA = getA();
        Float numberB = getB();
        Character userSign = getSign();
        Float result = calculator(numberA, numberB, userSign);
        String resultMessage = getResult(numberA, numberB, userSign, result);
        displayResult(resultMessage);

    }

    public static Float getA() {
        System.out.println("Enter the first number:");
        Scanner input = new Scanner(System.in);
        Float numberA = input.nextFloat();
        return numberA;
    }

    public static Float getB() {
        System.out.println("Enter the second number:");
        Scanner input = new Scanner(System.in);
        Float numberB = input.nextFloat();
        return numberB;
    }

    public static Character getSign() {
        System.out.println("Enter mathematical operational sign: + , - , * , / ");
        Set<Character> signs = new HashSet<>();

        signs.add('+');
        signs.add('-');
        signs.add('*');
        signs.add('/');

        Scanner input = new Scanner(System.in);
        Character userSign = input.next().charAt(0);
        while (!signs.contains(userSign)) {
            System.out.println("You gave wrong mathematical sign- please choose from: + , - , * , / ");
            userSign = input.next().charAt(0); // we need to repeat this input till we will receive proper sign from the user
        }
        return userSign;
    }

    // method for receiving A parameter -Done
    // method for receiving B parameter -Done
    // method for receiving mathematical sign -Done - i had a problem with creating loop and creating input with character variable

    // Still to do:
    // method for addition, subtraction, multiplication, division-  DONE
    // method for calculating - the best will be switch but i can try also with if, else if condition
    // method for displaying the result


    public static Float addition(Float numberA, Float numberB) {
        return numberA + numberB;
    }

    public static Float subtraction(Float numberA, Float numberB) {
        return numberA - numberB;
    }

    public static Float multiplication(Float numberA, Float numberB) {
        return numberA * numberB;
    }

    public static Float division(Float numberA, Float numberB) {
        if (numberB != 0) {
            return numberA / numberB;
        }
        else {
            System.out.println("You can't divide by 0!, start again");
        }
        return null;
    }

    public static Float calculator(Float numberA, Float numberB, Character userSign) {

        switch (userSign) {
            case ('+'):
                return addition(numberA, numberB);
            case ('-'):
                return subtraction(numberA, numberB);
            case ('*'):
                return multiplication(numberA, numberB);
            case ('/'):
                return division(numberA, numberB);
            default:
                return null;
        }
    }

    public static String getResult(Float numberA, Float numberB, Character userSign, Float result) {
        String resultMessage = numberA + " " + userSign + " " + numberB + " " + "=" + " " + result;
        return resultMessage;
    }

    public static void displayResult(String resultMessage) {
        System.out.println(resultMessage);
    }
}










