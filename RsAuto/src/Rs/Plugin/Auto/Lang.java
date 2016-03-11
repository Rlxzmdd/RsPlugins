package Rs.Plugin.Auto;

import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

public class Lang implements Rs.Plugin.Function.Lang {
    @Override
    public File getfile() {
        return( new File("plugins/RsAuto").getAbsoluteFile());
    }
}

