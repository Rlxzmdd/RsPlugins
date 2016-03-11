package Rs.Plugin.Land.Commands.Commands;

import Rs.Plugin.Land.Commands.*;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;

/**
 * Created by admin on 2016/3/10.
 */
public class Land extends LandCommandAPI {
    public Land(String cmd,Plugin plugin){
        super(cmd,plugin);
        setUsage(Usage("XXXXX"));
        setAliases(new String[]{"hhhh"});
        setPermission(Permission("Land"));
        setDescription(Description());
    }
    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        commandSender.sendMessage("???");
        return false;
    }
}
