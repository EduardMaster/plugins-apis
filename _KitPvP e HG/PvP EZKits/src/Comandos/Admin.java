package Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Main.Main;

public class Admin implements CommandExecutor, Listener{
	
	public static ArrayList<String> admin = new ArrayList<>();
	public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> savearmor = new HashMap<String, ItemStack[]>();
	@SuppressWarnings("deprecation")
	@Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (!(sender instanceof Player)) {
			sender.sendMessage("Para usar isso tem que ser um player");
			return true;
		}
		if (!(sender.hasPermission("ezkits.admin"))) {
			sender.sendMessage("§cVoce não tem Permissão");
			return true;
		}
		
		
		Player p = (Player)sender;
		if (args.length == 0) {
			if (!admin.contains(p.getName())) {
				p.sendMessage("§a Voce entrou no Modo Admin!*");
				for (Player s : Bukkit.getOnlinePlayers()) {
					s.sendMessage("§7[§4Ø§7]" + p.getDisplayName());
					if (s.hasPermission("ezkits.admin")) {
						s.hidePlayer(p);
					}
				}
				p.setGameMode(GameMode.CREATIVE);
				p.setAllowFlight(true);
				admin.add(p.getName());
				saveinv.put(p.getName(), p.getInventory().getContents());
				savearmor.put(p.getName(), p.getInventory().getArmorContents());
				p.getInventory().clear();
				
				ItemStack redstone = new ItemStack(Material.REDSTONE);
			    ItemMeta redstonemeta = redstone.getItemMeta();
				redstonemeta.setDisplayName("§f §k aa §4 SAIR do Admin §f §k aa");
				redstone.setItemMeta(redstonemeta);
				
				ItemStack info = new ItemStack(Material.PAPER);
			    ItemMeta infometa = info.getItemMeta();
				infometa.setDisplayName("§f §k aa §4 Informaçoes do Player §f §k aa");
				info.setItemMeta(infometa);
				
				ItemStack repulsao = new ItemStack(Material.STICK);
			    ItemMeta repulsaometa = repulsao.getItemMeta();
				repulsaometa.addEnchant(Enchantment.KNOCKBACK, 10, true);
			    repulsaometa.setDisplayName("§f §k aa §4 Teste de KB §f §k aa");
				repulsao.setItemMeta(repulsaometa);
				
				ItemStack autosoup = new ItemStack(Material.BOWL);
			    ItemMeta autosoupmeta = autosoup.getItemMeta();
				autosoupmeta.setDisplayName("§f §k aa §4 AutoSoup §f §k aa");
				autosoup.setItemMeta(autosoupmeta);
				
				ItemStack ff = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
			    ItemMeta ffmeta = ff.getItemMeta();
				ffmeta.setDisplayName("§f §k aa §4 ForceField §f §k aa");
				ff.setItemMeta(ffmeta);
				
				ItemStack tr = new ItemStack(Material.APPLE);
			    ItemMeta trmeta = tr.getItemMeta();
				trmeta.setDisplayName("§f §k aa §4 TrocaRapida §f §k aa");
				tr.setItemMeta(trmeta);
				
				ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
			    ItemMeta espadameta = espada.getItemMeta();
			    espadameta.addEnchant(Enchantment.DAMAGE_ALL, 9999, true);
			    espadameta.setDisplayName("§f §k aa §4 Hit-Kill §f §k aa");
				espada.setItemMeta(espadameta);
				
				p.getInventory().setItem(8, redstone);
				p.getInventory().setItem(6, info);
				p.getInventory().setItem(3, ff);
				p.getInventory().setItem(2, repulsao);
				p.getInventory().setItem(1, autosoup);
				p.getInventory().setItem(7, tr);
				p.getInventory().setItem(0, espada);
			} else {
				p.sendMessage("§aVoce Saiu do Modo Admin");
				p.getInventory().clear();
				admin.remove(p.getName());
				for (Player s : Bukkit.getOnlinePlayers()) {
					s.sendMessage("§7[§4+§7]" + p.getDisplayName());
					if (s.hasPermission("ezkits.admin")) {
						s.showPlayer(p);
					}
			}
				p.getInventory().setContents(saveinv.get(p.getName()));
				p.getInventory().setArmorContents(savearmor.get(p.getName()));
		}
	}
		return false;
	}
	
	@EventHandler
	public void InteragirRedstone(PlayerInteractEvent e) {
		if (e.getMaterial() == Material.REDSTONE && admin.contains(e.getPlayer().getName())) {
			e.getPlayer().chat("/admin");
		}
	}
	
	@EventHandler
	public void InteragirInfo(PlayerInteractEntityEvent e) {
		if (e.getPlayer().getItemInHand().getType() == Material.PAPER && admin.contains(e.getPlayer().getName()) && e.getRightClicked() instanceof Player) {
			Player p = e.getPlayer();
			Player t = (Player)e.getRightClicked();
			Damageable hp = t;
			p.sendMessage("§aInformaçoes do Player §6§l" + t.getName());
			p.sendMessage("§aVida   §6" +  (int)hp.getHealth());
			p.sendMessage("§aSopas: §6" + getMaterial(p, Material.MUSHROOM_SOUP));
			}
	}
	
	public static int getMaterial(Player p, Material m) {
		int value = 0;
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null && item.getType() == m && item.getAmount() > 0) {
				value += item.getAmount();
			}
		}
		return value;
	}
	
	@EventHandler
	public void AutoSoup(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.BOWL && admin.contains(e.getPlayer().getName())) {
			Player p = e.getPlayer();
			Player t = (Player)e.getRightClicked();
			p.openInventory(t.getInventory());
			ItemStack s = new ItemStack(Material.MUSHROOM_SOUP);
			ItemMeta smeta = s.getItemMeta();
			smeta.setDisplayName("SopaDeAutoGogumelo");
			t.getInventory().setItem(9, new ItemStack(Material.MUSHROOM_SOUP));
			t.getInventory().setItem(10, new ItemStack(Material.AIR));
			t.getInventory().setItem(11, new ItemStack(Material.AIR));
			t.getInventory().setItem(12, new ItemStack(Material.AIR));
			t.getInventory().setItem(13, new ItemStack(Material.AIR));
			t.getInventory().setItem(14, new ItemStack(Material.AIR));
			t.getInventory().setItem(15, new ItemStack(Material.AIR));
			t.getInventory().setItem(16, new ItemStack(Material.AIR));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				
				@Override
				public void run() {
				   t.getInventory().setItem(10, s);
					
				}
			}, 25);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				
				@Override
				public void run() {
				   t.getInventory().setItem(10, s);
					
				}
			}, 50);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		
		@Override
		public void run() {
		   t.getInventory().setItem(11, s);
			
		}
	}, 75);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		
		@Override
		public void run() {
		   t.getInventory().setItem(12, s);
			
		}
	}, 100);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		
		@Override
		public void run() {
		   t.getInventory().setItem(13, s);
			
		}
	}, 125);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		
		@Override
		public void run() {
		   t.getInventory().setItem(14, s);
			
		}
	}, 150);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		
		@Override
		public void run() {
		   t.getInventory().setItem(15, s);
			
		}
	}, 175);
	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		
		@Override
		public void run() {
		   t.getInventory().setItem(16, s);
			
		}
	}, 200);
		}
	}
	@EventHandler
	public void ff(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.SKULL_ITEM && admin.contains(e.getPlayer().getName())) {
			Player p = e.getPlayer();
			Player t = (Player)e.getRightClicked();
			p.chat("/f" + t.getName());
		}
	}
	 @EventHandler
	  public void interact(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
	      if (p.getItemInHand().getType() == Material.APPLE)
	      {
	        e.setCancelled(true);
	        









	        p.sendMessage("§cTestando...");
	        




	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
	        {
	          public void run()
	          {
	            p.setGameMode(GameMode.SURVIVAL);
	          }
	        }, 10L);
	        
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
	        {
	          public void run()
	          {
	            p.setGameMode(GameMode.CREATIVE);
	          }
	        }, 20L);
	      }
	    }
	  }
	
	@EventHandler
	public void abrirInv(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.AIR && admin.contains(e.getPlayer().getName())) {
			Player t = (Player)e.getRightClicked();
			e.getPlayer().openInventory(t.getInventory());
			
		}
	}
	@EventHandler
	public void Pegar(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (admin.contains(p.getName())) {
			e.setCancelled(true);
		}
	}
	
}
