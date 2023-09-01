package edu.chunjae.dto;

public class Review {
    private int rno;    //(auto)댓글 번호
    private int sno;
    private String cid;
    private String content;
    private int star;
    private String resdate;

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rno=" + rno +
                ", sno=" + sno +
                ", cid='" + cid + '\'' +
                ", content='" + content + '\'' +
                ", star=" + star +
                ", resdate='" + resdate + '\'' +
                '}';
    }
}
