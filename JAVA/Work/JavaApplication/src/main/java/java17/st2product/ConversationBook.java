package java17.st2product;

public class ConversationBook extends Book {

    protected String language = "";

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ConversationBook() {
        super();
    }

    @Override
    public String toString() {
        return "ConversationBook [language=" + language + ", toString()=" + super.toString() + "]";
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
        System.out.println("언어 :" + language);
        System.out.println("가격 :" + price);
        System.out.print("------------------------\n");

    }
}
