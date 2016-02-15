package Rs.Plugin.Function.Event;

import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.plugin.PluginEvent;
import cn.nukkit.plugin.Plugin;


public class EventAPI extends PluginEvent implements Cancellable {

    public EventAPI(Plugin plugin){
        super(plugin);
    }
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }
}