package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;




import org.bukkit.Bukkit;
import org.bukkit.Location;
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

import me.rafael.vinagre.KomboPvP.Listeners.Eventos;
import me.rafael.vinagre.KomboPvP.Listeners.KillsDeathsMoney;


public class Kits2
  implements Listener, CommandExecutor
{
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("§cKits [2]"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Pagina anterior")) {
          Bukkit.dispatchCommand(p, "kits");
        }
        
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lJellyfish"))
        {
          Bukkit.dispatchCommand(p, "jellyfish");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDeshfire"))
        {
          Bukkit.dispatchCommand(p, "deshfire");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNoFall"))
        {
        	 Bukkit.dispatchCommand(p, "nofall");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSonic"))
        {
        	 Bukkit.dispatchCommand(p, "sonic");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSubzero"))
        {
        	 Bukkit.dispatchCommand(p, "subzero");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAlladin"))
        {
        	 Bukkit.dispatchCommand(p, "alladin");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAvatar"))
        {
        	 Bukkit.dispatchCommand(p, "avatar");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTeleporter"))
        {
        	 Bukkit.dispatchCommand(p, "teleporter");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGun"))
        {
        	 Bukkit.dispatchCommand(p, "gun");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDoubleJump"))
        {
        	 Bukkit.dispatchCommand(p, "doublejump");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBurstmaster"))
        {
          Bukkit.dispatchCommand(p, "burstmaster");
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
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSeus Status")){
        	p.sendMessage("§cKills: " + KillsDeathsMoney.getKills(p));
	    	  p.sendMessage("§cDeaths: " + KillsDeathsMoney.getDeaths(p));
	    	  p.sendMessage("§cXp: " + XpM.getPlayerMoney(p));
	    	  p.closeInventory();
	      }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNetherman"))
        {
          Bukkit.dispatchCommand(p, "netherman");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lWither"))
        {
          Bukkit.dispatchCommand(p, "wither");
          p.closeInventory();
        }
      
      
       if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLoja")) {
          Bukkit.dispatchCommand(p, "loja");
          if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aSeus Status")){
        	  p.sendMessage("§cKills: " + KillsDeathsMoney.getKills(p));
	    	  p.sendMessage("§cDeaths: " + KillsDeathsMoney.getDeaths(p));
	    	  p.sendMessage("§cXp: " + XpM.getPlayerMoney(p));
	    	  p.closeInventory();
	      }
       }
    }
    }
  }
       
      
      
     
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("kits2"))
    {
      Inventory kits = Bukkit.createInventory(p, 54, "§cKits [2]");
      
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
      
      ItemStack voltar = new ItemStack(Material.INK_SACK, 1, (short)8);
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
      kits.setItem(8, voltar);
      
      
      
      if (p.hasPermission("kitpvp.kit.viper"))
      {
        ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lViper");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Com este kit voce deixar o inimigo com veneno !");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.vitality"))
      {
        ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lVitality");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Com este kit quando voce matar um jogador seu inventario");
        indiob.add("§7sera preenchido com sopa !");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.gaara"))
      {
        ItemStack pyro = new ItemStack(Material.SANDSTONE);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lGaara");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Controle a areia e seja o Gaara !");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
      }
      if (p.hasPermission("kitpvp.kit.wither"))
      {
        ItemStack pyro = new ItemStack(Material.SKULL_ITEM, 1, (short)1);
        ItemMeta metapyro = pyro.getItemMeta();
        metapyro.setDisplayName("§7Kit §e§lWither");
        ArrayList indiob = new ArrayList();
        indiob.add("§7Com este kit voce tacar cabeças de wither no inimigo !");
        metapyro.setLore(indiob);
        pyro.setItemMeta(metapyro);
        kits.addItem(new ItemStack[] { pyro });
        
      } 
      if (p.hasPermission("kitpvp.kit.jumper"))
      {
          ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
          ItemMeta metapyro = pyro.getItemMeta();
          metapyro.setDisplayName("§7Kit §e§lJumper");
          ArrayList indiob = new ArrayList();
          indiob.add("§7Teleport-se");
          indiob.add("§7Com seu item");
          metapyro.setLore(indiob);
          pyro.setItemMeta(metapyro);
          kits.addItem(new ItemStack[] { pyro });
        }
      {
    	  if (p.hasPermission("kitpvp.kit.trocador"))
          {
              ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
              ItemMeta metapyro = pyro.getItemMeta();
              metapyro.setDisplayName("§7Kit §e§lTrocador");
              ArrayList indiob = new ArrayList();
              indiob.add("§7Aperte shift");
              indiob.add("§7E ganhe armadura!");
              metapyro.setLore(indiob);
              pyro.setItemMeta(metapyro);
              kits.addItem(new ItemStack[] { pyro });
            }
          {
        	  if (p.hasPermission("kitpvp.kit.dj"))
              {
                  ItemStack pyro = new ItemStack(Material.GOLD_SWORD);
                  ItemMeta metapyro = pyro.getItemMeta();
                  metapyro.setDisplayName("§7Kit §e§lDJ");
                  ArrayList indiob = new ArrayList();
                  indiob.add("§7A cada hit");
                  indiob.add("§7Sua espada muda!");
                  metapyro.setLore(indiob);
                  pyro.setItemMeta(metapyro);
                  kits.addItem(new ItemStack[] { pyro });
                }
        	  if (p.hasPermission("kitpvp.kit.flash"))
              {
                  ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
                  ItemMeta metapyro = pyro.getItemMeta();
                  metapyro.setDisplayName("§7Kit §e§lFlash");
                  ArrayList indiob = new ArrayList();
                  indiob.add("§7Se teleporte");
                  indiob.add("§7Clicando na sua tocha");
                  metapyro.setLore(indiob);
                  pyro.setItemMeta(metapyro);
                  kits.addItem(new ItemStack[] { pyro });
                }
        	  if (p.hasPermission("kitpvp.kit.bloodgun"))
              {
                  ItemStack pyro = new ItemStack(Material.GOLD_HOE);
                  ItemMeta metapyro = pyro.getItemMeta();
                  metapyro.setDisplayName("§7Kit §e§lBloodgun");
                  ArrayList indiob = new ArrayList();
                  indiob.add("§7Solte uma bola de fogo");
                  indiob.add("§7Com sua enxada!");
                  metapyro.setLore(indiob);
                  pyro.setItemMeta(metapyro);
                  kits.addItem(new ItemStack[] { pyro });
                 
                      
                }
        	  if (p.hasPermission("kitpvp.kit.grandpa"))
              {
                  ItemStack pyro = new ItemStack(Material.STICK);
                  ItemMeta metapyro = pyro.getItemMeta();
                  metapyro.setDisplayName("§7Kit §e§lGrandpa");
                  ArrayList indiob = new ArrayList();
                  indiob.add("§7De knockback");
                  indiob.add("§7Extra com seu graveto!");
                  metapyro.setLore(indiob);
                  pyro.setItemMeta(metapyro);
                  kits.addItem(new ItemStack[] { pyro });
                 
                      
                }
        	
                  
        	  if (p.hasPermission("kitpvp.kit.frosty"))
              {
                  ItemStack pyro = new ItemStack(Material.SNOW_BLOCK);
                  ItemMeta metapyro = pyro.getItemMeta();
                  metapyro.setDisplayName("§7Kit §e§lFrosty");
                  ArrayList indiob = new ArrayList();
                  indiob.add("§7Ganhe vantagens");
                  indiob.add("§7No bioma de neve!");
                  metapyro.setLore(indiob);
                  pyro.setItemMeta(metapyro);
                  kits.addItem(new ItemStack[] { pyro });
              }
                  if (p.hasPermission("kitpvp.kit.burstmaster"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.GOLD_HOE);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lBurstmaster");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Cause explosoes");
        	        indiob.add("§7com sua foice");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.nofall"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.FEATHER);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lNoFall");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Nao leve dano de queda");
        	        
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.teleporter"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.BOW);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lTeleporter");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Aonde a flecha cair");
        	        indiob.add("§7Vc sera teleportado");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.subzero"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.PACKED_ICE);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lSubzero");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Seja o subzero");
        	        indiob.add("§7E solte um gelo congelante");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.sonic"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lSonic");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7De um desh");
        	        indiob.add("§7E bote veneno");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.avatar"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.BEACON);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lAvatar");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Controle os 4");
        	        indiob.add("§7Elementos");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.doublejump"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.CHAINMAIL_BOOTS);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lDoubleJump");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7De pulos duplos");
        	        indiob.add("§7Apertando espaço");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.gun"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.IRON_HOE);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lGun");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Tenha uma pistola");
        	        indiob.add("§7super daora!");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.alladin"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.CARPET);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lAlladin");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7Seja o alladin");
        	        indiob.add("§7E voe com seu tapete magico");
        	        metapyro.setLore(indiob);
        	        pyro.setItemMeta(metapyro);
        	        
        	        kits.addItem(new ItemStack[] { pyro });
        	      }
        	      if (p.hasPermission("kitpvp.kit.deshfire"))
        	      {
        	        ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
        	        ItemMeta metapyro = pyro.getItemMeta();
        	        metapyro.setDisplayName("§7Kit §e§lDeshfire");
        	        ArrayList indiob = new ArrayList();
        	        indiob.add("§7De um desh");
        	        indiob.add("§7e bote fogo!");
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
        	      return false;
        	    }
        	    
        	  }
        	}
	return false;
  }
}


