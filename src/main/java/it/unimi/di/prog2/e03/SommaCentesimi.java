/*

Copyright 2025 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e03;

import java.util.Scanner;

/** Classe per la somma di importi in centesimi. */
public class SommaCentesimi {

  /** Costruttore privato per impedire l'istanziazione. */
  private SommaCentesimi() {}

  /**
   * Scrivere il metodo main che legga dal flusso di ingresso un elenco di importi in euro e
   * centesimi (uno per riga, con la parte decimale separata dalla parte intera da un punto) e ne
   * emetta nel flusso d'uscita la somma.
   */

  public static void main(String[] args) {
    int totalEuro = 0;
    int totalCents = 0;
    String result = new String();

    try (Scanner sc = new Scanner(System.in)) {
      while (sc.hasNext()) {
        String nextValue = sc.next();
        
        // parsing a monetary value (e.g. 3.52)
        if (nextValue.contains(".")){
          int dotIndex = nextValue.indexOf(".");

          totalEuro += Integer.parseInt(nextValue.substring(0, dotIndex));
          totalCents += Integer.parseInt(nextValue.substring(dotIndex + 1));
        }

        // if cents is greater than 100, convert the exceeding value in euro
        if (totalCents > 100){
          totalEuro += totalCents / 100;
          totalCents %= 100;
        }

        // add the dot at the string
        result = totalEuro + ".";

        // if cents are less than 10, add a 0 to the resulting string
        if (totalCents < 10){
         result += "0";
        }

        result += totalCents;
        System.out.println(result);
      }
    }
  }
}
