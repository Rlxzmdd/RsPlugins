package Rs.Plugin.Shop;

import Rs.Plugin.Shop.Utils.SignUtils;
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
        return new SignUtils(sign).getFile();
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
