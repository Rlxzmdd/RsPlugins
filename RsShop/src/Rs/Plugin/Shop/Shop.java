package Rs.Plugin.Shop;

import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/15.
 */
public class Shop {
    public BlockEntitySign sign;
    public File file = new File("plugins/RsShop/").getAbsoluteFile();
    public cn.nukkit.utils.Config config =  null;
    public Shop(BlockEntitySign sign){
        this.sign = sign;
    }
    public boolean isShop(){
        return getFile().exists();
    }
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
    public void CreateShop(){
        if(getFile().exists()){
            return;
        }else{
            sign.setText("[SHOP]","1:1","64","Money:999");
            getConfig().set("Item","1:1");
            getConfig().set("Number",64);
            getConfig().set("Coin","Money");
            getConfig().set("Money",999);
            getConfig().save();
        }
        //[Shop]
        //物品:
        //数量:
        //售价
    }
}
