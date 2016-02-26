package Rs.Plugin.Shop;

import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

/**
 * Created by Rlx on 2016/2/15.
 */
public class Lang implements Rs.Plugin.Function.Lang {
    @Override
    public String getMsg(String msg, String address) {
        File qwe = new File(new File("plugins/RsShop/").getAbsoluteFile()+"/"+address+".json");
        Config config = new Config(new File(new File("plugins/RsShop/").getAbsoluteFile() + "/en.json"));
        config.set(msg,"-");
        config.save();
        return "";
       /* if(qwe.exists()){
            Config config = new Config(qwe, Config.JSON);
            Map<String,Object> lang = config.getAll();
            if (!lang.containsKey(msg)) {
                if(!lang.containsKey("Error.lang")){
                    return "No Text";
                }
                return lang.get("Error.lang").toString();
            }else {
                return lang.get(msg).toString();
            }
        }else {
            Config config = new Config(new File(new File("plugins/RsMoney/").getAbsoluteFile() + "/en.json"), Config.JSON);
            Map<String, Object> lang = config.getAll();
            if (!lang.containsKey(msg)) {
                if(!lang.containsKey("Error.lang"))
                return "No Lang";
                return lang.get("Error.lang").toString();
            } else {
                return lang.get(msg).toString();
            }

        }*/
    }
}
