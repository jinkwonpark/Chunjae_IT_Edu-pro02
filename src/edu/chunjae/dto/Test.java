package edu.chunjae.dto;

public class Test {
    private int no;
    private String name;
    private int point;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "{" +
                "no:" + no +
                ", name:'" + name + '\'' +
                ", point:" + point +
                '}';
    }
}
