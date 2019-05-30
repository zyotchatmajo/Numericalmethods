/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReglaFalsa2;

/**
 *
 * @author Nani
 */
public class Fraction {

     private int numerator, denominator;

     public Fraction(double decimal) {
         String stringNumber = String.valueOf(decimal);
         int numberDigitsDecimals = stringNumber.length() - 1 - stringNumber.indexOf('.');
         int denominator = 1;
         for (int i = 0; i < numberDigitsDecimals; i++) {
             decimal *= 10;
             denominator *= 10;
         }

        int numerator = (int) Math.round(decimal);
        int greatestCommonFactor = greatestCommonFactor(numerator, denominator);
        this.numerator = numerator / greatestCommonFactor;
        this.denominator = denominator / greatestCommonFactor;
     }

     public String toString() {
         return String.valueOf(numerator) + "/" + String.valueOf(denominator);
     }

     public static int greatestCommonFactor(int num, int denom) {
         if (denom == 0) {
             return num;
         }
         return greatestCommonFactor(denom, num % denom);
     }

     public static void main(String[] args) {
         System.out.println(new Fraction(0.75));
     }
 }