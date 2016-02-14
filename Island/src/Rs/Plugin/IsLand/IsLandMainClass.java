package Rs.Plugin.IsLand;

import Rs.Plugin.Function.LangSend;
import Rs.Plugin.Function.RsFunction;
import Rs.Plugin.IsLand.command.MyIsLandCommand;
import Rs.Plugin.IsLand.event.player.PlayerMoveToOtherIsLandEvent;
import Rs.Plugin.IsLand.lang.lang;
import Rs.Plugin.IsLand.level.generator.IsLandGenerator;
import Rs.Plugin.IsLand.utils.IsLandCoordinate;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.math.Vector3;
import cn.nukkit.plugin.PluginBase;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsLandMainClass extends PluginBase implements Listener
{
    //public String first = null;
    public LangSend run = new LangSend(new lang());
    public Map<String,Map<String,Object>> PlayerConfig = new HashMap<>();
    public void onEnable()
    {
        saveResource("config.yml");
        saveResource("isLandUsed.yml");
        saveResource("PlayerWarp.json");
        saveResource("en.json");
        saveResource("zh.json");

        //Addresses asdasd = new Addresses();
       // try {

          //  asds.plugin = this;
          //  asds.setLang(asds.getLang());
       // } catch (SocketException e) {
        //    getLogger().info("Can't get your Lang and yous ip");
        //}
       /// getLogger().info(asds.getMsg("Your.lang"));
       //// getLogger().info(asds.getMsg("Welcome.to.server"));
        getServer().getPluginManager().registerEvents(this, this);

        SimpleCommandMap commandMap = getServer().getCommandMap();
        commandMap.register("IsLand", new MyIsLandCommand("island", this));

        File file = new File(getDataFolder() + "/Players/");
        File assd = new File(getDataFolder() + "/IsLands/");
        file.mkdirs();
        assd.mkdirs();
        //new IsLand(new IsLandCoordinate("0.0")).newConfig();
        //new IsLand(new IsLandCoordinate("0.0")).setPermission("pvp", "t");
        //new IsLand(new IsLandCoordinate("0.0")).setTrustPlayerAuth("zmdd","use","false");
        //new IsLand(new IsLandCoordinate("0.0")).setTrustPlayerAuth("zmdd","usess","true");
        //getLogger().info(this.PlayerConfig+"");
       /// new NBT().asd = 222;


        /*CraftingManager asdasdasd = new CraftingManager();
        Recipe asdqwe =  (new BigShapedRecipe(Item.get(Item.FLOWER, 0, 1), "~X~", "X ~", " X~")).setIngredient("~", Item.get(Item.STONE)).setIngredient("X", Item.get(Item.STICK));
        asdasdasd.registerShapedRecipe((ShapedRecipe) asdqwe);

        asdasdasd.registerShapedRecipe((new ShapedRecipe(Item.get(Item.STONE, 0, 1),
                "X"
        )).setIngredient("X", Item.get(Item.COAL,0,10)));
*/
       boolean zxc =  Generator.addGenerator(IsLandGenerator.class,"island",4);
       // getLogger().info("233?");
        getServer().generateLevel("island",2333,IsLandGenerator.class);
        getServer().loadLevel("island");
        getServer().getLevelByName("island").setSpawnLocation(new Vector3(0.0D, 65.0D, 0.0D));
        RsFunction asds = new RsFunction();
        // asds.getMsg("233", new lang(this.getDataFolder()), new RsFunction().getPlayerLang(event.getPlayer()));
        //getLogger().info(run.getMsg("Your.lang"));
        //new PlayerWarp("zmdd").setWarp(new Vector3(233,2323,23));
        //getLogger().info((new PlayerWarp("zmdd").getWarp().getY())+"");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        IsLandCoordinate aszxc = new IsLandCoordinate(event.getPlayer().getX(),event.getPlayer().getZ());
        Map<String,Object> asdasd = new HashMap<String,Object>();
        asdasd.put("First",aszxc.getCoordinate());
        this.PlayerConfig.put(event.getPlayer().getName(), asdasd);
        //getLogger().info(this.PlayerConfig+"");
       // asds.getMsg("233", new lang(this.getDataFolder()), new RsFunction().getPlayerLang(event.getPlayer()));
     //   this.run.sM("Isn't.Host",event.getPlayer());
        //System.out.println(IsLandMainClass.this.getDataFolder());
        //getLogger().info(new NBT().asd+"");
        IsLandPlayer asd = new IsLandPlayer(event.getPlayer());
        asd.plugin = this;
        asd.newConfig();
        asd.plugin = this;
        HashMap qwe = new HashMap<String, Objects>();
        qwe.put("First", "");
        this.PlayerConfig.put(event.getPlayer().getName(),qwe);
       //// asd.setLang(new lang(event.getPlayer().getAddress(), event.getPlayer(), this).getLang());

      ///  event.getPlayer().sendMessage(new lang(event.getPlayer().getAddress(), event.getPlayer(), this).getMsg("Welcome.to.server"));
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onMove(PlayerMoveEvent event){
        if(!event.getPlayer().getLevel().getFolderName().equals("island")){
            return;
        }
        IsLand asd = new IsLand(new IsLandCoordinate(event.getPlayer().getFloorX(),event.getPlayer().getFloorZ()));
        asd.newConfig();
        //getLogger().info(this.PlayerConfig+""+asd.getCoordinate().getCoordinate()+".."+event.getPlayer().getX());
        if(!this.PlayerConfig.containsKey(event.getPlayer().getName())){
            Map<String,Object> asdasd = new HashMap<String,Object>();
            asdasd.put("First",asd.getCoordinate().getCoordinate());
            this.PlayerConfig.put(event.getPlayer().getName(), asdasd);
        }
        if(this.PlayerConfig.get(event.getPlayer().getName()).isEmpty()){
            Map<String,Object> asdasd = new HashMap<String,Object>();
            asdasd.put("First",asd.getCoordinate().getCoordinate());
            this.PlayerConfig.put(event.getPlayer().getName(), asdasd);
        }
            if(!this.PlayerConfig.get(event.getPlayer().getName()).get("First").toString().equals(asd.getCoordinate().getCoordinate())){

                PlayerMoveToOtherIsLandEvent ev = new PlayerMoveToOtherIsLandEvent(this, event.getPlayer(), this.PlayerConfig.get(event.getPlayer().getName()).get("First").toString(), asd.getCoordinate().getCoordinate());
                this.getServer().getPluginManager().callEvent(ev);
                //getLogger().info("233?");
                if(ev.isCancelled()){
                    event.setCancelled();
                    return;
                }
                Map<String,Object> asdasd = new HashMap<String,Object>();
                asdasd.put("First",asd.getCoordinate().getCoordinate());
                this.PlayerConfig.put(event.getPlayer().getName(), asdasd);
        }
    }

    @EventHandler
    public void onMoveO(PlayerMoveToOtherIsLandEvent event) {
        //getLogger().info("2333");
        if (event.getSecondIsLandHost().toString().equals("0")) {
           this.run.sM("No.Host.IsLand", event.getPlayer());
            //event.getPlayer().sendMessage("你探索到了一个无主之岛");
            return;
        }
        if (event.getSecondIsLandHost().equals(event.getPlayer().getName())) {
            this.run.sM("Return.IsLand", event.getPlayer());
            //event.getPlayer().sendMessage("你回到了你自己的空岛");
            return;
        }
        this.run.sM("Go.Other.IsLand",event.getPlayer(),event.getSecondIsLandHost());
        //event.getPlayer().sendMessage("你进入了别人的空岛，这个空岛的主人为" + event.getSecondIsLandHost());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event)
    {

        if(!event.getPlayer().getLevel().getFolderName().equals("island")){
            return;
        }
        if (event.getPlayer().isOp()) {
            event.getPlayer().sendMessage(Math.round(event.getPlayer().getX()) + ":" + Math.round(event.getPlayer().getY()) + ":" + Math.round(event.getPlayer().getZ()));
            return;
        }
        IsLand asd = new IsLand(Math.round(event.getBlock().getX()), Math.round(event.getBlock().getZ()));
        boolean asdasd = asd.canPlace(event.getPlayer().getName());
        if (!asdasd) {
           this.run.sM("Isn't.Host",event.getPlayer());
            //event.getPlayer().sendMessage("嘿，这个空岛不属于你！");
            event.setCancelled();
        }
    }

    @EventHandler
    public void onBlock(BlockBreakEvent event) {
        if(!event.getPlayer().getLevel().getFolderName().equals("island")){
            return;
        }
        IsLand asd = new IsLand(Math.round(event.getBlock().getX()), Math.round(event.getBlock().getZ()));
        if (event.getPlayer().isOp()) {
            return;
        }
        boolean asdasd = asd.canBreak(event.getPlayer().getName());
        if (!asdasd) {
            this.run.sM("Isn't.Host",event.getPlayer());
           // event.getPlayer().sendMessage("嘿，这个空岛不属于你！");
            event.setCancelled();
        } }

    @EventHandler
    public void onDecah(PlayerDeathEvent event) {
        event.setKeepInventory(true);
        event.setDrops(null);
    }
}