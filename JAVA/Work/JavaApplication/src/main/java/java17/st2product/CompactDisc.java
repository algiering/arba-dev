package java17.st2product;

public class CompactDisc extends Product {

    protected String albumTitle = "";
    protected String singer = "";

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public CompactDisc() {
        super();
    }

    @Override
    public String toString() {
        return "CompactDisc [albumTitle=" + albumTitle + ", singer=" + singer + ", toString()=" + super.toString()
                + "]";
    }
    
    @Override
    public void PrintProduct() {

        System.out.print("------------------------\n");
        System.out.println("상품 ID :" + id);
        System.out.println("설명 :" + explain);
        System.out.println("생산자 :" + producer);
        System.out.println("앨범 제목 :" + albumTitle);
        System.out.println("가수 :" + singer);
        System.out.println("가격 :" + price);
        System.out.print("------------------------\n");

    }

}
