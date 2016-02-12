package Rs.Plugin.Message;

import Rs.Plugin.Function.RsFunction;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MessageMainClass extends PluginBase implements Listener {

    public RsFunction run = new RsFunction();

    public void onEnable() {
        //File asd = new File(getDataFolder() + "/Langs/");
        getServer().getPluginManager().registerEvents(this, this);
        //asd.mkdirs();
        saveResource("eng.json", false);
        saveResource("zho.json", false);
        saveResource("config.yml", false);
        //getLogger().info(new Rs.Plugin.Function.position("1.1.1.1").getLang());
   }
    public String get(String lang,Player player) {
        return (this.run.getMsg(lang,new Rs.Plugin.Message.Lang(),this.run.getPlayerLang(player)));
    }
    public String get(String lang) {
        return (this.run.getMsg(lang,new Rs.Plugin.Message.Lang(),this.run.getLang()));
    }

    @EventHandler
    public void onkick(PlayerQuitEvent event){
       // System.out.print("233?");
        event.setQuitMessage("");
        //event.setJoinMessage(new TextContainer("233?"));
        String str = this.get("Player.Quit");
        str = str.replaceAll("\\{Player\\}", event.getPlayer().getName());
        getLogger().info(str);
        Set set=this.getServer().getOnlinePlayers().entrySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            Map.Entry  mapentry = (Map.Entry) iterator.next();
            ((Player)mapentry.getValue()).sendTip("23333");
            String asd = this.get("Player.Quit",(Player)mapentry.getValue());
            asd = asd.replaceAll("\\{Player\\}", event.getPlayer().getName());
            if(this.UseTip())
                ((Player) mapentry.getValue()).sendTip(asd);
            if(this.UsePopup())
                ((Player) mapentry.getValue()).sendPopup(asd);
            if(this.UseMessage())
                ((Player) mapentry.getValue()).sendMessage(asd);
        }
    }
    @EventHandler
    public void onJon(PlayerJoinEvent event){
        // System.out.print("233?");
        //event.setJoinMessage(null);
        event.setJoinMessage("");
        //event.setJoinMessage(new TextContainer("233?"));
        String str = this.get("Player.Join");
        str = str.replaceAll("\\{Player\\}", event.getPlayer().getName());
        getLogger().info(str);
        Set set=this.getServer().getOnlinePlayers().entrySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            Map.Entry  mapentry = (Map.Entry) iterator.next();
            ((Player)mapentry.getValue()).sendTip("23333");
            String asd = this.get("Player.Join",(Player)mapentry.getValue());
            asd = asd.replaceAll("\\{Player\\}", event.getPlayer().getName());
            if(this.UseTip())
                ((Player) mapentry.getValue()).sendTip(asd);
            if(this.UsePopup())
                ((Player) mapentry.getValue()).sendPopup(asd);
            if(this.UseMessage())
                ((Player) mapentry.getValue()).sendMessage(asd);
        }
    }
    @EventHandler
    public void ondie(PlayerDeathEvent event){
        getLogger().info(event.getDeathMessage()+"");
    }

    @EventHandler
    public void ondiasded(BlockBreakEvent event){
        if(event.getPlayer().isOp()){
            return;
        }
       if( event.getPlayer().getLevel().getFolderName().equals("world")){
           event.setCancelled();
       }
    }

    @EventHandler
    public void ondqweied(BlockPlaceEvent event){
        if(event.getPlayer().isOp()){
            return;
        }
        if (event.getPlayer().getLevel().getFolderName().equals("world")){
            event.setCancelled();
        }
    }


    public boolean UseTip(){
        Config config = new Config(new File("plugins/RsMessage/config.yml").getAbsoluteFile(),Config.YAML);
        if(config.get("UseTip").toString().equals("true")){
            return true;
        }
        return false;
    }
    public boolean UsePopup() {
        Config config = new Config(new File("plugins/RsMessage/config.yml").getAbsoluteFile(), Config.YAML);
        if (config.get("UsePopup").toString().equals("true")) {
            return true;
        }
        return false;
    }
    public boolean UseMessage(){
        Config config = new Config(new File("plugins/RsMessage/config.yml").getAbsoluteFile(),Config.YAML);
        if(config.get("UseMessage").toString().equals("true")){
            return true;
        }
        return false;
    }
}
