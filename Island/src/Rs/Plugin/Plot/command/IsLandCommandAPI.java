package Rs.Plugin.Plot.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.PluginIdentifiableCommand;

abstract class IsLandCommandAPI extends Command implements PluginIdentifiableCommand {
    public IsLandCommandAPI(String name) {
        super(name);
    }
    /*
/island                               �յ�����            ��ʼ������յ������߷��ص����Ѿ�ӵ�еĵ�
/island restart                       �յ�����            ���°����С�񵺱�ɳ�ʼ״̬����ա�
/island sethome                      ��ס������          ���ûص����ϵ�λ�á�ֻ�����Լ����ķ�Χ
/island info                          �յ���Ϣ           ��ѯ����߱��˵����������Ϣ
/island top                         �յ�ǰʮ���         �鿴ǰʮ�ĵ������
/island lock                           ������            ��ֹ���˽��뵺�죬ǰ��OP�������羯�챣������
/island unlock                         �뵺��            ֻ������Ͱ��ڽ��룬ǰ��OP�������羯�챣������
/island invite <���ID>             �յ����ɽ���         ������Ѽ���ĵ�����ɰ���
/island kick <���ID>               �յ���������         �����Ǹ�˧�������ܺ��Ӱ���
/island makeleader <���ID>         �յ���������         ѡ������е�����
/island accept                      �յ�����趨         ���ܼ��뵽���˵ĵ�һ��չ
/island reject                      �յ�����趨         �������ĵ������ܺ��ӣ��㲻�����
/island leave                       �յ�����趨         �뿪��ĵ���������ǰ�������ĵ��ᱣ������С��ȫɾ����
/island party                         �յ���ѯ           ��ʾ���ڵĵ��İ����ͳ�Ա��Ϣ
/island warp                          �յ�����           �鿴����յ���ѡ��
/island warp <���ID>                 �յ�����           ��ѯ��Ҫ��С�ܶԵ���Ľ���Ҫ���� ���ѵ��������д�������
/island setwarp                   �յ����ⲹ�����       ���ñ��˴��͵��㵺ʱ��λ�ã��Լ�����/island sethome��
/island ban <���ID>                �㶮��ban��~         ��BAN�����޷����͵���ĵ��������ɹ�ȥ�Ϳ��ԡ�
/dev topten                           �յ�ǰʮ          �����µ�ǰʮ���б����߸���
/dev reload                         ����յ�����         ���¼����ļ��е����ã�ȫ���쾻����
/dev remove <���ID>                �յ��������         ɾ��ָ�����˵ĵ���ʹ��Ȩ��������
/dev delete <���ID>                �յ�����ɾ��         ɾ��ָ�����˵ĵ���
/dev purge <����>                   �յ���������         ������û���ߵ���ң������Զ�ɾ��
     */
}