package Rs.Plugin.Money.Commands.Commands;

import Rs.Plugin.Money.Commands.MoneyCommandAPI;
import Rs.Plugin.Money.MoneyMainClass;
import Rs.Plugin.Money.Object.MoneyClass;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;

import java.math.BigDecimal;

/**
 * Created by admin on 2016/3/4.
 */
public class Pay extends MoneyCommandAPI {
    public Pay(String cmd,MoneyMainClass plugin) {
        super(cmd,plugin);
        setUsage("/pay [Player] [Count] (Money/Point)");
        this.setDescription("/pay [Player] [Count] (Money/Point)");
        setAliases(new String[]{"givemoney"});
        setDescription("Give other player money");
        setPermission("Rs.command.pay");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        boolean money;
        if(args.length < 2){
            sender.sendMessage("/pay [Player] [Count] (Money/Point)");
            return false;
        }
        if(!isNum(args[1])){
            sender.sendMessage("/pay [Player] [Count] (Money/Point)");
            return false;
        }
        if(!(args.length < 2)) {
            money = true;
        } else {
            if(args[2].equals("Money") || args[2].equals("money") || args[2].equals("p") || args[2].equals("P")){
                money = true;
            }else if(args[2].equals("Point") || args[2].equals("point") || args[2].equals("m") || args[2].equals("M")){
                money = false;
            }else{
                sender.sendMessage("/pay [Player] [Count] (Money/Point)");
                return false;
            }
        }
        if(!sender.getServer().getOfflinePlayer(args[0]).isOnline()){
            sender.sendMessage("Player ["+args[0]+"] is Offline");
            return true;
        }
        MoneyClass asd = new MoneyClass(plugin,sender.getServer().getPlayer(args[0]));
        if(!sender.isPlayer()){
            if(money){
                asd.addMoney(Float.valueOf(args[1]));
                sender.sendMessage("Give ["+args[0]+"] Money : "+args[1]);
            }else{
                asd.addPoint(Float.valueOf(args[1]));
                sender.sendMessage("Give ["+args[0]+"] Point : "+args[1]);
            }
            return true;
        }
        float playermoney;
        MoneyClass qwe =  new MoneyClass(plugin,sender.getName());
        if(money){
            playermoney = qwe.reduceMoney(Float.valueOf(args[1]));
        }else{
            playermoney = qwe.reducePoint(Float.valueOf(args[1]));
        }
        if(playermoney != 0){
           sender.sendMessage("You don't have enough Money/Point");
            return false;
        }
        if(money){
            asd.addMoney(Float.valueOf(args[1]));
            sender.sendMessage("Reduce Money: "+args[1] +",Your Money: "+  qwe.getMoney());
        }else{
            asd.addPoint(Float.valueOf(args[1]));
            sender.sendMessage("Reduce Point: " + args[1] + ",Your Money: " + qwe.getPoint());
        }
        return true;
    }

    public static boolean isNum(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
