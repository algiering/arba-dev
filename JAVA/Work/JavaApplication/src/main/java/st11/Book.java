package st11;


public class Book extends Product {
    
    protected String isbn = "";
    protected String writer = "";
    protected String bookTitle = "";
    
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public Book() {
        super();
    }
    @Override
    public String toString() {
    return "ISBN : "+isbn+"\n"+"저자 : "+writer+"\n"+"책 제목 : "+bookTitle+"\n"
    +super.toString();
    }
    
    

}

