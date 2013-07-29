package org.kiwi.steps;

public class Multi {
    private int a;
    private int b;
    private int result;

    public Multi(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getResult() {
        return result;
    }

    void execute() {
        this.result = a * b;
    }
}