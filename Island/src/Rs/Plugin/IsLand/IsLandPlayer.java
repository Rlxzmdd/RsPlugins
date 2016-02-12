package Rs.Plugin.IsLand;

import Rs.Plugin.IsLand.utils.IsLandCoordinate;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class IsLandPlayer
{
    public Player player;
    public Plugin plugin;
    public IsLandPlayer(Player player) {
        this.player = player;
    }
    public IsLandPlayer(CommandSender player) {
        if(player instanceof Player){
            this.player = (Player)player;
        }else{
            this.player = (Player)player;
        }
    }
    public IsLandPlayer(Plugin plugin,String name){
        if(plugin.getServer().getOfflinePlayer(name).isOnline()){
            this.player = plugin.getServer().getPlayer(name);
        }else{
           this.player = (Player)plugin.getServer().getOfflinePlayer(name);
        }
    }
    public String getFile(){
        return (new File("plugins/IsLand/Players/").getAbsolutePath());
    }
    public String getMain(){
        return (new File("plugins/IsLand/").getAbsolutePath());
    }

    public void newConfig() {
        if(this.player == null){
            return;
        }
            File is = new File(this.getFile(),"/" + this.player.getName() + ".json");
            if (is.exists()) {
                return;
            }
            Config config = new Config(is, Config.JSON);
            config.set("IsLands", new ArrayList<>());
            config.set("added", Integer.valueOf(0));
            config.save();
    }
    public ArrayList<String> getIsLands() {
            File is = new File(this.getFile(),"/"+this.player.getName()+".json");
            if (!is.exists()) {
                return null;
            }
        Config config = new Config(is, 1);
        return((ArrayList<String>)config.get("IsLands"));
    }

    public void setIsLand(ArrayList<String> isLand) {
        //this.plugin.getLogger().info("233333");
        Config config = new Config(this.getFile()+"/"+this.player.getName()+".json",Config.JSON);
        config.set("IsLands", isLand);
        config.save();
        //System.out.print("2333");
    }

    public void addIsLand(String isLand){
        Config config = new Config(this.getFile()+"/"+this.player.getName()+".json",Config.JSON);
        ArrayList<String> islands = new ArrayList<String>();//(ArrayList<String>)config.get("IsLands");
        //islands.add(isLand);
        islands.add(isLand);
        System.out.print(islands);
        config.set("IsLands",islands);

        config.save();
    }

    public boolean removeIsLand(String isLand){
        Config config = new Config(this.getFile()+"/"+this.player.getName()+".json",Config.JSON);
        Set<String> islands = (Set<String>)config.get("IsLands");
        boolean asd= islands.remove(isLand);
        config.set("IsLands", islands);
        config.save();
        return asd;
    }

    public IsLand getInIsLand(){
        return (new IsLand(new IsLandCoordinate(player.getX(),player.getZ())));
    }
    public void newIsland()
    {
        new Thread()
        {
            public void run()
            {
                Config config = new Config(getMain() + "/isLandUsed.yml");
                Map isLand = config.getAll();
                ArrayList islands = (ArrayList)isLand.get("HasUsed");
                for (long x1 = 1L; x1 <= 10L; x1 += 1L)
                    for (long z1 = 1L; z1 <= x1; z1 += 1L) {
                        if (((x1 == 0L) || (z1 == 0L) ? 1 : 0) == 0) {
                            if (!islands.contains(x1 + "." + z1)) {
                                long x = x1;
                                long z = z1;
                                    IsLand asd = new IsLand(new IsLandCoordinate(x+"."+z));
                                    asd.newConfig();
                                    String name = player.getName();
                                    asd.setHost(name);
                                addIsLand(x + "." + z);
                                islands.add(x + "." + z);
                                config.set("HasUsed",islands);
                                config.save();
                                return;
                            }
                        }
                        for (long x2 = z1; x2 >= 0L - z1; x2 -= 1L) {
                            if (((x2 - 1L == 0L) || (z1 == 0L) ? 1 : 0) == 0) {
                                if (!islands.contains(x2 - 1L + "." + z1)) {
                                    long x = x2 - 1L;
                                    long z = z1;
                                    IsLand asd = new IsLand(new IsLandCoordinate(x+"."+z));
                                    asd.newConfig();
                                    String name = player.getName();
                                    asd.setHost(name);
                                    addIsLand(x + "." + z);
                                    islands.add(x + "." + z);
                                    config.set("HasUsed",islands);
                                    config.save();
                                    return;
                                }
                            }
                            for (long z2 = x1 - 1L; z2 > -x1; z2 -= 1L) {
                                if (((-x1 == 0L) || (z2 - 1L == 0L) ? 1 : 0) == 0)
                                    if (!islands.contains(-x1 + "." + (z2 - 1L))) {
                                        long x = -x1;
                                        long z = z2 - 1L;
                                        IsLand asd = new IsLand(new IsLandCoordinate(x+"."+z));
                                        asd.newConfig();
                                        String name = player.getName();
                                        asd.setHost(name);
                                        addIsLand(x + "." + z);
                                        islands.add(x + "." + z);
                                        config.set("HasUsed",islands);
                                        config.save();
                                        return;
                                    }
                            }
                            for (long z2 = 0L - x1 + 1L; z2 < x1; z2 += 1L) {
                                if (((z2 == 0L) || (0L - x1 == 0L) ? 1 : 0) == 0)
                                    if (!islands.contains(z2 + "." + (0L - x1))) {
                                        long x = z2;
                                        long z = 0L - x1;
                                        IsLand asd = new IsLand(new IsLandCoordinate(x+"."+z));
                                        asd.newConfig();
                                        String name = player.getName();
                                        asd.setHost(name);
                                        addIsLand(x + "." + z);
                                        islands.add(x + "." + z);
                                        config.set("HasUsed",islands);
                                        config.save();
                                        return;
                                    }
                            }
                            for (long z3 = 0L - z1; z3 < 0L; z3 += 1L)
                                if (((x1 == 0L) || (z3 == 0L) ? 1 : 0) == 0)
                                    if (!islands.contains(x1 + "." + z3)) {
                                        long x = x1;
                                        long z = z3;
                                        IsLand asd = new IsLand(new IsLandCoordinate(x+"."+z));
                                        asd.newConfig();
                                        String name = player.getName();
                                        asd.setHost(name);
                                        addIsLand(x + "." + z);
                                        islands.add(x + "." + z);
                                        config.set("HasUsed",islands);
                                        config.save();
                                        return;
                                    }
                        }
                    }
            }
        }.start();
    }
}