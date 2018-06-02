package Net.Hunger.Eventos;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Net.Hunger.Manager.Habilidade;

public class LoadKits implements Listener {
	
	@SuppressWarnings("deprecation")
	public static void CheckKits(Player p) {
		
	if (Habilidade.getAbility(p).equalsIgnoreCase("kangaroo")) {
	ItemStack kit = new ItemStack(Material.FIREWORK);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aKangaroo §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("nenhum")) {
	ItemStack kit = new ItemStack(Material.BREAD,15);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aNenhum §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
	
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("crafter")) {
	ItemStack kit = new ItemStack(Material.NETHER_STAR);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aCrafter §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("enderman")) {
	ItemStack kit = new ItemStack(Material.ENDER_PEARL,3);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aEnderman §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("launcher")) {
	ItemStack kit = new ItemStack(Material.SPONGE,20);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aLauncher §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("well")) {
	ItemStack kit = new ItemStack(Material.GOLD_NUGGET);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aWell §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("swords")) {
	ItemStack kit = new ItemStack(Material.WOOD_SWORD);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aSwords Wood §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("jackhammer")) {
	ItemStack kit = new ItemStack(Material.STONE_AXE);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aJackHammer §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}	
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("jellyfish")) {
	ItemStack kit = new ItemStack(Material.CLAY_BALL);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aJellyfish §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("grandpa")) {
	ItemStack kit = new ItemStack(Material.STICK);
	kit.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aGrandpa §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("bigjump")) {
	ItemStack kit = new ItemStack(Material.LEATHER_BOOTS);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aBigJump §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("rush")) {
    ItemStack kitss = new ItemStack(Material.WOOD_SWORD);
    ItemMeta rkitss = kitss.getItemMeta();
	kitss.setItemMeta(rkitss);
	p.getInventory().setItem(1, kitss);
	
	ItemStack kit = new ItemStack(Material.RED_MUSHROOM,16);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aRush §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(2, kit);
	
	ItemStack kits = new ItemStack(Material.BROWN_MUSHROOM,16);
	ItemMeta rkits = kits.getItemMeta();
	rkits.setDisplayName("§aRush §7Kit!");
	kits.setItemMeta(rkits);
	p.getInventory().setItem(3, kits);
	
	ItemStack kitsss = new ItemStack(Material.BOWL,16);
	ItemMeta rkitsss = kitsss.getItemMeta();
	rkitsss.setDisplayName("§aRush §7Kit!");
	kitsss.setItemMeta(rkitsss);
	p.getInventory().setItem(4, kitsss);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("backpacker")) {
	ItemStack kit = new ItemStack(Material.LEATHER);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aBackPacker §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("wolff")) {
	ItemStack kit = new ItemStack(Material.FLINT);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aWolff §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("frozen")) {
	ItemStack kit = new ItemStack(Material.SNOW_BALL,16);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aFrozen §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("fireman")) {
	ItemStack kit = new ItemStack(Material.WATER_BUCKET);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aFireman §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("demoman")) {
	ItemStack kit = new ItemStack(Material.STONE_PLATE,6);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aDemoman §7Kit!");
	kit.setItemMeta(rkit);
	p.updateInventory();
	ItemStack kits = new ItemStack(Material.GRAVEL,6);
	ItemMeta rkits = kits.getItemMeta();
	rkits.setDisplayName("§aDemoman §7Kit!");
	kits.setItemMeta(rkits);
	p.updateInventory();
	p.getInventory().setItem(1, kit);
	p.getInventory().setItem(2, kits);
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("endermage")) {
	ItemStack kit = new ItemStack(Material.PORTAL);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aEndermage §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("fisherman")) {
	ItemStack kit = new ItemStack(Material.FISHING_ROD);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aFisherman §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("forger")) {
	ItemStack kit = new ItemStack(Material.COAL,16);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aForger §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("gladiator")) {
	ItemStack kit = new ItemStack(Material.IRON_FENCE);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aGladiator §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("grappler")) {
	ItemStack kit = new ItemStack(Material.LEASH);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aGrappler §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("lumberjack")) {
	ItemStack kit = new ItemStack(Material.WOOD_AXE);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aLumberJack §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("miner")) {
	ItemStack kit = new ItemStack(Material.STONE_PICKAXE);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aMiner §7Kit!");
	kit.setItemMeta(rkit);
	kit.addEnchantment(Enchantment.DIG_SPEED, 1);
	kit.addEnchantment(Enchantment.DURABILITY, 3);
	
	ItemStack kits = new ItemStack(Material.APPLE,3);
	ItemMeta rkits = kits.getItemMeta();
	rkits.setDisplayName("§aMiner §7Kit!");
	kits.setItemMeta(rkits);
	
	p.getInventory().setItem(1, kit);
	p.getInventory().setItem(2, kits);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("monk")) {
	ItemStack kit = new ItemStack(Material.BLAZE_ROD);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aMonk §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("reaper")) {
	ItemStack kit = new ItemStack(Material.WOOD_HOE);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aReaper §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("specialist")) {
	ItemStack kit = new ItemStack(Material.BOOK);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aSpecialist §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("switcher")) {
	ItemStack kit = new ItemStack(Material.SNOW_BALL,16);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aSwitcher §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}

	if (Habilidade.getAbility(p).equalsIgnoreCase("thor")) {
	ItemStack kit = new ItemStack(Material.WOOD_AXE);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aThor §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
	
	if (Habilidade.getAbility(p).equalsIgnoreCase("timelord")) {
	ItemStack kit = new ItemStack(Material.WATCH);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aTimelord §7Kit!");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(1, kit);
	p.updateInventory();
	}
  }
}