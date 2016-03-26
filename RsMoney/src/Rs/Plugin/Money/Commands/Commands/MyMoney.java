package Rs.Plugin.Money.Commands.Commands;

import Rs.Plugin.Money.Commands.MoneyCommandAPI;
import Rs.Plugin.Money.MoneyMainClass;
import Rs.Plugin.Money.Object.MoneyClass;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;

/**
 * Created by admin on 2016/3/3.
 */
public class MyMoney extends MoneyCommandAPI {
    public MyMoney(String cmd,MoneyMainClass plugin) {
        super(cmd,plugin);
        setUsage("/bal");
        setAliases(new String[]{"mymoney","money"});
        setDescription("查看金钱");
        setPermission("Rs.command.bal");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (sender.isPlayer()) {
            sender.sendMessage("Money:" + plugin.getMoneyClass(sender.getName()).getMoney());
            sender.sendMessage("Point:" + plugin.getMoneyClass(sender.getName()).getPoint());
            return true;
        } else {
            sender.sendMessage("You don't have money/point");
            return true;
        }
    }
}
