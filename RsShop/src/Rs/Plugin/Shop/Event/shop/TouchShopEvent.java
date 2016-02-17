package Rs.Plugin.Shop.Event.shop;

import Rs.Plugin.Shop.Event.EventAPI;
import Rs.Plugin.Shop.Shop;
import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/16.
 */
public class TouchShopEvent extends EventAPI{
    public Player player;
    public Shop shop;
    public TouchShopEvent(Plugin plugin,Player player,Shop shop) {
        super(plugin);
        this.player = player;
        this.shop = shop;
    }

    public Shop getShop(){
        return shop;
    }

    public Player getPlayer(){
        return player;
    }
}
