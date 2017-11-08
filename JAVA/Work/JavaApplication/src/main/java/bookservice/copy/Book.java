package bookservice.copy;

public class Book{

    private int bnum = 0;
    private String btitle = "";
    private String bpublisher = "";
    private String bgenre = "";
    private String bwriter = "";
    private String bprice = "";
    private boolean bstatus = false;
    private int bBorrowCusNo = 0;

    public boolean getBstatus() {
        return bstatus;
    }

    public void setBstatus(boolean bstatus) {
        this.bstatus = bstatus;
    }

    public int getbBorrowCusNo() {
        return bBorrowCusNo;
    }

    public void setbBorrowCusNo(int bBorrowCusNo) {
        this.bBorrowCusNo = bBorrowCusNo;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }

    public String getBgenre() {
        return bgenre;
    }

    public void setBgenre(String bgenre) {
        this.bgenre = bgenre;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    public Book() {
        super();
    }

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }

    public Book(int bnum, String btitle, String bpublisher, String bgenre, String bwriter, String bprice,
            boolean bstatus, int bBorrowCusNo) {
        super();
        this.bnum = bnum;
        this.btitle = btitle;
        this.bpublisher = bpublisher;
        this.bgenre = bgenre;
        this.bwriter = bwriter;
        this.bprice = bprice;
        this.bstatus = bstatus;
        this.bBorrowCusNo = bBorrowCusNo;
    }

    @Override
    public String toString() {
        return "Book [bnum=" + bnum + ", btitle=" + btitle + ", bpublisher=" + bpublisher + ", bgenre=" + bgenre
                + ", bwriter=" + bwriter + ", bprice=" + bprice + ", bstatus=" + bstatus + ", bBorrowCusNo="
                + bBorrowCusNo + "]";
    }
}
