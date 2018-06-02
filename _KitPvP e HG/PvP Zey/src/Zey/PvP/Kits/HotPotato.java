package Zey.PvP.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.scheduler.*;

import Zey.PvP.Essencial.Cooldown;
import Zey.PvP.Essencial.KitUtil;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;

import org.bukkit.plugin.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;

public class HotPotato implements Listener
{
    public static ArrayList<String> emhotpotato;
    
    static {
        HotPotato.emhotpotato = new ArrayList<String>();
    }
    
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
    public void onInteract(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player k = (Player)e.getRightClicked();
            if (p.getItemInHand().getType().equals((Object)Material.POTATO) && Habilidade.getAbility(p).equalsIgnoreCase("HotPotato")) {
                if (Gladiator.lutando.containsKey(p.getName())) {
                }
                else {
                    if (Cooldown.add(p)) {
                    	KitUtil.MensagemCooldown(p);
                        return;
                    }
                    Cooldown.add(p, 20);
                    HotPotato.emhotpotato.add(k.getName());
                    p.sendMessage(String.valueOf(Main.prefix) + " §7» §aHotPotato Colocada");
                    k.sendMessage(String.valueOf(Main.prefix) + " §7» §eVocê está com a tnt do hotpotato tire ou ira explodir em 5 segundos!");
                    k.sendMessage(String.valueOf(Main.prefix) + " §7» §cClique com o botao direito na hotpotato para tira-la.");
                    
                    final ItemStack tnt = new ItemStack(Material.TNT);
                    final ItemMeta tntmeta = tnt.getItemMeta();
                    tntmeta.setDisplayName("§cTNT");
                    tnt.setItemMeta(tntmeta);
                    
                    k.getInventory().setHelmet(tnt);
                    
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage(String.valueOf(Main.prefix) + " §7» §eVocê está com a tnt, ela será explodida em 4 segundos");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance1(), 0L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage(String.valueOf(Main.prefix) + " §7» §eVocê está com a tnt, ela será explodida em 3 segundos");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance1(), 20L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage(String.valueOf(Main.prefix) + " §7» §eVocê está com a tnt, ela será explodida em 2 segundos");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance1(), 40L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.sendMessage(String.valueOf(Main.prefix) + " §7» §e§lVocê está com a tnt, ela será explodida em 1 segundo");
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance1(), 60L);
                    new BukkitRunnable() {
                        public void run() {
                            if (HotPotato.emhotpotato.contains(k.getName())) {
                                k.getWorld().createExplosion(k.getLocation(), 3.0f, true);
                                k.getWorld().playEffect(k.getLocation(), Effect.EXPLOSION_HUGE, 20);
                                k.setLastDamage(9999.0);
                                HotPotato.emhotpotato.remove(k.getName());
                            }
                        }
                    }.runTaskLater((Plugin)Main.getInstance1(), 80L);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            KitUtil.ccooldown(p);
                        }
                    }, 500L);
                }
            }
        }
    }
    
    @EventHandler
    public void onRemoverTNT(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (Habilidade.getAbility(p) != "Nenhum" && e.getSlot() == 39 && e.getCurrentItem().getType().equals((Object)Material.TNT) && HotPotato.emhotpotato.contains(p.getName())) {
            HotPotato.emhotpotato.remove(p.getName());
            e.setCancelled(true);
            p.getInventory().setHelmet((ItemStack)null);
            p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2.0f, 2.0f);
            p.sendMessage(String.valueOf(Main.prefix) + " §7» §aVocê desarmou a hotpotato.");
            p.closeInventory();
        }
    }
}
