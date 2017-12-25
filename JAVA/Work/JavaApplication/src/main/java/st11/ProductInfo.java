package st11;

import java.util.Scanner;

public class ProductInfo {

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        String s = "";
        int i = 0;

        Product[] ap = new Product[10];

        for (; true;) {

            System.out.print("상품 추가(1), 모든 상품 조회(2), 끝내기(3) :");
            s = key.next();
            System.out.println();

            if (s.equals("1")) {

                for (; true;) {

                    System.out.print("상품종류 : 책(1), 음악CD(2), 회화책(3), 전단계로(z):");
                    s = key.next();
                    System.out.println();

                    if (i > 9) {
                        System.out.println("더 이상 추가 할 수 없습니다.");
                        break;
                    }

                    else if (s.equals("1")) {

                        Product p = new Book();

                        System.out.print("ISBN :");
                        ((Book) p).isbn = key.next();

                        System.out.print("저자 :");
                        ((Book) p).writer = key.next();

                        System.out.print("책 이름 :");
                        ((Book) p).bookTitle = key.next();

                        System.out.print("상품 설명 :");
                        p.explain = key.next();

                        System.out.print("생산자 :");
                        p.producer = key.next();

                        System.out.print("가격 :");
                        p.price = key.nextInt();

                        System.out.println();

                        p.type = 1;

                        ap[i] = p;

                        i = i + 1;
                    }

                    else if (s.equals("2")) {

                        Product p = new CompactDisc();

                        System.out.print("앨범 제목 :");
                        ((CompactDisc) p).albumTitle = key.next();

                        System.out.print("가수 :");
                        ((CompactDisc) p).singer = key.next();

                        System.out.print("상품 설명 :");
                        p.explain = key.next();

                        System.out.print("생산자 :");
                        p.producer = key.next();

                        System.out.print("가격 :");
                        p.price = key.nextInt();

                        System.out.println();

                        p.type = 2;

                        ap[i] = p;

                        i = i + 1;
                    }

                    else if (s.equals("3")) {

                        Product p = new ConversationBook();

                        System.out.print("ISBN :");
                        ((ConversationBook) p).isbn = key.next();

                        System.out.print("저자 :");
                        ((ConversationBook) p).writer = key.next();

                        System.out.print("책 제목 :");
                        ((ConversationBook) p).bookTitle = key.next();

                        System.out.print("언어 :");
                        ((ConversationBook) p).language = key.next();

                        System.out.print("상품 설명 :");
                        p.explain = key.next();

                        System.out.print("생산자 :");
                        p.producer = key.next();

                        System.out.print("가격 :");
                        p.price = key.nextInt();

                        System.out.println();

                        p.type = 3;

                        ap[i] = p;

                        i = i + 1;
                    }

                    else if (s.equals("z") || s.equals("Z")) {
                        break;
                    }

                    else {
                        System.out.println("잘못 입력하셨습니다.");
                    }
                }
            }

            else if (s.equals("2")) {

                for (; true;) {

                    System.out.print("상품 ID (0~9) (전단계:Z) :");
                    s = key.next();

                    try {

                        if (ap[Integer.valueOf(s)].getType() == 1) {

                            System.out.println("상품 ID : " + ap[Integer.valueOf(s)].getId());
                            System.out.println("상품 설명 : " + ap[Integer.valueOf(s)].getExplain());
                            System.out.println("가격 : " + ap[Integer.valueOf(s)].getPrice());
                            System.out.println("생산자 : " + ap[Integer.valueOf(s)].getProducer());
                            System.out.println("책 제목 : " + (((Book) ap[Integer.valueOf(s)]).getBookTitle()));
                            System.out.println("ISBN : " + (((Book) ap[Integer.valueOf(s)]).getIsbn()));
                            System.out.println("저자 : " + (((Book) ap[Integer.valueOf(s)]).getWriter()));
                            System.out.println();

                        }

                        else if (ap[Integer.valueOf(s)].getType() == 2) {

                            System.out.println("상품 ID : " + ap[Integer.valueOf(s)].getId());
                            System.out.println("상품 설명 : " + ap[Integer.valueOf(s)].getExplain());
                            System.out.println("가격 : " + ap[Integer.valueOf(s)].getPrice());
                            System.out.println("생산자 : " + ap[Integer.valueOf(s)].getProducer());
                            System.out.println("앨범 제목 : " + (((CompactDisc) ap[Integer.valueOf(s)]).getAlbumTitle()));
                            System.out.println("가수 : " + (((CompactDisc) ap[Integer.valueOf(s)]).getSinger()));
                            System.out.println();

                        }

                        else if (ap[Integer.valueOf(s)].getType() == 3) {

                            System.out.println("상품 ID : " + ap[Integer.valueOf(s)].getId());
                            System.out.println("상품 설명 : " + ap[Integer.valueOf(s)].getExplain());
                            System.out.println("가격 : " + ap[Integer.valueOf(s)].getPrice());
                            System.out.println("생산자 : " + ap[Integer.valueOf(s)].getProducer());
                            System.out.println("책 제목 : " + (((Book) ap[Integer.valueOf(s)]).getBookTitle()));
                            System.out.println("ISBN : " + (((Book) ap[Integer.valueOf(s)]).getIsbn()));
                            System.out.println("저자 : " + (((Book) ap[Integer.valueOf(s)]).getWriter()));
                            System.out.println("언어 : " + (((ConversationBook) ap[Integer.valueOf(s)]).getLanguage()));
                            System.out.println();

                        }

                        else if (s.equals("z") || s.equals("Z")) {
                            break;
                        }

                        else {
                            System.out.println("해당 ID의 상품이 없습니다.");
                            System.out.println();
                        }
                    }

                    catch (java.lang.NullPointerException e) {

                        System.out.println("해당 ID의 상품이 없습니다.");

                        System.out.println();

                    }

                    catch (java.lang.NumberFormatException e) {

                        System.out.println("해당 ID의 상품이 없습니다.");

                        System.out.println();

                    }

                    catch (java.lang.ArrayIndexOutOfBoundsException e) {

                        System.out.println("해당 ID의 상품이 없습니다.");

                        System.out.println();

                    }

                    finally {

                        if (s.equals("z") || s.equals("Z")) {
                            break;
                        }

                    }
                }
            }

            else if (s.equals("3")) {

                System.out.println("종료합니다.");
                break;
            }

            else {

                System.out.println("잘못 입력하셨습니다.");
                System.out.println();
            }
        }

        key.close();
    }
}
