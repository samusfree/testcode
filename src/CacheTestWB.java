import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Objects;

public class CacheTestWB {
    public static void main(String[] args) {
        CacheEntity<String, String> cacheObject =
                new CacheEntity<>(3, 3);
        cacheObject.put("1", "1");
        cacheObject.put("2", "2");
        cacheObject.put("3", "3");
        System.out.println(cacheObject);
        cacheObject.get("1");
        cacheObject.put("4", "4");
        System.out.println(cacheObject);
    }
}

class CacheEntity<K, V> {
    private LinkedHashMap<K, CacheValue<V>> map;
    private int max;
    private int minutesToLife;

    public CacheEntity(int size, int minutesToLife) {
        if(size < 1) {
            throw new RuntimeException("Minimum size is 1");
        }

        /*this.map = new LinkedHashMap<> (){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheValue<V>> eldest) {
                return size() > max;
            }
        };*/
        this.map = new LinkedHashMap<>();
        this.max = size;
        this.minutesToLife = minutesToLife;
    }

    public void put(K key, V value) {
        put(key, value, minutesToLife);
    }

    public void put(K key, V value, int minutesToLife) {
        if(Objects.isNull(this.map.get(key)) && max == this.map.size()) {
            remove();
        }
        this.map.put(key, new CacheValue<>(value, minutesToLife));
    }

    @Override
    public String toString() {
        return "CacheEntity{" +
                "map=" + map +
                ", max=" + max +
                ", minutesToLife=" + minutesToLife +
                '}';
    }

    public V get(K key) {
        CacheValue<V> value = this.map.get(key);
        value.updateHits();
        return value.value;
    }

    private void remove() {
        K keyToRemove = this.map.entrySet().stream().min((o1, o2) -> {
             return o1.getValue().numberOfHits - o2.getValue().numberOfHits;
        }).get().getKey();
        map.remove(keyToRemove);
    }
}

class CacheValue<V> {
    V value;
    int numberOfHits;
    LocalDateTime lastAccesedTime;
    LocalDateTime expirationTime;

    public CacheValue(V value, int minutesToLife) {
        this.value = value;
        this.numberOfHits = 0;
        this.expirationTime = LocalDateTime.now().plusMinutes(minutesToLife);
    }

    public void updateHits() {
        this.lastAccesedTime = LocalDateTime.now();
        this.numberOfHits++;
    }

    @Override
    public String toString() {
        return "CacheValue{" +
                "value=" + value +
                ", numberOfHits=" + numberOfHits +
                ", lastAccesedTime=" + lastAccesedTime +
                ", expirationTime=" + expirationTime +
                '}';
    }
}