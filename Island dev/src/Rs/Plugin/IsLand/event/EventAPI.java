package Rs.Plugin.IsLand.event;

import cn.nukkit.event.Cancellable;
import cn.nukkit.event.plugin.PluginEvent;
import cn.nukkit.plugin.Plugin;


public class EventAPI extends PluginEvent implements Cancellable {

    public EventAPI(Plugin plugin){
        super(plugin);
    }
}
