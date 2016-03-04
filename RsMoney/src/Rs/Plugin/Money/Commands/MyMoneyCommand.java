package Rs.Plugin.Money.Commands;

import Rs.Plugin.Money.MoneyClass;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;

/**
 * Created by admin on 2016/3/3.
 */
public class MyMoneyCommand extends RsMoneyCommandAPI {
    public MyMoneyCommand(String cmd,Plugin plugin) {
        super(cmd);
        this.plugin = plugin;
        setUsage("/bal");
        setAliases(new String[]{"mymoney","money"});
        setDescription("查看金钱");
        setPermission("Rs.command.bal");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (sender.isPlayer()) {
            sender.sendMessage("Money:" + new MoneyClass(sender.getName()).getMoney());
            sender.sendMessage("Point:" + new MoneyClass(sender.getName()).getPoint());
            return true;
        } else {
            sender.sendMessage("You don't have money/point");
            return true;
        }
    }
}
