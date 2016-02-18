package Rs.Plugin.Shop.Event.shop;

import Rs.Plugin.Shop.Event.EventAPI;
import Rs.Plugin.Shop.Shop;
import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/16.
 */
public class BreakShopEvent extends EventAPI{
    public Player player;
    public Shop shop;
    public BreakShopEvent(Plugin plugin,Player player,Shop shop) {
        super(plugin);
        this.player = player;
        this.shop = shop;
    }
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }
    public Shop getShop(){
        return shop;
    }

    public Player getPlayer(){
        return player;
    }
}