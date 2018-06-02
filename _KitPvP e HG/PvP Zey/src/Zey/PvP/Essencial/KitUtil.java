package Zey.PvP.Essencial;

import org.bukkit.event.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.enchantments.*;
import org.bukkit.potion.*;

import Zey.PvP.Main.*;

public class KitUtil implements Listener
{
    public static void MensagemCooldown(final Player p) {
        p.sendMessage(String.valueOf(Main.prefix) + " §7» §cAguarde " + Cooldown.CoolDown(p) + " segundos");
    }
    
    public static void ccooldown(final Player p) {
        p.sendMessage(String.valueOf(Main.prefix) + " §7» §aSeu cooldown acabou.");
    }
    
    public static ItemStack darArmadura(final Material material, final Color cor) {
        final ItemStack item = new ItemStack(material);
        final LeatherArmorMeta itemm = (LeatherArmorMeta)item.getItemMeta();
        itemm.setColor(cor);
        item.setItemMeta((ItemMeta)itemm);
        return item;
    }
    
    public static void tirarEfeitos(final Player p) {
        p.removePotionEffect(PotionEffectType.ABSORPTION);
        p.removePotionEffect(PotionEffectType.BLINDNESS);
        p.removePotionEffect(PotionEffectType.CONFUSION);
        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        p.removePotionEffect(PotionEffectType.FAST_DIGGING);
        p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        p.removePotionEffect(PotionEffectType.HARM);
        p.removePotionEffect(PotionEffectType.HEAL);
        p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
        p.removePotionEffect(PotionEffectType.HUNGER);
        p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        p.removePotionEffect(PotionEffectType.INVISIBILITY);
        p.removePotionEffect(PotionEffectType.JUMP);
        p.removePotionEffect(PotionEffectType.NIGHT_VISION);
        p.removePotionEffect(PotionEffectType.POISON);
        p.removePotionEffect(PotionEffectType.REGENERATION);
        p.removePotionEffect(PotionEffectType.SATURATION);
        p.removePotionEffect(PotionEffectType.SLOW);
        p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        p.removePotionEffect(PotionEffectType.SPEED);
        p.removePotionEffect(PotionEffectType.WATER_BREATHING);
        p.removePotionEffect(PotionEffectType.WEAKNESS);
        p.removePotionEffect(PotionEffectType.WITHER);
    }
    
	public static void ItemServer(final Player p) {
		
    	final ItemStack vidrohot = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta vidrohotx = vidrohot.getItemMeta();
        vidrohotx.setDisplayName("§6§lZey§f§lPvP");
        vidrohot.setItemMeta(vidrohotx);
        
        p.getInventory().setItem(0, vidrohot);
        p.getInventory().setItem(1, vidrohot);
        KitAPI.setitem(p, Material.PAPER, "§e§lWARPS", 2, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(3, vidrohot);
        KitAPI.setitem(p, Material.ENDER_CHEST, "§e§lKITS", 4, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(5, vidrohot);
        KitAPI.setitem(p, Material.BOOK, "§e§lMENU GERAL", 6, Enchantment.DAMAGE_ALL, 0, false);
        p.getInventory().setItem(7, vidrohot);
        p.getInventory().setItem(8, vidrohot);
    }
    
    public static void darSopa(final Player p, final int quantas) {
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta msopa = sopa.getItemMeta();
        msopa.setDisplayName("§e§lSOPA");
        sopa.setItemMeta(msopa);
        for (int i = 0; i < quantas; ++i) {
            p.getInventory().setItem(p.getInventory().firstEmpty(), new ItemStack(sopa));
        }
    }
    
    public static void setitem(final Player p, final Material mat, final String nome, final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
        final ItemStack item = new ItemStack(mat);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        itemmeta.addEnchant(enchant, level, trueorfalse);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }
    
    public static void darItemEnchant(final Player p, final Material mat, final int quantidade, final String nome, final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
        final ItemStack item = new ItemStack(mat, quantidade);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.addEnchant(enchant, level, trueorfalse);
        itemmeta.setDisplayName(nome);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }
    
    public static void tirarArmadura(final Player p) {
        p.getInventory().setHelmet(new ItemStack(Material.AIR));
        p.getInventory().setChestplate(new ItemStack(Material.AIR));
        p.getInventory().setLeggings(new ItemStack(Material.AIR));
        p.getInventory().setBoots(new ItemStack(Material.AIR));
    }
    
    public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
        p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
    }
    public static void darItem(final Player p, final Material mat, final int quantidade, final String nome, final int lugar) {
        final ItemStack item = new ItemStack(mat, quantidade);
        final ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        item.setItemMeta(itemmeta);
        p.getInventory().setItem(lugar, item);
    }
}
