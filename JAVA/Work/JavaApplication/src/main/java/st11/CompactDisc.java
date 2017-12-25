package st11;


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
    return "앨범 제목 : "+albumTitle+"\n"+"가수 이름 : "+ singer+"\n"+ super.toString();
    }
    
}

