package Rs.Plugin.Money.Commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;

/**
 * Created by admin on 2016/3/3.
 */
abstract class RsMoneyCommandAPI extends Command implements PluginIdentifiableCommand {
    protected Plugin plugin;
    public RsMoneyCommandAPI(String cmd,Plugin plugin) {
        super(cmd);
        this.plugin = plugin;
    }

    public RsMoneyCommandAPI(String cmd) {
        super(cmd);
    }

    public Plugin getPlugin(){
        return plugin;
    }
}

