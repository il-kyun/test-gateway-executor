import org.junit.Test;

public class ControllerTest {


    @Test
    public void test1() {
        String data = "1\r\n2\r\n3";
        RequestData  requestData = new SimpleRequestData(data);
        System.out.println(requestData.getKey());
        PrivacyRequest privacyRequest = new PrivacyRequest(requestData);

    }

    @Test
    public void test2() {
        String data = "placeNo,privacyI\r\n1,111\r\n1,112\r\n2,222\r\n3,333";
        RequestData  requestData = new KeyAndFilterReqeustData(data);
        System.out.println(requestData.getKey());
        System.out.println(requestData.getFilters());
        PrivacyRequest privacyRequest = new PrivacyRequest(requestData);

    }
}
