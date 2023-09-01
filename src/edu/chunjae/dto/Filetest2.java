package edu.chunjae.dto;

public class Filetest2 {
    private String uname;
    private String subject;
    private String content;
    private String filename1 = "noimg.jpg";
    private String filename2 = "noimg.jpg";
    private String filename3 = "noimg.jpg";

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename1() {
        return filename1;
    }

    public void setFilename1(String filename1) {
        this.filename1 = filename1;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename3() {
        return filename3;
    }

    public void setFilename3(String filename3) {
        this.filename3 = filename3;
    }

    @Override
    public String toString() {
        return "Filetest2{" +
                "uname='" + uname + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", filename1='" + filename1 + '\'' +
                ", filename2='" + filename2 + '\'' +
                ", filename3='" + filename3 + '\'' +
                '}';
    }
}
