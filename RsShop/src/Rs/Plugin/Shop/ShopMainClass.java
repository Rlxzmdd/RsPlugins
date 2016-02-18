package Rs.Plugin.Shop;

import Rs.Plugin.Function.Event.Player.PlayerPlaceSignEvent;
import Rs.Plugin.Shop.Utils.BlockUtils;
import Rs.Plugin.Shop.Utils.ShopJudge;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.SignChangeEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.math.BigDecimal;


public class ShopMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/RsShop/").getAbsoluteFile();

    public void onEnable() {
        File file = new File(this.getDataFolder() + "/Players/");
        file.mkdirs();
        File asd = new File(this.getDataFolder() + "/Shops/");
        asd.mkdirs();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
        this.saveResource("items.properties");
    }


   /* @EventHandler
    public void onc(PlayerTouchSignEvent e) {
        e.getPlayer().sendMessage(new Shop(e.getSign()).isShop()+"");
        new Shop(e.getSign()).CreateShop();
    }*/
   public static boolean isNum(String str) {
       try {
           new BigDecimal(str);
           return true;
       } catch (Exception e) {
           return false;
       }
   }
    @EventHandler
    public void onc(PlayerPlaceSignEvent e) {
       // e.getPlayer().getLevel().addParticle(new FloatingTextParticle(e.getPlayer().getPosition().clone(),"2333?","asd"));
        //if(e.getPlayer().hasPermission("Rs.Event.Shop.CreateShop")){
        //e.getPlayer().sendMessage(new Item(17).getCustomName());

        //shop
        //coin
        //money

            if(new ShopJudge().isNewShop(e.getText()[0])){
                String coin,money,item,number;
                Config config = new Config(this.file + "/config.yml",Config.YAML);
                if(!isNum(e.getText()[1])){
                    money = e.getText()[1];
                }else{
                    money = "0";
                }
                if(e.getText()[2].equals("") || !e.getText()[2].equals("money") || !e.getText()[2].equals("point")){
                    coin = "Money";
                }else{
                    if(e.getText()[2].equals("point")){
                        coin = "Point";
                    }else {
                        coin = "Money";
                    }
                }
                new BlockUtils(e.getBlock()).createShop(item,number,coin,money);
                e.setText(0,config.getString("Text1"));
                e.setText(1,"WillCreate");
                e.setText(2,config.getString("Text3").replaceAll("%cur",coin));
                e.setText(3,config.getString("Text4").replaceAll("%money",money));
            }
    }
    @EventHandler
    public void oncc(SignChangeEvent e){

    }
  /*  @EventHandler
    public void onc(PlayerBreakSignEvent e) {
        e.getPlayer().sendMessage(new Shop(e.getSign()).isShop()+"");
        new Shop(e.getSign()).CreateShop();
    }
    */
    //@EventHandler
    //public void onasd()
}