package me.Pedro.INV;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Pedro.Main;

public class Kits implements Listener, CommandExecutor {
	public Kits(Main main) {
	}

	public static void guiKits1(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(p, 54, "§e§lKitPvP");

		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)4);
		ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName("");
		vidro.setItemMeta(metav);

		@SuppressWarnings("deprecation")
		ItemStack ant = new ItemStack(Material.getMaterial(133), 1, (short) 14);
		ItemMeta antv = ant.getItemMeta();
		antv.setDisplayName("§a§LProxima");
		ant.setItemMeta(antv);
		
		ItemStack ant1 = new ItemStack(Material.getMaterial(152), 1, (short) 14);
		ItemMeta antv1 = ant1.getItemMeta();
		antv1.setDisplayName("§c§LImpossivel voltar");
		ant1.setItemMeta(antv1);
		
		ItemStack ant11 = new ItemStack(Material.getMaterial(384), 1, (short) 14);
		ItemMeta antv11 = ant11.getItemMeta();
		antv11.setDisplayName("§cXP");
		ant11.setItemMeta(antv11);
		
		inv.setItem(0, ant1);
		inv.setItem(8, ant);
		inv.setItem(4, ant11);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		if (p.hasPermission("kit.pvp")) {
			ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lPvP");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fSem Abilidades");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Stomper")) {
			ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lStomper");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAo cair em cima dos player esguiu");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.AntiStomper")) {
			ItemStack pyro = new ItemStack(Material.GRASS);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lAntiStomper");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fNao morra pra stomper");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.QuickDropper")) {
			ItemStack pyro = new ItemStack(Material.BOWL);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lQuickDropper");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAo tomar sopa drope o pode");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Kangaroo")) {
			ItemStack pyro = new ItemStack(Material.FIREWORK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lKangaroo");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fCom seu firework de super jump");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Thor")) {
			ItemStack pyro = new ItemStack(Material.WOOD_AXE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lThor");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAo clicar no machado sumone raios");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Fisherman")) {
			ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lFisherman");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fPesque seus inimigos com sua vara");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Ajnin")) {
			ItemStack pyro = new ItemStack(Material.NETHER_STAR);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lAjnin");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAperte shift e teleport o player ritado a");
			descpyro1.add("§fvoce");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Ninja")) {
			ItemStack pyro = new ItemStack(Material.COMPASS);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lNinja");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAperte shift e teleport ao player ritado");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Anchor")) {
			ItemStack pyro = new ItemStack(Material.ANVIL);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lAnchor");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fNao tome Knokback");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Levitator")) {
			ItemStack pyro = new ItemStack(Material.WOOL);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lLevitator");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fLevite seus inimigos");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.DeathNote")) {
			ItemStack pyro = new ItemStack(Material.BOOK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lDeathNote");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAo clicar no player coloque efeitos");
			descpyro1.add("§fruins nele");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.BurstMaster")) {
			ItemStack pyro = new ItemStack(Material.GOLD_HOE);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lBurstMaster");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fTenha um canhao");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Sonic")) {
			ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lSonic");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fDe um desh ao passar perto de");
			descpyro1.add("§fseus inimigos deixos invenenados");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.DeshFire")) {
			ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lDeshFire");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fDe um desh ao passar perto de");
			descpyro1.add("§fseus inimigos deixos pegando fogo");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Vaccum")) {
			ItemStack pyro = new ItemStack(Material.EYE_OF_ENDER);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lVaccum");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fPuxe seus inimigos");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.TimeLord")) {
			ItemStack pyro = new ItemStack(Material.WATCH);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lTimeLord");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fCongele o tempo");
			descpyro1.add("§f");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Teleman")) {
			ItemStack pyro = new ItemStack(Material.FIREBALL);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lTeleman");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAo acertar o tiro no player se teleport");
			descpyro1.add("§fa ele");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.Thresh")) {
			ItemStack pyro = new ItemStack(Material.LEASH);
			ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7§lKit » §e§lThresh");
			ArrayList<String> descpyro1 = new ArrayList<String>();
			descpyro1.add("§bHabilidade >");
			descpyro1.add("§7-  =  -  =  -");
			descpyro1.add("§fAo acertar o tiro no player teleport ele");
			descpyro1.add("§fa voce");
			descpyro1.add("§c§lClick");
			descpyro1.add("§7-  =  -  =  -");
			metapyro.setLore(descpyro1);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		ItemStack[] arrayOfItemStack;
		int descpyro1 = (arrayOfItemStack = inv.getContents()).length;
		for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++) {
			ItemStack item = arrayOfItemStack[metapyro1];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidro);
			}
		}
		p.openInventory(inv);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if ((commandLabel.equalsIgnoreCase("kits"))) {
			Player p = (Player) sender;

			guiKits1(p);
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerCLickInventry(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if ((e.getInventory().getTitle().equalsIgnoreCase("§e§lKitPvP")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getTypeId() != 0)) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lPvP")) {
				p.closeInventory();
				p.chat("/kit pvp");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lBurstMaster")) {
				p.closeInventory();
				p.chat("/kit BurstMaster");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lThresh")) {
				p.closeInventory();
				p.chat("/kit Thresh");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lTeleman")) {
				p.closeInventory();
				p.chat("/kit teleman");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lSonic")) {
				p.closeInventory();
				p.chat("/kit sonic");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lTimeLord")) {
				p.closeInventory();
				p.chat("/kit timelord");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lVaccum")) {
				p.closeInventory();
				p.chat("/kit vaccum");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lDeshFire")) {
				p.closeInventory();
				p.chat("/kit deshfire");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lDeathNote")) {
				p.closeInventory();
				p.chat("/kit deathnote");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lKangaroo")) {
				p.closeInventory();
				p.chat("/kit kangaroo");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lStomper")) {
				p.closeInventory();
				p.chat("/kit stomper");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lLevitator")) {
				p.closeInventory();
				p.chat("/kit levitator");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lAnchor")) {
				p.closeInventory();
				p.chat("/kit anchor");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lFisherman")) {
				p.closeInventory();
				p.chat("/kit fisherman");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lAjnin")) {
				p.closeInventory();
				p.chat("/kit ajnin");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lNinja")) {
				p.closeInventory();
				p.chat("/kit ninja");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lAntiStomper")) {
				p.closeInventory();
				p.chat("/kit antistomper");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lThor")) {
				p.closeInventory();
				p.chat("/kit thor");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lKit » §e§lQuickDropper")) {
				p.closeInventory();
				p.chat("/kit quickdropper");
				p.closeInventory();
				return;
			}
		}
	}
}
