package com.javalab.concurrency.virtual;

public class VirtualThread {
  public static void main(String[] args) {
    System.out.println("Virtual thread example");

    doVirtual();
  }

  private static void doVirtual() {
    System.out.println("Enters doVirtual()");
  }
}
