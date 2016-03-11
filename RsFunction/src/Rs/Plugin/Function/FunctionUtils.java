package Rs.Plugin.Function;

import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Locale;

/**
 * Created by Rlx on 2016/2/9.
 */
public class FunctionUtils {
    public String getLang(){
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        switch (country){
            case"CN":
                return "zh";
            case"TW":
                return "zh";
            case"HK":
                return "zh";
            case"MO":
                return "zh";
            case"BY":
                return "ru";
            case"RU":
                return "ru";
            case"JP":
                return "ja";
            case"KR":
                return "ko";
            case"US":
                return "en";
            case"GB":
                return "en";
        }
        return this.getl(language);
    }
    public String getl(String c){
        switch (c){
            case"zh":
                return "zh";
            case"zh-CN":
                return "zh";
            case"zh-HK":
                return "zh";
            case"zh-MO":
                return "zh";
            case"zh-SG":
                return "zh";
            case"zh-TW":
                return "zh";
            case"ja":
                return "ja";
            case"ja-JP":
                return "ja";
            case"ko":
                return "ko";
            case"ko-KR":
                return "ko";
            case"ru":
                return "ru";
            case"ru-RU":
                return "ru";
        }
        return c;
    }

    public String getSystemLang() {
        //getLogger().info(this.fileName);
        File file = new File(new File("plugins/Language").getAbsolutePath(), "config.json");
        if (file.exists()) {
            Config config = new Config(file, Config.JSON);
            //return "eng";
            config.set("Lang", new FunctionUtils().getLang());
            config.save();
            return config.get("Lang").toString();
        } else {
            Config config = new Config(file, Config.JSON);
            config.set("Lang", new FunctionUtils().getLang());
            config.save();
            return config.get("Lang").toString();
        }
    }
}
