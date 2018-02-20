package java17.st2product;

import java.util.Scanner;

public class TestTemp {

    static Scanner keyboard = new Scanner(System.in);
    static int roomid = 0;
    
    public static void main(String[] args) {
        
        // int[] prods = new int[10] ;
        Product[] prods = new Product[10] ;
      
        for( ; true ; ) {
            
            // 상품 추가 메뉴 출력
            System.out.println("상품추가(1), 상품조회(2), 종료(3)");
            int action = keyboard.nextInt();
            
            if( action == 1 ){ // 상품 입력 
                상품입력(prods);
            }
            else if( action ==2 ){ // 상품 출력
                상품출력(prods);                
            }
            else if( action==3){
                break;               
            }
            else {
                System.out.println("잘못된 입력");
            }
        }        
    }

    private static void 상품출력(Product[] prods) {
        // 출력
        for( int i=0; i<=prods.length-1; i=i+1 ){
            System.out.println( prods[i].toString() );
        }
    }

    // 상품 종류 입력 받아 배열에 저장하는 코드를 추가.
    private static void 상품입력(Product[] prods) {
        
        // 상품 추가 메뉴 출력
        System.out.println("상품 종류 책(1), 음악CD(2), 회화책(3)");
        int menu = keyboard.nextInt();
        
        if( menu == 1){
            Book book = new Book();
            System.out.println("상품 설명 >>");   book.set상품설명( keyboard.next() );
            System.out.println("생산자    >>");   book.set생산자  ( keyboard.next() );
            System.out.println("가격      >>");   book.set가격    ( keyboard.next() );
            System.out.println("책제목    >>");   book.set책제목  ( keyboard.next() );
            System.out.println("저자      >>");   book.set저자    ( keyboard.next() );
            System.out.println("ISBN번호  >>");   book.setISBN번호( keyboard.next() );
            
            prods[roomid] = book;
            roomid = roomid + 1;
        }
        else if( menu == 2){
            CompactDisc cd = new CompactDisc();
            System.out.println("상품 설명 >>");   cd.set상품설명( keyboard.next() );
            System.out.println("생산자    >>");   cd.set생산자  ( keyboard.next() );  
            System.out.println("가격      >>");   cd.set가격    ( keyboard.next() );   
            System.out.println("앨범제목  >>");   cd.set앨범제목( keyboard.next() );   
            System.out.println("가수이름  >>");   cd.set가수이름( keyboard.next() );             
            
            prods[roomid] = cd;
            roomid = roomid + 1;
        }
        else if( menu == 3){
            ConversationBook cbook = new ConversationBook();
            System.out.println("상품 설명 >>");   cbook.set상품설명( keyboard.next() );
            System.out.println("생산자    >>");   cbook.set생산자  ( keyboard.next() );  
            System.out.println("가격      >>");   cbook.set가격    ( keyboard.next() ); 
            System.out.println("책제목    >>");   cbook.set책제목  ( keyboard.next() );
            System.out.println("저자      >>");   cbook.set저자    ( keyboard.next() );
            System.out.println("ISBN번호  >>");   cbook.setISBN번호( keyboard.next() );
            System.out.println("언어      >>");   cbook.set언어    ( keyboard.next() );
            
            prods[roomid] = cbook;
            roomid = roomid + 1;
        }
        else {
            System.out.println("올바른 값이 아닙니다. 1,2,3 만 가능합니다.");
        }        
        
    }
    
}
