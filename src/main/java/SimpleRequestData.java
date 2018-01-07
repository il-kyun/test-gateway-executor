import java.util.*;

public class SimpleRequestData implements RequestData {
    private Set<Long> keys;
    public SimpleRequestData(String data) {
        //\r\n & \r -> \n
        String[] split = data.split("\r\n");
        keys = new HashSet(Arrays.asList(split));
    }

    @Override
    public Optional<Set<Long>> getKey() {
        return Optional.ofNullable(keys);
    }

    @Override
    public Optional<Map<Long, Map<String, Long>>> getFilters() {
        return Optional.ofNullable(Collections.EMPTY_MAP);
    }
}
