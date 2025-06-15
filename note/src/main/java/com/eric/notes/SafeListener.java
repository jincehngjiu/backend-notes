//package com.eric.notes;
//
//import com.sun.jdi.event.Event;
//
//import java.util.EventListener;
//
///**
// * <p>
// * TODO
// * </p>
// *
// * @author Eric Jin
// * @since 11/30/24 AM10:48
// */
//public class SafeListener {
//
//    private final EventListener listener;
//
//    private SafeListener() {
//        listener = new EventListener () {
//            public void onEvent (Event event) {
//                doSomething(e);
//            }
//        };
//    }
//    public static SafeListener newInstance(EventSource source) {
//        SafeListener safe = new SafeListener();
//        source.registerListener(safe.listener);
//        return safe;
//    }
//
//}
