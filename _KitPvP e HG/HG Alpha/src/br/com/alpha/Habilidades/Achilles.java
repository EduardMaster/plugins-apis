package br.com.alpha.Habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;

public class Achilles implements Listener{

	@EventHandler
	public void HabilidadeAchilles(EntityDamageByEntityEvent e) {
		Player p = (Player)e.getEntity();
		Player d = (Player)e.getDamager();
		ItemStack item =  d.getItemInHand();
		if (e.getEntity() != p) {
			return;
		}
		if (e.getDamager() != d) {
			return;
		}
		if (item == null) return;
		if (KitsEnum.getKit(p) == KitsEnum.ACHILLES) {
			if (MCAlpha.Status ==GameTime.INGAME){
			if (item.getType().equals(Material.WOOD_SWORD)) {
				e.setDamage(6.0D);
			} else if (item.getType().equals(Material.WOOD_AXE)) {
				e.setDamage(e.getDamage() + 6.0D);
			} else if (item.getType().equals(Material.WOOD_SPADE)) {
				e.setDamage(e.getDamage() + 6.0D);
			} else if (item.getType().equals(Material.WOOD_PICKAXE)) {
				e.setDamage(e.getDamage() + 6.0D);
			} else if (item.getType().equals(Material.STONE_SWORD)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.STONE_PICKAXE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.STONE_AXE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.STONE_SPADE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.IRON_SWORD)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.IRON_PICKAXE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.IRON_SPADE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.IRON_AXE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.GOLD_SWORD)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.GOLD_PICKAXE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.GOLD_AXE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 2.0D);
			} else if (item.getType().equals(Material.DIAMOND_SWORD)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 3.0D);
			} else if (item.getType().equals(Material.DIAMOND_SPADE)) {
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
				e.setDamage(e.getDamage() - 3.0D);
			} else if (item.getType().equals(Material.DIAMOND_AXE)) {
				e.setDamage(e.getDamage() - 3.0D);
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
			} else if (item.getType().equals(Material.DIAMOND_PICKAXE)) {
				e.setDamage(e.getDamage() - 3.0D);
				p.sendMessage("§cEste player é achilles!\nuse itens de madeira para dar mais dano!");
			}
			}else {
				e.setCancelled(true);
			}
		}
	}
}
	

