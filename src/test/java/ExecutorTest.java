import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ExecutorTest {
    @Test
    public void name() {
        String data = "1\r\n2\r\n3";
        RequestData requestData = new SimpleRequestData(data);
        PrivacyRequest privacyRequest = new PrivacyRequest(requestData);
        TestClient<Member> client = new TestClient<Member>();
//        BiFunction<PrivacyRequest, List<Member>, List<Member>> biFunction = (r, l) -> {
//            l.stream().filter( m -> m.)
//
//        };

        PrivacyExecutor privacyExecutor = new PrivacyExecutor(privacyRequest, client, null);

    }

    @Test
    public void name1() {
//        String data = "placeNo,id\r\n1,111\r\n1,112\r\n2,222\r\n3,333";
        String data = "placeNo,id\r\n1,111\r\n2,112";
        RequestData  requestData = new KeyAndFilterReqeustData(data);
        PrivacyRequest privacyRequest = new PrivacyRequest(requestData);
        TestClient<PlacePhone> client = new PlacePhoneTestClient();
        BiFunction<PrivacyRequest, List<PlacePhone>, List<PlacePhone>> biFunction = (r, l) -> {
            Map<Long, Map<String, Long>> filters = r.getFilters();
            return l.stream().filter( p -> check(filters.get(p.getPlaceNo()), p)).collect(Collectors.toList());
        };

        PrivacyExecutor<PlacePhone> privacyExecutor = new PrivacyExecutor<>(privacyRequest, client, biFunction);
        List<PlacePhone> result = privacyExecutor.execute();
        System.out.println(result);

    }

    private boolean check(Map<String, Long> filters, PlacePhone p){
        boolean rtn = true;

        for(Map.Entry<String, Long> e : filters.entrySet()){
            try {
                Field declaredField = p.getClass().getDeclaredField(e.getKey());
                declaredField.setAccessible(true);
                 if(declaredField.getLong(p) != e.getValue()){
                     rtn = false;
                     break;
                 }
            } catch (NoSuchFieldException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

        return rtn;

    }
}
