package GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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
import Main.Main;
import Outros.ScoreBoard;
import Utils.KillsDeathsMoney;

public class LojaKits implements CommandExecutor, Listener {
	
	
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static java.util.List<String> Lore(String string)
      {
        String[] split = string.split(" ");
        string = "";
        ChatColor color = ChatColor.GOLD;
            ArrayList<String> newString = new ArrayList();
        for (int i = 0; i < split.length; i++)
        {
          if ((string.length() > 20) || (string.endsWith(".")))
          {
            newString.add(color + string);
            if ((string.endsWith("."))) {
              newString.add("");
            }
            string = "";
          }
          string = string + (string.length() == 0 ? "" : " ") + split[i];
        }
        newString.add(string);
        return newString;
      }
	
	public static ItemStack vidro;
	public static ItemMeta vidrometa;
	public static ItemStack erro;
	public static ItemMeta errometa;
	public static ItemStack sucesso;
	public static ItemMeta sucessometa;
	public static ItemStack vidro1;
	public static ItemMeta vidro1meta;
	public static ItemStack phantom;
	public static ItemMeta phantommeta;
	public static ItemStack poseidon;
	public static ItemMeta poseidonmeta;
	public static ItemStack Urgal;
	public static ItemMeta Urgalmeta;
	public static ItemStack ninja;
	public static ItemMeta ninjameta;
	public static ItemStack stomper;
	public static ItemMeta stompermeta;
	
