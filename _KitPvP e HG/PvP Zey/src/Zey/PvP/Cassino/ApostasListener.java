package Zey.PvP.Cassino;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import Zey.PvP.Config.ConfigManager;
import Zey.PvP.Config.ZeyCoins;
import Zey.PvP.Main.Main;

public class ApostasListener extends ConfigManager implements Listener
{
    public static HashMap<String, Integer> valor;
    public static HashMap<String, String> apostado;
    public static HashMap<String, Integer> numero;
    
    static {
        ApostasListener.valor = new HashMap<String, Integer>();
        ApostasListener.apostado = new HashMap<String, String>();
        ApostasListener.numero = new HashMap<String, Integer>();
    }
    
    public static ItemStack getItem(final Material material, final String nome, final int quantidade, final int bite) {
        final ItemStack item = new ItemStack(material, quantidade, (short)bite);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    @EventHandler
    public void entitbiausdsan(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Villager) {
            final Villager v = (Villager)e.getEntity();
            if (v.getCustomName().equalsIgnoreCase("§c§l✽ CASSINO ✽")) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void nsaioudnsa(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            final Villager v = (Villager)e.getRightClicked();
            if (v.getCustomName().equalsIgnoreCase("§c§l✽ CASSINO ✽")) {
                e.setCancelled(true);
                Seletor(e.getPlayer());
            }
        }
    }
    
    public static void Seletor(final Player p) {
        if (ApostasListener.apostado.containsKey(p.getName())) {
            ApostasListener.apostado.remove(p.getName());
        }
        if (ApostasListener.valor.containsKey(p.getName())) {
            ApostasListener.valor.remove(p.getName());
        }
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 36, "§c§l✽ CASSINO ✽");
        final ItemStack coins = getItem(Material.GOLD_INGOT, "§6R$" + ZeyCoins.getPlayerMoney(p), 1, 0);
        final ItemStack milm = getItem(Material.STAINED_CLAY, "§a$1,000", 1, 5);
        final ItemStack cincom = getItem(Material.STAINED_CLAY, "§a$5,000", 5, 5);
        final ItemStack dezm = getItem(Material.STAINED_CLAY, "§a$10,000", 10, 5);
        final ItemStack cinqm = getItem(Material.STAINED_CLAY, "§a$50,000", 50, 5);
        final ItemStack ct = getItem(Material.STAINED_CLAY, "§9Azul §7(x2)", 1, 3);
        final ItemStack tr = getItem(Material.STAINED_CLAY, "§cVermelho §7(x2)", 1, 14);
        final ItemStack gold = getItem(Material.STAINED_CLAY, "§6Ouro §7(x4)", 1, 4);
        final ItemStack miln = getItem(Material.STAINED_CLAY, "§c$1,000", 1, 14);
        final ItemStack cincon = getItem(Material.STAINED_CLAY, "§c$5,000", 5, 14);
        final ItemStack dezn = getItem(Material.STAINED_CLAY, "§c$10,000", 10, 14);
        final ItemStack cinqn = getItem(Material.STAINED_CLAY, "§c$50,000", 50, 14);
        final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
        final ItemStack glass = getItem(Material.THIN_GLASS, "-", 1, 0);
        inv.setItem(4, coins);
        inv.setItem(12, ct);
        inv.setItem(13, tr);
        inv.setItem(14, gold);
        inv.setItem(27, miln);
        inv.setItem(28, cincon);
        inv.setItem(29, dezn);
        inv.setItem(30, cinqn);
        inv.setItem(31, apostado);
        inv.setItem(35, milm);
        inv.setItem(34, cincom);
        inv.setItem(33, dezm);
        inv.setItem(32, cinqm);
        ItemStack[] arrayOfItemStack;
        for (int descpyro = (arrayOfItemStack = inv.getContents()).length, metapyro = 0; metapyro < descpyro; ++metapyro) {
            final ItemStack item = arrayOfItemStack[metapyro];
            if (item == null) {
                inv.setItem(inv.firstEmpty(), glass);
            }
        }
        p.openInventory(inv);
    }
    
