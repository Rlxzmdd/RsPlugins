package Rs.Plugin.Function;

import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class position
{
    private String ip;
    public Plugin plugin = null;
    public Player player = null;

    public position(){}
    public position(String ip) {
        this.ip = ip;
    }
    public position(String ip, Player player) {
        this.ip = ip;
        this.player = player;
    }
    public position(String  ip, Player player, Plugin mainClass) {
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
            connection.setReadTimeout(1000);
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
        try
        {
            String address = getAddresses("ip=" + this.ip, "utf-8");
            //System.out.println(address);
            if(address == null){
                return "en";
            }
            if (address.equals("中国"))
                return "zh";
            if (address.equals("美国"))
                return "en";
            if (address.equals("俄罗斯"))
                return "ru";
            if (address.equals("日本"))
                return "ja";
            if(address.equals("韩国"))
                return "ko";
        } catch (UnsupportedEncodingException e) {
            //System.out.println(e);
            return "en";
        }
        return "en";
    }

}