
import java.util.*;

/**
 * Created by Jiqing on 2016/11/27.
 */
public class MapTest {
    public static void main(String[] args) {
        // Map��ͬ��List������key��һ��������
        Map map = new HashMap();
        map.put("���Java����",109);
        map.put("���iOS����",10);
        map.put("���Ajax����",79);

        // ����µ�value������ԭ�е�value���÷������ر����ǵ�value
        System.out.println(map.put("���iOS����",99)); // ���10
        System.out.println(map);

        // �ж��Ƿ����ָ��key
        System.out.println("�Ƿ����ֵΪ���iOS����key��"+map.containsKey("���iOS����"));
        System.out.println("�Ƿ����ֵΪ99 value��"+map.containsValue(99));

        // ����map
        for (Object key : map.keySet()) {
            System.out.println(key+"-->"+map.get(key));
        }

    }
}