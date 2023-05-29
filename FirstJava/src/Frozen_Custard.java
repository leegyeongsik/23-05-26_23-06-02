import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Frozen_Custard implements shuffle {
    String[][] arr = {
            {"바밤바", "6100", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"하드", "6200", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"붕어싸만코", "6300", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"국화빵", "6400", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"아이스크림", "6500", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"}
    };

    @Override
    public String[][] mix() {
        List<String[]> list = Arrays.asList(arr);
        Collections.shuffle(list);

        return arr;
    }
}
