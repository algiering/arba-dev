package java17.st2product;

import java.util.Scanner;

public class Tester {

    static Scanner key = new Scanner(System.in);
    static Product[] p = new Product[10];
    static int count = 0;
    static int s = 0;
    static int f = 0;

    public static void main(String[] args) {
        
        inputProduct();

    }

    public static void inputProduct() {

        for (; true;) {
            System.out.print("--------------------------------------\n");
            System.out.println("(1)상품추가, (2)상품검색, (99)종료");
            System.out.print("--------------------------------------\n");
            s = key.nextInt();

            if (s == 1) {

                for (; true;) {
                    System.out.print("--------------------------------------\n");
                    System.out.println("추가 할 상품 종류");
                    System.out.println("(1)책, (2)음악CD, (3)회화책, (99)이전메뉴");
                    System.out.print("--------------------------------------\n");
                    s = key.nextInt();

                    if (s == 99) {
                        break;
                    }

                    else if (count > p.length - 1) {

                        System.out.print("--------------------------------------\n");
                        System.out.println("더 이상 추가 할 수 없습니다.");
                        System.out.print("--------------------------------------\n");

                    }

                    else if (s == 1) {

                        Book b = new Book();

                        System.out.print("책 제목 :");
                        b.bookTitle = key.next();
                        System.out.print("저자 :");
                        b.writer = key.next();
                        System.out.print("ISBN :");
                        b.isbn = key.next();
                        System.out.print("상품 설명 :");
                        b.explain = key.next();
                        System.out.print("생산자 :");
                        b.producer = key.next();
                        System.out.print("가격 :");
                        b.price = key.nextInt();

                        p[count] = b;

                        count = count + 1;

                    }

                    else if (s == 2) {

                        CompactDisc cd = new CompactDisc();

                        System.out.print("앨범 제목 :");
                        cd.albumTitle = key.next();
                        System.out.print("가수 :");
                        cd.singer = key.next();
                        System.out.print("상품 설명 :");
                        cd.explain = key.next();
                        System.out.print("생산자 :");
                        cd.producer = key.next();
                        System.out.print("가격 :");
                        cd.price = key.nextInt();

                        p[count] = cd;

                        count = count + 1;

                    }

                    else if (s == 3) {

                        ConversationBook cb = new ConversationBook();

                        System.out.print("책 제목 :");
                        cb.bookTitle = key.next();
                        System.out.print("저자 :");
                        cb.writer = key.next();
                        System.out.print("ISBN :");
                        cb.isbn = key.next();
                        System.out.print("언어 :");
                        cb.language = key.next();
                        System.out.print("상품 설명 :");
                        cb.explain = key.next();
                        System.out.print("생산자 :");
                        cb.producer = key.next();
                        System.out.print("가격 :");
                        cb.price = key.nextInt();

                        p[count] = cb;

                        count = count + 1;

                    }

                    else {
                        System.out.print("--------------------------------------\n");
                        System.out.println("잘못 입력하셨습니다");
                        System.out.print("--------------------------------------\n");
                    }

                }

            }

            else if (s == 2) {

                for (; true;) {

                    try {
                        for (; true; f = f + 1) {
                            if (p[f] == null) {
                                break;
                            }
                        }
                    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                        f = p.length;
                    } finally {

                    }

                    if (f <= 0) {

                        System.out.print("--------------------------------------\n");
                        System.out.println("상품이 없습니다");
                        System.out.print("--------------------------------------\n");

                        break;
                    }

                    if (f > 0) {

                        System.out.print("--------------------------------------\n");
                        System.out.println("검색할 상품의 ID입력 ( 0 ~ " + (f - 1) + " ), (99)이전메뉴");
                        System.out.print("--------------------------------------\n");
                    }

                    f = 1;

                    s = key.nextInt();

                    if ((s < p.length) && (p[s] != null)) {
                        p[s].PrintProduct();
                    }

                    else if (s == 99) {
                        break;
                    }

                    else {
                        System.out.print("--------------------------------------\n");
                        System.out.println("잘못 입력하셨습니다");
                        System.out.print("--------------------------------------\n");
                    }

                }

            }

            else if (s == 99) {

                System.out.print("--------------------------------------\n");
                System.out.println("종료합니다.");
                System.out.print("--------------------------------------\n");
                break;

            }

            else {
                System.out.print("--------------------------------------\n");
                System.out.println("잘못 입력하셨습니다");
                System.out.print("--------------------------------------\n");
            }

        }

        key.close();

    }

}
