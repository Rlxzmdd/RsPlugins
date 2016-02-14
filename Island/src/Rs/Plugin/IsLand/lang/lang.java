package Rs.Plugin.IsLand.lang;

import Rs.Plugin.Function.Lang;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

public class lang implements Lang
{
    @Override
    public String getMsg(String msg, String address) {
        File qwe = new File(new File("plugins/IsLand").getAbsoluteFile()+"/"+address+".json");
        if(qwe.exists()){
            Config config = new Config(qwe, Config.JSON);
            Map<String,Object> lang = config.getAll();
            if (!lang.containsKey(msg)) {
                return lang.get("Error.lang").toString();
            }else {
                return lang.get(msg).toString();
            }
        }else{
            Config config = new Config( new File(new File("plugins/IsLand").getAbsoluteFile()+"/en.json"), Config.JSON);
            Map<String,Object> lang = config.getAll();
            if (!lang.containsKey(msg)) {
                return lang.get("Error.lang").toString();
            }else {
                return lang.get(msg).toString();
            }
        }
       // File
    }
    /*private String ip;
    public Plugin plugin = null;
    public Player player = null;

    public lang(String ip) {
        this.ip = ip;
    }
    public lang(String ip, Player player) {
        this.ip = ip;
        this.player = player;
    }
    public lang(String ip, Player player, MainClass mainClass) {
        this.ip = ip;
        this.player = player;
        this.plugin = mainClass;
    }

    public String getAddresses(String content, String encodingString) throws UnsupportedEncodingException
    {
        String urlStr = "http://ip.taobao.com/service/getIpInfo.php";

        String returnStr = getResult(urlStr, content, encodingString);
        if (returnStr != null)
        {
            String[] temp = returnStr.split(",");
            if (temp.length < 3) {
                return null;
            }
            String country = "";
            country = temp[1].split(":")[2].replaceAll("\"", "");
            country = decodeUnicode(country);

            return country;
        }

        return null;
    }

    private String getResult(String urlStr, String content, String encoding)
    {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlStr);
            connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(2000);
            connection.setReadTimeout(200);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.connect();

            DataOutputStream out = new DataOutputStream(connection
                    .getOutputStream());
            out.writeBytes(content);
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();

            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public static String decodeUnicode(String theString)
    {
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            char aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - 48;
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 97;
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 65;
                                break;
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                            case 'G':
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                            default:
                                throw new IllegalArgumentException("Malformed      encoding.");
                        }
                    }

                    outBuffer.append((char)value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            } else {
                outBuffer.append(aChar);
            }
        }
        return outBuffer.toString();
    }

    public String getLang() {
        Config config = new Config(this.plugin.getDataFolder() + "\\config.yml");
        if (!config.get("Lang").toString().equals("0")) {
            return config.get("Lang").toString();
        }
        try
        {
            String address = getAddresses("ip=" + this.ip, "utf-8");
            if (address.equals("中国"))
                return "zho";
            if (address.equals("美国"))
                return "eng";
            if (address.equals("俄罗斯"))
                return "rus";
            if (address.equals("日本"))
                return "jap";
            if (address.equals("英国")) {
                return "eng";
            }
            return "eng";
        } catch (UnsupportedEncodingException e) {
        }
        return "eng";
    }

    public String getPlayerLang(Player player)
    {
        Config config = new Config(new File(this.plugin.getDataFolder() + "\\Players\\" + player.getName() + ".json"), 1);
        if (config.get("lang").toString().equals("0")) {
            this.ip = player.getAddress();
            return getLang();
        }
        return config.get("lang").toString();
    }

    public String getMsg(String msg)
    {
        if (this.plugin == null) {
            return "Error.lang1";
        }
        if (this.player == null) {
            File asd = new File(this.plugin.getDataFolder(), "\\Langs\\" + getLang() + ".json");
            if (asd.exists()) {
                Config config = new Config(asd, 1);
                if (!config.exists(msg))
                    msg = config.get("Error.lang").toString();
                else
                    msg = config.get(msg).toString();
            }
            else {
                Config config = new Config(new File(this.plugin.getDataFolder(), "\\Langs\\eng.json"), 2);
                if (!config.exists(msg))
                    msg = config.get("Error.lang").toString();
                else {
                    msg = config.get(msg).toString();
                }
            }
            return msg;
        }
        File asd = new File(this.plugin.getDataFolder(), "\\Langs\\" + getPlayerLang(this.player) + ".json");
        if (asd.exists()) {
            Config config = new Config(asd, 1);
            if (!config.exists(msg))
                msg = config.get("Error.lang").toString();
            else
                msg = config.get(msg).toString();
        }
        else {
            Config config = new Config(new File(this.plugin.getDataFolder(), "\\Langs\\eng.json"), 2);
            if (!config.exists(msg))
                msg = config.get("Error.lang").toString();
            else {
                msg = config.get(msg).toString();
            }
        }
        return msg;
    }

    public void setLang(String lang)
    {
        Config config = new Config(this.plugin.getDataFolder() + "/config.yml");
        config.set("Lang", lang);
        config.save();
    }
*/

}