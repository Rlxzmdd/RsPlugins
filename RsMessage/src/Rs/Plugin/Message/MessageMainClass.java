package Rs.Plugin.Message;

import Rs.Plugin.Function.RsFunction;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.TextContainer;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.ArrayList;
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
           // ((Player)mapentry.getValue()).sendTip("23333");
            String asd = this.get("Player.Quit",(Player)mapentry.getValue());
            asd = asd.replaceAll("\\{Player\\}", event.getPlayer().getName());
            if(this.UseTip("Quit"))
                ((Player) mapentry.getValue()).sendTip(asd);
            if(this.UsePopup("Quit"))
                ((Player) mapentry.getValue()).sendPopup(asd);
            if(this.UseMessage("Quit"))
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
            //((Player)mapentry.getValue()).sendTip("23333");
            String asd = this.get("Player.Join",(Player)mapentry.getValue());
            asd = asd.replaceAll("\\{Player\\}", event.getPlayer().getName());
            if(this.UseTip("Join"))
                ((Player) mapentry.getValue()).sendTip(asd);
            if(this.UsePopup("Join"))
                ((Player) mapentry.getValue()).sendPopup(asd);
            if(this.UseMessage("Join"))
                ((Player) mapentry.getValue()).sendMessage(asd);
        }
    }
    @EventHandler
    public void ondie(PlayerDeathEvent event){
        // System.out.print("233?");
        //event.setJoinMessage(new TextContainer("233?"));
        //getLogger().info(event.getDeathMessage().getText());
        String asdasd = this.get(event.getDeathMessage().getText());
        String str = asdasd.replaceAll("\\{Player\\}", event.getEntity().getName());
        getLogger().info(str);
        Set set=this.getServer().getOnlinePlayers().entrySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            Map.Entry  mapentry = (Map.Entry) iterator.next();
            //((Player)mapentry.getValue()).sendTip("23333");
            String asd = this.get(event.getDeathMessage().getText(),(Player)mapentry.getValue());
            asd = asd.replaceAll("\\{Player\\}", event.getEntity().getName());
            if(this.UseTip("Death"))
                ((Player) mapentry.getValue()).sendTip(asd);
            if(this.UsePopup("Death"))
                ((Player) mapentry.getValue()).sendPopup(asd);
            if(this.UseMessage("Death"))
                ((Player) mapentry.getValue()).sendMessage(asd);
        }
        event.setDeathMessage(new TextContainer(""));
       /*
        death.fell.accident.generic={%0} �Ӹߴ�ˤ������
        death.attack.inFire={%0} ԡ�����
        death.attack.onFire={%0} ��������
        death.attack.lava={%0} ��ͼ���ҽ�����Ӿ
        death.attack.inWall={%0} ��ǽ����Ϣ����
        death.attack.drown={%0} ������
        death.attack.cactus={%0} ��������
        death.attack.generic={%0} ����
        death.attack.explosion={%0} ��ը��
        death.attack.explosion.player={%0} �� {%1} ը����
        death.attack.magic={%0} ��ħ��ɱ����
        death.attack.wither={%0} ��л��
        death.attack.mob={%0} �� {%1} ɱ����
        death.attack.player={%0} �� {%1} ɱ����
        death.attack.player.item={%0} �� {%1} �� {%2} ɱ����
        death.attack.arrow={%0} �� {%1} ��ɱ
        death.attack.arrow.item={%0} �� {%1} �� {%2} ��ɱ
        death.attack.fall={%0} ��ع���
        death.attack.outOfWorld={%0} �������������
        */
    }

    /*@EventHandler
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
    }*/


    public boolean UseTip(String mode){
        Config config = new Config(new File("plugins/RsMessage/config.yml").getAbsoluteFile(),Config.YAML);
            return ((ArrayList<String>)(config.get("UseTip"))).contains(mode);
    }
    public boolean UsePopup(String mode) {
        Config config = new Config(new File("plugins/RsMessage/config.yml").getAbsoluteFile(), Config.YAML);
        return ((ArrayList<String>)(config.get("UsePopup"))).contains(mode);
    }
    public boolean UseMessage(String mode){
        Config config = new Config(new File("plugins/RsMessage/config.yml").getAbsoluteFile(),Config.YAML);
        return ((ArrayList<String>)(config.get("UseMessage"))).contains(mode);
    }
}
