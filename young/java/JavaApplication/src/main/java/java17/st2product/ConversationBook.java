package java17.st2product;

public class ConversationBook extends Book {

    private String 언어;

    public String get언어() {
        return 언어;
    }

    public void set언어(String 언어) {
        this.언어 = 언어;
    }

    @Override
    public String toString() {
        return "CoversationBook{" +
                "언어='" + 언어 + '\'' +
                "} " + super.toString();
    }

    public ConversationBook() {
        super();
    }

    public ConversationBook(int 고유식별자, String 상품설명, String 생산자, String 가격, String ISBN번호, String 저자, String 책제목, String 언어) {
        super(고유식별자, 상품설명, 생산자, 가격, ISBN번호, 저자, 책제목);
        this.언어 = 언어;
    }

    @Override
    protected void printValue() {
        super.printValue();

        System.out.println("언어=" + 언어);
    }
}
