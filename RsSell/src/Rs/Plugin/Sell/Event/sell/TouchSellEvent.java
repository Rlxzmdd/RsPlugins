package Rs.Plugin.Sell.Event.sell;

import Rs.Plugin.Sell.Event.EventAPI;
import Rs.Plugin.Sell.Sell;
import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/16.
 */
public class TouchSellEvent extends EventAPI{
    public Player player;
    public Sell shop;
    public TouchSellEvent(Plugin plugin,Player player,Sell shop) {
        super(plugin);
        this.player = player;
        this.shop = shop;
    }
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }
    public Sell getShop(){
        return shop;
    }

    public Player getPlayer(){
        return player;
    }
}
