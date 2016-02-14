package Rs.Plugin.Function;

import java.util.Locale;

/**
 * Created by Rlx on 2016/2/9.
 */
public class FunctionUtils {
    public String getLang(){
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        switch (language){
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
        return this.getl(country);
    }
    public String getl(String c){
        switch (c){
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
        return "en";
    }
}
