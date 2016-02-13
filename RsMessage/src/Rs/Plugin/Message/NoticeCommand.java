package Rs.Plugin.Message;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginIdentifiableCommand;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/13.
 */
class NoticeCommand extends Command implements PluginIdentifiableCommand {
    private Plugin plugin;
    public NoticeCommand(Plugin plugin,String name){
        super(name);
        this.plugin = plugin;
        this.setPermission("Rs.Command.Message.notice");
        this.setUsage("/notice help");
    }
    public Plugin getPlugin(){
        return this.plugin;
    }
    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(strings.length < 1){
            commandSender.sendMessage("请输入二级指令");
            return false;
        }
        switch(strings[0]){
            case"add":
                //<>
            case"remove":
            case"list":
            case"set":
        }
        return false;
    }
}
