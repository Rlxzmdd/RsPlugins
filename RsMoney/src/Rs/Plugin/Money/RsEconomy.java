package Rs.Plugin.Money;

import Rs.Plugin.Money.Commands.MyMoneyCommand;
import Rs.Plugin.Money.Commands.PayCommand;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;

import java.io.File;


public class RsEconomy extends PluginBase implements Listener {
    public File file = new File("plugins/RsMoney/").getAbsoluteFile();
    public void onEnable() {
        File file = new File(this.getDataFolder() + "/Players/");
        file.mkdirs();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
        this.getServer().getCommandMap().register("RsMoney",new MyMoneyCommand("bal",this));
        this.getServer().getCommandMap().register("RsMoney",new PayCommand("pay",this));
       // this.getEconomy("zmdd").getMoneyConfig().newConfig();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.getEconomy(event.getPlayer().getName()).getMoneyConfig().newConfig();

    }
    public MoneyClass getEconomy(String name){
        return (new MoneyClass(name));
    }
}