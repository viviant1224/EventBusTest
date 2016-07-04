package constraintlayout.test.test.viviant.eventbustest.manager;

//import de.greenrobot.event.EventBus;//2.4

import org.greenrobot.eventbus.EventBus;//3.0

/**
 * @创建者 ：viviant
 * @时间 ：2016/06/28  13:47
 * @描述 : 事件总线管理
 */
public class EventBusManager {

    private static EventBusManager busManager;
    private EventBus globalEventBus;

    private EventBusManager() {
    }

    public EventBus getGlobaEventBus() {
        if (globalEventBus == null) {
            globalEventBus = new EventBus();
        }
        return globalEventBus;
    }

    public static EventBusManager getInstance() {
        if (busManager == null) {
            synchronized (EventBusManager.class) {
                if (busManager == null) {
                    busManager = new EventBusManager();
                }
            }
        }
        return busManager;
    }
}
