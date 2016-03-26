package Rs.Plugin.World.Commands;

import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public abstract class WorldCommandAPI extends Command implements PluginIdentifiableCommand {
    public WorldMainClass plugin;
    public WorldCommandAPI(String name,WorldMainClass plugin) {
            super(name);
        this.plugin = plugin;
    }
    public WorldMainClass getPlugin(){
        return plugin;
    }
    public String Permission(String per){
        return ("Rs.Command.World."+per);
    }
    public String Description(){
        return WorldMainClass.getRun().getMsg(this.getPermission());
    }
    public String Usage(String usage){
        return ("/"+this.getLabel()+" "+ usage);
    }
}
