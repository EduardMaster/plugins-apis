package Zey.PvP.Config;

import java.util.List;

import Zey.PvP.Main.Main;

public class ConfigManager
{
    public static String getString(final String text) {
        return Main.getPlugin().getConfig().getString(text).replace("&", "§");
    }
    
    public static Integer getInt(final String text) {
        return Main.getPlugin().getConfig().getInt(text);
    }
    
    public static List<String> getList(final String text) {
        return (List<String>)Main.getPlugin().getConfig().getStringList(text);
    }
    
    public static void setConfig(final String text, final String c) {
        Main.getPlugin().getConfig().set(text, (Object)c);
        Main.getPlugin().saveConfig();
    }
}
