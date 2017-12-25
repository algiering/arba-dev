package java16.st5controllable;

public class TestVideo {

    public static void main(String[] args) {
        
        VideoPlayer p = new VideoPlayer() {
            
            @Override
            public void play() {
               System.out.println("TestVideo play");
            }
            
            @Override
            public void stop() {
                System.out.println("TestVideo stop");
            }
        };
        
        p.play();
        p.stop();

    }

}
