package Rs.Plugin.Plot.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;

abstract class IsLandCommandAPI extends Command implements PluginIdentifiableCommand {
    public IsLandCommandAPI(String name) {
        super(name);
    }
    /*
/island                               空岛创造            开始创建天空岛，或者返回到你已经拥有的岛
/island restart                       空岛创造            重新把你的小鸟岛变成初始状态，清空。
/island sethome                      居住点锁定          设置回到岛上的位置。只能在自己岛的范围
/island info                          空岛信息           查询你或者别人岛屿的排名信息
/island top                         空岛前十玩家         查看前十的岛屿玩家
/island lock                           岛封锁            禁止别人进入岛屿，前提OP启动世界警察保卫命令
/island unlock                         半岛锁            只允许你和帮众进入，前提OP启动世界警察保护命令
/island invite <玩家ID>             空岛帮派建立         邀请好友加你的岛屿组成帮派
/island kick <玩家ID>               空岛帮派踢人         赶走那个帅掉渣的熊孩子帮众
/island makeleader <玩家ID>         空岛帮派领袖         选择帮派中的领袖
/island accept                      空岛玩家设定         接受加入到别人的岛一起发展
/island reject                      空岛玩家设定         请你加入的岛主是熊孩子，你不想加入
/island leave                       空岛玩家设定         离开你的岛，如果你是帮主，你的岛会保留，但小弟全删除。
/island party                         空岛查询           显示你在的岛的帮主和成员信息
/island warp                          空岛变形           查看改造空岛的选项
/island warp <玩家ID>                 空岛变形           查询并要求小弟对岛屿的建设要积极 （难道不积极有处罚？）
/island setwarp                   空岛特殊补充变形       设置别人传送到你岛时的位置（自己的是/island sethome）
/island ban <玩家ID>                你懂的ban嘛~         被BAN的人无法传送到你的岛，但他飞过去就可以。
/dev topten                           空岛前十          生成新的前十名列表，或者更新
/dev reload                         管理空岛重启         重新加载文件中的配置（全岛屿净化）
/dev remove <玩家ID>                空岛管理免除         删除指定的人的岛屿使用权，岛还在
/dev delete <玩家ID>                空岛管理删除         删除指定的人的岛屿
/dev purge <几天>                   空岛天数整肃         多少天没上线的玩家，岛屿自动删除
     */
}