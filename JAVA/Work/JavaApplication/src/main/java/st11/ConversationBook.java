package st11;


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
    return "언어 : "+language+"\n"+super.toString();
    }

}

