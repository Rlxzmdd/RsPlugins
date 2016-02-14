package Rs.Plugin.Message;

import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

public class Lang implements Rs.Plugin.Function.Lang {
    @Override
    public String getMsg(String msg, String address) {
        File qwe = new File(new File("plugins/RsMessage/").getAbsoluteFile()+"/"+address+".json");
        if(qwe.exists()){
            Config config = new Config(qwe, Config.JSON);
            Map<String,Object> lang = config.getAll();
            if (!lang.containsKey(msg)) {
                return lang.get("Error.lang").toString();
            }else {
                return lang.get(msg).toString();
            }
        }else {
            Config config = new Config(new File(new File("plugins/RsMessage/").getAbsoluteFile() + "/en.json"), Config.JSON);
            Map<String, Object> lang = config.getAll();
            if (!lang.containsKey(msg)) {
                return lang.get("Error.lang").toString();
            } else {
                return lang.get(msg).toString();
            }
        }
    }
}

