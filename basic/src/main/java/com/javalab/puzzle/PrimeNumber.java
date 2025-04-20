package com.javalab.puzzle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//sieveOfEratosthenes methods
public class PrimeNumber {
  private void listAllPrime(int value) {
    List primeList = new ArrayList<>(value / 2);

    List initialList = new ArrayList<>();
    for (int i = 2; i <= value; i++) {
      initialList.add(i);
    }

    //elemination process
    Iterator itr = initialList.iterator();
    while (itr.hasNext()) {
      int current = (int) itr.next();
      if (current == 2) {
        primeList.add(current);
      }


    }

    System.out.println("Initial numbers: " + initialList);
    System.out.println("Prime numbers: " + primeList);
  }

  public static void main(String[] args) {
    new PrimeNumber().listAllPrime(10);
  }
}
