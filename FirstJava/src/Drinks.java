import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Drinks implements shuffle {
    String[][] arr = {
            {"콜라", "6100", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"사이다", "6200", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"환타", "6300", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"우유", "6400", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"음료", "6500", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"}
    };

    @Override
    public String[][] mix() {
        List<String[]> list = Arrays.asList(arr);
        Collections.shuffle(list);

        return arr;
    }
}