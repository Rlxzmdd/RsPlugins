package Rs.Plugin.Auto;

import Rs.Plugin.Function.RsFunction;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.inventory.InventoryPickupArrowEvent;
import cn.nukkit.event.inventory.InventoryPickupItemEvent;
import cn.nukkit.event.player.*;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


public class RsAutoMainClass extends PluginBase implements Listener {
    public HashMap<String, Map<String, Object>> PlayerConfig = new HashMap<>();
    public RsFunction run = new Rs.Plugin.Function.RsFunction();

    public void onEnable() {
        this.saveResource("config.yml");
        saveResource("eng.json", false);
        saveResource("zho.json", false);
        // new isLand().addGenerator(isLand.class,"isLand",3);
        this.getLogger().info(TextFormat.DARK_GREEN + "RsAuto is Loaded");
        this.getServer().getPluginManager().registerEvents(this, this);
        //this.getServer().getScheduler().scheduleRepeatingTask(new RsAuto.BroadcastPluginTask(this), 200);

        Config config = new Config(new File(this.getDataFolder(), "/config.yml"), Config.YAML);
        File file = new File(this.getDataFolder() + "/Players/");
        // File asd = new File(getDataFolder() + "/Langs/");

        //asd.mkdirs();
        file.mkdirs();

        //getLogger().info(this.run.getMsg("Prefix", new Lang(), this.run.getLang()));
        //System.out.println(PlayerConfig);
        //HashMap qwe = new HashMap<String,Objects>();
        //qwe.put("isLogin",0);
        //qwe.put("Password",null);
        //qwe.put("Maths",null);
        // System.out.println(qwe);
        // PlayerConfig.put("233",qwe);
        //System.out.println(PlayerConfig);
        // PlayerConfig asd  = new PlayerConfig();
        //  asd.main = this;
        // if(asd.getStat() == null){
        //      this.getLogger().info(TextFormat.DARK_GREEN + "服务器连接失败");
        //    }else{
        //       this.getLogger().info(TextFormat.DARK_GREEN + "服务器连接成功");
        //  }
    }
    // @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    //public boolean onB(BlockBreakEvent event){
    //    event.getPlayer().sendMessage("X:"+event.getPlayer().getFloorX()+",Y:"+event.getPlayer().getFloorY()+".Z:"+event.getPlayer().getFloorZ()+"");
    //    return true;
    //}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //if(sender instanceof Player){
        if(command.getName().equals("unregister")){
            if (args.length < 1) {
                sender.sendMessage(this.get("Want.Unresgiter"));
                //System.out.print(args);
                return false;
            } else {
                if(!sender.isOp() || !sender.hasPermission("Rs.Command.Auto.unregister")){
                    if(args[0].equals(sender.getName())){
                        sender.sendMessage(get("Plaes.enter")+"/unregister "+sender.getName());
                        return false;
                    }
                }
                sender.sendMessage(get("Enter.Player") + args[0]);
                if(new RsAuto().HasRsg(args[0]) == 0){
                    sender.sendMessage(get("This.no.Register")+args[0]);
                    return true;
                }
                new RsAuto().setPassword(args[0],"");
                sender.sendMessage(get("Sc.unregister")+args[0]);
                return true;
            }
        }
        //}else{
        //    sender.sendMessage(this.run.getMsg("Isnt.Player",new Lang(),this.run.getLang()));
        //    return true;
        //}
        return false;
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = false)
    public boolean onPlayerRsg(PlayerChatEvent event) {
        //PlayerConfig mysql = new PlayerConfig(event.getPlayer(),event.getMessage());
        //mysql.File = this.getDataFolder();
        //mysql.OnloadPlayer();
        //return true;
        // }
        //0为未注册,验证码输入正确进入3，输入密码
        //1为已登录
        //2为未登陆
        //3为验证码输入完毕，开始输入第一次密码
        //4为第一遍密码输入完毕。第二次密码,之后进入1
        //第二遍如果输入正确，直接进入1状态
        Player player = event.getPlayer();
        String name = player.getName();
        String msg = event.getMessage();
        // System.out.println(event.getMessage());
        switch (Integer.parseInt(PlayerConfig.get(name).get("isLogin").toString())) {
            case (0):
                if (PlayerConfig.get(name).get("Maths").toString().equals(msg)) {
                    event.setMessage("");
                    player.sendMessage(this.get("Verification.Code", player));
                    player.sendMessage(this.get("Password.One", player));
                    //this.isLogin = 3;
                    HashMap qwe = new HashMap<String, Objects>();
                    qwe.put("isLogin", 3);
                    qwe.put("Password", null);
                    qwe.put("Maths", Long.valueOf(PlayerConfig.get(event.getPlayer().getName()).get("isLogin").toString()));
                    qwe.put("Op",PlayerConfig.get(name).get("Op").toString());
                    PlayerConfig.put(event.getPlayer().getName(), qwe);
                    //this.PlayerConfig.put(event.getPlayer().getName(), qwe);
                    event.setCancelled();
                } else {
                    player.sendMessage(this.get("Verification.Error", player));
                    player.sendMessage(this.get("Verification.Two", player) + PlayerConfig.get(event.getPlayer().getName()).get("Maths").toString());
                    event.setCancelled();
                }
                return true;
            case (1):
                return true;
            case (2):
                event.setMessage("");
                RsAuto mysql = new RsAuto(player, msg, this);
                mysql.main = this;
                if (mysql.getPassword(event.getPlayer().getName()).equals(msg)) {
                    player.sendMessage(this.get("Password.Success", player));
                    player.sendMessage(this.get("Login.Success", player));
                    //this.isLogin = 1;
                    HashMap qwe = new HashMap<String, Objects>();
                    if(this.PlayerConfig.get(event.getPlayer().getName()).get("Op").toString().equals("True")){
                        event.getPlayer().setOp(true);
                    }
                    qwe.put("isLogin", 1);
                    qwe.put("Password", msg);
                    qwe.put("Maths", Long.valueOf(PlayerConfig.get(event.getPlayer().getName()).get("isLogin").toString()));
                    if(event.getPlayer().isOp()){
                        qwe.put("Op","True");
                        PlayerConfig.put(event.getPlayer().getName(), qwe);
                        event.getPlayer().setOp(true);
                    }else{
                        qwe.put("Op","False");
                        event.getPlayer().setOp(false);
                        PlayerConfig.put(event.getPlayer().getName(), qwe);
                    }
                    //this.PlayerConfig.put(event.getPlayer().getName(), qwe);
                } else {
                    player.sendMessage(this.get("Password.Error", player));
                    player.sendMessage(this.get("Old.Player.3", player));
                }
                event.setCancelled();
                return true;
            case (3):
                event.setMessage("");
                //this.pwd = msg;
                player.sendMessage(this.get("Password.One.End", player) + msg);
                player.sendMessage(this.get("Password.Two", player));
                //this.isLogin = 4;
                Map qwe = new HashMap<String, Objects>();
                qwe.put("isLogin", 4);
                qwe.put("Password", msg);
                qwe.put("Maths", Long.valueOf(PlayerConfig.get(event.getPlayer().getName()).get("isLogin").toString()));
                qwe.put("Op",PlayerConfig.get(name).get("Op").toString());
                PlayerConfig.put(event.getPlayer().getName(), qwe);
                //PlayerConfig.put(event.getPlayer().getName(), qwe);
                event.setCancelled();
                return true;
            case (4):
                event.setMessage("");
                if (PlayerConfig.get(event.getPlayer().getName()).get("Password").toString().equals(msg)) {
                    //String xx = this.pwd("NewPlayer", event.getPlayer(), this.pwd);
                    RsAuto mysqla = new RsAuto(player, msg, this);
                    mysqla.Password = msg;
                    mysqla.NewPlayer();
                    player.sendMessage(this.get("Register.Success", player));
                    // player.sendMessage("您的账号为:" + name + ",您的密码为:" + this.pwd + ",请牢记");
                    // this.isLogin = 1;
                    //this.maths = 0;
//System.out.println(PlayerConfig);
                    // this.pwd = null;
                    if(this.PlayerConfig.get(event.getPlayer().getName()).get("Op").toString().equals("True")){
                        event.getPlayer().setOp(true);
                    }
                    Map qweqwe = new HashMap<String, Objects>();
                    qweqwe.put("isLogin", 1);
                    qweqwe.put("Password", msg);
                    qweqwe.put("Maths", Long.valueOf(PlayerConfig.get(event.getPlayer().getName()).get("isLogin").toString()));
                    if(event.getPlayer().isOp()){
                        qweqwe.put("Op","True");
                        PlayerConfig.put(event.getPlayer().getName(), qweqwe);
                        event.getPlayer().setOp(true);
                    }else{
                        qweqwe.put("Op","False");
                        event.getPlayer().setOp(false);
                        PlayerConfig.put(event.getPlayer().getName(), qweqwe);
                    }
                   // PlayerConfig.put(event.getPlayer().getName(), qweqwe);
                    event.setCancelled();
                    return true;
                } else {
                    player.sendMessage(this.get("Password.Two.Error", player));
                    player.sendMessage(this.get("Register.Re", player));
                    //this.isLogin = 0;
                    Random math = new Random();
                    long maths = math.nextInt(10) * 1000 + math.nextInt(10) * 100 + math.nextInt(10) * 10 + math.nextInt(10);
                    player.sendMessage(this.get("Verification.One", player) + maths);
                    Map qweqwe = new HashMap<String, Objects>();
                    qweqwe.put("isLogin", 0);
                    qweqwe.put("Password", PlayerConfig.get(event.getPlayer().getName()).get("Password").toString());
                    qweqwe.put("Maths", maths);
                    if(event.getPlayer().isOp()){
                        qweqwe.put("Op","True");
                        PlayerConfig.put(event.getPlayer().getName(), qweqwe);
                        event.getPlayer().setOp(true);
                    }else{
                        qweqwe.put("Op","False");
                        player.setOp(false);
                        PlayerConfig.put(event.getPlayer().getName(), qweqwe);
                    }
                    //PlayerConfig.put(event.getPlayer().getName(), qweqwe);
                    event.setCancelled();
                    return true;
                }
        }
        return true;
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "RsAuto is unloaded");
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public boolean onJoin(PlayerJoinEvent event) {
        RsAuto mysql = new RsAuto();
        mysql.Player = event.getPlayer();
        mysql.main = this;
        int hasRsg = mysql.HasRsg();
        Player player = event.getPlayer();
        if (hasRsg == 0) {
            //this.getLogger().info("新玩家 " + name + " 来到了服务器");
            // this.getLogger().info("成功为玩家 " + name + " 创建了数据文夹:" + name + ".yml");
            //old player
            player.sendMessage(this.get("New.Player.1", player));
            player.sendMessage(this.get("New.Player.2", player));
            Random math = new Random();
            long maths = math.nextInt(10) * 1000 + math.nextInt(10) * 100 + math.nextInt(10) * 10 + math.nextInt(10);
            player.sendMessage(this.get("Verification.One", player) + maths);
            HashMap qwe = new HashMap<String, Objects>();
            qwe.put("isLogin", 0);
            qwe.put("Password", null);
            qwe.put("Maths", maths);
            if(event.getPlayer().isOp()){
                qwe.put("Op","True");
                PlayerConfig.put(event.getPlayer().getName(), qwe);
                event.getPlayer().setOp(false);
            }else{
                qwe.put("Op","False");
                PlayerConfig.put(event.getPlayer().getName(), qwe);
            }
            //System.out.println(qwe);
            //PlayerConfig.put(event.getPlayer().getName(), qwe);
            //System.out.println(PlayerConfig);
            // PlayerConfig.put()
            return true;
        } else if (hasRsg == 1) {
            //new player
            //this.getLogger().info("未注册玩家 " + name + " 回到了服务器");
            player.sendMessage(this.get("Old.Player.1", player));
            player.sendMessage(this.get("Old.Player.2", player));
            //this.isLogin = 2;
            Map qwe = new HashMap<String, Objects>();
            qwe.put("isLogin", 2);
            qwe.put("PassWord", null);
            qwe.put("Maths", null);
            if(event.getPlayer().isOp()){
                qwe.put("Op","True");
                event.getPlayer().setOp(false);
                PlayerConfig.put(event.getPlayer().getName(), qwe);
            }else{
                qwe.put("Op","False");
                PlayerConfig.put(event.getPlayer().getName(), qwe);
            }
            //PlayerConfig.put(event.getPlayer().getName(), qwe);
            return true;
        }
        return true;
    }

    public String get(String lang, Player player) {
        return (this.run.getMsg("Prefix", new Lang(), this.run.getPlayerLang(player)) + "" + this.run.getMsg(lang, new Lang(), this.run.getPlayerLang(player)));
        //   sM(player, lang, new Lang());
        /*Config config = new Config(this.getDataFolder() + "/config.yml", Config.YAML);
        if(config.exists(lang)){
            return config.get("Prefix").toString()+config.get(lang).toString();
        }else{
            return config.get("Prefix").toString()+config.get("error.lang").toString();
        }*/
    }
    public String get(String lang){
        return (this.run.getMsg("Prefix", new Lang(), this.run.getLang()) + "" + this.run.getMsg(lang, new Lang(), this.run.getLang()));
    }
    //  public String get(String lang) {
    // return this.run.getMsg("Prefix",new Lang(),this.run.getPlayerLang(player)+this.run.getMsg(lang,new Lang(),this.run.getPlayerLang(player)));
    //Config config = new Config(this.getDataFolder() + "/config.yml", Config.YAML);
    // if(config.exists(lang)){
    //     return config.get("Prefix").toString()+config.get(lang).toString();
    //}else{
    //   return config.get("Prefix").toString()+config.get("error.lang").toString();
    //  }
    //  }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanInteract")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {

            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    // @EventHandler
    //public void asd(PlayerMessageEvent event){
    //    getLogger().info(event.getMessage());
    // }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanBreak")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {

            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }
    @EventHandler
    public  void respawn(PlayerRespawnEvent event){
        System.out.print(event.getRespawnPosition().getX());
        System.out.print(event.getPlayer().getX());
             //  System.out.print("2323123123123");
    }
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event instanceof EntityDamageByEntityEvent) {
            cn.nukkit.entity.Entity p = ((EntityDamageByEntityEvent) event).getDamager();
            cn.nukkit.entity.Entity d = event.getEntity();
            if (p instanceof Player) {
                String name = ((Player) p).getName();
                if (((Player) p).hasPermission("Rs.Event.Auto.CanDamage")) {
                    return;
                }
                if (this.PlayerConfig.containsKey(name)) {
                    if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                        ((Player) p).sendTip(get("No.LoginAndRegsiter", (Player) p));
                        event.setCancelled();
                    }
                }
            } else if (d instanceof Player) {
                String name = ((Player) d).getName();
                if (this.PlayerConfig.containsKey(name)) {
                    if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                        ((Player) d).sendTip(get("No.LoginAndRegsiter", (Player) d));
                        event.setCancelled();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanPlace")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            // ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }
    @EventHandler
    public void onrescomm(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanCommand")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            // ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setMessage(null);
                event.setCancelled();
            }
        }
    }
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanDrop")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            //ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanMove")) {
            return;
        }
        String name = event.getPlayer().getName();
        //System.out.print("233??");
        if (this.PlayerConfig.containsKey(name)) {
            //System.out.print("233?");
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onP(PlayerItemHeldEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanItemHeld")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            //ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onc(PlayerItemConsumeEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanItemConsume")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            //ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onf(PlayerEatFoodEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanEatFood")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            //ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onfc(PlayerFoodLevelChangeEvent event) {
        if (event.getPlayer().hasPermission("Rs.Event.Auto.CanFoodLevelChange")) {
            return;
        }
        String name = event.getPlayer().getName();
        if (this.PlayerConfig.containsKey(name)) {
            //ppp = this.players[name];
            if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                event.getPlayer().sendTip(get("No.LoginAndRegsiter", event.getPlayer()));
                event.setCancelled();
            }
        }
    }

    @EventHandler
    public void onit(InventoryPickupItemEvent event) {
        if (event.getInventory().getHolder() instanceof Player) {
            Player player = ((Player) event.getInventory().getHolder());
            if (player.hasPermission("Rs.Event.Auto.CanPickupItem")) {
                return;
            }
            String name = player.getName();
            if (this.PlayerConfig.containsKey(name)) {
                //ppp = this.players[name];
                if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                    player.sendTip(get("No.LoginAndRegsiter", player));
                    event.setCancelled();
                }
            }
        }
    }

    @EventHandler
    public void onisadt(InventoryPickupArrowEvent event) {
        if (event.getInventory().getHolder() instanceof Player) {
            Player player = ((Player) event.getInventory().getHolder());
            if (player.hasPermission("Rs.Event.Auto.CanPickupItem")) {
                return;
            }
            String name = player.getName();
            if (this.PlayerConfig.containsKey(name)) {
                //ppp = this.players[name];
                if (!PlayerConfig.get(name).get("isLogin").toString().equals("1")) {
                    player.sendTip(get("No.LoginAndRegsiter", player));
                    event.setCancelled();
                }
            }
        }
    }
}
