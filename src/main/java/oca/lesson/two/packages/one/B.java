package oca.lesson.two.packages.one;

import oca.lesson.two.packages.two.C;

/**
 * Classes that are in the same package like A and B on package "one", do not have the need of be
 * imported.
 * One time you already need to use a class that are in a different package, in that moment, YOU
 * already need to import it. In this case, class C from package "two".
 */

public class B {

    public B() {
        System.out.println("Hi from B");
    }

    public static void main(String[] args) {
        A a = new A();
        C c = new C();
    }
}
