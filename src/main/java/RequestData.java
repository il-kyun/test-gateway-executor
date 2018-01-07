import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface RequestData {
    Optional<Set<Long>> getKey();

    Optional<Map<Long, Map<String, Long>>> getFilters();
}
