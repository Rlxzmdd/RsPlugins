package Rs.Plugin.Message;

import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.utils.Config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Rlx on 2016/2/13.
 */
public class PTNotice extends PluginTask {
    private Plugin plugin;
    private File file = new File("plugins/RsMessage/").getAbsoluteFile();

    public PTNotice(Plugin owner) {
        super(owner);
        this.plugin = owner;
    }

    //为了减少对服务器的负担
    //计时器频率设置1秒一次
    //
    @Override
    public void onRun(int i) {
        Config config = new Config(file + "/PTNotice.yml", Config.YAML);
        if (!config.exists("WillUse")) {
            return;
        }
        ArrayList<String> WillUse = (ArrayList) config.get("WillUse");
        //this.plugin.getLogger().info(WillUse+","+WillUse.get(0));
        //this.plugin.getLogger().info(new SimpleDateFormat("yyyyMMddHHmm").format(new Date()));
        Iterator iterator=WillUse.iterator();
        while (iterator.hasNext()) {
            String Use = iterator.next().toString();
            if(config.exists(Use)){
                Map<String, String> notice = (Map) config.get(Use);

                Long asd = (Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())) - (Long.parseLong(notice.get("UseTime"))));
                if (asd >= Long.parseLong(notice.get("Intervel"))) {
                    //this.plugin.getLogger().info("触发了，");

                    if (notice.get("Mode").toString().equals("Tip"))
                        this.OnlinePlayerTip(notice.get("Contect"));
                    if (notice.get("Mode").toString().equals("Popup"))
                        this.OnlinePlayerPopup(notice.get("Contect"));

                    if (asd >= (Long.parseLong(notice.get("Intervel")) + Long.parseLong(notice.get("Duration")))) {
                        //this.plugin.getLogger().info("触发结束");
                        notice.put("UseTime", new SimpleDateFormat("yyyyMMddHHmm").format(new Date()));
                        config.set(Use, notice);
                        config.save();
                    }
                }
            }
        }

        //思路：当前时间戳减去UseTime，得到中间时间，再判断是否大于Intervel，然后开始发送Mode，Contect的，
        // 发送完判断是否大于Duration+Intervel，大于则把UseTime设置为当前时间
    }
    /*
    PTNotice.yml文件结构:
    WillUse:
     - XXX
    XXX:
      Duration: 1m  //持续的时间
      Intervel: 5m  //间隔的时间
      //注意，这里的Intervel是间隔触发时间
      UseTime: XXXX //使用过的时间
      Contect: "你开心就好" //内容
      Mode: Tip     //公告发出的形式
     */
    public void OnlinePlayerTip(String msg){
        Set set=this.plugin.getServer().getOnlinePlayers().entrySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            Map.Entry  mapentry = (Map.Entry) iterator.next();
            // ((Player)mapentry.getValue()).sendTip("23333");
            ((Player) mapentry.getValue()).sendTip(msg);
        }
    }
    public void OnlinePlayerPopup(String msg){
        Set set=this.plugin.getServer().getOnlinePlayers().entrySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            Map.Entry  mapentry = (Map.Entry) iterator.next();
            // ((Player)mapentry.getValue()).sendTip("23333");
            ((Player) mapentry.getValue()).sendPopup(msg);
        }
    }
}
