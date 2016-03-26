package Rs.Plugin.World.Commands.Commands;

import Rs.Plugin.World.Commands.WorldCommandAPI;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.command.CommandSender;
import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/3/10.
 */
public class proworld extends WorldCommandAPI {
    public proworld(String cmd,WorldMainClass plugin){
        super(cmd,plugin);
        setUsage(Usage("[add/remove] [world/player] [WorldName/PlayerName] [(PlayerName)WorldName]"));
        setAliases(new String[]{"hhhh"});
        setPermission(Permission("proworld"));
        setDescription(Description());
    }
    public String get(){
        return "/proworld [add/remove] [world/player] [WorldName/PlayerName] [(PlayerName)WorldName]";
    }
    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
       if(args.length<3){
           sender.sendMessage(this.get());
           return false;
       }
        if(args[0].equals("add")){
            if(args[1].equals("world")){
                plugin.getWorldUtils(args[2]).createWorld();
                return true;
            }else if(args[1].equals("player")){
                plugin.getWorldTrust().addTrust(args[3],args[2]);
                return true;
            }else{
                sender.sendMessage(this.get());
                return false;
            }
        }else if(args[0].equals("remove")){
            if(args[1].equals("world")){
                plugin.getWorldUtils(args[2]).del();
                return true;
            }else if(args[1].equals("player")){
                plugin.getWorldTrust().removeTrust(args[3],args[2]);
                return true;
            }else{
                sender.sendMessage(this.get());
                return false;
            }
        }else{
            sender.sendMessage(this.get());
            return false;
        }
    }
}
