package org.kiwi.domain;

public class Add {
    private final int a;
    private final int b;
    private int result;

    public Add(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void execute() {
        this.result = a + b;
    }

    public int getResult() {
        return result;
    }
}
