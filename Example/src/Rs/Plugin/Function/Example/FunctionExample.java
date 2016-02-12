package Rs.Plugin.Function.Example;

import Rs.Plugin.Function.RsFunction;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

public class FunctionExample extends PluginBase implements Listener {

    public RsFunction run = new Rs.Plugin.Function.RsFunction();

    public void onEnable() {
        saveResource("eng.json", false);
        saveResource("zho.json", false);
       //getLogger().info(this.run.getLang());
    }

    @EventHandler
    public boolean onCommand(CommandSender sender, Command $command,String label, String[] args){
            getLogger().info(this.run.getMsg(args[0], new Lang(), this.run.getLang()));
        return true;
    }
    public String get(String lang,Player player) {
       return (this.run.getMsg(lang,new Lang(),this.run.getPlayerLang(player)));
    }

}
