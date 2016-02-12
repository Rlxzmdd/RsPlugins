package Rs.Plugin.IsLand.event.player;

import Rs.Plugin.IsLand.IsLand;
import Rs.Plugin.IsLand.event.EventAPI;
import Rs.Plugin.IsLand.utils.IsLandCoordinate;
import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;

public class PlayerMoveToOtherIsLandEvent extends EventAPI
{
    protected String FirstIsLand;
    protected String SecondIsLand;
    protected Player player;

    public PlayerMoveToOtherIsLandEvent(Plugin plugin, Player player, String FirstIsLand, String SecondIsLand)
    {
        super(plugin);
        this.player = player;
        this.FirstIsLand = FirstIsLand;
        this.SecondIsLand = SecondIsLand;
    }

    public Player getPlayer()
    {
        return this.player;
    }

    public String getFirstIsLand() {
        return this.FirstIsLand;
    }

    public String getSecondIsLand() {
        return this.SecondIsLand;
    }

    public String getFirstIsLandHost() {
        IsLand asd = new IsLand(new IsLandCoordinate(this.getFirstIsLand()));
        return asd.getHost();
    }

    public String getSecondIsLandHost() {
        IsLand asd = new IsLand(new IsLandCoordinate(this.getSecondIsLand()));
        return asd.getHost();
    }
}