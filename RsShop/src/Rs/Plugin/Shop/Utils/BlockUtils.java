package Rs.Plugin.Shop.Utils;

import cn.nukkit.block.Block;

/**
 * Created by Rlx on 2016/2/16.
 */
public class BlockUtils {
    public Block block;
    public BlockUtils(Block block){
        this.block = block;
    }
    public void createShop(){

    }
   /*
    public File getFile(){
        String asd = this.sign.getBlock().getLevel().getFolderName()+
                "-"+new Double(this.sign.getBlock().getX()).longValue()+
                "-"+new Double(this.sign.getBlock().getY()).longValue()+
                "-"+new Double(this.sign.getBlock().getZ()).longValue();
        return (new File(file+"/Shops/"+asd+".json"));
    }
    public Config getConfig(){
        if(this.config == null) {
            Config config = new Config(getFile(),Config.JSON);
            this.config = config;
            return this.config;
        }
        return this.config;
    }
    */
}
