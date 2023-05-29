import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class menu implements shuffle{
    String[][] arr = {
            {"Burgers", "앵거스 비프 통살을 다져만든 버거"},
            {"Frozen Custard", "매장에서 신선하게 만드는 아이스크림"},
            {"Drinks", "매장에서 신선하게 만드는 아이스크림"},
            {"Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"}
    };
    public String [][] mix() {
        List<String[]> list = Arrays.asList(arr);
        Collections.shuffle(list);
        return arr;
    }
}
