package bookmanager.model;

import java.sql.Date;

public class ModelBook {
    
    private Integer bookindex = null;
    private String  bookname  = null;
    private String  writter   = null;
    private String  publisher = null;
    private String  isbn      = null;
    private Date    pdate     = null;

    public Integer getBookindex() {
        return bookindex;
    }

    public void setBookindex(Integer bookindex) {
        this.bookindex = bookindex;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "ModelBook [bookindex=" + bookindex + ", bookname=" + bookname + ", writter=" + writter + ", publisher="
                + publisher + ", isbn=" + isbn + ", pdate=" + pdate + "]";
    }

    public ModelBook(Integer bookindex, String bookname, String writter, String publisher, String isbn, Date pdate) {
        super();
        this.bookindex = bookindex;
        this.bookname = bookname;
        this.writter = writter;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pdate = pdate;
    }

    public ModelBook() {
        super();
    }

}