	@EventHandler
	public void Execute(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§aLoja de Kits")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}
	public void Execute2(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§6Cringed§7MC » §cVoce nao tem coins suficentes para este kit.")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(erro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}
	public void Execute3(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§6Cringed§7MC » §aKit §a§lADIQUIRIDO §aCom sucesso!")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(sucesso)) {
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}
	public void Execute4(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§4Ja Possui")) {
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(erro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
			}
		}
	}
	@EventHandler
	public void Execute1(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Player p = (Player)e.getWhoClicked();
			Inventory Inv = e.getInventory();
			if (Inv.getTitle().equalsIgnoreCase("§aLoja de Kits") || Inv.getTitle().equals("§4Ja Possui o kit") || Inv.getTitle().equals("§4Sem Coins Suficientes")
					|| Inv.getTitle().equals("§aComprado com sucesso")) {
				if (e.getCurrentItem().isSimilar(vidro1)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(erro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(sucesso)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(vidro)) {
					e.setCancelled(true);
					p.closeInventory();
				}
				if (e.getCurrentItem().isSimilar(ninja)) {
					e.setCancelled(true);
					if (Main.getInstace().loja.getString(p.getUniqueId() + ".Ninja").equals("false")) {
						if (KillsDeathsMoney.getMoney(p) >= 35000) {
							comprou(p, "Ninja", 35000);
							KillsDeathsMoney.removermoney(p, 35000);
							ScoreBoard.UpdateScore(p);
						} else {
							MoneyErro(p, "Ninja", 35000);
						}
					} else {
						Japossui(p, "Ninja");
					}
				}
				if (e.getCurrentItem().isSimilar(poseidon)) {
					e.setCancelled(true);
					if (Main.getInstace().loja.getString(p.getUniqueId() + ".Poseidon").equals("false")) {
						if (KillsDeathsMoney.getMoney(p) >= 25000) {
							comprou(p, "Poseidon", 25000);
							KillsDeathsMoney.removermoney(p, 25000);
							ScoreBoard.UpdateScore(p);
						} else {
							MoneyErro(p, "Poseidon", 25000);
						}
					} else {
						Japossui(p, "Poseidon");
					}
				}
				if (e.getCurrentItem().isSimilar(stomper)) {
					e.setCancelled(true);
					if (Main.getInstace().loja.getString(p.getUniqueId() + ".Stomper").equals("false")) {
						if (KillsDeathsMoney.getMoney(p) >= 60000) {
							comprou(p, "Stomper", 60000);
							KillsDeathsMoney.removermoney(p, 60000);
							ScoreBoard.UpdateScore(p);
						} else {
							MoneyErro(p, "Stomper", 60000);
						}
					} else {
						Japossui(p, "Stomper");
					}
				}
				if (e.getCurrentItem().isSimilar(Urgal)) {
					e.setCancelled(true);
					if (Main.getInstace().loja.getString(p.getUniqueId() + ".Urgal").equals("false")) {
						if (KillsDeathsMoney.getMoney(p) >= 40000) {
							comprou(p, "Urgal", 40000);
							KillsDeathsMoney.removermoney(p, 40000);
							ScoreBoard.UpdateScore(p);
						} else {
							MoneyErro(p, "Urgal", 40000);
						}
					} else {
						Japossui(p, "Urgal");
					}
				}
				if (e.getCurrentItem().isSimilar(phantom)) {
					e.setCancelled(true);
					if (Main.getInstace().loja.getString(p.getUniqueId() + ".Phantom").equals("false")) {
						if (KillsDeathsMoney.getMoney(p) >= 15000) {
							comprou(p, "Phantom", 15000);
							KillsDeathsMoney.removermoney(p, 15000);
							ScoreBoard.UpdateScore(p);
						} else {
							MoneyErro(p, "Phantom", 15000);
						}
					} else {
						Japossui(p, "Phantom");
					}
				}
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§6Cringed§7Kits ➜ §bPrecisa ser um Player para usar esse comando");
			return true;
		}
		Player p = (Player)sender;
	    Inventory loja = Bukkit.createInventory(p, 27, "§aLoja de Kits");
	    
	    vidro = new ItemStack(Material.STAINED_GLASS_PANE);
	    vidrometa = vidro.getItemMeta();
	    vidrometa.setDisplayName("§6Cringed§7Kits ");
	    vidro.setItemMeta(vidrometa);
	    
	    vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
	    vidro1meta = vidro1.getItemMeta();
	    vidro1meta.setDisplayName("§6Cringed§7Kits ");
	    vidro1.setItemMeta(vidro1meta);
	    
	    stomper = new ItemStack(Material.IRON_BOOTS);
	    stompermeta = stomper.getItemMeta();
	    stompermeta.setDisplayName("§b§lStomper R$: 60,000");
	    stompermeta.setLore(Lore("§fPule §fde §flugares §faltos §fe §fmate §foponentes"));
	    stomper.setItemMeta(stompermeta);
	    
	    ninja = new ItemStack(Material.COAL_BLOCK);
	    ninjameta = ninja.getItemMeta();
	    ninjameta.setDisplayName("§b§lNinja R$: 35,000");
	    ninjameta.setLore(Lore("§fSeja §fum §fum §fninja §fe §fteleporte §faos §foponentes"));
	    ninja.setItemMeta(ninjameta);

	    Urgal = new ItemStack(Material.REDSTONE);
	    Urgalmeta = Urgal.getItemMeta();
	    Urgalmeta.setDisplayName("§b§lUrgal R$: 40,000");
	    Urgalmeta.setLore(Lore("§fSeja mais forte"));
	    Urgal.setItemMeta(Urgalmeta);
	    
	    poseidon = new ItemStack(Material.WATER_BUCKET);
	    poseidonmeta = poseidon.getItemMeta();
	    poseidonmeta.setDisplayName("§b§lPoseidon R$: 25,000");
	    poseidonmeta.setLore(Lore("§fSeja §fo §fposeidon"));
	    poseidon.setItemMeta(poseidonmeta);
	    
	    phantom = new ItemStack(Material.FEATHER);
	    phantommeta = phantom.getItemMeta();
	    phantommeta.setDisplayName("§b§lPhantom R$: 15,000");
	    phantommeta.setLore(Lore("§fVoe §fpor §f5 §fsegundos"));
	    phantom.setItemMeta(phantommeta);
	    
	    for (int i = 1; i <= 27; i++) {
	    loja.setItem(0, vidro1);
	    loja.setItem(1, vidro1);
	    loja.setItem(2, vidro1);
	    loja.setItem(3, vidro1);
	    loja.setItem(4, vidro1);
	    loja.setItem(5, vidro1);
	    loja.setItem(6, vidro1);
	    loja.setItem(7, vidro1);
	    loja.setItem(8, vidro1);
	    loja.setItem(9, vidro);
	    loja.setItem(10, vidro);
	    loja.setItem(11, phantom);
	    loja.setItem(12, ninja);
	    loja.setItem(13, Urgal);
	    loja.setItem(14, stomper);
	    loja.setItem(15, poseidon);
	    loja.setItem(16, vidro);
	    loja.setItem(17, vidro);
	    loja.setItem(18, vidro1);
	    loja.setItem(19, vidro1);
	    loja.setItem(20, vidro1);
	    loja.setItem(21, vidro1);
	    loja.setItem(22, vidro1);
	    loja.setItem(23, vidro1);
	    loja.setItem(24, vidro1);
	    loja.setItem(25, vidro1);
	    loja.setItem(26, vidro1); 
	    }
	    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
	    p.openInventory(loja);
		return false;
	
  }
	public void MoneyErro(Player p, String k, int i) {
		Inventory moneyerro = Bukkit.createInventory(p, 9, "§4Sem Coins Suficientes");
		
	    vidro = new ItemStack(Material.STAINED_GLASS_PANE);
	    vidrometa = vidro.getItemMeta();
	    vidrometa.setDisplayName(" ");
	    vidro.setItemMeta(vidrometa);
	    
	    erro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    errometa = erro.getItemMeta();
	    errometa.setDisplayName("§4ERRO AO COMPRAR");
	    errometa.setLore(Lore("§cVoce §cnao §cpossui §f" + i + " §cpara §ccomprar §co §ckit §f" + k));
	    erro.setItemMeta(errometa);
	    
	    for (int ii = 1; ii <= 9; ii++) {
	    	moneyerro.setItem(0, vidro);
	    	moneyerro.setItem(1, vidro);
	    	moneyerro.setItem(2, erro);
	    	moneyerro.setItem(3, erro);
	    	moneyerro.setItem(4, erro);
	    	moneyerro.setItem(5, erro);
	    	moneyerro.setItem(6, erro);
	    	moneyerro.setItem(7, vidro);
	    	moneyerro.setItem(8, vidro);
	    	
	    }
	    p.sendMessage("§c§lVoce nao possui §f" + i + " §c§lpara comprar o kit §f" + k);
	    p.openInventory(moneyerro);
	}
	
	public void Japossui(Player p, String k) {
			Inventory moneyerro = Bukkit.createInventory(p, 9, "§4Ja Possui");
			
		    vidro = new ItemStack(Material.STAINED_GLASS_PANE);
		    vidrometa = vidro.getItemMeta();
		    vidrometa.setDisplayName("§f§l#");
		    vidro.setItemMeta(vidrometa);
		    
		    erro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
		    errometa = erro.getItemMeta();
		    errometa.setDisplayName("§4Ja Possui");
		    errometa.setLore(Lore("§cVoce ja possui o kit: §f" + k));
		    erro.setItemMeta(errometa);
		    
		    for (int ii = 1; ii <= 9; ii++) {
		    	moneyerro.setItem(0, vidro);
		    	moneyerro.setItem(1, vidro);
		    	moneyerro.setItem(2, erro);
		    	moneyerro.setItem(3, erro);
		    	moneyerro.setItem(4, erro);
		    	moneyerro.setItem(5, erro);
		    	moneyerro.setItem(6, erro);
		    	moneyerro.setItem(7, vidro);
		    	moneyerro.setItem(8, vidro);
		    	
		    }
		    p.sendMessage("§c§lVoce ja possui o kit: §f" + k);
		    p.openInventory(moneyerro);
		}
	
	public void comprou(Player p, String k, int i) {
		Inventory moneyerro = Bukkit.createInventory(p, 9, "§aComprado com sucesso");
		
	    vidro = new ItemStack(Material.STAINED_GLASS_PANE);
	    vidrometa = vidro.getItemMeta();
	    vidrometa.setDisplayName("§f§l#");
	    vidro.setItemMeta(vidrometa);
	    
	    sucesso = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
	    sucessometa = sucesso.getItemMeta();
	    sucessometa.setDisplayName("§bVOCE COMPROU");
	    sucessometa.setLore(Lore("§bParabens §bvoce §bcomprou §bo §bkit §f" + k));
	    sucesso.setItemMeta(sucessometa);
	    
	    Main.getInstace().loja.set(p.getUniqueId() + "." + k, "true");
	    Main.getInstace().save();
	    
	    for (int ii = 1; ii <= 9; ii++) {
	    	moneyerro.setItem(0, vidro);
	    	moneyerro.setItem(1, vidro);
	    	moneyerro.setItem(2, sucesso);
	    	moneyerro.setItem(3, sucesso);
	    	moneyerro.setItem(4, sucesso);
	    	moneyerro.setItem(5, sucesso);
	    	moneyerro.setItem(6, sucesso);
	    	moneyerro.setItem(7, vidro);
	    	moneyerro.setItem(8, vidro);
	    	
	    }
	    p.sendMessage("§a§lVoce adquiriu o kit §f" + k + " §a§lcom sucesso");
	    p.openInventory(moneyerro);
	}
	}