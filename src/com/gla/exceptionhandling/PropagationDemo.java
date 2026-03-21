package com.gla.exceptionhandling;
public class PropagationDemo {

    // 1. The source of the error
    public static void method1() {
        // This will throw an ArithmeticException
        int result = 10 / 0;
        System.out.println("This will never print.");
    }

    // 2. The middleman (Propagator)
    public static void method2() {
        // method2 calls method1 but doesn't handle the error
        method1();
    }

    public static void main(String[] args) {
        try {
            // 3. The caller (Handler)
            // main calls method2, which calls method1
            method2();
        } catch (ArithmeticException e) {
            // The exception "bubbled up" all the way to this block
            System.out.println("Handled exception in main");
        }
    }
}
