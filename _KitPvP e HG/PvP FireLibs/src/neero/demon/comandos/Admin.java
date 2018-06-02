
package neero.demon.comandos;

import java.util.ArrayList;
import java.util.HashMap;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Admin
implements CommandExecutor,
Listener {
    public static ArrayList<String> admin = new ArrayList<String>();
    public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
    public static HashMap<String, ItemStack[]> savearmor = new HashMap<String, ItemStack[]>();

    @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
            return true;
        }
        if (!sender.hasPermission("ng.admin")) {
            sender.sendMessage("§cSem Permissao");
            return true;
        }
        Player p = (Player)sender;
        if (args.length == 0) {
            if (!admin.contains(p.getName())) {
                p.sendMessage("§bVoc\u00ea entrou no Modo Admin!");
                Player[] arrplayer = Bukkit.getOnlinePlayers();
                int n = arrplayer.length;
                int n2 = 0;
                while (n2 < n) {
                    Player s = arrplayer[n2];
                    s.hidePlayer(p);
                    ++n2;
                }
                p.setGameMode(GameMode.CREATIVE);
                p.setAllowFlight(true);
                admin.add(p.getName());
                saveinv.put(p.getName(), p.getInventory().getContents());
                savearmor.put(p.getName(), p.getInventory().getArmorContents());
                p.getInventory().clear();
                ItemStack redstone = new ItemStack(Material.REDSTONE);
                ItemMeta redstonemeta = redstone.getItemMeta();
                redstonemeta.setDisplayName("§b§lSair do modo Admin");
                redstone.setItemMeta(redstonemeta);
                ItemStack info = new ItemStack(Material.NETHER_STAR);
                ItemMeta infometa = info.getItemMeta();
                infometa.setDisplayName("§c§lInformaçoes do Player");
                info.setItemMeta(infometa);
                ItemStack repulsao = new ItemStack(Material.STICK);
                ItemMeta repulsaometa = repulsao.getItemMeta();
                repulsaometa.addEnchant(Enchantment.KNOCKBACK, 5, true);
                repulsaometa.setDisplayName("§c§lTestar Knock-Back");
                repulsao.setItemMeta(repulsaometa);
                ItemStack autosoup = new ItemStack(Material.BOWL);
                ItemMeta autosoupmeta = autosoup.getItemMeta();
                autosoupmeta.setDisplayName("§c§lTestar Auto-Soup");
                autosoup.setItemMeta(autosoupmeta);
                ItemStack tr = new ItemStack(Material.MAGMA_CREAM);
                ItemMeta trmeta = tr.getItemMeta();
                trmeta.setDisplayName("§c§lTroca Rapida");
                tr.setItemMeta(trmeta);
                ItemStack arena = new ItemStack(Material.MOB_SPAWNER);
                ItemMeta arenameta = arena.getItemMeta();
                arenameta.setDisplayName("§c§lArena");
                arena.setItemMeta(arenameta);
                ItemStack crash = new ItemStack(Material.BONE);
                ItemMeta crashmeta = crash.getItemMeta();
                crashmeta.setDisplayName("§c§lCrash");
                crash.setItemMeta(crashmeta);
                p.getInventory().setItem(8, redstone);
                p.getInventory().setItem(1, info);
                p.getInventory().setItem(2, autosoup);
                p.getInventory().setItem(4, tr);
                p.getInventory().setItem(6, crash);
                p.getInventory().setItem(7, arena);
                p.updateInventory();
            } else {
                p.sendMessage("§c§lVocê saiu do modo Admin");
                p.getInventory().clear();
                admin.remove(p.getName());
                Player[] infometa = Bukkit.getOnlinePlayers();
                int info = infometa.length;
                int redstonemeta = 0;
                while (redstonemeta < info) {
                    Player s = infometa[redstonemeta];
                    s.showPlayer(p);
                    p.setGameMode(GameMode.ADVENTURE);
                    ++redstonemeta;
                }
                p.getInventory().setContents(saveinv.get(p.getName()));
                p.getInventory().setArmorContents(savearmor.get(p.getName()));
                p.updateInventory();
            }
        }
        return false;
    }

    @EventHandler
    public void InteragirRedstone(PlayerInteractEvent e) {
        if (e.getMaterial() == Material.REDSTONE && admin.contains(e.getPlayer().getName())) {
            e.getPlayer().chat("/admin");
            e.getPlayer().updateInventory();
        }
    }

    @EventHandler
    public void Interagirinfo(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.NETHER_STAR && admin.contains(e.getPlayer().getName())) {
            Player t;
            Player p = e.getPlayer();
            Player hp = t = (Player)e.getRightClicked();
            p.sendMessage("§6Informaçoes de §c§l§o" + t.getName());
            p.sendMessage("§6Sopa: §e" + Admin.getMaterial(t, Material.MUSHROOM_SOUP));
            p.sendMessage("§6IP: §e" + Bukkit.getIp());
            p.sendMessage("§6Fome: §e" + t.getFoodLevel());
            p.sendMessage("§6Kit: §e" + KitAPI.getkit(t));
        }
    }

    public static int getMaterial(Player p, Material m) {
        int value = 0;
        ItemStack[] arritemStack = p.getInventory().getContents();
        int n = arritemStack.length;
        int n2 = 0;
        while (n2 < n) {
            ItemStack item = arritemStack[n2];
            if (item != null && item.getType() == m && item.getAmount() > 0) {
                value += item.getAmount();
            }
            ++n2;
        }
        return value;
    }

    @EventHandler
    public void autosoup(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.BOWL && admin.contains(e.getPlayer().getName())) {
            final Player p = e.getPlayer();
            final Player t = (Player)e.getRightClicked();
            p.openInventory((Inventory)t.getInventory());
            t.setHealth(2);
            saveinv.put(t.getName(), t.getInventory().getContents());
            savearmor.put(t.getName(), t.getInventory().getArmorContents());
            t.getInventory().setItem(16, new ItemStack(Material.MUSHROOM_SOUP));
            t.getInventory().setItem(17, new ItemStack(Material.AIR));
            t.getInventory().setItem(18, new ItemStack(Material.AIR));
            t.getInventory().setItem(19, new ItemStack(Material.AIR));
            t.getInventory().setItem(20, new ItemStack(Material.AIR));
            t.getInventory().setItem(21, new ItemStack(Material.AIR));
            t.getInventory().setItem(23, new ItemStack(Material.AIR));
            t.getInventory().setItem(25, new ItemStack(Material.AIR));
            t.getInventory().clear();
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    t.getInventory().setItem(16, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 25);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    t.getInventory().setItem(17, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 50);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    t.getInventory().setItem(18, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 75);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @SuppressWarnings("deprecation")
				@Override
                public void run() {
                    t.getInventory().setItem(19, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 100);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @SuppressWarnings("deprecation")
				@Override
                public void run() {
                    t.getInventory().setItem(20, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 125);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @SuppressWarnings("deprecation")
				@Override
                public void run() {
                    t.getInventory().setItem(21, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 150);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    t.getInventory().setItem(23, new ItemStack(Material.MUSHROOM_SOUP));
                    t.setHealth(2);
                }
            }, 175);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    t.getInventory().setItem(25, new ItemStack(Material.MUSHROOM_SOUP));
                    t.getInventory().setContents(Admin.saveinv.get(t.getName()));
                    t.getInventory().setArmorContents(Admin.savearmor.get(t.getName()));
                    p.updateInventory();
                    t.updateInventory();
                    p.closeInventory();
                }
            }, 200);
        }
    }

    @EventHandler
    public void tr(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getMaterial() == Material.MAGMA_CREAM && admin.contains(p.getName()) && p.hasPermission("ng.admin")) {
            Player[] arrplayer = Bukkit.getOnlinePlayers();
            int n = arrplayer.length;
            int n2 = 0;
            while (n2 < n) {
                Player s = arrplayer[n2];
                s.showPlayer(p);
                p.setGameMode(GameMode.SURVIVAL);
                ++n2;
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    Player[] arrplayer = Bukkit.getOnlinePlayers();
                    int n = arrplayer.length;
                    int n2 = 0;
                    while (n2 < n) {
                        Player s = arrplayer[n2];
                        if (p.hasPermission("ng.admin")) {
                            s.hidePlayer(p);
                            p.setGameMode(GameMode.CREATIVE);
                        }
                        ++n2;
                    }
                }
            }, 10);
        }
    }

    @EventHandler
    public void abririnv(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.AIR && admin.contains(p.getName()) && p.hasPermission("ng.admin")) {
            Player t = (Player)e.getRightClicked();
            p.openInventory((Inventory)t.getInventory());
        }
    }

    @EventHandler
    public void arena(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.MOB_SPAWNER && admin.contains(e.getPlayer().getName())) {
            Player t = (Player)e.getRightClicked();
            e.getPlayer().chat("/arena " + t.getName());
        }
    }

    @EventHandler
    public void crash(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.BONE && admin.contains(e.getPlayer().getName())) {
            Player t = (Player)e.getRightClicked();
            e.getPlayer().chat("/crash " + t.getName());
        }
    }

}

