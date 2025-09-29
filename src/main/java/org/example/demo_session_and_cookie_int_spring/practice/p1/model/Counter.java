package org.example.demo_session_and_cookie_int_spring.practice.p1.model;

public class Counter {
    private int count;

    public Counter() {}

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }
}
