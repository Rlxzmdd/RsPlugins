package Rs.Plugin.Shop;

import Rs.Plugin.Function.Event.Player.PlayerTouchSignEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

import java.io.File;


public class ShopMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/RsMoney/").getAbsoluteFile();

    public void onEnable() {
        File file = new File(this.getDataFolder() + "/Players/");
        file.mkdirs();
        File asd = new File(this.getDataFolder() + "/Shops/");
        asd.mkdirs();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
    }


    @EventHandler
    public void onc(PlayerTouchSignEvent e) {
        e.getPlayer().sendMessage(new Shop(e.getSign()).isShop()+"");
        new Shop(e.getSign()).CreateShop();
    }
    //@EventHandler
    //public void onasd()
}