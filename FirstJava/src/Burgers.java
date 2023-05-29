import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Burgers implements shuffle {
    String[][] arr = {
            {"불고기버거", "2300", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"치즈버거", "3300", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"더블불고기버거", "4500", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"애그불고기버거", "5500", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"햄버거", "6500", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"}
    };

    @Override
    public String[][] mix() {
        List<String[]> list = Arrays.asList(arr);
        Collections.shuffle(list);
        return arr;
    }
}
