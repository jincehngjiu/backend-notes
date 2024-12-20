package com.eric.notes.multithreading.监视器模式;

import javax.annotation.concurrent.GuardedBy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * =线程安全的前提是MutablePoint不可变的
 * </p>
 *
 * @author Eric Jin
 * @since 2024/12/16 14:57
 */
public class MonitorVehicletracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;

    public MonitorVehicletracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getlocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getlocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }


    public synchronized void setlocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null)
            throw new RuntimeException("No such ID: " + id);
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }

}
