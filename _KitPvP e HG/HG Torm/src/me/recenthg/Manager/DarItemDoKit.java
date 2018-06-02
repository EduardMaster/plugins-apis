package me.recenthg.Manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DarItemDoKit implements Listener {
	
	public static void CheckKits(Player p) {
		
		if (Habilidade.getAbility(p).equalsIgnoreCase("kangaroo")) {
			ItemStack kit = new ItemStack(Material.FIREWORK);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lRocket Kangaroo!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("aladdin")) {
			ItemStack kit = new ItemStack(Material.CARPET);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lAladdin!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("thor")) {
			ItemStack kit = new ItemStack(Material.WOOD_AXE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lThor!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("gaara")) {
			ItemStack kit = new ItemStack(Material.SANDSTONE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lGaara!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("lumberjack")) {
			ItemStack kit = new ItemStack(Material.WOOD_AXE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lLumberJack!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(2, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("fisherman")) {
			ItemStack kit = new ItemStack(Material.FISHING_ROD);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lFisherman!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("fireman")) {
			ItemStack kit = new ItemStack(Material.LAVA_BUCKET);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lFireman!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("specialist")) {
			ItemStack kit = new ItemStack(Material.BOOK);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lSpecialist!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("grappler")) {
			ItemStack kit = new ItemStack(Material.LEASH);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lGrappler!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("endermage")) {
			ItemStack kit = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lEndermage!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("BurstMaster")) {
			ItemStack kit = new ItemStack(Material.GOLD_HOE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lBurstMaster!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("Vulcanos")) {
			ItemStack kit = new ItemStack(Material.FIREWORK_CHARGE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lVulcanos!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("gladiator")) {
			ItemStack kit = new ItemStack(Material.IRON_FENCE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lGladiator!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("velotrol")) {
			ItemStack kit = new ItemStack(Material.MINECART);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lVelotrol!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("reaper")) {
			ItemStack kit = new ItemStack(Material.WOOD_HOE);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lReaper!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("monk")) {
			ItemStack kit = new ItemStack(Material.BLAZE_ROD);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lMonk!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("well")) {
			ItemStack kit = new ItemStack(Material.GOLD_NUGGET);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lWell!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("wither")) {
			ItemStack kit = new ItemStack(Material.SKULL_ITEM);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lWither!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
		if (Habilidade.getAbility(p).equalsIgnoreCase("phantom")) {
			ItemStack kit = new ItemStack(Material.FEATHER);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§a§lPhantom!");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(1, kit);
			p.updateInventory();
		}
	}
}