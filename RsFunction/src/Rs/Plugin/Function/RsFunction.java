package Rs.Plugin.Function;

import Rs.Plugin.Function.Event.Player.PlayerBreakSignEvent;
import Rs.Plugin.Function.Event.Player.PlayerPlaceSignEvent;
import Rs.Plugin.Function.Event.Player.PlayerTouchSignEvent;
import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Locale;


public class RsFunction extends PluginBase implements Listener {

    //public File file = this.fileName;
    public String fileName = new File("plugins/Language").getAbsolutePath();

    public void onEnable() {
        //getLogger().info(new position("1.1.1.1").getLang());
        //saveResource("config.yml");
        // getLogger().info("load");
        //File asd = new File(getDataFolder() + "/Players/");
        //asd.mkdirs();
        Locale locale = Locale.getDefault();
        getLogger().info("You look like come from : " + locale.getCountry());
        getLogger().info("Next you will use :" + new FunctionUtils().getLang());
        File directory = new File("plugins/Language");
        File asdasd = new File(directory.getAbsolutePath() + "/Players");    //得到的是C:/test/abc
        //directory.mkdirs();
        asdasd.mkdirs();
        //getLogger().info(getLang());
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("language")) {
            if (args.length < 1) {
                sender.sendMessage("id: en");
                sender.sendMessage(" - Language: English");
                sender.sendMessage("id: zh");
                sender.sendMessage(" - Language: China");
                sender.sendMessage("id: ru");
                sender.sendMessage(" - Language: Russian ");
                sender.sendMessage("id: ja");
                sender.sendMessage(" - Language: Japan");
                sender.sendMessage("id: ko");
                sender.sendMessage(" - Language: Korea");
                return false;
            }

            if (args[0].equals("en") || args[0].equals("zh") || args[0].equals("ru") || args[0].equals("ja") || args[0].equals("ko")) {
                if (sender instanceof Player) {
                    File file = new File(this.fileName + "/Players/" + sender.getName() + ".json");
                    if (file.exists()) {
                        Config config = new Config(file, Config.JSON);
                        config.set("Address", ((Player) sender).getAddress());
                        config.set("Lang", args[0]);
                        config.save();
                        sender.sendMessage("Change Language success");
                        return true;
                    } else {
                        Config config = new Config(file, Config.JSON);
                        config.set("Address", ((Player) sender).getAddress());
                        config.set("Lang", args[0]);
                        config.save();
                        sender.sendMessage("Change Language success");
                        //System.out.print(config+"");
                        return true;
                    }
                } else {
                    File file = new File(this.fileName + "/config.json");
                    if (file.exists()) {
                        Config config = new Config(file, Config.JSON);
                        config.set("Lang", args[0]);
                        config.save();
                        sender.sendMessage("Change Language success");
                        return true;
                    } else {
                        Config config = new Config(file, Config.JSON);
                        config.set("Lang", args[0]);
                        config.save();
                        sender.sendMessage("Change Language success");
                        return true;
                    }
                }
            } else {
                sender.sendMessage("id: en");
                sender.sendMessage(" - Language: English");
                sender.sendMessage("id: zh");
                sender.sendMessage(" - Language: China");
                sender.sendMessage("id: ru");
                sender.sendMessage(" - Language: Russian ");
                sender.sendMessage("id: ja");
                sender.sendMessage(" - Language: Japan");
                sender.sendMessage("id: ko");
                sender.sendMessage(" - Language: Korea");
                return false;
            }
        }
        return false;
    }

    @EventHandler
    public void oni(PlayerInteractEvent e){
        BlockEntity sign = this.getServer().getLevelByName(e.getPlayer().getLevel().getFolderName()).getBlockEntity(new Vector3(e.getBlock().getX(),e.getBlock().getY(),e.getBlock().getZ()));
        if(sign instanceof BlockEntitySign){
            PlayerTouchSignEvent ev = new PlayerTouchSignEvent(this,e.getPlayer(),(BlockEntitySign)sign);
            this.getServer().getPluginManager().callEvent(ev);
            if(ev.isCancelled()){
                e.setCancelled();
                return;
            }
        }
    }
    @EventHandler
    public void onbp(BlockPlaceEvent e){
        BlockEntity sign = this.getServer().getLevelByName(e.getPlayer().getLevel().getFolderName()).getBlockEntity(new Vector3(e.getBlock().getX(),e.getBlock().getY(),e.getBlock().getZ()));
        if(sign instanceof BlockEntitySign){
            PlayerPlaceSignEvent ev = new PlayerPlaceSignEvent(this,e.getPlayer(),(BlockEntitySign)sign);
            this.getServer().getPluginManager().callEvent(ev);
            if(ev.isCancelled()){
                e.setCancelled();
                return;
            }
        }
    }
    @EventHandler
    public void onbsp(BlockBreakEvent e){
       if(e.getBlock().getId() == 63){
            PlayerBreakSignEvent ev = new PlayerBreakSignEvent(this,e.getPlayer(),e.getBlock());
            this.getServer().getPluginManager().callEvent(ev);
            if(ev.isCancelled()){
                e.setCancelled();
                return;
            }
        }
    }

    public String getMsg(String msg, Lang lang, String address) {
        return lang.getMsg(msg, address);
    }

    public String getMsg(String msg, Lang lang) {
        return lang.getMsg(msg, this.getLang());
    }

    public void sM(Player player, String msg, Lang lang) {
        new LangSend(player, lang).sM(msg);
    }

    public String getLang() {
        //getLogger().info(this.fileName);
        File file = new File(this.fileName + "/config.json");
        if (file.exists()) {
            Config config = new Config(file, Config.JSON);
            //return "eng";
            config.set("Lang", new FunctionUtils().getLang());
            config.save();
            return config.get("Lang").toString();
        } else {
            Config config = new Config(file, Config.JSON);
            config.set("Lang", new FunctionUtils().getLang());
            config.save();
            return config.get("Lang").toString();
        }
    }

    public String getPlayerLang(Player player) {
        File file = new File(this.fileName + "/Players/" + player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(file, Config.JSON);
            if (config.get("Address").toString().equals(player.getAddress())) {
                return config.get("Lang").toString();
            } else {
                config.set("Address", player.getAddress());
                config.set("Lang", new position(player.getAddress()).getLang());
                config.save();
                return config.get("Lang").toString();
            }
        } else {
            Config config = new Config(file, Config.JSON);
            config.set("Address", player.getAddress());
            config.set("Lang", new position(player.getAddress()).getLang());
            config.save();
            //System.out.print(config+"");
            return config.get("Lang").toString();
        }
    }
}
