package Rs.Plugin.Function.Event.Player;

/**
 * Created by Rlx on 2016/2/15.
 */

import Rs.Plugin.Function.Event.EventAPI;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.HandlerList;
import cn.nukkit.plugin.Plugin;


public class PlayerPlaceSignEvent extends EventAPI
{
    protected String[] text;
    protected Player player;
    protected Block block;
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }
    public PlayerPlaceSignEvent(Plugin plugin, Player player, String[] text,Block block)
    {
        super(plugin);
        this.player = player;
        this.text = text;
        this.block = block;
    }

    public String[] getText(){
        return this.text;
    }

    public boolean setText(int line,String contect){
        if(text.length > line || line > 0){
            text[line] = contect;
            return true;
        }else{
            return false;
        }

    }

    public Player getPlayer(){
        return this.player;
    }

    public Block getBlock(){
        return this.block;
    }
}
