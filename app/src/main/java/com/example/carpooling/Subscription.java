package com.example.carpooling;

public class Subscription {
    public String sub;
    public String unsub;
    public String prec;

    public Subscription(String sub, String unsub, String prec) {
        this.sub = sub;
        this.unsub = unsub;
        this.prec = prec;
    }

    public Subscription() {
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "sub='" + sub + '\'' +
                ", unsub='" + unsub + '\'' +
                ", prec='" + prec + '\'' +
                '}';
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getUnsub() {
        return unsub;
    }

    public void setUnsub(String unsub) {
        this.unsub = unsub;
    }

    public String getPrec() {
        return prec;
    }

    public void setPrec(String prec) {
        this.prec = prec;
    }

}
