package br.com.alpha.Habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class BackPacker implements Listener {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Player> cooldownbk = new ArrayList();

	@EventHandler
	public void backpackerKit(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (MCAlpha.Status != GameTime.INGAME) {
			ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
			ItemMeta sopas = sopa.getItemMeta();
			sopa.setItemMeta(sopas);
			if ((p.getItemInHand().getType() == Material.LEATHER) && (KitsEnum.getKit(p) == KitsEnum.BACKPACKER)) {
				if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) {
					event.setCancelled(true);
				}

				if (cooldownbk.contains(p)) {
					p.sendMessage("§cVocê está em cooldown.");
				} else {
					Inventory v = Bukkit.createInventory(null, 27, "§6Mochila de sopas!");
					for (int i = 0; i < 27; i++) {
						v.addItem(new ItemStack[] { new ItemStack(sopa) });
					}
					event.getPlayer().openInventory(v);
					cooldownbk.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MCAlpha.mcAlpha, new Runnable() {
						public void run() {
							BackPacker.cooldownbk.remove(p);
							p.sendMessage("§aVocê já pode usar o kit novamente.");
						}
					}, 1200L);
				}
			}
		}
	}
}