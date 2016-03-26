package Rs.Plugin.World;

import Rs.Plugin.Function.LangSend;
import Rs.Plugin.World.Commands.WorldCommandManager;
import Rs.Plugin.World.Listeners.WorldListenerManager;
import Rs.Plugin.World.Object.World;
import Rs.Plugin.World.Utils.WorldTrust;
import Rs.Plugin.World.Utils.WorldUtils;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Library;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorldMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/RsWorld/").getAbsoluteFile();
    public LinkedHashMap<String, Map<String,Map<String,Boolean>>> AllWorld = new LinkedHashMap<>();
    /*
    "world"£º{
     "zmdd":{
      "Place": True,
      "Break": True
     }
    }
     */
    public void onEnable() {
        new WorldListenerManager(this);
        new WorldCommandManager(this);
        this.saveResource("config.json");
        this.saveResource("en.json");
        this.saveResource("zh.json");
        Map<String,Object> config = new Config(file+"/config.json").getAll();
        for(Iterator world = config.keySet().iterator();world.hasNext();){
            String zxc = world.next().toString();
            Map<String,Map<String,Boolean>> asd = (Map<String,Map<String,Boolean>>)config.get(zxc);
            AllWorld.put(zxc,asd);
        }
        getLogger().info("4asd");
    }
    public void onDisable(){
        getLogger().info(AllWorld+"rel");
        Config config = new Config(file+"/config.json");
        config.setAll((LinkedHashMap)AllWorld);
        config.save();
}

    public static LangSend getRun(){
        return new LangSend(new Rs.Plugin.World.Utils.WorldLang());
    }

    public LinkedHashMap<String, Map<String,Map<String,Boolean>>> getAllWorld(){
        return this.AllWorld;
    }

    public void setAllWorld(LinkedHashMap<String, Map<String,Map<String,Boolean>>> all){
        this.AllWorld.putAll(all);
    }

    public WorldUtils getWorldUtils(String WorldName){
        return (new WorldUtils(this,WorldName));
    }

    public WorldTrust getWorldTrust(){
        return new WorldTrust(this);
    }
}