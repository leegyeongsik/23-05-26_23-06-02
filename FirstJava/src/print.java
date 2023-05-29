
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class print extends order {
    static String[][] total_menu = new String[4][2]; // 전체메뉴카테고리 # 재사용성 별로 5개변수 전부
    static String[][] Burgers = new String[5][3]; // 햄버거의 종류
    static String[][] Frozen_Custard = new String[5][3]; // 아이스크림 종류
    static String[][] Drink = new String[5][3]; // 음류 종류
    static String[][] Beer = new String[5][3]; // 맥주 종류
    Stack<String> basket = new Stack<>(); // 장바구니
    Stack<Integer> basket_num = new Stack<>(); // 장바구니_상품개수
    Stack<String> basket_summary = new Stack<>(); // 장바구니_상품정보
    Stack<Integer> basket_price = new Stack<>(); // 장바구니_상품가격
    Stack<Integer> basket_original_price = new Stack<>(); // 장바구니_상품기본가격
    int total_W; // 총 판매한 금액
    List<String> total_sell = new ArrayList<>();//판매완료한 상품 리스트
    List<Integer> total_sell_price = new ArrayList<>();//판매완료한 상품가격
    String selected_menu; // 입력 임시로 넣어놓을 변수

    print() { // 각 메뉴배열 초기화

        menu_create(new Beer());
        menu_create(new Frozen_Custard());
        menu_create(new Drinks());
        menu_create(new Burgers());
        menu_create(new menu());

    }
    static void menu_create(shuffle i) { // 메뉴 셔플해주고 변수 초기화
        String[][] a =i.mix();
        if (i instanceof Beer) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    String b =a[j][k];
                    Beer[j][k] =b;
                }
            }
        } else if (i instanceof Burgers) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    Burgers[j][k] = a[j][k];
                }
            }
        } else if (i instanceof Drinks) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    Drink[j][k] = a[j][k];
                }
            }
        } else if (i instanceof Frozen_Custard) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    Frozen_Custard[j][k] = a[j][k];
                }
            }
        } else if (i instanceof menu) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    total_menu[j][k] = a[j][k];
                }
            }

        }
    }
    void  get_menu_category(){
        System.out.println("\"BURGER 에 오신걸 환영합니다.\" ");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 보고싶은 카테고리이름을 입력해주세요 ) .");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < print.total_menu.length; i++) {
            int num = i+1;
            System.out.println(num +"."+ " " + total_menu[i][0] + "|" + total_menu[i][1]);
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        int nums =print.total_menu.length;
        for (int i = 0; i < confirmation_Cancel.length; i++) {
            nums+=1;
            System.out.println(nums+"."+" "+ confirmation_Cancel[i][0] + "|" + confirmation_Cancel[i][1]);
        }
        Scanner sc = new Scanner(System.in);
        selected_menu = sc.nextLine();
        get_menes(selected_menu);
    }
    void get_menu(String[][] selected_menu){
        for (int i = 0; i < selected_menu.length; i++) {
            int num = i+1;
            System.out.println(num +"."+ " " + selected_menu[i][0] + "|" + selected_menu[i][1]);
        }
    }
    void get_menes(String menu) {
        if (menu.equals("Beer")) {
            get_menu(print.Beer);
            Scanner sc_select_beer = new Scanner(System.in);
            menu = sc_select_beer.nextLine();
            String temp_menu = menu;

            for (int i = 0; i < Beer.length; i++) {
                if (Beer[i][0].equals(menu)) {
                    if (basket.contains(Beer[i][0])) {
                        for (int j = 0; j < basket.size(); j++) {
                            if (basket.elementAt(j).equals(Beer[i][0])) {
                                basket_num.set(j, basket_num.get(j) + 1);
                                Integer temp_price = Integer.parseInt(Beer[i][1]);
                                basket_price.set(j, basket_num.get(j) * temp_price);
                                System.out.println(Beer[i][0] + "|" + Beer[i][1]);
                            }
                        }
                    } else {
                        System.out.println(Beer[i][0] + "|" + Beer[i][1]);
                        basket.add(Beer[i][0]);
                        basket_num.add(1);
                        Integer temp_price = Integer.parseInt(Beer[i][1]);
                        basket_price.add(temp_price);
                        basket_summary.add(Beer[i][2]);
                        basket_original_price.add(temp_price);
                    }
                }
            }
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            for (int i = 0; i < confirmation_Cancel_second.length; i++) {
                int num = i + 1;
                System.out.print(num + "." + " " + confirmation_Cancel_second[i]);
                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            }
            Scanner sc_select_beer_option = new Scanner(System.in);
            menu = sc_select_beer_option.nextLine();
            if (menu.equals("1")) {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        System.out.println(basket.elementAt(i) + " " + "가 장바구니에 추가되었습니다");
                        get_menu_category();
                    }
                }
            } else {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        if (basket_num.get(i) > 1) {
                            basket_num.set(i, basket_num.get(i) - 1);
                            basket_price.set(i, basket_price.get(i) - basket_original_price.get(i));
                            break;
                        } else if (basket_num.get(i).equals(1)) {
                            basket.remove(i);
                            basket_num.remove(i);
                            basket_price.remove(i);
                            basket_summary.remove(i);
                            basket_original_price.remove(i);
                            break;

                        }
                    }
                }
                get_menu_category();
            }
            //--------------------------------------------------- Beer

        } else if (menu.equals("Frozen Custard")) {
            get_menu(print.Frozen_Custard);
            Scanner sc_select_Frozen_Custard = new Scanner(System.in);
            menu = sc_select_Frozen_Custard.nextLine();
            String temp_menu = menu;
            for (int i = 0; i < Frozen_Custard.length; i++) {
                if (Frozen_Custard[i][0].equals(menu)) {
                    if (basket.contains(Frozen_Custard[i][0])) {
                        for (int j = 0; j < basket.size(); j++) {
                            if (basket.elementAt(j).equals(Frozen_Custard[i][0])) {
                                basket_num.set(j, basket_num.get(j) + 1);
                                Integer temp_price = Integer.parseInt(Frozen_Custard[i][1]);
                                basket_price.set(j, basket_num.get(j) * temp_price);

                                System.out.println(Frozen_Custard[i][0] + "|" + Frozen_Custard[i][1]);
                            }
                        }
                    } else {
                        System.out.println(Frozen_Custard[i][0] + "|" + Frozen_Custard[i][1]);
                        basket.add(Frozen_Custard[i][0]);
                        basket_num.add(1);
                        Integer temp_price = Integer.parseInt(Frozen_Custard[i][1]);
                        basket_price.add(temp_price);
                        basket_summary.add(Frozen_Custard[i][2]);
                        basket_original_price.add(temp_price);

                    }
                }
            }
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            for (int i = 0; i < confirmation_Cancel_second.length; i++) {
                int num = i + 1;
                System.out.print(num + "." + " " + confirmation_Cancel_second[i]);
                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            }
            Scanner sc_select_Frozen_Custard_option = new Scanner(System.in);
            menu = sc_select_Frozen_Custard_option.nextLine();
            if (menu.equals("1")) {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        System.out.println(basket.elementAt(i) + " " + "가 장바구니에 추가되었습니다");
                        get_menu_category();
                    }
                }
            } else {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        if (basket_num.get(i) > 1) {
                            basket_num.set(i, basket_num.get(i) - 1);
                            basket_price.set(i, basket_price.get(i) - basket_original_price.get(i));
                            break;
                        } else if (basket_num.get(i) == 1) {
                            basket.remove(i);
                            basket_num.remove(i);
                            basket_price.remove(i);
                            basket_summary.remove(i);
                            basket_original_price.remove(i);
                            break;

                        }
                    }
                }
                get_menu_category();
            }
            //--------------------------------------------------- Frozen Custard

        } else if (menu.equals("Drinks")) {
            get_menu(print.Drink);
            Scanner sc_select_Drink = new Scanner(System.in);
            menu = sc_select_Drink.nextLine();
            String temp_menu = menu;
            for (int i = 0; i < Drink.length; i++) {
                if (Drink[i][0].equals(menu)) {
                    if (basket.contains(Drink[i][0])) {
                        for (int j = 0; j < basket.size(); j++) {
                            if (basket.elementAt(j).equals(Drink[i][0])) {
                                basket_num.set(j, basket_num.get(j) + 1);
                                Integer temp_price = Integer.parseInt(Drink[i][1]);
                                basket_price.set(j, basket_num.get(j) * temp_price); // 사칙연산은 BigDecimal 쓰는걸로

                                System.out.println(Drink[i][0] + "|" + Drink[i][1]);
                            }
                        }
                    } else {
                        System.out.println(Drink[i][0] + "|" + Drink[i][1]);
                        basket.add(Drink[i][0]);
                        basket_num.add(1);
                        Integer temp_price = Integer.parseInt(Drink[i][1]);
                        basket_price.add(temp_price);
                        basket_summary.add(Drink[i][2]);
                        basket_original_price.add(temp_price);

                    }
                }
            }
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            for (int i = 0; i < confirmation_Cancel_second.length; i++) {
                int num = i + 1;
                System.out.print(num + "." + " " + confirmation_Cancel_second[i]);
                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            }
            Scanner sc_select_Drinks_option = new Scanner(System.in);
            menu = sc_select_Drinks_option.nextLine();
            if (menu.equals("1")) {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        System.out.println(basket.elementAt(i) + " " + "가 장바구니에 추가되었습니다");
                        get_menu_category();
                    }
                }
            } else {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        if (basket_num.get(i) > 1) {
                            basket_num.set(i, basket_num.get(i) - 1);
                            basket_price.set(i, basket_price.get(i) - basket_original_price.get(i));
                            break;
                        } else if (basket_num.get(i) == 1) {
                            basket.remove(i);
                            basket_num.remove(i);
                            basket_price.remove(i);
                            basket_summary.remove(i);
                            basket_original_price.remove(i);
                            break;

                        }
                    }
                }
                get_menu_category();
            }
            //--------------------------------------------------- Drinks

        } else if (menu.equals("Burgers")) {
            get_menu(print.Burgers);
            Scanner sc_select_Burgers = new Scanner(System.in);
            menu = sc_select_Burgers.nextLine();
            String temp_menu = menu;
            for (int i = 0; i < Burgers.length; i++) {
                if (Burgers[i][0].equals(menu)) {
                    if (basket.contains(Burgers[i][0])) {
                        for (int j = 0; j < basket.size(); j++) {
                            if (basket.elementAt(j).equals(Burgers[i][0])) {
                                basket_num.set(j, basket_num.get(j) + 1);
                                Integer temp_price = Integer.parseInt(Burgers[i][1]);
                                basket_price.set(j, basket_num.get(j) * temp_price);

                                System.out.println(Burgers[i][0] + "|" + Burgers[i][1]);
                            }
                        }
                    } else {
                        System.out.println(Burgers[i][0] + "|" + Burgers[i][1]);
                        basket.add(Burgers[i][0]);
                        basket_num.add(1);
                        Integer temp_price = Integer.parseInt(Burgers[i][1]);
                        basket_price.add(temp_price);
                        basket_summary.add(Burgers[i][2]);
                        basket_original_price.add(temp_price);
                    }
                }
            }
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            for (int i = 0; i < confirmation_Cancel_second.length; i++) {
                int num = i + 1;
                System.out.print(num + "." + " " + confirmation_Cancel_second[i]);
                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            }
            Scanner sc_select_Burgers_option = new Scanner(System.in);
            menu = sc_select_Burgers_option.nextLine();
            if (menu.equals("1")) {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        System.out.println(basket.elementAt(i) + " " + "가 장바구니에 추가되었습니다");
                        get_menu_category();
                    }
                }
            } else {
                for (int i = 0; i < basket.size(); i++) {
                    if (basket.elementAt(i).equals(temp_menu)) {
                        if (basket_num.get(i) > 1) {
                            basket_num.set(i, basket_num.get(i) - 1);
                            basket_price.set(i, basket_price.get(i) - basket_original_price.get(i));

                            break;
                        } else if (basket_num.get(i) == 1) {
                            basket.remove(i);
                            basket_num.remove(i);
                            basket_price.remove(i);
                            basket_summary.remove(i);
                            basket_original_price.remove(i);
                            break;

                        }
                    }
                }
                get_menu_category();
            }
            //--------------------------------------------------- Burgers


        } else if (menu.equals("Order")) {
            System.out.println("아래와 같이 주문 하시겠습니까?");
            System.out.println();
            System.out.println("[ Orders ]");
            int total_price = 0;
            for (int i = 0; i < basket.size(); i++) { // 이 부분 수정 4개밖에 출력못함 그리고 basket[i] 가 포함되어있다면으로 그리고 먄약에 고른게 5 5 5 5 5 라면 하나만 출력가능
                System.out.println(basket.get(i) + "|" + " " + basket_num.get(i) + "개" + " " + "|" + " " + basket_price.get(i) + "원" + " " + "|" + basket_summary.get(i));
                total_price += basket_price.get(i);
//                if (basket.contains(Burgers[i][0]) || basket.contains(Drink[i][0]) || basket.contains(Frozen_Custard[i][0]) || basket.contains(Beer[i][0])){
//                    if (basket.contains(Burgers[i][0])){
//                        System.out.println(Burgers[i][0] + "|" + Burgers[i][1] + "|" + basket_num.elementAt(basket.indexOf(Burgers[i][0])) + "개");
//                        System.out.println(basket);
//                    } else if ((basket.contains(Drink[i][0]))) {
//                        System.out.println(Drink[i][0] + "|" + Drink[i][1] + "|" + basket_num.elementAt(basket.indexOf(Drink[i][0]))+ "개");
//                        System.out.println(basket);
//                    } else if ((basket.contains(Frozen_Custard[i][0]))) {
//                        System.out.println(Frozen_Custard[i][0] + "|" + Frozen_Custard[i][1] + "|" + basket_num.elementAt(basket.indexOf(Frozen_Custard[i][0]))+ "개");
//                    } else if ((basket.contains(Beer[i][0]))) {
////                        basket_num.elementAt(basket.indexOf("Beer[i][0]"))
//                        System.out.println(Beer[i][0] + "|" + Beer[i][1] + "|" + basket_num.elementAt(basket.indexOf(Beer[i][0])) + "개");
//                    }
            }
            System.out.println();
            System.out.println("[Total]");
            System.out.println(total_price + "원");
            for (int i = 0; i < option_order.length; i++) {
                int num = i + 1;
                System.out.print(num + "." + " " + option_order[i]);
                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            }
            Scanner sc_select_option = new Scanner(System.in);
            menu = sc_select_option.nextLine();
            if (menu.equals("1")) {
                System.out.println("주문이 완료되었습니다!");
                System.out.println();
                System.out.println("대기번호는 [ 1 ] 번 입니다.");
                System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
                total_W += total_price;
                // 리스트 구현 2차원 [0][1][0][2]
                for (int i = 0; i < basket.size(); i++) {
                    for (int j = 0; j < basket_num.get(i); j++) {
                        total_sell.add(basket.get(i));
                        total_sell_price.add(basket_original_price.get(i));
                    }
                }
                basket.clear();
                basket_num.clear();
                basket_original_price.clear();
                basket_summary.clear();
                basket_price.clear();
                try {
                    Thread.sleep(3000); //1초 대기
                } catch (InterruptedException e) {

                    e.printStackTrace();

                } finally {
                    get_menu_category();
                }
            } else {
                get_menu_category();
            }


            //--------------------------------------------------- Order
        } else if ((menu.equals("Cancel"))) {
            System.out.println("진행하던 주문을 취소하시겠습니까?");
            for (int i = 0; i < confirmation_Cancel_second.length; i++) {
                int num = i + 1;
                System.out.print(num + "." + " " + confirmation_Cancel_second[i]);
                System.out.print(" ");
                System.out.print(" ");
                System.out.print(" ");
            }
            Scanner sc_option = new Scanner(System.in);
            menu = sc_option.nextLine();
            if (menu.equals("1")) {
                basket.clear();
                basket_num.clear();
                System.out.println("진행하던 주문이 취소되었습니다.");
                System.out.println();
                get_menu_category();
            } else if (menu.equals("2")) {
                get_menu_category();
            }
            //--------------------------------------------------- Cancel
        } else if (menu.equals("0")) {
            System.out.println("[ 총 판매금액 현황 ]");
            System.out.println("현재까지 총 판매된 금액은" + " " + "[" + " " + total_W + "원" + " " + "]" + " " + "입니다.");
            System.out.println();
            System.out.println("[ 총 판매상품 목록 현황 ]");
            System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
            System.out.println();
            for (int i = 0; i < total_sell.size(); i++) {
                System.out.println("-" + " " + total_sell.get(i) + "|" + " " + total_sell_price.get(i)+"원");
            }
            System.out.println();
            System.out.println("1. 돌아가기");
            Scanner sc_select_Frozen_Custard_option = new Scanner(System.in);
            String returns = sc_select_Frozen_Custard_option.nextLine();
            if (returns.equals("1")){
                get_menu_category();
            } else{
                get_menu_category();
            }



        } else {
            {
                System.out.println("없다");
                get_menu_category();
            }
        }
    }

}


