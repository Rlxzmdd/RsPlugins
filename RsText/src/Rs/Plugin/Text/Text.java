package Rs.Plugin.Text;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.protocol.AddItemEntityPacket;
import cn.nukkit.plugin.PluginBase;

import java.io.File;


public class Text extends PluginBase implements Listener {
    public File file = new File("plugins/Text/").getAbsoluteFile();
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveResource("config.yml");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
       /*
       AddPlayerPacket pk = new AddPlayerPacket();
        pk.eid = 123123;
        pk.username = "233?";
        pk.x = (float)event.getPlayer().getX();
        pk.z = (float)event.getPlayer().getZ();
        pk.y = (float)event.getPlayer().getY();
        byte asd[] = new byte[64 * 32 * 4 +1];
        String same = "haha";
        String result = "";
        pk.uuid = new UUID(123123,123123);
        pk.metadata = new EntityMetadata();
        */
        /*for(int i=0;i<asd.length;i++) {
            asd[i] = 0;
        }
        pk.putSkin(new Skin(asd));*/

        //getLogger().info("11111."+pk);
        AddItemEntityPacket pk = new AddItemEntityPacket();
        pk.eid = 123123;
        pk.x = (float)event.getPlayer().getX();
        pk.z = (float)event.getPlayer().getZ();
        pk.y = (float)event.getPlayer().getY();
        Enchantment enchantment = Enchantment.getEnchantment(1);
        enchantment.setLevel(9);
        Item item = new Item(3);
      // item.addEnchantment(enchantment);
        //item.setCustomName("2323");
        CompoundTag nbt=new CompoundTag()
               . putCompound("display", new CompoundTag("display").putString("Name", "asdasd"))
               .putLong("Age", 100);
        // item.setCompoundTag(nbt);
        item.setCompoundTag(nbt);
        pk.item = item;;
        getLogger().info(item.getCompoundTag()+"");
        event.getPlayer().dataPacket(pk);
        event.getPlayer().getInventory().setItemInHand(item);

    }

   /* public void onTag(Player $p, String $info, String $eid) {
        AddPlayerPacket pk = new AddPlayerPacket();
        pk.eid = $eid;
        pk.username = $info['message'];
        pk.x = $info['x'];
        pk.y = $info['y'];
        pk.z = $info['z'];
        pk.putSkin(null);
        pk.metadata = null;
        p.dataPacket($pk);
    }*/
}