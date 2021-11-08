package com.example.freemeal2;

public class ListViewApply {
    private String apply;

    public ListViewApply(String apply) {
        this.apply = apply;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    @Override
    public String toString() {
        return "ListViewApply{" +
                "apply_name='" + apply + '\'' +
                '}';
    }
}
