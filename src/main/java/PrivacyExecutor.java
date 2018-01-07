import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public class PrivacyExecutor<O> {
    private final PrivacyRequest privacyRequest;

    //client <I,O>
    private final TestClient<O> testClient;
    //filter<Filter,List<O>,List<O>>
    private final BiFunction<PrivacyRequest, List<O>, List<O>> filter;

    public PrivacyExecutor(PrivacyRequest privacyRequest, TestClient<O> testClient, BiFunction<PrivacyRequest, List<O>, List<O>> filter) {
        this.privacyRequest = privacyRequest;
        this.testClient = testClient;
        this.filter = filter;
    }


    public List<O> execute(){
        List<O> execute = testClient.execute(privacyRequest.getKey());

        List<O> os = filter.apply(privacyRequest, execute);

        return os;
    }




}
