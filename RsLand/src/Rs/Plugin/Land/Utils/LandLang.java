package Rs.Plugin.Land.Utils;

import Rs.Plugin.Function.Lang;

import java.io.File;

/**
 * Created by admin on 2016/3/10.
 */
public class LandLang implements Lang {
    @Override
    public File getfile() {
        return new File("plugins/RsLand").getAbsoluteFile();
    }
}
