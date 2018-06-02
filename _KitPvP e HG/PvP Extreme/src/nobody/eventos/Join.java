package nobody.eventos;

import nobody.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Join implements Listener{

	  public Main plugin;
	  
	  public Join(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	@EventHandler
	public void entrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Main.mlg.remove(p.getName());
		Location l = p.getWorld().getSpawnLocation();
		p.teleport(l);
		
		e.setJoinMessage(null);
		p.sendMessage("§c§m-----------------------------------------------");
		p.sendMessage("     §6§l •  §aSeja Bem-Vindo ao    §6§l• ");
		p.sendMessage("     §6§l •  §b§lEXTREMEPVP    §6§l• ");
		p.sendMessage("     §6§l • §7Bom Treino!   §6§l• ");
		p.sendMessage("     §6§l  •  §bNovo Sistema:    §6§l• ");
		p.sendMessage("     §6§l•  §e§l§nCAIXAS!§a    §6§l• ");
		p.sendMessage("§c§m-----------------------------------------------");
		p.getInventory().setChestplate(null);
		p.getInventory().setHelmet(null);
		p.getInventory().setBoots(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setChestplate(null);
	
	    p.setDisplayName("§7" + p.getName() + ChatColor.WHITE);
	    p.setPlayerListName("§f" + p.getName());
		p.setGameMode(GameMode.ADVENTURE);
		
		  Main.plugin.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
		  {
		    public void run()
		    {
		      nobody.scoreboard.Scoreboards.iscoriboard(p);
		    }
		  }, 0L, 20L);
		}
	
	@EventHandler
	  public void onR(PlayerRespawnEvent e)
	  {
		Player p = e.getPlayer();
		Join.entrar(p);
	  }
	@EventHandler
	public void explodir(EntityExplodeEvent e)
	{
		e.setCancelled(true);
	}
		 
@SuppressWarnings("deprecation")
public static void entrar(Player p){
	    
	    ItemStack livro = Main.im.createItem(Material.getMaterial(342), "livro", "§7[§6§l!§7] §bSeus Kits§7 [§6§l!§7] ", new String[] { "§b» §7Escolha Seu Kit! §b«" }, 1, (short)0);
	    ItemStack papel = Main.im.createItem(Material.PAPER, "barra", "§7[§6§l!§7] §bWarps§7 [§6§l!§7] ", new String[] { "§b» §7Teleporte-se Entre Arenas! §b«" }, 1, (short)0);
	    ItemStack yt = Main.im.createItem(Material.BONE, "barra", "§7[§6§l!§7] §bMiniGames§7 [§6§l!§7] ", new String[] { "§b» §7Treine Com Nossos Minigames! §b«" }, 1, (short)0);
	    ItemStack loja = Main.im.createItem(Material.EXP_BOTTLE, "barra", "§7[§6§l!§7] §bXP do Dia§7 [§6§l!§7] ", new String[] { "§b» §7Loja de BuyCraft §b«" }, 1, (short)0);    
	    ItemStack menu = Main.im.createItem(Material.PISTON_BASE, "barra", "§7[§6§l!§7] §aMenu§7 [§6§l!§7] ", new String[] { "§e» §7ExtremeKits 2016 §e«" }, 1, (short)0);
	    ItemStack Ajuda = Main.im.createItem(Material.NAME_TAG, "barra", "§7[§6§l!§7] §bExtras§7 [§6§l!§7] ", new String[] {"§b» §7Caixas... §b«" }, 1, (short)0);
	    ItemStack lojakits = Main.im.createItem(Material.GOLD_INGOT, "barra", "§7[§6§l!§7] §bMenu de Lojas §7[§6§l!§7] ", new String[] { "§b» §7Compre Kits Com o XP §b«" }, 1, (short)0);
	    ItemStack air = new ItemStack(Material.AIR);
	    
	    p.getInventory().clear();
	    p.getInventory().setItem(0, livro);
	    p.getInventory().setItem(1, papel);
	    p.getInventory().setItem(2, air);
	    p.getInventory().setItem(3, lojakits);
	    p.getInventory().setItem(4, menu);
	    p.getInventory().setItem(5, Ajuda);
	    p.getInventory().setItem(6, air);
	    p.getInventory().setItem(7, yt);
	    p.getInventory().setItem(8, loja);
	    
		  p.getInventory().setHelmet(null);
		  p.getInventory().setBoots(null);
		  p.getInventory().setLeggings(null);
		  
	      KitAPI.RemoveKit(p);
  }
  
	@EventHandler
	  public void onK(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    entrar(p);
	      Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Gold", "false");
	      Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Diamante", "false");
	      Main.getInstance().caixa.set(p.getName().toLowerCase() + ".Esmeralda", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Anchor", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Stomper", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Endermage", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Camel", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Avatar", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".ForceField", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Rain", "false");
	      Main.getInstance().loja.set(p.getName().toLowerCase() + ".Snail", "false");
	      Main.getInstance().save();
	      Main.getInstance().save2();
	  }

		      @EventHandler
		      public void matou(PlayerDeathEvent e)
		      {
		        Player p = e.getEntity();
		        
		        if (p.getKiller() == null) {
		          p.sendMessage("§7[§6§l!§7] §cVoce morreu!");
		        }
		        if ((p.getKiller() instanceof Player))
		        {
		        	
	      Player k = p.getKiller();
	      p.sendMessage("§c§lDEATH §b» §7Você Morreu Para: §c" + k.getName());
	      p.sendMessage("§e§lXP §b» §c-30");
	      
	      Money.removeMoney(p, 30);
	      
	      k.sendMessage("§e§lKILL §b» §7Voce Matou: §c" +  p.getName());
	      k.sendMessage("§e§lXP §b» §a+50");
	      k.playSound(k.getLocation(), Sound.FIREWORK_LAUNCH, 12F, 12F);
	      MoneyRank.addKills(1, k);
	      Money.addMoney(50, k);
	      {
			if(k.hasPermission("tk.doublecoins")) {
				k.sendMessage("§6§lVIP §b» §a+50 §7(x2) Coins");
				k.playSound(k.getLocation(), Sound.FIREWORK_LAUNCH, 12F, 12F);
				Money.addMoney(50, k);
		
				return;
			}
		        }
		        }
	  }
		      
		@EventHandler
		public void onpegaritens(PlayerPickupItemEvent e)
		{
			e.setCancelled(true);
		}
	  @SuppressWarnings("deprecation")
	@EventHandler
	
	  public void inte(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	     if (KitAPI.getkit(p) == "Nenhum" &&
	     ((p.getItemInHand().getType() == Material.GOLD_INGOT) && (
	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
	      (e.getAction() == Action.LEFT_CLICK_BLOCK)))) {
	      p.chat("/lojas");
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 9.0F, 1.0F);
	    }
	    if ((p.getItemInHand().getType() == Material.EMERALD) && (
	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
	      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	    	Inventory ender = p.getEnderChest();
	    	p.openInventory(ender);
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 9.0F, 1.0F);
	    }
	   
	    if ((p.getItemInHand().getType() == Material.PAPER) && (
	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
	      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	      p.chat("/warps");
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
	    }
	    if ((p.getItemInHand().getType() == Material.getMaterial(342)) && (
	      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	      (e.getAction() == Action.LEFT_CLICK_AIR) || 
	      (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
	      p.chat("/kits");
	    }
	      if ((p.getItemInHand().getType() == Material.NAME_TAG) && (
	     (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	     (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	     (e.getAction() == Action.LEFT_CLICK_AIR) || 
	     (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	      p.chat("/extra");
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
	      }	      
	      
	      if ((p.getItemInHand().getType() == Material.PISTON_BASE) && (
	     (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	     (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	     (e.getAction() == Action.LEFT_CLICK_AIR) || 
	     (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	      p.chat("/menu");
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
	      }
	      if ((p.getItemInHand().getType() == Material.SLIME_BALL) && (
	     (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	     (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	     (e.getAction() == Action.LEFT_CLICK_AIR) || 
	     (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	      p.chat("/kill");
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.0F, 1.0F);
	      }
	    if ((p.getItemInHand().getType() == Material.getMaterial(2256)) && (
	    (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	    (e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	    (e.getAction() == Action.LEFT_CLICK_AIR) || 
	    (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
	    e.setCancelled(true);
	    p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 15.0F, 1.0F);
	    }

	      }
	    
	    @EventHandler
	    public void fullJoin(PlayerLoginEvent event)
	    {
	      Player p = event.getPlayer();
	      if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL)
	      {
	        if (p.hasPermission("tk.cheio")) {
	          event.setResult(PlayerLoginEvent.Result.ALLOWED);
	        } else {
	          event.setKickMessage("§ceServidor Cheio!\n§fCompre §6VIP §fEm §aExtreme-Kits.TK");
	        }
	      }
	      else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
	        event.setKickMessage(ChatColor.GRAY + 
	          "§eO Servidor Encontra-Se Em Manutenção!\n§fCompre §6§lVIP §fPara Entrar\n§2=-=§bextreme-kits.tk§2=-=");
	      }
	    }
	  }

