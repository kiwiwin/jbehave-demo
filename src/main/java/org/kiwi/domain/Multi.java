package org.kiwi.domain;

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

    public void execute() {
        this.result = a * b;
    }
}