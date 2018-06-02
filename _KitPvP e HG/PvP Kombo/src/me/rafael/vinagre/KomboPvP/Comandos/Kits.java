package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;



import org.bukkit.Bukkit;
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

import Scoreboard.Genocida;
import XP.XpM;
import me.rafael.vinagre.KomboPvP.Listeners.KillsDeathsMoney;
import me.rafael.vinagre.KomboPvP.Listeners.Eventos;


import org.bukkit.enchantments.Enchantment;

public class Kits 
implements Listener, CommandExecutor
{
	
	@EventHandler
	public void kits(InventoryClickEvent e)
	{
	  if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
	  {
	    Inventory inv = e.getInventory();
	    Player p = (Player)e.getWhoClicked();
	    if (inv.getTitle().equals("§7» §cKits"))
	    {
	      p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
	      e.setCancelled(true);
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aProxima pagina")){
	    	  Bukkit.dispatchCommand(p, "kits2");
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLoja")){
	    	  Bukkit.dispatchCommand(p, "loja");
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSeus Status")){
	    	  p.sendMessage("§cKills: " + KillsDeathsMoney.getKills(p));
	    	  p.sendMessage("§cDeaths: " + KillsDeathsMoney.getDeaths(p));
	    	  p.sendMessage("§cXp: " + XpM.getPlayerMoney(p));
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPvP")){
	    	  Bukkit.dispatchCommand(p, "pvp");
	    	  p.closeInventory();
	      }
	    
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lJellyfish"))
	        {
	          Bukkit.dispatchCommand(p, "jellyfish");
	          p.closeInventory();
	        }
	        
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBloodgun"))
	        {
	          Bukkit.dispatchCommand(p, "bloodgun");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNaruto"))
	        {
	          Bukkit.dispatchCommand(p, "naruto");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFlash"))
	        {
	          Bukkit.dispatchCommand(p, "flash");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFrosty"))
	        {
	          Bukkit.dispatchCommand(p, "frosty");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTrocador"))
	        {
	          Bukkit.dispatchCommand(p, "trocador");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNinja"))
	        {
	          Bukkit.dispatchCommand(p, "ninja");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPoseidon"))
	        {
	          Bukkit.dispatchCommand(p, "poseidon");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lJumper"))
	        {
	          Bukkit.dispatchCommand(p, "jumper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lReaper"))
	        {
	          Bukkit.dispatchCommand(p, "reaper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDJ"))
	        {
	          Bukkit.dispatchCommand(p, "dj");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGrandpa"))
	        {
	          Bukkit.dispatchCommand(p, "grandpa");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lRobinHood"))
	        {
	          Bukkit.dispatchCommand(p, "robinhood");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lRyu"))
	        {
	          Bukkit.dispatchCommand(p, "ryu");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSnail"))
	        {
	          Bukkit.dispatchCommand(p, "snail");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lStomper"))
	        {
	          Bukkit.dispatchCommand(p, "stomper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAvatar"))
	        {
	          Bukkit.dispatchCommand(p, "avatar");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSwitcher"))
	        {
	          Bukkit.dispatchCommand(p, "switcher");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lThor"))
	        {
	          Bukkit.dispatchCommand(p, "thor");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lThresh"))
	        {
	          Bukkit.dispatchCommand(p, "thresh");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTimelord"))
	        {
	          Bukkit.dispatchCommand(p, "timelord");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTurtle"))
	        {
	          Bukkit.dispatchCommand(p, "turtle");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lVelotrol"))
	        {
	          Bukkit.dispatchCommand(p, "velotrol");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lViking"))
	        {
	          Bukkit.dispatchCommand(p, "viking");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lViper"))
	        {
	          Bukkit.dispatchCommand(p, "viper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lVitality"))
	        {
	          Bukkit.dispatchCommand(p, "vitality");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGaara"))
	        {
	          Bukkit.dispatchCommand(p, "gaara");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNetherMan"))
	        {
	          Bukkit.dispatchCommand(p, "netherman");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lWither"))
	        {
	          Bukkit.dispatchCommand(p, "wither");
	          p.closeInventory();
	        }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lQuickdropper")){
	    	  Bukkit.dispatchCommand(p, "quickdropper");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAnchor")){
	    	  Bukkit.dispatchCommand(p, "anchor");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lArcher")){
	    	  Bukkit.dispatchCommand(p, "archer");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lChestplate")){
	    	  Bukkit.dispatchCommand(p, "chestplate");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBarbarian")){
	    	  Bukkit.dispatchCommand(p, "barbarian");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBoxer")){
	    	  Bukkit.dispatchCommand(p, "boxer");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCamel")){
	    	  Bukkit.dispatchCommand(p, "camel");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCicle-Fire")){
	    	  Bukkit.dispatchCommand(p, "ciclefire");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lConfuser")){
	    	  Bukkit.dispatchCommand(p, "confuser");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCritical")){
	    	  Bukkit.dispatchCommand(p, "critical");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCyclope")){
	    	  Bukkit.dispatchCommand(p, "cyclope");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDarkGod")){
	    	  Bukkit.dispatchCommand(p, "darkgod");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDrain")){
	    	  Bukkit.dispatchCommand(p, "drain");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lEbola")){
	    	  Bukkit.dispatchCommand(p, "ebola");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFireMan")){
	    	  Bukkit.dispatchCommand(p, "fireman");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFisherMan")){
	    	  Bukkit.dispatchCommand(p, "fisherman");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lForcefield")){
	    	  Bukkit.dispatchCommand(p, "forcefield");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFujao")){
	    	  Bukkit.dispatchCommand(p, "fujao");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGladiator")){
	    	  Bukkit.dispatchCommand(p, "gladiator");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGolen")){
	    	  Bukkit.dispatchCommand(p, "golen");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGrappler")){
	    	  Bukkit.dispatchCommand(p, "grappler");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lHulk")){
	    	  Bukkit.dispatchCommand(p, "hulk");
	    	  p.closeInventory();
	      }
	      
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lIndio")){
	    	  Bukkit.dispatchCommand(p, "indio");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lInfernor")){
	    	  Bukkit.dispatchCommand(p, "infernor");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lKangaroo")){
	    	  Bukkit.dispatchCommand(p, "kangaroo");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lLauncher")){
	    	  Bukkit.dispatchCommand(p, "launcher");
	    	  p.closeInventory();
	      }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lMonk")){
	    	  Bukkit.dispatchCommand(p, "monk");
	    	  p.closeInventory();
	      }
	     }
	  }
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("kits")){
			
			Inventory kits = Bukkit.createInventory(p, 54, "§7» §cKits");
			
			ItemStack vidro = new ItemStack(Material.THIN_GLASS);
			ItemMeta vidro2 = vidro.getItemMeta();
			vidro2.setDisplayName("§cVocê nao possue esse kit!");
			vidro.setItemMeta(vidro2);
			
			ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
			ItemMeta vidrob2 = vidrob.getItemMeta();
			vidrob2.setDisplayName(" ");
			vidrob.setItemMeta(vidrob2);
			
			ItemStack vidroc = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)13);
			ItemMeta vidroc2 = vidroc.getItemMeta();
			vidroc2.setDisplayName(" ");
			vidroc.setItemMeta(vidroc2);
			
			ItemStack loja = new ItemStack(Material.GOLD_INGOT);
			ItemMeta loja2 = loja.getItemMeta();
			loja2.setDisplayName("§aLoja");
			loja.setItemMeta(loja2);
			
			ItemStack status = new ItemStack(Material.SKULL_ITEM);
			ItemMeta status2 = status.getItemMeta();
			status2.setDisplayName("§aSeus Status");
			status.setItemMeta(status2);
			
			ItemStack passar = new ItemStack(Material.INK_SACK,1,(short)10);
			ItemMeta passar2 = passar.getItemMeta();
			passar2.setDisplayName("§aProxima pagina");
			passar.setItemMeta(passar2);
			
			ItemStack voltar = new ItemStack(Material.INK_SACK,1,(short)8);
			ItemMeta voltar2 = voltar.getItemMeta();
			voltar2.setDisplayName("§7Pagina anterior");
			voltar.setItemMeta(voltar2);
			
			 kits.setItem(0, voltar);
		      kits.setItem(1, vidrob);
		      kits.setItem(2, loja);
		      kits.setItem(3, vidroc);
		      kits.setItem(4, status);
		      kits.setItem(5, vidroc);
		      kits.setItem(6, loja);
		      kits.setItem(7, vidrob);
		      kits.setItem(8, passar);
			
		     {
				ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lPvP");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Ganhe espada encantada!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.quickdropper")){
				ItemStack pyro = new ItemStack(Material.BOWL);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lQuickdropper");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Drope sopas automaticamente !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.kangaroo")){
				ItemStack pyro = new ItemStack(Material.FIREWORK);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lKangaroo");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7De pulos duplos");
			      indiob.add("§7usando seu firework !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.archer")){
				ItemStack pyro = new ItemStack(Material.BOW);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lArcher");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Use seu arco para acabar com os inimigos !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.chestplate")){
				ItemStack pyro = new ItemStack(Material.IRON_CHESTPLATE);
				
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lChestplate");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Ganhe um peitoral !");
			      indiob.add("§7de ferro !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.barbarian")){
				ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lBarbarian");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7A cada kill sua espada aumentara de level !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.boxer")){
				ItemStack pyro = new ItemStack(Material.QUARTZ);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lBoxer");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Com este kit, sua mao vai ter o dano de uma espada de ferro !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.camel")){
				ItemStack pyro = new ItemStack(Material.SAND);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lCamel");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Ganhe vantagens");
			      indiob.add("§7No deserto");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.ciclefire")){
				ItemStack pyro = new ItemStack(Material.FLINT_AND_STEEL);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lCicle-Fire");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Bote fogo");
			      indiob.add("§7nos inimigos!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.confuser")){
				ItemStack pyro = new ItemStack(Material.POTION);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lConfuser");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Deixe o inimigo confuso!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.critical")){
				ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lCritical");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7De golpe criticos!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.cyclope")){
				ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lCyclope");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Seja um cyclope!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.darkgod")){
				ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lDarkGod");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Deixe os inimigos");
			      indiob.add("§7cegos");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.drain")){
				ItemStack pyro = new ItemStack(Material.REDSTONE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lDrain");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Suge o sangue");
			      indiob.add("§7dos inimigos");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.ebola")){
				ItemStack pyro = new ItemStack(Material.POTION);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lEbola");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Passe ebola");
			      indiob.add("§7para todos");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.fireman")){
				ItemStack pyro = new ItemStack(Material.FIRE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lFireMan");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Bote fogo");
			      indiob.add("§7nos inimigos");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.fisherman")){
				ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lFisherMan");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Vire um pescador");
			      indiob.add("§7de players");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.forcefield")){
				ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lForcefield");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Tenha um campo de força");
			      indiob.add("§7que te protege");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.fujao")){
				ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lFujao");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Fuja do inimigo");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.gladiator")){
				ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lGladiator");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Chame o inimigo pra X1");
			      indiob.add("§7na sua arena de vidro !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.golen")){
				ItemStack pyro = new ItemStack(Material.RED_ROSE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lGolen");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Jogue os inimigos pra cima");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.grappler")){
				ItemStack pyro = new ItemStack(Material.LEASH);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lGrappler");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Use sua cordinha");
			      indiob.add("§7Para voar por ai");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.hulk")){
				ItemStack pyro = new ItemStack(Material.SADDLE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lHulk");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Pegue os inimigos");
			      indiob.add("§cE jogue eles");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.indio")){
				ItemStack pyro = new ItemStack(Material.PUMPKIN_SEEDS);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lIndio");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Atire dardos venenos");
				  metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.infernor")){
				ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lInfernor");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Chame o inimigo pra x1");
			      indiob.add("§7em sua arena do nether!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.anchor")){
				ItemStack pyro = new ItemStack(Material.ANVIL);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lAnchor");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Nao leve");
			      indiob.add("§7nem tome KB");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.launcher")){
				ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lLauncher");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Com este kit voce pode jogar o inimigo para cima");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.monk")){
				ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§7Kit §e§lMonk");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Bagungue o inv inimigo");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if (p.hasPermission("kitpvp.kit.netherman"))
		      {
		        ItemStack pyro = new ItemStack(Material.NETHER_BRICK);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lNetherMan");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Ganhe vantagens");
		        indiob.add("§7No bioma do Nether");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.naruto"))
		      {
		        ItemStack pyro = new ItemStack(Material.NETHER_STAR);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lNaruto");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Vire o naruto");
		        indiob.add("§7E entre no modo 9 caudas!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		     
		      if (p.hasPermission("kitpvp.kit.jellyfish"))
		      {
		        ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lJellyfish");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Coloque agua parada no chao");
		        indiob.add("§c§lE cause veneno");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.ninja"))
		      {
		        ItemStack pyro = new ItemStack(Material.FENCE);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lNinja");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Com este kit quando voce apertar SHIFT sera");
		        indiob.add("§7teletransportado para o ultimo jogador hitado.");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.poseidon"))
		      {
		        ItemStack pyro = new ItemStack(Material.WATER);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lPoseidon");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Com este kit quando voce entrar na agua");
		        indiob.add("§7ganhara efeitos.");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.reaper"))
		      {
		        ItemStack pyro = new ItemStack(Material.WOOD_HOE);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lReaper");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Bata no inimigo com a foice");
		        indiob.add("§7e faça ele apodrecer");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.robinhood"))
		      {
		        ItemStack pyro = new ItemStack(Material.BOW);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lRobinHood");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Com este kit quando voce pode virar o Robin !");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.ryu"))
		      {
		        ItemStack pyro = new ItemStack(Material.BEACON);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lRyu");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Com este kit voce pode dar um hadouken no inimigo !");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.snail"))
		      {
		        ItemStack pyro = new ItemStack(Material.WEB);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lSnail");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Deixe seus inimigos lentos !");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.stomper"))
		      {
		        ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lStomper");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Esmague seus inimigos");
		        indiob.add("§7Pulando em cima deles");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.switcher"))
		      {
		        ItemStack pyro = new ItemStack(Material.SNOW_BALL, 16);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lSwitcher");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Troque de lugar com seu inimigo");
		        indiob.add("§7Usando bolas de neve");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.thor"))
		      {
		        ItemStack pyro = new ItemStack(Material.GOLD_AXE);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lThor");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Invoque raios!");
		        indiob.add("§7Com seu machado!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.thresh"))
		      {
		        ItemStack pyro = new ItemStack(Material.TRIPWIRE_HOOK);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lThresh");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Puxe o inimigo");
		        indiob.add("§7E o deixe envenenado");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.timelord"))
		      {
		        ItemStack pyro = new ItemStack(Material.WATCH);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lTimelord");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Pare o tempo");
		        indiob.add("§7E congele os inimigos");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.turtle"))
		      {
		        ItemStack pyro = new ItemStack(Material.GOLD_CHESTPLATE);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lTurtle");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Leve menos dano!");
		        indiob.add("§7Segurando shift!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.velotrol"))
		      {
		        ItemStack pyro = new ItemStack(Material.MINECART);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lVelotrol");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7De um boost");
		        indiob.add("§7e exploda o inimigo!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.viking"))
		      {
		        ItemStack pyro = new ItemStack(Material.STONE_AXE);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§7Kit §e§lViking");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7De o dano de uma espada de ferro!");
		        indiob.add("§7Com seu machado");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
			ItemStack[] arrayOfItemStack;
		    int descpyro1 = (arrayOfItemStack = kits.getContents()).length;
		    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
		    {
		      ItemStack item = arrayOfItemStack[metapyro1];
		      if (item == null) {
		        kits.setItem(kits.firstEmpty(), vidro);
		      }
		    }
			
			p.openInventory(kits);
		}
		return true;
	}
}