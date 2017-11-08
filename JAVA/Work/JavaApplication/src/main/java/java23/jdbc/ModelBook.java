package java23.jdbc;

import java.util.Date;

public class ModelBook {
    private Integer bookid    = null;
    private String  bookname  = "";
    private String  publisher = "";
    private String  genre     = "";
    private String  writer    = "";
    private Integer price     = null;
    private Date    dtm       = null;
    private Boolean use_yn    = null;
    private Integer authid    = null;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDtm() {
        return dtm;
    }

    public void setDtm(Date dtm) {
        this.dtm = dtm;
    }

    public boolean getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(Boolean use_yn) {
        this.use_yn = use_yn;
    }

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    @Override
    public String toString() {
        return "ModelBook [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", genre="
                + genre + ", writer=" + writer + ", price=" + price + ", dtm=" + dtm + ", use_yn=" + use_yn
                + ", authid=" + authid + "]";
    }

    public ModelBook(Integer bookid, String bookname, String publisher, String genre, String writer, Integer price,
            Date dtm, Boolean use_yn, Integer authid) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.genre = genre;
        this.writer = writer;
        this.price = price;
        this.dtm = dtm;
        this.use_yn = use_yn;
        this.authid = authid;
    }

    public ModelBook() {
        super();
    }

}
