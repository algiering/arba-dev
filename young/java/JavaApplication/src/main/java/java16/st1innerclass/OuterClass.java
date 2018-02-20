package java16.st1innerclass;

public class OuterClass {

    private String secret = "Time is money";

    public OuterClass() {
        InnerClass obj = new InnerClass();
        obj.print();
    }

    private class InnerClass {
        private String insecret = "Show me the money";

        public InnerClass() {
            System.out.println( "내부 클래스 생성자" );
        }

        public void print() {
            System.out.println( secret );
        }

        public InnerClass(String insecret) {
            this.insecret = insecret;
        }
    }
}
