package oca.lesson.two.packages.two;

import oca.lesson.two.packages.one.A;

/**
 * Classes that are in the same package like A and B on package "one", do not have the need of be
 * imported.
 * One time you already need to use a class that are in a different package, in that moment, YOU
 * already need to import it. In this case, class A and B from package "one".
 */

public class C {

    public C() {
        System.out.println("Hi from C");
    }

    public static void main(String[] args) {
        A a = new A();
        oca.lesson.two.packages.one.B b = new oca.lesson.two.packages.one.B();
    }
}
