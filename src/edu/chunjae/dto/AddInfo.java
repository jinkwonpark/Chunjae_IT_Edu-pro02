package edu.chunjae.dto;
//상품 부가 정보
public class AddInfo {
    private int ano;        //콘텐츠 번호
    private int pno;        //해당 상품번호
    private String title;   //콘텐츠 제목
    private String movie;   //콘텐츠 url
    private String resdate; //콘텐츠 등록일

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return "AddInfo{" +
                "ano=" + ano +
                ", pno=" + pno +
                ", title='" + title + '\'' +
                ", movie='" + movie + '\'' +
                ", resdate='" + resdate + '\'' +
                '}';
    }
}
