package Rs.Plugin.Shop;

import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

/**
 * Created by Rlx on 2016/2/15.
 */
public class Lang implements Rs.Plugin.Function.Lang {
    @Override
    public File getfile() {
        return new File("plugins/RsShop/").getAbsoluteFile() ;
    }
}
