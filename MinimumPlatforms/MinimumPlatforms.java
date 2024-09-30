package MinimumPlatforms;

import java.util.TreeMap;

public class MinimumPlatforms {
    public TreeMap<Integer, Integer> map = new TreeMap<>();
    public int max = 1;

    public int findPlatform(int arr[], int dep[]) {
        for (var i = 0; i < arr.length; i++) {
            var start = getMinutes(arr[i]);
            var end = getMinutes(dep[i]) + 1;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        var count = 0;
        for (var value : map.values()) {
            count += value;
            max = Math.max(max, count);
        }
        return max;
    }

    public int getMinutes(int time) {
        var p = 0;
        var m = 0;
        while (time != 0 && p < 2) {
            var d = time % 10;
            m += d * (int) Math.pow(10, p);
            time = time / 10;
            p++;
        }
        m += time * 60;
        return m;
    }
}