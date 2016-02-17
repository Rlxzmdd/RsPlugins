package Rs.Plugin.Shop.Utils;

import cn.nukkit.block.Block;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/16.
 */
public class BlockUtils {
    public Block block;
    public File file = new File("plugins/RsShop/").getAbsoluteFile();
    public Config config =null;
    public BlockUtils(Block block){
        this.block = block;
    }
    public void createShop(String item,String number,String coin,String money){
        if(getFile().exists()){
            return;
        }else{
            this.getConfig().set("Item",item);
            this.getConfig().set("Number",number);
            this.getConfig().set("Coin",coin);
            this.getConfig().set("Money",money);
            this.getConfig().save();
        }
    }
    public File getFile(){
        String asd = this.block.getLevel().getFolderName()+
                "-"+new Double(this.block.getX()).longValue()+
                "-"+new Double(this.block.getY()).longValue()+
                "-"+new Double(this.block.getZ()).longValue();
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
}
