package Rs.Plugin.Land.Commands;

import Rs.Plugin.Land.LandMainClass;
import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public abstract class LandCommandAPI extends Command implements PluginIdentifiableCommand {
    public Plugin plugin;
    public LandCommandAPI(String name,Plugin plugin) {
            super(name);
        this.plugin = plugin;
    }
    public Plugin getPlugin(){
        return plugin;
    }
    public String Permission(String per){
        return ("Rs.Command.Land."+per);
    }
    public String Description(){
        return LandMainClass.getRun().getMsg(this.getPermission());
    }
    public String Usage(String usage){
        return ("/"+this.getLabel()+" "+ usage);
    }
}
