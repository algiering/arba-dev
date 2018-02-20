package java17.st2product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProduct {

    public static void main(String[] args) {

        Product[] list = new Product[10];
        
        int index = 0;

        Scanner keyboard  = new Scanner(System.in);
        int 고유식별자 = 0;
        String 상품설명   = "";
        String 생산자     = "";
        String 가격       = "";
        String ISBN번호   = "";
        String 저자       = "";
        String 책제목     = "";
        String 언어       = "";
        String 앨범제목   = "";
        String 가수이름   = "";

        for( ; true ; ) {

            System.out.print("상품 추가(1), 모든 상품 조회(2), 끝내기(3) >>");

            int select = keyboard.nextInt();

            if( select ==1 ) {
                System.out.print("상품 종류 책(1), CD(2), 회화책(3) >>");
                select = keyboard.nextInt();


                고유식별자   = index ;
                System.out.print("상품 설명 >>");
                상품설명   = keyboard.next();
                System.out.print("생산자 >>");
                생산자     = keyboard.next();
                System.out.print("가격 >>");
                가격   = keyboard.next();

                if( select ==1 ) {
                    System.out.print("책제목 >>");
                    책제목     = keyboard.next();
                    System.out.print("저자 >>");
                    저자       = keyboard.next();
                    System.out.print("ISBN번호 >>");
                    ISBN번호   = keyboard.next();

                    Book book = new Book(고유식별자, 상품설명, 생산자, 가격, ISBN번호, 저자, 책제목);
                    list[index] =  book;
                    
                    // 배열에서 사용할 index 증가.
                    index = index + 1;
                }
                else if( select == 2) {
                    System.out.print("앨범제목 >>");
                    앨범제목       = keyboard.next();
                    System.out.print("가수이름 >>");
                    가수이름     = keyboard.next();

                    CompactDisc disc = new CompactDisc( 고유식별자, 상품설명, 생산자, 가격, 앨범제목, 가수이름);
                    list[index] = disc ;
                    
                    // 배열에서 사용할 index 증가.
                    index = index + 1;
                }
                else if( select == 3) {
                    System.out.print("책제목 >>");
                    책제목     = keyboard.next();
                    System.out.print("저자 >>");
                    저자       = keyboard.next();

                    System.out.print("언어 >>");
                    언어     = keyboard.next();

                    System.out.print("ISBN번호 >>");
                    ISBN번호   = keyboard.next();

                    ConversationBook book = new ConversationBook( 고유식별자, 상품설명, 생산자, 가격, ISBN번호, 저자, 책제목, 언어);
                    list[index] = book;
                    
                    // 배열에서 사용할 index 증가.
                    index = index + 1;
                }
                else {
                    System.out.println("올바른 값이 아닙니다");
                }

            }
            else if( select == 2) {

                for( Product obj : list ){
                     obj.printValue();
                }
            }
            else if( select == 3) {
                break;
            }
            else {
                System.out.println("올바른 값이 아닙니다");
            }
        }
    }
}
