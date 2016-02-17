package Rs.Plugin.Shop;

import Rs.Plugin.Function.Event.Player.PlayerPlaceSignEvent;
import Rs.Plugin.Shop.Utils.ShopJudge;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.SignChangeEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;


public class ShopMainClass extends PluginBase implements Listener {
    public File file = new File("plugins/RsShop/").getAbsoluteFile();

    public void onEnable() {
        File file = new File(this.getDataFolder() + "/Players/");
        file.mkdirs();
        File asd = new File(this.getDataFolder() + "/Shops/");
        asd.mkdirs();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
    }


   /* @EventHandler
    public void onc(PlayerTouchSignEvent e) {
        e.getPlayer().sendMessage(new Shop(e.getSign()).isShop()+"");
        new Shop(e.getSign()).CreateShop();
    }*/

    @EventHandler
    public void onc(PlayerPlaceSignEvent e) {
       // e.getPlayer().getLevel().addParticle(new FloatingTextParticle(e.getPlayer().getPosition().clone(),"2333?","asd"));
        //if(e.getPlayer().hasPermission("Rs.Event.Shop.CreateShop")){
            if(new ShopJudge().isNewShop(e.getText()[0])){
                Config config = new Config(this.file + "/config.yml",Config.YAML);
                //e.setText(0,config.getString("Text1"));
                //e.setText(1,"123");
                // getLogger().info("2323123");
            }
        //}
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