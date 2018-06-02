package br.com.alpha.APIs;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class InventariosGUI implements Listener {

	public static ItemStack createItem(Material item , List<String> lore, String nome,int quantidade,byte bytes) {
		ItemStack stack = new ItemStack(item,quantidade,bytes);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(nome);
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}

	

	
	@SuppressWarnings("deprecation")
	public static void inventarioKits(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, "§cKits de §a" + p.getName());
		for (int i = 0; i <9; i++) {
			inv.setItem(i, new ItemStack(Material.THIN_GLASS));
		}
		if (p.hasPermission("kit.anchor")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.ANVIL, null, "§cKit: §6Anchor",1,(byte)0));
		}
		if (p.hasPermission("kit.achilles")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.WOOD_SWORD, null, "§cKit: §6Achilles",1,(byte)0));
		}
		if (p.hasPermission("kit.backpacker")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.LEATHER, null, "§cKit: §6BackPacker",1,(byte)0));
		}
		if (p.hasPermission("kit.barbarian")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.WOOD_SWORD, null, "§cKit: §6Barbarian",1,(byte)0));
		}
		if (p.hasPermission("kit.cannibal")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.POTION, null, "§cKit: §6Cannibal",1,(byte)0));
		}
		if (p.hasPermission("kit.copycat")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.YELLOW_FLOWER, null, "§cKit: §6CopyCat",1,(byte)0));
		}
		if (p.hasPermission("kit.cultivator")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.getMaterial(31), null, "§cKit: §6Cultivator",1,(byte)1));
		}
		if (p.hasPermission("kit.demoman")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.GRAVEL, null, "§cKit: §6Demoman",1,(byte)0));
		}
		if (p.hasPermission("kit.endermage")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.PORTAL, null, "§cKit: §6Endermage",1,(byte)0));
		}
		if (p.hasPermission("kit.fireman")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.LAVA_BUCKET, null, "§cKit: §6Fireman",1,(byte)0));
		}
		if (p.hasPermission("kit.fisherman")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.FISHING_ROD, null, "§cKit: §6Fisherman",1,(byte)0));
		}
		if (p.hasPermission("kit.forger")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.COAL, null, "§cKit: §6Forger",1,(byte)0));
		}
		if (p.hasPermission("kit.jackhammer")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.STONE_AXE, null, "§cKit: §6JackHammer",1,(byte)0));
		}
		if (p.hasPermission("kit.kangaroo")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.FIREWORK, null, "§cKit: §6Kangaroo",1,(byte)0));
		}
		if (p.hasPermission("kit.launcher")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.SPONGE, null, "§cKit: §6Launcher",1,(byte)0));
		}
		if (p.hasPermission("kit.lumberjack")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.WOOD_AXE, null, "§cKit: §6Lumberjack",1,(byte)0));
		}
		if (p.hasPermission("kit.madman")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.POTION, null, "§cKit: §6Madman",1,(byte)8232));
		}
		if (p.hasPermission("kit.miner")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.STONE_PICKAXE, null, "§cKit: §6Miner",1,(byte)0));
		}
		if (p.hasPermission("kit.monk")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.BLAZE_ROD, null, "§cKit: §6Monk",1,(byte)0));
		}
		if (p.hasPermission("kit.phantom")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.FEATHER, null, "§cKit: §6Phantom",1,(byte)0));
		}
		if (p.hasPermission("kit.poseidon")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.WATER, null, "§cKit: §6Poseidon",1,(byte)0));
		}
		if (p.hasPermission("kit.pyro")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.FLINT_AND_STEEL, null, "§cKit: §6Pyro",1,(byte)0));
		}
		if (p.hasPermission("kit.reaper")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.WOOD_HOE, null, "§cKit: §6Reaper",1,(byte)0));
		}
		if (p.hasPermission("kit.snail")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.POTION, null, "§cKit: §6Snail",1,(byte)8234));
		}
		if (p.hasPermission("kit.specialist")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.BOOK, null, "§cKit: §6Specialist",1,(byte)0));
		}
		if (p.hasPermission("kit.stomperl")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.DIAMOND_BOOTS, null, "§cKit: §6Stomper",1,(byte)0));
		}
		if (p.hasPermission("kit.switcher")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.SNOW_BALL, null, "§cKit: §6Switcher",1,(byte)0));
		}
		if (p.hasPermission("kit.tank")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.TNT, null, "§cKit: §6Tank",1,(byte)0));
		}
		if (p.hasPermission("kit.tower")||p.hasPermission("kit.*")) {
			inv.addItem( createItem(Material.GOLD_BOOTS, null, "§cKit: §6Tower",1,(byte)0));
		}
		if (p.hasPermission("kit.worm")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.DIRT, null, "§cKit: §6Worm",1,(byte)0));
		}
		if (p.hasPermission("kit.urgal")||p.hasPermission("kit.*")) {
			inv.addItem(createItem(Material.POTION, null, "§cKit: §6Urgal",1,(byte)8201));
		}
		for (ItemStack i : inv.getContents()) {
			if (i == null) {
				inv.setItem(inv.firstEmpty(), new ItemStack(Material.THIN_GLASS));
			}
		}

		p.openInventory(inv);
	}
	@EventHandler
	void sad(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType()==Material.CHEST) {
			inventarioKits(p);
		}
		if (p.getItemInHand().getType()==Material.ENDER_CHEST) {
			p.sendMessage("§cPara ver seu status entre em: §ahttps://www.mc-alpha.com.br/status.php");
		}
		if (p.getItemInHand().getType()==Material.PAPER) {
			p.sendMessage("§cPara ver as novidades entre em: §ahttps://www.mc-alpha.com.br/noticias.php");
		}
		if (p.getItemInHand().getType()==Material.ENCHANTED_BOOK) {
			p.sendMessage("§cEm desenvolvimento.");
		}
		if (p.getItemInHand().getType()==Material.GOLD_INGOT) {
			p.chat("/buy");
			p.sendMessage("§cDeseja comprar por BOLETO?\nAcesse: §ahttps://www.mc-alpha.com.br/loja.php");
		}
	}
	@EventHandler
	void inventory(InventoryClickEvent e) {
		Player p =(Player) e.getWhoClicked();
		
		ItemStack i = e.getCurrentItem();
		if (i!=null&&e.getInventory().getTitle().equals("§cKits de §a" + p.getName())) {

				e.setCancelled(true);

			if(handle(p, i, "Achilles")) {
				
			}
			if(handle(p, i, "Viper")) {
			} if(			handle(p, i, "Anchor")){
			
			} if(			handle(p, i, "Anchor")) {
			}if (			handle(p, i, "BackPacker")) {
				
			}if (		handle(p, i, "Barbarian")) {
				
			} if (				handle(p, i, "Cannibal")) {
				
			} if (				handle(p, i, "CopyCat")) {
				
			}if (	handle(p, i, "Cultivator")) {
				
			} if (
					handle(p, i, "Demoman")) {
				
			} if (				handle(p, i, "Endermage")) {
				
			} if (				handle(p, i, "Fireman")) {
				
			} if (
					handle(p, i, "Fisherman")) {
				
			} if (			handle(p, i, "Forger")) {
				
			} if (				
					handle(p, i, "JackHammer")) {
				
			} if (				handle(p, i, "Kangaroo")) {
				
			}if (		handle(p, i, "Launcher")) {
				
			}if (				handle(p, i, "Lumberjack")) {
				
			} if (		handle(p, i, "Madman")) {
				
			} if (		handle(p, i, "Miner")) {
				
			} if (	handle(p, i, "Monk")) {
				
			} if (				handle(p, i, "Phantom")) {
				
			} if (		handle(p, i, "Poseidon")) {
				
			} if (				handle(p, i, "Pyro")) {
				
			} if (	handle(p, i, "Reaper")) {
				
			} if (				handle(p, i, "Snail")) {
				
			} if (				handle(p, i, "Specialist")) {
				
			} if (			handle(p, i, "Stomper")) {
				
			} if (				handle(p, i, "Switcher")) {
				
			} if (				handle(p, i, "Tank")) {
				
			} if (		handle(p, i, "Tower")) {
				
			} if (			handle(p, i, "Thor")) {
				
			} if (			handle(p, i, "Worm")) {
				
			} if (				handle(p, i, "Urgal")) {
				
			}
			

				
				

	




		}
	}
	private boolean handle(Player player, ItemStack item, String kit) {

			if (item.hasItemMeta() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§cKit: §6" + kit)) {
				player.performCommand("kit " + kit);
				player.closeInventory();
				return true;
			}
			return true;
	}
}
