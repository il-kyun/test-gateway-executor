import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlacePhoneTestClient extends TestClient<PlacePhone>{
    @Override
    public List<PlacePhone> execute(Set<Long> req) {
        List<PlacePhone> list = new ArrayList();
        PlacePhone p1 = new PlacePhone(1, 111, 01011111111);
        PlacePhone p12 = new PlacePhone(1, 112, 01011111112);
        PlacePhone p2 = new PlacePhone(2, 111, 01011111121);
        PlacePhone p22 = new PlacePhone(2, 112, 01011111122);

        list.add(p1);
        list.add(p12);
        list.add(p2);
        list.add(p22);
        return list;
    }
}
