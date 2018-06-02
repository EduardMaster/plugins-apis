package Net.Hunger.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class BackPacker implements Listener {

  public static List<Player> cooldownbk = new ArrayList<Player>();
  
  @EventHandler
  public void backpackerKit(PlayerInteractEvent event) {
    final Player p = event.getPlayer();
    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
    ItemMeta sopas = sopa.getItemMeta();
    sopa.setItemMeta(sopas);
    if ((p.getItemInHand().getType() == Material.LEATHER) && (Habilidade.getAbility(p).equalsIgnoreCase("backpacker"))) {
      if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) {
      event.setCancelled(true);
      }
      if (cooldownbk.contains(p)) {
        p.sendMessage("§7[§a?§7] Voce ainda esta no cooldown!");
      }  else {
        Inventory v = Bukkit.createInventory(null, 27, "§a§lMochila de sopas!");
        for (int i = 0; i < 27; i++) {
        v.addItem(new ItemStack[] { new ItemStack(sopa) });
        }
        event.getPlayer().openInventory(v);
        cooldownbk.add(p);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
          public void run() {
            BackPacker.cooldownbk.remove(p);
            p.sendMessage("§7[§a!§7] Você ja pode usar seu kit novamente!");
          }
        }, 1200L);
      }
    }
  }
}