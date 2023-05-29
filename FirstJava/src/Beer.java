import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Beer implements shuffle{
    String[][] arr = {
            {"카스", "6100" , "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"하이트", "6200" , "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"곰표맥주", "6300" , "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"아사히", "6400" , "토마토, 양상추, 쉑소스가 토핑된 치즈버거"},
            {"맥주", "6500" , "토마토, 양상추, 쉑소스가 토핑된 치즈버거"}
    };


    public String [][] mix(){
        List<String[]> list =  Arrays.asList(arr);
        Collections.shuffle(list);
        return arr;

    }
}
