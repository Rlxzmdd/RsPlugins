package Rs.Plugin.Plot.lang;

import Rs.Plugin.Function.Lang;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

public class lang implements Lang
{

    @Override
    public File getfile() {
        return new File("plugins/RsPlot").getAbsoluteFile();
    }
}