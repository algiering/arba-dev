package st11;

import java.util.Scanner;

public class BookTest {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        int x = 0;
        int i = 0;

        Product[] p = new Product[10];

        for (; true;) {

            System.out.print("상품 추가(1), 상품 검색(2), 종료(3) :");
            x = key.nextInt();

            if (x == 1) {

                for (; true;) {

                    System.out.println("추가 할 상품 종류");
                    System.out.print("책(1), 음악CD(2), 회화책(3), 이전메뉴(99) :");
                    x = key.nextInt();

                    if (i > 9) {

                        System.out.println("더 이상 추가 할 수 없습니다.");
                        break;

                    }

                    else if (x == 1) {
                        Book b = new Book();

                        b.id = i;

                        System.out.print("책 제목 : ");
                        b.bookTitle = key.next();

                        System.out.print("상품 설명 : ");
                        b.explain = key.next();

                        System.out.print("ISBN : ");
                        b.isbn = key.next();

                        System.out.print("생산자 : ");
                        b.producer = key.next();

                        System.out.print("저자 : ");
                        b.writer = key.next();

                        System.out.print("가격 : ");
                        b.price = key.nextInt();

                        p[b.id] = b;

                        i = i + 1;

                    }

                    else if (x == 2) {
                        CompactDisc cd = new CompactDisc();

                        cd.id = i;

                        System.out.print("앨범 제목 : ");
                        cd.albumTitle = key.next();

                        System.out.print("상품 설명 : ");
                        cd.explain = key.next();

                        System.out.print("생산자 : ");
                        cd.producer = key.next();

                        System.out.print("가수 이름 : ");
                        cd.singer = key.next();

                        System.out.print("가격 : ");
                        cd.price = key.nextInt();

                        p[cd.id] = cd;

                        i = i + 1;
                    }

                    else if (x == 3) {
                        ConversationBook cb = new ConversationBook();

                        cb.id = i;

                        System.out.print("책 제목 : ");
                        cb.bookTitle = key.next();

                        System.out.print("상품 설명 : ");
                        cb.explain = key.next();

                        System.out.print("ISBN : ");
                        cb.isbn = key.next();

                        System.out.print("생산자 : ");
                        cb.producer = key.next();

                        System.out.print("저자 : ");
                        cb.writer = key.next();

                        System.out.print("가격 : ");
                        cb.price = key.nextInt();

                        p[cb.id] = cb;

                        i = i + 1;
                    }

                    else if (x == 99) {
                        break;
                    }

                    else {
                        System.out.println("잘못 입력하셨습니다.");
                    }

                }

            }

            else if (x == 2) {

                for (; true;) {

                    System.out.print("검색 할 상품의 ID (이전메뉴:99):");
                    x = key.nextInt();

                    if (x == 99) {
                        break;
                    }

                    else if ((p[x] != null) && (x < p.length)) {
                        System.out.println(p[x].toString());
                    }

                    else {
                        System.out.println("잘못 입력하셨습니다.");
                    }
                }

            }

            else if (x == 3) {
                System.out.println("종료합니다.");
                break;
            }

            else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}