    public static void SeletorApostar(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 18, "§6§lAPOSTANDO...");
        final ItemStack ll = getItem(Material.TRIPWIRE_HOOK, "-", 1, 0);
        inv.setItem(4, ll);
        final ItemStack glass = getItem(Material.THIN_GLASS, "-", 1, 0);
        ItemStack[] arrayOfItemStack;
        for (int descpyro = (arrayOfItemStack = inv.getContents()).length, metapyro = 0; metapyro < descpyro; ++metapyro) {
            final ItemStack item = arrayOfItemStack[metapyro];
            if (item == null) {
                inv.setItem(inv.firstEmpty(), glass);
            }
        }
        inv.setItem(10, randomItem());
        inv.setItem(11, randomItem());
        inv.setItem(12, randomItem());
        inv.setItem(13, randomItem());
        inv.setItem(14, randomItem());
        inv.setItem(15, randomItem());
        inv.setItem(16, randomItem());
        p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
        ApostasListener.numero.put(p.getName(), 0);
        new BukkitRunnable() {
            @SuppressWarnings({ "deprecation" })
			public void run() {
                if (p.getInventory() != inv) {
                    if (ApostasListener.numero.get(p.getName()) < 21) {
                        inv.setItem(10, inv.getItem(11));
                        inv.setItem(11, inv.getItem(12));
                        inv.setItem(12, inv.getItem(13));
                        inv.setItem(13, inv.getItem(14));
                        inv.setItem(14, inv.getItem(15));
                        inv.setItem(15, inv.getItem(16));
                        inv.setItem(16, ApostasListener.randomItem());
                        p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
                        ApostasListener.numero.put(p.getName(), ApostasListener.numero.get(p.getName()) + 1);
                    }
                    else {
                        this.cancel();
                        if (inv.getItem(13).getData().getData() == 3 && ApostasListener.apostado.get(p.getName()).equalsIgnoreCase("Azul")) {
                            p.sendMessage("§aVocê ganhou R$" + ApostasListener.getAposta(p) * 2);
                            ZeyCoins.addMoney(p, ApostasListener.getAposta(p) * 2);
                            if (ApostasListener.apostado.containsKey(p.getName())) {
                                ApostasListener.apostado.remove(p.getName());
                            }
                            if (ApostasListener.valor.containsKey(p.getName())) {
                                ApostasListener.valor.remove(p.getName());
                            }
                            return;
                        }
                        if (inv.getItem(13).getData().getData() == 14 && ApostasListener.apostado.get(p.getName()).equalsIgnoreCase("Vermelho")) {
                            p.sendMessage("§aVocê ganhou R$" + ApostasListener.getAposta(p) * 2);
                            ZeyCoins.addMoney(p, ApostasListener.getAposta(p) * 2);
                            if (ApostasListener.apostado.containsKey(p.getName())) {
                                ApostasListener.apostado.remove(p.getName());
                            }
                            if (ApostasListener.valor.containsKey(p.getName())) {
                                ApostasListener.valor.remove(p.getName());
                            }
                            return;
                        }
                        if (inv.getItem(13).getData().getData() == 4 && ApostasListener.apostado.get(p.getName()).equalsIgnoreCase("Ouro")) {
                            p.sendMessage("§aVocê ganhou R$" + ApostasListener.getAposta(p) * 4);
                            ZeyCoins.addMoney(p, ApostasListener.getAposta(p) * 2);
                            if (ApostasListener.apostado.containsKey(p.getName())) {
                                ApostasListener.apostado.remove(p.getName());
                            }
                            if (ApostasListener.valor.containsKey(p.getName())) {
                                ApostasListener.valor.remove(p.getName());
                            }
                        }
                        if (inv.getItem(0) != null) {
                            p.sendMessage("§cInfelizmente, você perdeu.");
                            if (ApostasListener.apostado.containsKey(p.getName())) {
                                ApostasListener.apostado.remove(p.getName());
                            }
                            if (ApostasListener.valor.containsKey(p.getName())) {
                                ApostasListener.valor.remove(p.getName());
                            }
                        }
                    }
                }
                else {
                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 5L);
        p.openInventory(inv);
    }
    
    public static ItemStack randomItem() {
        final ItemStack ct = getItem(Material.STAINED_CLAY, "§9Azul §7(x2)", 1, 3);
        final ItemStack tr = getItem(Material.STAINED_CLAY, "§cVermelho §7(x2)", 1, 14);
        final ItemStack gold = getItem(Material.STAINED_CLAY, "§6Ouro §7(x4)", 1, 4);
        final Random rand = new Random();
        final int r = rand.nextInt(100);
        if (r < 45) {
            return ct;
        }
        if (r < 90 && r > 45) {
            return tr;
        }
        if (r > 90) {
            return gold;
        }
        return ct;
    }
    
    @EventHandler
    public void inventory(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        final Inventory inv = e.getClickedInventory();
        if (inv == null) {
            return;
        }
        if (inv.getTitle() == null) {
            return;
        }
        if (!inv.getTitle().equalsIgnoreCase("§c§l✽ CASSINO ✽")) {
            return;
        }
        if (e.getCurrentItem() == null) {
            return;
        }
        if (!e.getCurrentItem().hasItemMeta()) {
            e.setCancelled(true);
            return;
        }
        if (!e.getCurrentItem().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("-")) {
            e.setCancelled(true);
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6R$" + ZeyCoins.getPlayerMoney(p))) {
            e.setCancelled(true);
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","))) {
            e.setCancelled(true);
            if (getAposta(p) > 0) {
                if (ApostasListener.apostado.containsKey(p.getName())) {
                    ZeyCoins.removeMoney(p, getAposta(p));
                    SeletorApostar(p);
                }
                else {
                    p.sendMessage("§cVocê tem que apostar em alguma cor!");
                }
            }
            else {
                p.sendMessage("§cVocê não pode apostar R$0");
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a$1,000")) {
            e.setCancelled(true);
            if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 1000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) + 1000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            else {
                p.sendMessage("§cVocê não possui saldo o suficiente!");
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a$5,000")) {
            e.setCancelled(true);
            if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 5000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) + 5000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            else {
                p.sendMessage("§cVocê não possui saldo o suficiente!");
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a$10,000")) {
            e.setCancelled(true);
            if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 10000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) + 10000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            else {
                p.sendMessage("§cVocê não possui saldo o suficiente!");
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a$50,000")) {
            e.setCancelled(true);
            if (ZeyCoins.getPlayerMoney(p) >= getAposta(p) + 50000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) + 50000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            else {
                p.sendMessage("§cVocê não possui saldo o suficiente!");
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c$1,000")) {
            e.setCancelled(true);
            if (getAposta(p) >= 1000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) - 1000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c$5,000")) {
            e.setCancelled(true);
            if (getAposta(p) >= 5000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) - 5000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c$10,000")) {
            e.setCancelled(true);
            if (getAposta(p) >= 10000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) - 10000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c$50,000")) {
            e.setCancelled(true);
            if (getAposta(p) >= 50000) {
                ApostasListener.valor.put(p.getName(), getAposta(p) - 50000);
                final ItemStack apostado = getItem(Material.STAINED_CLAY, "§aApostar R$" + String.valueOf(getAposta(p)).replace(".", ","), 1, 5);
                inv.setItem(31, apostado);
            }
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Azul §7(x2)")) {
            e.setCancelled(true);
            if (inv.getItem(12).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(12).removeEnchantment(Enchantment.DURABILITY);
            }
            if (inv.getItem(13).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(13).removeEnchantment(Enchantment.DURABILITY);
            }
            if (inv.getItem(14).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(14).removeEnchantment(Enchantment.DURABILITY);
            }
            e.getCurrentItem().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            ApostasListener.apostado.put(p.getName(), "Azul");
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVermelho §7(x2)")) {
            e.setCancelled(true);
            if (inv.getItem(12).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(12).removeEnchantment(Enchantment.DURABILITY);
            }
            if (inv.getItem(13).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(13).removeEnchantment(Enchantment.DURABILITY);
            }
            if (inv.getItem(14).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(14).removeEnchantment(Enchantment.DURABILITY);
            }
            e.getCurrentItem().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            ApostasListener.apostado.put(p.getName(), "Vermelho");
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Ouro §7(x4)")) {
            e.setCancelled(true);
            if (inv.getItem(12).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(12).removeEnchantment(Enchantment.DURABILITY);
            }
            if (inv.getItem(13).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(13).removeEnchantment(Enchantment.DURABILITY);
            }
            if (inv.getItem(14).containsEnchantment(Enchantment.DURABILITY)) {
                inv.getItem(14).removeEnchantment(Enchantment.DURABILITY);
            }
            e.getCurrentItem().addUnsafeEnchantment(Enchantment.DURABILITY, 1);
            ApostasListener.apostado.put(p.getName(), "Ouro");
        }
    }
    
    @EventHandler
    public void inventory2(final InventoryClickEvent e) {
        final Inventory inv = e.getClickedInventory();
        if (inv == null) {
            return;
        }
        if (inv.getTitle() == null) {
            return;
        }
        if (!inv.getTitle().equalsIgnoreCase("§6§lAPOSTANDO...")) {
            return;
        }
        if (e.getCurrentItem() == null) {
            return;
        }
        if (!e.getCurrentItem().hasItemMeta()) {
            e.setCancelled(true);
            return;
        }
        if (e.getCurrentItem().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aa(final InventoryCloseEvent e) {
        final Inventory inv = e.getInventory();
        if (inv.getTitle() != null && inv.getTitle().equalsIgnoreCase("§6§lAPOSTANDO...")) {
            if (ApostasListener.apostado.containsKey(e.getPlayer().getName())) {
                ApostasListener.apostado.remove(e.getPlayer().getName());
            }
            if (ApostasListener.valor.containsKey(e.getPlayer().getName()) && ApostasListener.numero.get(e.getPlayer().getName()) < 21) {
                ZeyCoins.addMoney(e.getPlayer().getName(), getAposta((Player)e.getPlayer()));
                ApostasListener.valor.remove(e.getPlayer().getName());
            }
        }
    }
    
    public static int getAposta(final Player p) {
        if (ApostasListener.valor.containsKey(p.getName())) {
            return ApostasListener.valor.get(p.getName());
        }
        return 0;
    }
}
