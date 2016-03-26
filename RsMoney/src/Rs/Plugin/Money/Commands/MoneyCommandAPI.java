package Rs.Plugin.Money.Commands;

import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;

/**
 * Created by Rlx on 2016/2/15.
 */
public abstract class MoneyCommandAPI extends Command implements PluginIdentifiableCommand {
    public MoneyMainClass plugin;
    public MoneyCommandAPI(String name,MoneyMainClass plugin) {
            super(name);
        this.plugin = plugin;
    }
    public MoneyMainClass getPlugin(){
        return plugin;
    }
    public String Permission(String per){
        return ("Rs.Command.Money."+per);
    }
    public String Description(){
        return MoneyMainClass.getRun().getMsg(this.getPermission());
    }
    public String Usage(String usage){
        return ("/"+this.getLabel()+" "+ usage);
    }
}
