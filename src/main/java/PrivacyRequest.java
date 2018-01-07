import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PrivacyRequest {

    private RequestData requestData;

    public PrivacyRequest(RequestData requestData) {


        this.requestData = requestData;
    }
    public Set<Long> getKey(){
        return requestData.getKey().get();
    }

    public Map<Long, Map<String, Long>> getFilters(){
        return requestData.getFilters().get();
    }


}
