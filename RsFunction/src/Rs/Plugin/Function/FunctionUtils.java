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
                return "zho";
            case"zh-CN":
                return "zho";
            case"zh-HK":
                return "zho";
            case"zh-MO":
                return "zho";
            case"zh-SG":
                return "zho";
            case"zh-TW":
                return "zho";
            case"ja":
                return "jap";
            case"ja-JP":
                return "jap";
            case"ko":
                return "kor";
            case"ko-KR":
                return "kor";
            case"ru":
                return "rus";
            case"ru-RU":
                return "rus";
        }
        return this.getl(country);
    }
    public String getl(String c){
        switch (c){
            case"CN":
                return "zho";
            case"TW":
                return "zho";
            case"HK":
                return "zho";
            case"MO":
                return "zho";
            case"BY":
                return "rus";
            case"RU":
                return "rus";
            case"JP":
                return "jap";
            case"KR":
                return "kor";
            case"US":
                return "eng";
            case"GB":
                return "eng";
        }
        return "eng";
    }
}
