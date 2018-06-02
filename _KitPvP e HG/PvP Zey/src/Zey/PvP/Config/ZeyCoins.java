package Zey.PvP.Config;

import org.bukkit.event.*;

import Zey.PvP.Main.*;

import org.bukkit.entity.*;

public class ZeyCoins implements Listener
{
    public static MyConfig PlayerMoney;
    public static int defaultmoney;
    
    static {
        ZeyCoins.defaultmoney = 0;
    }
    
    public static void loadMoneyManager() {
        ZeyCoins.PlayerMoney = Main.manager.getNewConfig("ZeyCoins.yml");
    }
    
    public static int getPlayerMoney(final Player p) {
        return ZeyCoins.PlayerMoney.getInt(p.getUniqueId().toString());
    }
    
    public static void addMoney(final Player p, final int add) {
        ZeyCoins.PlayerMoney.set(p.getUniqueId().toString(), getPlayerMoney(p) + add);
        ZeyCoins.PlayerMoney.saveConfig();
    }
    
    public static void removeMoney(final Player p, final int remove) {
        ZeyCoins.PlayerMoney.set(p.getUniqueId().toString(), getPlayerMoney(p) - remove);
        ZeyCoins.PlayerMoney.saveConfig();
    }
    
    public static void addMoney(final String name, final int aposta) {
    }
}
