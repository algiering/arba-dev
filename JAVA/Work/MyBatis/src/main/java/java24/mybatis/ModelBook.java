package java24.mybatis;

import java.util.Date;

public class ModelBook {

    private Integer bookid    = 0; 
    private String  bookname  = "";
    private String  publisher = "";
    private String  year      = "";
    private Integer price     = 0;
    private Date    dtm       = null;
    private Boolean use_yn    = null;
    private Integer authid    = 0;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDtm() {
        return dtm;
    }

    public void setDtm(Date dtm) {
        this.dtm = dtm;
    }

    public boolean isUse_yn() {
        return use_yn;
    }

    public void setUse_yn(Boolean use_yn) {
        this.use_yn = use_yn;
    }

    public int getAuthid() {
        return authid;
    }

    public void setAuthid(int authid) {
        this.authid = authid;
    }

    @Override
    public String toString() {
        return "ModelBook [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" + publisher + ", year=" + year
                + ", price=" + price + ", dtm=" + dtm + ", use_yn=" + use_yn + ", authid=" + authid + "]";
    }

    public ModelBook() {
        super();
    }

    public ModelBook(int bookid, String bookname, String publisher, String year, int price, Date dtm, boolean use_yn,
            int authid) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.dtm = dtm;
        this.use_yn = use_yn;
        this.authid = authid;
    }

}
