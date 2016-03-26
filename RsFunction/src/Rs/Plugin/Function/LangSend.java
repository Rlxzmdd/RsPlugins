package Rs.Plugin.Function;

import Rs.Plugin.Function.Lang;
import Rs.Plugin.Function.RsFunction;
import Rs.Plugin.Function.Utils.FunctionUtils;
import cn.nukkit.Player;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

/**
 * Created by Rlx on 2016/2/5.
 */
public class LangSend {
    public Lang lang = null;
    public Player player = null;
    public LangSend(Lang lang){
        this.lang = lang;
    }
    public String getMsg(String msg,Player player){
        if(this.player == null){
            this.player = player;
        }
        File file;
        if(this.player != null){
            file  = new File(lang.getfile(),new RsFunction().getPlayerLang(this.player)+".json");
        }else{
            file  = new File(lang.getfile(),new FunctionUtils().getSystemLang()+".json");
    }
            if(file.exists()){

                Config config = new Config(file, Config.JSON);
                Map configs = config.getAll();
               // System.out.println(configs+".."+configs.get("Error.lang"));
                    if(configs.containsKey(msg)){
                        return configs.get(msg).toString();
                }else if(configs.containsKey("Error.lang")){
                    return configs.get("Error.lang").toString();
                }else{
                    return msg;
                }
            }else if(new File(lang.getfile(),"en.json").exists()){
                Config config = new Config(new File(lang.getfile(),"en.json"),Config.JSON);
                Map configs = config.getAll();
                if(configs.containsKey(msg)){
                    return configs.get(msg).toString();
                }else if(configs.containsKey("Error.lang")){
                    return configs.get("Error.lang").toString();
                }else{
                    return msg;
                }
            }else{
                return msg;
            }

    }
    public String getMsg(String msg) {
        return getMsg(msg, null);
    }

    public String replaceAll(String msg,String mode1,String msg1,String mode2,String msg2,String mode3,String msg3,String mode4,String msg4) {
        return replaceAll(msg, mode1, msg1, mode2, msg2, mode3, msg3).replaceAll(mode4, msg4);
    }
    public String replaceAll(String msg,String mode1,String msg1,String mode2,String msg2,String mode3,String msg3){
        return replaceAll(msg, mode1, msg1, mode2, msg2).replaceAll(mode3,msg3);
    }
    public String replaceAll(String msg,String mode1,String msg1,String mode2,String msg2){
        return replaceAll(msg, mode1, msg1).replaceAll(mode2,msg2);
    }
    public String replaceAll(String msg,String mode1,String msg1){
        return msg.replaceAll(mode1,msg1);
    }


    public String getMsg(String msg,String mode1,String msg1,String mode2,String msg2,String mode3,String msg3,String mode4,String msg4) {
        return getMsg(msg,mode1, msg1,mode2, msg2,mode3, msg3).replaceAll(mode4, msg4);
    }
    public String getMsg(String msg,String mode1,String msg1,String mode2,String msg2,String mode3,String msg3){
        return getMsg(msg,mode1, msg1,mode2, msg2).replaceAll(mode3,msg3);
    }
    public String getMsg(String msg,String mode1,String msg1,String mode2,String msg2){
        return getMsg(msg,mode1, msg1).replaceAll(mode2,msg2);
    }
    public String getMsg(String msg,String mode1,String msg1){
        return getMsg(msg).replaceAll(mode1,msg1);
    }

    public void sM(String msg,Player player){
        player.sendMessage(getMsg(msg,player));
    }
}
