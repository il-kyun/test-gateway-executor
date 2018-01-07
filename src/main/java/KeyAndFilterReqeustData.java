import java.util.*;

public class KeyAndFilterReqeustData implements RequestData {

    private Set<Long> keys;
    private Map<Long, Map<String, Long>> filters = new HashMap<>();

    public KeyAndFilterReqeustData(String data) {
        List<String> filterOrder = new ArrayList<>();
        String[] split = data.split("\r\n");


        List<String> stringList = Arrays.asList(split);
        String header = stringList.get(0);
        List<String> body = stringList.subList(1, stringList.size());

        String[] headers = header.split(",");

        for (String s : headers) {
            filterOrder.add(s);
        }

        for (String s : body) {
            String[] split1 = s.split(",");
            // id,pid,oid
            // 1,112,1233
            Map<String, Long> map = new HashMap<>();
            for (int i = 0; i < split1.length; i++) {
                map.put(filterOrder.get(i), Long.valueOf(split1[i]));
            }
            filters.put(Long.valueOf(split1[0]), map);
        }

        keys = filters.keySet();


    }

    @Override
    public Optional<Set<Long>> getKey() {
        return Optional.of(keys);
    }

    @Override
    public Optional<Map<Long, Map<String, Long>>> getFilters() {
        return Optional.ofNullable(filters);
    }
}
