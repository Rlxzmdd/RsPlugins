package Rs.Plugin.Shop;

import Rs.Plugin.Function.Event.Player.PlayerBreakSignEvent;
import Rs.Plugin.Function.Event.Player.PlayerPlaceSignEvent;
import Rs.Plugin.Function.Event.Player.PlayerTouchSignEvent;
import Rs.Plugin.Function.LangSend;
import Rs.Plugin.Money.MoneyClass;
import Rs.Plugin.Shop.Event.shop.BreakShopEvent;
import Rs.Plugin.Shop.Event.shop.TouchShopEvent;
import Rs.Plugin.Shop.Utils.BlockUtils;
import Rs.Plugin.Shop.Utils.ShopJudge;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.level.particle.FloatingTextParticle;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.math.BigDecimal;


public class ShopMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/RsShop/").getAbsoluteFile();
    public Rs.Plugin.Function.LangSend run = new LangSend(new Lang());

    public void onEnable() {
        File file = new File(this.getDataFolder() + "/Players/");
        file.mkdirs();
        File asd = new File(this.getDataFolder() + "/Shops/");
        asd.mkdirs();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
        this.saveResource("items.properties");
        this.run.getMsg("No.Item.Shop");
    }

    public void onj(PlayerJoinEvent e) {
       // e.getPlayer().getLevel().addParticle(new FloatingTextParticle(null, "233"), e.getPlayer());
    }

    @EventHandler
    public void oncc(PlayerTouchSignEvent e) {
        if (new ShopJudge().isShop(e.getSign())) {
            TouchShopEvent ev = new TouchShopEvent(this, e.getPlayer(), new Shop(e.getSign()));
            this.getServer().getPluginManager().callEvent(ev);
            if (ev.isCancelled()) {
                e.setCancelled();
                return;
            }
        }
    }

    @EventHandler
    public void oncc(PlayerBreakSignEvent e) {
        if (new ShopJudge().isShop(e.getSign())) {
            BreakShopEvent ev = new BreakShopEvent(this, e.getPlayer(), new Shop(e.getSign()));
            this.getServer().getPluginManager().callEvent(ev);
            if (ev.isCancelled()) {
                e.setCancelled();
                return;
            }
        }

    }


    @EventHandler
    public void onc(PlayerPlaceSignEvent e) {
        //shop
        //coin
        //money
        if (new ShopJudge().isNewShop(e.getText()[0])) {
            if (e.getPlayer().hasPermission("Rs.Event.Shop.CreateShop")) {
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
                if (e.getText()[2].equals("") && !e.getText()[2].equals("money") && !e.getText()[2].equals("point")) {
                    coin = "Money";
                } else {
                    if (e.getText()[2].equals("point")) {
                        coin = "Point";
                    } else {
                        coin = "Money";
                    }
                }
                new BlockUtils(e.getBlock()).createShop("0", "0", coin, money);
                e.setText(0, config.getString("Text1"));
                e.setText(2, config.getString("Text2").replaceAll("%cur", coin).replaceAll("%money", money));
                e.setText(1, config.getString("Text3").replaceAll("%money", money).replaceAll("%cur", coin));
                e.setText(3, getConfig().get("WillCreate").toString());
            } else {
                e.setText(1, this.run.getMsg("Shop.No.Create", e.getPlayer()));
            }
        }

    }

    @EventHandler
    public void ont(TouchShopEvent e) {
        //getLogger().info(new ShopJudge().isWillShop(e.getShop())+"");
        if (new ShopJudge().isWillShop(e.getShop())) {
            if (e.getPlayer().hasPermission("Rs.Event.Shop.setItem")) {
                e.getShop().setItem(e.getPlayer().getInventory().getItemInHand());
            } else {
                this.run.sM("Shop.No.Buy", e.getPlayer());
                return;
            }
        } else {
            if (!e.getPlayer().getInventory().canAddItem(e.getShop().getItem())) {
                this.run.sM("Shop.No.Buy",e.getPlayer());
                //不能添加物品，取消购买
                e.setCancelled();
                return;
            }
            float asd = new MoneyClass(e.getPlayer()).reduceMoney(e.getShop().getMoney());
            if (asd == 0) {
                e.getPlayer().getInventory().addItem(e.getShop().getItem());
                this.run.sM("Shop.Can.buy",e.getPlayer());
                //可以购买
            } else {
                this.run.sM("Money.No.Enough",e.getPlayer());
                return;
                //余额不够，向player输出asd变量
            }
            //todo buy item
        }
        e.setCancelled();
        //e.getPlayer().sendMessage(new ShopJudge().isWillShop(e.getShop())+"");
    }

    @EventHandler
    public void obsg(BreakShopEvent e) {
        if (e.getPlayer().hasPermission("Rs.Event.Shop.BreakShop")) {
            this.run.sM("Shop.Can.Del",e.getPlayer());
            //有权限
            e.getShop().del();
        } else {
            this.run.sM("Shop.No.Del", e.getPlayer());
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