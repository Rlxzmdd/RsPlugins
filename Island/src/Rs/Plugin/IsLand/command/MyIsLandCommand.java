package Rs.Plugin.IsLand.command;

import Rs.Plugin.IsLand.IsLand;
import Rs.Plugin.IsLand.IsLandPlayer;
import Rs.Plugin.IsLand.utils.PlayerWarp;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.Plugin;

import java.util.ArrayList;

public class MyIsLandCommand extends IsLandCommandAPI
{
    public Plugin plugin;

    public MyIsLandCommand(String cmd, Plugin plugin)
    {
        super(cmd);
        this.plugin = plugin;
        setUsage("/island");
        setAliases(new String[]{"is"});
        setDescription("通过此命令回到空岛和领取空岛");
        setPermission("Rs.command.myLand");
    }

    public boolean execute(final CommandSender sender, String s, String[] strings)
    {
        if(strings.length == 0){
            if ((sender instanceof Player)) {
                final IsLandPlayer asd = new IsLandPlayer(sender);
                if (asd.getIsLands().size() == 0) {
                    sender.sendMessage("由于你是第一次进入服务器，你可以领取一个空岛");
                    sender.sendMessage("将为你传送至你的空岛出生地");
                    IsLandPlayer play = new IsLandPlayer(sender);
                    play.newIsland();
                    Player player = sender.getServer().getPlayer(sender.getName());
                    player.getInventory().addItem(new Item[] { new Item(6, Integer.valueOf(0), 2) });
                    player.getInventory().addItem(new Item[] { new Item(351, Integer.valueOf(15), 10) });
                    player.getInventory().addItem(new Item[] { new Item(325, Integer.valueOf(0), 1) });
                    player.getInventory().addItem(new Item[] { new Item(174, Integer.valueOf(0), 2) });

                    player.getInventory().addItem(new Item[] { new Item(295, Integer.valueOf(0), 2) });
                    player.getInventory().addItem(new Item[] { new Item(360, Integer.valueOf(0), 2) });
                    player.getInventory().addItem(new Item[] { new Item(361, Integer.valueOf(0), 2) });
                    player.getInventory().addItem(new Item[] { new Item(391, Integer.valueOf(0), 2) });
                    player.getInventory().addItem(new Item[] { new Item(3, Integer.valueOf(0), 20) });
                    player.getInventory().addItem(new Item[] { new Item(2, Integer.valueOf(0), 10) });
                    sender.sendMessage("拿好你的物资！新人！");
                }else{
                    sender.sendMessage("即将传送到你的空岛");
                }
                new Thread()
                {
                    public void run()
                    {

                        try
                        {
                            sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(!((Player)sender).getLevel().getFolderName().equals("island")){
                            ((Player)sender).teleport(getPlugin().getServer().getLevelByName("island").getSafeSpawn(new Vector3(0,65,0)));
                        }
                        ArrayList<String> island = asd.getIsLands();
                        String islands = island.get(0);
                        IsLand Island = new IsLand(islands);
                        sender.getServer().getPlayer(sender.getName()).teleport(Island.getIsLandSpawn());
                        //getPlugin().getLogger().info(((Player) sender).getX()+"..."+((Player) sender).getY()+"..."+((Player) sender).getZ()+"");
                        //Island.setIsLandSpawn(((Player) sender).getX(), ((Player) sender).getY(), ((Player) sender).getZ());
                    }
                }
                        .start();
            }
            return true;
            /*
            sender.sendMessage("请输入子命令");
            sender.sendMessage("/island pset <玩家> <权限> <T/F>  ----  为玩家设置权限");
            sender.sendMessage("/island set <权限> <T/F>          ----  为空岛设置默认权限");
            sender.sendMessage("/island setwarp                   ----  设置你的传送点");
            sender.sendMessage("/island warp <玩家名字>           ----  传送到一个传送点");
            sender.sendMessage("更多指令请输入/island help");
            return true;*/
        }
        switch (strings[0]) {
            case "pset":
                if (strings.length < 4) {
                    sender.sendMessage("请输入/island pset <玩家> <权限> <T/F>");
                    return true;
                }
                //System.out.println((new IsLandPlayer(sender)).getInIsLand().getHost());
                if (!(new IsLandPlayer(sender)).getInIsLand().getHost().equals(sender.getName()) || !((Player)(sender)).getLevel().getFolderName().equals("island")) {
                    sender.sendMessage("必须在自己的空岛里面才能使用");
                    return false;
                }
                if (new IsLandPlayer(sender).getInIsLand().setTrustPlayerAuth(strings[1], strings[2], strings[3])) {
                    sender.sendMessage("设置成功");
                } else {
                    sender.sendMessage("设置失败,原因如下:");
                    sender.sendMessage("你所输入的权限不存在");
                }
                return true;
            case "set":
                if (strings.length < 3) {
                    sender.sendMessage("请输入/island set <权限> <T/F>");
                    return true;
                }
                if (!(new IsLandPlayer(sender)).getInIsLand().getHost().equals(sender.getName())|| !((Player)(sender)).getLevel().getFolderName().equals("island")) {
                    sender.sendMessage("必须在自己的空岛里面才能使用");
                    return false;
                }
                if (new IsLandPlayer(sender).getInIsLand().setPermission(strings[1], strings[2])) {
                    sender.sendMessage("设置成功");
                } else {
                    sender.sendMessage("设置失败,原因如下:");
                    sender.sendMessage("你所输入的权限不存在");
                }
                return true;
            case "warp":
                if((strings.length < 2)){
                    sender.sendMessage("请输入/island warp <玩家名字>----传送到一个传送点");
                    return true;
                }
                if (!((Player)(sender)).getLevel().getFolderName().equals("island")) {
                    sender.sendMessage("必须在空岛地图里面才能使用");
                    return true;
                }
               Vector3 asd= new PlayerWarp(strings[1]).getWarp();
                if(asd == null){
                    sender.sendMessage("没有这个传送点");
                    return true;
                }
                ((Player)sender).teleport(asd);
                sender.sendMessage("传送成功");
            case"setwarp":
                if (!(new IsLandPlayer(sender)).getInIsLand().getHost().equals(sender.getName()) ||!((Player)(sender)).getLevel().getFolderName().equals("island")) {
                    sender.sendMessage("必须在自己的空岛里面才能使用");
                    return true;
                }
                new PlayerWarp(sender.getName()).setWarp(new Vector3(((Player) sender).getX(), ((Player) sender).getY(),((Player)sender).getZ()));
                sender.sendMessage("传送点设置成功");
                return true;
           /* case"setspawn":
                if (!(new IsLandPlayer(sender)).getInIsLand().getHost().equals(sender.getName())|| !((Player)(sender)).getLevel().getFolderName().equals("island")){
                    sender.sendMessage("必须在自己的空岛里面才能使用");
                    return true;
                }
                (new IsLandPlayer(sender).getInIsLand()).setIsLandSpawn(new Vector3(((Player) sender).getX(), ((Player) sender).getY(),((Player)sender).getZ()));
                sender.sendMessage("重生点设置成功");
                return true;
                */
        }
        sender.sendMessage("请输入子命令");
        sender.sendMessage("/island                           ----  回到和领取空岛");
        sender.sendMessage("/island pset <玩家> <权限> <T/F>  ----  为玩家设置权限");
        sender.sendMessage("/island set <权限> <T/F>          ----  为空岛设置默认权限");
        sender.sendMessage("/island setwarp                   ----  设置你的传送点");
        sender.sendMessage("/island warp <玩家名字>           ----  传送到一个传送点");
        sender.sendMessage("更多指令请输入/island help");
        return true;
    }

    public Plugin getPlugin()
    {
        return this.plugin;
    }
}