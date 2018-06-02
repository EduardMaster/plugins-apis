package nobody.comandos;

import nobody.eventos.Money;
import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaDeItens
  implements Listener, CommandExecutor
{
  @SuppressWarnings("unused")
private Main plugin;
  
  public LojaDeItens(Main instance)
  {
    this.plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§7[§cErro§7] §cApenas jogadores podem executar esse comando");
      return true;
    }
    
    ItemStack iron = new ItemStack(Material.STAINED_GLASS_PANE, 1,(short)3);
    
    ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
    ItemMeta Swordmeta = Sword.getItemMeta();
    Swordmeta.setDisplayName(ChatColor.GREEN + " §fEspada de Diamante §a$200");
    Sword.setItemMeta(Swordmeta);
    
    ItemStack Sharp4 = new ItemStack(Material.DIAMOND_SWORD);
    Sharp4.addEnchantment(Enchantment.DAMAGE_ALL, 4);
    ItemMeta Sharp4meta = Sharp4.getItemMeta();
    Sharp4meta.setDisplayName(ChatColor.GREEN + " §fEspada Sharpness 4 §a$6000");
    Sharp4.setItemMeta(Sharp4meta);
    
    ItemStack Sharp5 = new ItemStack(Material.DIAMOND_SWORD);
    Sharp5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
    ItemMeta Sharp5meta = Sharp5.getItemMeta();
    Sharp5meta.setDisplayName(ChatColor.GREEN + " §fEspada Sharpness 5 §a$8000");
    Sharp5.setItemMeta(Sharp5meta);
    
    ItemStack EXP = new ItemStack(Material.EXP_BOTTLE);
    ItemMeta EXPmeta = EXP.getItemMeta();
    EXPmeta.setDisplayName(ChatColor.GREEN + " §fEXP §a$5200");
    EXP.setItemMeta(EXPmeta);
    
    ItemStack Arco = new ItemStack(Material.BOW);
    ItemMeta Arcometa = Arco.getItemMeta();
    Arcometa.setDisplayName(ChatColor.GREEN + " §fArco e Flecha §a$250");
    Arco.setItemMeta(Arcometa);
    
    ItemStack ArcoForça = new ItemStack(Material.BOW);
    ArcoForça.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
    ItemMeta ArcoForçameta = ArcoForça.getItemMeta();
    ArcoForçameta.setDisplayName(ChatColor.GREEN + " §fArco Força 5 §a$7000");
    ArcoForça.setItemMeta(ArcoForçameta);
    
    ItemStack ArcoImpacto = new ItemStack(Material.BOW);
    ArcoImpacto.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
    ItemMeta ArcoImpactometa = ArcoImpacto.getItemMeta();
    ArcoImpactometa.setDisplayName(ChatColor.GREEN + " §fArco Impacto 2 §a$4000");
    ArcoImpacto.setItemMeta(ArcoImpactometa);
    
    ItemStack warps = new ItemStack(Material.ARROW);
    ItemMeta Flechasmeta = warps.getItemMeta();
    Flechasmeta.setDisplayName(ChatColor.GREEN + "warps §a$150");
    warps.setItemMeta(Flechasmeta);
    
    ItemStack poção = new ItemStack(Material.POTION);
    poção.setDurability((short)8265);
    ItemMeta poçãometa = poção.getItemMeta();
    poçãometa.setDisplayName(ChatColor.GREEN + " §fPoção de Força §a$9500");
    poção.setItemMeta(poçãometa);
    
    ItemStack poção2 = new ItemStack(Material.POTION);
    poção2.setDurability((short)16457);
    ItemMeta poção2meta = poção2.getItemMeta();
    poção2meta.setDisplayName(ChatColor.GREEN + " §fDuas Poções de Força §a$9000");
    poção2.setItemMeta(poção2meta);
    
    ItemStack poção3 = new ItemStack(Material.POTION);
    poção3.setDurability((short)16428);
    ItemMeta poção3meta = poção3.getItemMeta();
    poção3meta.setDisplayName(ChatColor.GREEN + " §fPoção de Dano §a$2000");
    poção3.setItemMeta(poção3meta);
    
    ItemStack poção4 = new ItemStack(Material.POTION);
    poção4.setDurability((short)16418);
    ItemMeta poção4meta = poção4.getItemMeta();
    poção4meta.setDisplayName(ChatColor.GREEN + " §fPoção de Velocidade II §a$3000");
    poção4.setItemMeta(poção4meta);
    
    ItemStack poção5 = new ItemStack(Material.POTION);
    poção5.setDurability((short)16388);
    ItemMeta poção5meta = poção5.getItemMeta();
    poção5meta.setDisplayName(ChatColor.GREEN + " §fPoção de Veneno §a$1000");
    poção5.setItemMeta(poção5meta);
    Player p = (Player)sender;
    Inventory shop = Bukkit.getServer().createInventory(p, 18, ChatColor.GOLD + " §fShop");
    
    shop.setItem(0, iron);
    shop.setItem(1, iron);
    shop.setItem(2, ArcoImpacto);
    shop.setItem(3, Sharp4);
    shop.setItem(4, Sword);
    shop.setItem(5, Sharp5);
    shop.setItem(6, ArcoForça);
    shop.setItem(7, iron);
    shop.setItem(8, iron);
    shop.setItem(9, iron);
    shop.setItem(10, Arco);
    shop.setItem(11, poção3);
    shop.setItem(12, poção);
    shop.setItem(13, poção2);
    shop.setItem(14, poção4);
    shop.setItem(15, poção5);
    shop.setItem(16, EXP);
    shop.setItem(17, iron);
    p.openInventory(shop);
	return false;
	
  }
  @EventHandler
  public void clicarplaca(PlayerInteractEvent e)
  {
	  Player p = e.getPlayer();
	  
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
	    	      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
	    	    {
	    	      Sign s = (Sign)e.getClickedBlock().getState();
	    	      String[] lines = s.getLines();
	    	      if ((lines.length > 2) && (lines[1].equals("§7[§eExtreme§7]")) && 
	    	        (lines.length > 1) && (lines[0].equals("§6§lLOJA"))) {
	    	        p.chat("/lojaitens");
	    	      }
	    	    }
  				}
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("loja"))
    {
      e.setLine(0, "§6§lLOJA");
      e.setLine(1, "§7[§eExtreme§7]");
    }
  }
  
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void inventoryclick(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD  + " §fShop")) && 
      (e.getRawSlot() < 18) && (e.getRawSlot() > -1))
    {
      ItemStack itemclicked = e.getCurrentItem();
      ItemStack cursor = e.getCursor();
      e.setCancelled(true);
      if (cursor.getTypeId() == 0)
      {
        Player p = (Player)e.getWhoClicked();
        
        ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta Swordmeta = Sword.getItemMeta();
        Swordmeta.setDisplayName(ChatColor.GREEN + " §fEspada de Diamante §a$200");
        Sword.setItemMeta(Swordmeta);
        
        ItemStack Sharp4 = new ItemStack(Material.DIAMOND_SWORD);
        Sharp4.addEnchantment(Enchantment.DAMAGE_ALL, 4);
        ItemMeta Sharp4meta = Sharp4.getItemMeta();
        Sharp4meta.setDisplayName(ChatColor.GREEN + " §fEspada Sharpness 4 §a$6000");
        Sharp4.setItemMeta(Sharp4meta);
        
        ItemStack Sharp5 = new ItemStack(Material.DIAMOND_SWORD);
        Sharp5.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        ItemMeta Sharp5meta = Sharp5.getItemMeta();
        Sharp5meta.setDisplayName(ChatColor.GREEN + " §fEspada Sharpness 5 §a$8000");
        Sharp5.setItemMeta(Sharp5meta);
        
        ItemStack EXP = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta EXPmeta = EXP.getItemMeta();
        EXPmeta.setDisplayName(ChatColor.GREEN + " §fEXP §a$5200");
        EXP.setItemMeta(EXPmeta);
        
        ItemStack Arco = new ItemStack(Material.BOW);
        ItemMeta Arcometa = Arco.getItemMeta();
        Arcometa.setDisplayName(ChatColor.GREEN + " §fArco e Flecha §a$250");
        Arco.setItemMeta(Arcometa);
        
        ItemStack ArcoForça = new ItemStack(Material.BOW);
        ArcoForça.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        ItemMeta ArcoForçameta = ArcoForça.getItemMeta();
        ArcoForçameta.setDisplayName(ChatColor.GREEN + " §fArco Força 5 §a$7000");
        ArcoForça.setItemMeta(ArcoForçameta);
        
        ItemStack ArcoImpacto = new ItemStack(Material.BOW);
        ArcoImpacto.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        ItemMeta ArcoImpactometa = ArcoImpacto.getItemMeta();
        ArcoImpactometa.setDisplayName(ChatColor.GREEN + " §fArco Impacto 2 §a$4000");
        ArcoImpacto.setItemMeta(ArcoImpactometa);
        
        ItemStack warps = new ItemStack(Material.ARROW);
        ItemMeta Flechasmeta = warps.getItemMeta();
        Flechasmeta.setDisplayName(ChatColor.GREEN + "warps §a$150");
        warps.setItemMeta(Flechasmeta);
        
        ItemStack poção = new ItemStack(Material.POTION);
        poção.setDurability((short)8265);
        ItemMeta poçãometa = poção.getItemMeta();
        poçãometa.setDisplayName(ChatColor.GREEN + " §fPoção de Força §a$9500");
        poção.setItemMeta(poçãometa);
        
        ItemStack poção2 = new ItemStack(Material.POTION);
        poção2.setDurability((short)16457);
        ItemMeta poção2meta = poção2.getItemMeta();
        poção2meta.setDisplayName(ChatColor.GREEN + " §fDuas Poções de Força §a$9000");
        poção2.setItemMeta(poção2meta);
        
        ItemStack poção3 = new ItemStack(Material.POTION);
        poção3.setDurability((short)16428);
        ItemMeta poção3meta = poção3.getItemMeta();
        poção3meta.setDisplayName(ChatColor.GREEN + " §fPoção de Dano §a$2000");
        poção3.setItemMeta(poção3meta);
        
        ItemStack poção4 = new ItemStack(Material.POTION);
        poção4.setDurability((short)16418);
        ItemMeta poção4meta = poção4.getItemMeta();
        poção4meta.setDisplayName(ChatColor.GREEN + " §fPoção de Velocidade II §a$3000");
        poção4.setItemMeta(poção4meta);
        
        ItemStack poção5 = new ItemStack(Material.POTION);
        poção5.setDurability((short)16388);
        ItemMeta poção5meta = poção5.getItemMeta();
        poção5meta.setDisplayName(ChatColor.GREEN + " §fPoção de Veneno §a$1000");
        poção5.setItemMeta(poção5meta);
        if (itemclicked.equals(Sword))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
          
            ItemStack Diamond = new ItemStack(Material.DIAMOND_SWORD);
            p.getInventory().addItem(new ItemStack[] { Diamond });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou uma espada de diamante!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;
        }
        if (itemclicked.equals(Sword))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
          
            ItemStack Diamond = new ItemStack(Material.DIAMOND_SWORD);
            p.getInventory().addItem(new ItemStack[] { Diamond });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou uma espada de diamante!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;
        }
        if (itemclicked.equals(Sharp4))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
            ItemStack Diamond = new ItemStack(Material.DIAMOND_SWORD);
            Diamond.addEnchantment(Enchantment.DAMAGE_ALL, 4);
            p.getInventory().addItem(new ItemStack[] { Diamond });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou Força 4 para sua espada!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;

        }
        if (itemclicked.equals(Sharp5))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
          
            ItemStack Diamond = new ItemStack(Material.DIAMOND_SWORD);
            Diamond.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            p.getInventory().addItem(new ItemStack[] { Diamond });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou Força 5 para sua espada!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;

        }
        if (itemclicked.equals(EXP))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
          
            for (int i = 0; i < 64; i++)
            {
              ItemStack Diamond = new ItemStack(Material.EXP_BOTTLE);
              p.getInventory().addItem(new ItemStack[] { Diamond });
            }
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou um pack de Exp!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;

        }
        if (itemclicked.equals(Arco))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
          
            ItemStack Diamond = new ItemStack(Material.BOW);
            p.getInventory().addItem(new ItemStack[] { Diamond });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(262, 64) });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou um arco e flecha!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;

        }
        if (itemclicked.equals(poção3))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
          
            ItemStack poçãoa3 = new ItemStack(Material.POTION);
            poçãoa3.setDurability((short)16428);
            p.getInventory().addItem(new ItemStack[] { poçãoa3 });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou uma Poção de dano!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;
        }
        if (itemclicked.equals(poção4))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
            ItemStack poção4a = new ItemStack(Material.POTION);
            poção4a.setDurability((short)16418);
            p.getInventory().addItem(new ItemStack[] { poção4a });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou uma Poção de velocidade II!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;
        }
        if (itemclicked.equals(poção5))
        {
            if (Money.getMoney(p) >= 2000){
              Money.removeMoney(p, 2000);
            ItemStack poção5a = new ItemStack(Material.POTION);
            poção5a.setDurability((short)16388);
            p.getInventory().addItem(new ItemStack[] { poção5a });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou uma Poção de Veneno!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;

        }
        if (itemclicked.equals(ArcoForça))
        {
            if (Money.getMoney(p) >= 2000){
              Money.removeMoney(p, 2000);
          
            ItemStack ArcoForçaa = new ItemStack(Material.BOW);
            ArcoForçaa.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            p.getInventory().addItem(new ItemStack[] { ArcoForçaa });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou Força 5 para seu arco!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;

        }
        
        if (itemclicked.equals(ArcoImpacto))
        {
        	
            if (Money.getMoney(p) >= 2000){
              Money.removeMoney(p, 2000);
          
            ItemStack ArcoForçaaa = new ItemStack(Material.BOW);
            ArcoForçaaa.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            p.getInventory().addItem(new ItemStack[] { ArcoForçaaa });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou Impacto 2 para seu arco!");
            p.closeInventory();
            return;
          }
          MoneyErro(p);
          return;
          }

        
        if (itemclicked.equals(poção))
        {
            if (Money.getMoney(p) >= 2000){
              Money.removeMoney(p, 2000);
              ItemStack poçãoa = new ItemStack(Material.POTION);
              poçãoa.setDurability((short)8265);
              p.getInventory().addItem(new ItemStack[] { poçãoa });
              p.sendMessage(ChatColor.GREEN + " §aVocê  comprou uma poção de Força!");
              p.closeInventory();
              return;
            }
            MoneyErro(p);
            return;
        }
            
        if (itemclicked.equals(poção2))
        {
            if (Money.getMoney(p) >= 2000)
            {
              Money.removeMoney(p, 2000);
            }
            else MoneyErro(p); MoneyErro(p);
            {
          
          
            ItemStack poçãoaa = new ItemStack(Material.POTION);
            poçãoaa.setDurability((short)16457);
            p.getInventory().addItem(new ItemStack[] { poçãoaa });
            p.getInventory().addItem(new ItemStack[] { poçãoaa });
            p.sendMessage(ChatColor.GREEN + " §aVocê  comprou duas poção de Força!");
            p.closeInventory();
            return;
          }
        }
        }
      }
    }
        public void MoneyErro(Player p)
        {
          p.sendMessage("§7[§6§lXP§7] §c XP Insuficiente");
          p.closeInventory();
        }
        
        {   
}
}


