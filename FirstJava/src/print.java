import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class print extends order {
    static String[][] total_menu = new String[4][2]; // 전체메뉴카테고리
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

    print() { // 각 메뉴배열 초기화

        menu_create(new Beer());
        menu_create(new Frozen_Custard());
        menu_create(new Drinks());
        menu_create(new Burgers());
        menu_create(new menu());

    }

    static void menu_create(shuffle i) { // 메뉴 셔플해주고 변수 초기화
        String[][] a = i.mix();
        if (i instanceof Beer) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[j].length; k++) {
                    String b = a[j][k];
                    Beer[j][k] = b;
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

    void get_menu_category() { // 카테고리 출력
        System.out.println("\"BURGER 에 오신걸 환영합니다.\" ");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 보고싶은 카테고리이름을 입력해주세요 ) .");
        System.out.println();
        System.out.println("[ Burger MENU ]");
        for (int i = 0; i < print.total_menu.length; i++) {
            int num = i + 1;
            System.out.println(num + "." + " " + total_menu[i][0] + "|" + total_menu[i][1]);
        }
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        int number = print.total_menu.length;
        for (int i = 0; i < confirmation_Cancel.length; i++) {
            number += 1;
            System.out.println(number + "." + " " + confirmation_Cancel[i][0] + "|" + confirmation_Cancel[i][1]);
        }

        Scanner sc = new Scanner(System.in);
        String selected_menu = sc.nextLine();
        if (selected_menu.equals("Beer")) {
            String temps =  get_menu_Beer();
            set_basket(temps);
        } else if (selected_menu.equals("Burgers")) {
            String temps = get_menu_Burgers();
            set_basket(temps);
        } else if (selected_menu.equals("Frozen Custard")) {
            String temps = get_menu_Frozen_Custard();
            set_basket(temps);
        } else if (selected_menu.equals("Drinks")) {
            String temps = get_menu_Drinks();
            set_basket(temps);
        } else if (selected_menu.equals("Order")) {
            get_set_menu_Order();
        } else if (selected_menu.equals("Cancel")) {
            set_menu_Cancel();
        } else if (selected_menu.equals("0")) {
            get_total_sell();
        } else {
            System.out.println("없다");
            get_menu_category();

        }
    }

    String get_menu_Beer() { // beer 카테고리 출력
        get_menu(print.Beer);
        String temp=get_menus(Beer);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        option_confirmation_Cancel();
        return temp;
    }

     String get_menu_Burgers() { // burger 카테고리출력
         get_menu(print.Burgers);
         String temp=get_menus(Burgers);
         System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
         option_confirmation_Cancel();
         return temp;
    }

    String get_menu_Drinks() { //drinks 출력
        get_menu(print.Drink);
        String temp=get_menus(Drink);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        option_confirmation_Cancel();
        return temp;
    }

    String get_menu_Frozen_Custard() { // frozen custard 출력
        get_menu(print.Frozen_Custard);
        String temp=get_menus(Frozen_Custard);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        option_confirmation_Cancel();
        return temp;
    }

    void get_set_menu_Order() { // 장바구니에 있는거 출력하고 주문을 누르면 판매내역에 추가
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        int total_price = 0;
        for (int i = 0; i < basket.size(); i++) {
            System.out.println(basket.get(i) + "|" + " " + basket_num.get(i) + "개" + " " + "|" + " " + basket_price.get(i) + "원" + " " + "|" + basket_summary.get(i));
            total_price += basket_price.get(i);
        }
        System.out.println();
        System.out.println("[Total]");
        System.out.println(total_price + "원");
        option_order();
        Scanner sc_select_option = new Scanner(System.in);
        String menu = sc_select_option.nextLine();
        if (menu.equals("1")) {
            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 [ 1 ] 번 입니다.");
            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
            total_W += total_price;
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

    }

    void set_menu_Cancel() { // cancel 을 입력하면 다시 메뉴판으로 이동하고 장바구니에 있던것이 다 사라짐
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        option_confirmation_Cancel();
        Scanner sc_option = new Scanner(System.in);
        String menu = sc_option.nextLine();
        if (menu.equals("1")) {
            basket.clear();
            basket_num.clear();
            basket_original_price.clear();
            basket_price.clear();
            basket_summary.clear();
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
            get_menu_category();
        } else if (menu.equals("2")) {
            get_menu_category();
        }
    }

    void get_total_sell() { // 총 판매금액과 총 판매내역 출력
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은" + " " + "[" + " " + total_W + "원" + " " + "]" + " " + "입니다.");
        System.out.println();
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        System.out.println();
        for (int i = 0; i < total_sell.size(); i++) {
            System.out.println("-" + " " + total_sell.get(i) + "|" + " " + total_sell_price.get(i) + "원");
        }
        System.out.println();
        System.out.println("1. 돌아가기");
        Scanner sc_select_Frozen_Custard_option = new Scanner(System.in);
        String returns = sc_select_Frozen_Custard_option.nextLine();
        if (returns.equals("1")) {
            get_menu_category();
        } else {
            get_menu_category();
        }
    }

    void get_menu(String[][] selected_menu) { // 매개변수에 맞는 메뉴 출력
        for (int i = 0; i < selected_menu.length; i++) {
            int num = i + 1;
            System.out.println(num + "." + " " + selected_menu[i][0] + "|" + selected_menu[i][1]);
        }
    }
    String get_menus(String[][] selected_menu) {
        Scanner sc_select_beer = new Scanner(System.in);
        String menu = sc_select_beer.nextLine();
        for (int i = 0; i < selected_menu.length; i++) {
            if (selected_menu[i][0].equals(menu)) {
                if (basket.contains(selected_menu[i][0])) {
                    for (int j = 0; j < basket.size(); j++) {
                        if (basket.elementAt(j).equals(selected_menu[i][0])) {
                            basket_num.set(j, basket_num.get(j) + 1);
                            Integer temp_price = Integer.parseInt(selected_menu[i][1]);
                            basket_price.set(j, basket_num.get(j) * temp_price);
                            System.out.println(selected_menu[i][0] + "|" + selected_menu[i][1]);
                        }
                    }
                } else {
                    System.out.println(selected_menu[i][0] + "|" + selected_menu[i][1]);
                    basket.add(selected_menu[i][0]);
                    basket_num.add(1);
                    Integer temp_price = Integer.parseInt(selected_menu[i][1]);
                    basket_price.add(temp_price);
                    basket_summary.add(selected_menu[i][2]);
                    basket_original_price.add(temp_price);
                }
            }
        }
        return menu;
        }
    void option_confirmation_Cancel () { // 확인 , 취소 출력
        for (int i = 0; i < confirmation_Cancel_second.length; i++) {
            int num = i + 1;
            System.out.print(num + "." + " " + confirmation_Cancel_second[i]);
            System.out.print(" ");
            System.out.print(" ");
            System.out.print(" ");
        }
    }
    void set_basket (String selected_menu){ // 장바구니에 선택한 메뉴 추가
        Scanner sc_select_Burgers_option = new Scanner(System.in);
        String menus = sc_select_Burgers_option.nextLine();
        if (menus.equals("1")) {
            for (int i = 0; i < basket.size(); i++) {
                if (basket.elementAt(i).equals(selected_menu)) {
                    System.out.println(basket.elementAt(i) + " " + "가 장바구니에 추가되었습니다");
                    get_menu_category();
                }
            }
        } else {
            for (int i = 0; i < basket.size(); i++) {
                if (basket.elementAt(i).equals(selected_menu)) {
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
    }
    void option_order(){ // 주문 , 메뉴판 출력
        for (int i = 0; i < option_order.length; i++) {
            int num = i + 1;
            System.out.print(num + "." + " " + option_order[i]);
            System.out.print(" ");
            System.out.print(" ");
            System.out.print(" ");
        }
    }

}

