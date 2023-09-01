package edu.chunjae.dto;
//카테고리
public class Category {
    //A:초등교과서, B:초등참고서, C:초등문제집, D:초등기타
    //E:중등교과서, F:중등참고서, G:중등문제집, H:중등기타
    //I:고등교과서, J:고등참고서, K:고등문제집, L:고등기타
    //M:일반교과서, N:일반참고서, O:일반문제집, P:일반기타
    //Q:유아콘텐츠, R:유아놀이, S:유아기타
    //T:해외서적,  U:해외콘텐츠
    private String cno;
    private String cname;   //카테고리명

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                '}';
    }
}
