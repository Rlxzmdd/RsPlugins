package Rs.Plugin.Sell;

import Rs.Plugin.Function.Event.Player.PlayerBreakSignEvent;
import Rs.Plugin.Function.Event.Player.PlayerPlaceSignEvent;
import Rs.Plugin.Function.Event.Player.PlayerTouchSignEvent;
import Rs.Plugin.Function.LangSend;
import Rs.Plugin.Money.MoneyClass;
import Rs.Plugin.Sell.Event.sell.BreakSellEvent;
import Rs.Plugin.Sell.Event.sell.TouchSellEvent;
import Rs.Plugin.Sell.Utils.BlockUtils;
import Rs.Plugin.Sell.Utils.SellJudge;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import cn.nukkit.level.particle.FloatingTextParticle;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.math.BigDecimal;


public class SellMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/RsSell/").getAbsoluteFile();
    public Rs.Plugin.Function.LangSend run = new LangSend(new Lang());

    public void onEnable() {
        File asd = new File(this.getDataFolder() + "/Shops/");
        asd.mkdirs();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
        this.saveResource("items.properties");
        this.saveResource("en.json");
        this.saveResource("zh.json");
       // this.run.getMsg("No.Item.Sell");

    }

    public void onj(PlayerJoinEvent e) {
       // e.getPlayer().getLevel().addParticle(new FloatingTextParticle(null, "233"), e.getPlayer());
    }

    @EventHandler
    public void oncc(PlayerTouchSignEvent e) {
        if (new SellJudge().isShop(e.getSign())) {
            TouchSellEvent ev = new TouchSellEvent(this, e.getPlayer(), new Sell(e.getSign()));
            this.getServer().getPluginManager().callEvent(ev);
            if (ev.isCancelled()) {
                e.setCancelled();
                return;
            }
        }
    }

    @EventHandler
    public void oncc(PlayerBreakSignEvent e) {
        if (new SellJudge().isShop(e.getSign())) {
            BreakSellEvent ev = new BreakSellEvent(this, e.getPlayer(), new Sell(e.getSign()));
            this.getServer().getPluginManager().callEvent(ev);
            if (ev.isCancelled()) {
                e.setCancelled();
                return;
            }
        }

    }


    @EventHandler
    public void onc(PlayerPlaceSignEvent e) {
        //Sell
        //coin
        //money
        if (new SellJudge().isNewShop(e.getText()[0])) {
            if (e.getPlayer().hasPermission("Rs.Event.Sell.CreateSell")) {
                String coin, money, item, number;
                Config config = new Config(this.file + "/config.yml", Config.YAML);
                if (!e.getText()[1].equals("")) {
                    money = e.getText()[1];
                    if (!isNum(e.getText()[1])) {
                        money = "0";
                    }
                } else {
                    money = "0";
                }
                if(e.getText()[2].equals("Money") || e.getText()[2].equals("money") || e.getText()[2].equals("m") ||e.getText()[2].equals("M") )
                    coin = "Money";
                else
                coin = "Point";
                new BlockUtils(e.getBlock()).createShop("0", "0", coin, money);
                e.setText(0, config.getString("Text1"));
                e.setText(2, config.getString("Text2").replaceAll("%cur", coin).replaceAll("%money", money));
                e.setText(1, config.getString("Text3").replaceAll("%money", money).replaceAll("%cur", coin));
                e.setText(3, getConfig().get("WillCreate").toString());
            } else {
                e.setText(1, this.run.getMsg("Sell.No.Create", e.getPlayer()));
            }
        }

    }

    @EventHandler
    public void ont(TouchSellEvent e) {
        run.player = e.getPlayer();
        //getLogger().info(new SellJudge().isWillSell(e.getSell())+"");
        if (new SellJudge().isWillShop(e.getShop())) {
            if (e.getPlayer().hasPermission("Rs.Event.Sell.setItem")) {
                e.getShop().setItem(e.getPlayer().getInventory().getItemInHand());
            } else {
                this.run.sM("Sell.No.Buy", e.getPlayer());
                return;
            }
        } else {
            Item inv = e.getPlayer().getInventory().getItemInHand();
            Item sell = e.getShop().getItem();
            if(!(inv.getId() == sell.getId() && inv.getDamage()==sell.getDamage()&&inv.getCount() >= sell.getCount())){
                this.run.sM("Item.No.Enough", e.getPlayer());
                return;
            }
            boolean qwe;
            if(e.getShop().getCoin().equals("Point")){
                new MoneyClass(e.getPlayer()).addPoint(e.getShop().getMoney());
                qwe = false;
            }else{
                new MoneyClass(e.getPlayer()).addMoney(e.getShop().getMoney());
                qwe = true;
            }

                e.getPlayer().getInventory().removeItem(e.getShop().getItem());
                if(qwe){   e.getPlayer().sendMessage(run.getMsg("Sell.Can.Buy",e.getPlayer()).
                        replaceAll("%Coin","Money").
                        replaceAll("%Money",e.getShop().getMoney()+"").
                        replaceAll("%Item",e.getShop().getItem().getId()+":"+e.getShop().getItem().getDamage()).
                        replaceAll("%Number",e.getShop().getItem().getCount()+""));
                }else {
                    e.getPlayer().sendMessage(run.getMsg("Sell.Can.Buy",e.getPlayer()).
                            replaceAll("%Coin","Point").
                            replaceAll("%Money",e.getShop().getMoney()+"").
                            replaceAll("%Item",e.getShop().getItem().getId()+":"+e.getShop().getItem().getDamage()).
                           replaceAll("%Number",e.getShop().getItem().getCount()+""));
                }
            //todo buy item
        }
        e.setCancelled();
        //e.getPlayer().sendMessage(new SellJudge().isWillSell(e.getSell())+"");
    }

    @EventHandler
    public void obsg(BreakSellEvent e) {
        if (e.getPlayer().hasPermission("Rs.Event.Sell.BreakSell")) {
            this.run.sM("Sell.Can.Del",e.getPlayer());
            //��Ȩ��
            //��Ȩ��
            e.getShop().del();
        } else {
            this.run.sM("Sell.No.Del", e.getPlayer());
            e.setCancelled();
        }
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