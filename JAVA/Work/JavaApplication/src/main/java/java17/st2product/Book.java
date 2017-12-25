package java17.st2product;

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
        return "Book [isbn=" + isbn + ", writer=" + writer + ", bookTitle=" + bookTitle + ", toString()="
                + super.toString() + "]";
    }
    
    @Override
    public void PrintProduct() {

        System.out.print("------------------------\n");
        System.out.println("상품 ID :" + id);
        System.out.println("설명 :" + explain);
        System.out.println("생산자 :" + producer);
        System.out.println("ISBN :" + isbn);
        System.out.println("책 제목 :" + bookTitle);
        System.out.println("저자 :" + writer);
        System.out.println("가격 :" + price);
        System.out.print("------------------------\n");

    }
}
