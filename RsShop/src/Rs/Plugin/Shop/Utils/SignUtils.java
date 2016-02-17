package Rs.Plugin.Shop.Utils;

import Rs.Plugin.Shop.Shop;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/16.
 */
public class SignUtils {
    public BlockEntitySign sign;
    public File file = new File("plugins/RsShop/").getAbsoluteFile();
    public Config config =null;
    public SignUtils(BlockEntitySign sign){
        this.sign = sign;
    }
    public File getFile(){
        String asd = this.sign.getBlock().getLevel().getFolderName()+
                "-"+new Double(this.sign.getBlock().getX()).longValue()+
                "-"+new Double(this.sign.getBlock().getY()).longValue()+
                "-"+new Double(this.sign.getBlock().getZ()).longValue();
        return (new File(file+"/Shops/"+asd+".json"));
    }
    public boolean isShop(){
        return getFile().exists();
    }
    public Shop getShop(){
        if(this.isShop()){
            return new Shop(sign);
        }else{
            return null;
        }
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
       // System.out.print(123123);
        if(getFile().exists()){
            //System.out.print(123);
            return;
        }else{
            System.out.print(123123123);
            sign.setText("[SHOP]",sign.getText()[1] +"*"+sign.getText()[2],"Money:999");
            getConfig().set("Item",sign.getText()[1]);
            getConfig().set("Number",sign.getText()[2]);
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
