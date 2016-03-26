package Rs.Plugin.Land;

import Rs.Plugin.Function.LangSend;
import Rs.Plugin.Land.Commands.LandCommandManager;
import Rs.Plugin.Land.Listeners.LandListenerManager;
import Rs.Plugin.Land.Utils.LandLang;
import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

import java.io.File;

public class LandMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/Land/").getAbsoluteFile();
    public void onEnable() {
        new LandListenerManager(this);
        new LandCommandManager(this);
        this.saveResource("config.yml");
    }
    public static LangSend getRun(){
        return new LangSend(new LandLang());
    }
}