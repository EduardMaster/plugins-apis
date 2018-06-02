package me.recenthg.Manager;

import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.recenthg.Main;
import me.recenthg.Dinheiro.DinheiroM;
import me.recenthg.Eventss.CombatLog;

public class MensagenDeMorrer
  implements Listener
{
  public static String NomeDosItens(ItemStack i)
  {
    String nome = null;
    if (i.getType() == Material.AIR)
      nome = "Soco";
    else if (i.getType() == Material.WOOD_SWORD)
      nome = "Espada de Madeira";
    else if (i.getType() == Material.STONE_SWORD)
      nome = "Espada de Pedra";
    else if (i.getType() == Material.IRON_SWORD)
      nome = "Espada de Ferro";
    else if (i.getType() == Material.DIAMOND_SWORD)
      nome = "Espada de Diamante";
    else if (i.getType() == Material.GOLD_SWORD)
      nome = "Espada de Ouro";
    else if (i.getType() == Material.WOOD_AXE)
      nome = "Machado de Madeira";
    else if (i.getType() == Material.STONE_AXE)
      nome = "Machado de Pedra";
    else if (i.getType() == Material.IRON_AXE)
      nome = "Machado de Ferro";
    else if (i.getType() == Material.DIAMOND_AXE)
      nome = "Machado de Diamante";
    else if (i.getType() == Material.GOLD_AXE)
      nome = "Machado de Ouro";
    else if (i.getType() == Material.WOOD_SPADE)
      nome = "Pa de Madeira";
    else if (i.getType() == Material.STONE_SPADE)
      nome = "Pa de Pedra";
    else if (i.getType() == Material.IRON_SPADE)
      nome = "Pa de Ferro";
    else if (i.getType() == Material.DIAMOND_SPADE)
      nome = "Pa de Diamante";
    else if (i.getType() == Material.GOLD_SPADE)
      nome = "Pa de Ouro";
    else if (i.getType() == Material.WOOD_PICKAXE)
      nome = "Picareta de Madeira";
    else if (i.getType() == Material.STONE_PICKAXE)
      nome = "Picareta de Pedra";
    else if (i.getType() == Material.IRON_PICKAXE)
      nome = "Picareta de Ferro";
    else if (i.getType() == Material.DIAMOND_PICKAXE)
      nome = "Picareta de Diamante";
    else if (i.getType() == Material.GOLD_PICKAXE)
      nome = "Picareta de Ouro";
    else if (i.getType() == Material.STICK)
      nome = "Graveto";
    else if (i.getType() == Material.MAP)
      nome = "Mapa";
    else if (i.getType() == Material.MUSHROOM_SOUP)
      nome = "Sopa";
    else if (i.getType() == Material.RED_MUSHROOM)
      nome = "Cogumelo";
    else if (i.getType() == Material.BROWN_MUSHROOM)
      nome = "Cogumelo";
    else if (i.getType() == Material.BOWL)
      nome = "Tigela";
    else if (i.getType() == Material.COMPASS)
      nome = "Bussola";
    else {
      nome = i.getType().toString();
    }
    return nome;
  }

  @EventHandler
  public void onDeath(PlayerDeathEvent event) {
    for (ItemStack drops : event.getDrops()) {
      Material m = drops.getType();
      if ((m.equals(Material.LEATHER)) || (m.equals(Material.FLINT)) || (m.equals(Material.WATCH)) || (m.equals(Material.BLAZE_ROD)) || 
        (m.equals(Material.STONE_PICKAXE)) || (m.equals(Material.WOOD_AXE)) || (m.equals(Material.FIREWORK)) || 
        (m.equals(Material.LEASH)) || (m.equals(Material.IRON_FENCE)) || (m.equals(Material.SNOW_BALL)) || 
        (m.equals(Material.SLIME_BALL)) || (m.equals(Material.STONE_AXE)) || (m.equals(Material.WOOD_HOE)) || (m.equals(Material.STICK)) || (m.equals(Material.FISHING_ROD)) || (m.equals(Material.ENDER_PEARL)) || 
        (m.equals(Material.CLAY_BALL)) || (m.equals(Material.PORTAL)) || (m.equals(Material.LEATHER_BOOTS)) || (m.equals(Material.NETHER_STAR)) || (m.equals(Material.STONE_PLATE)) || 
        (m.equals(Material.GRAVEL))) {
        drops.setAmount(1);
        drops.setType(Material.AIR);
      }
    }
  }

  @EventHandler
  public void DeathMSGMonster(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    EntityDamageEvent damageEvent = p.getLastDamageCause();
    if (!(damageEvent instanceof EntityDamageByEntityEvent)) {
      return;
    }
    Entity damager = ((EntityDamageByEntityEvent)damageEvent).getDamager();
    if ((damager instanceof Monster))
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um monstro!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um monstro!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
    DinheiroM.TirarDinheiro(p, 10);
    p.sendMessage("§cVoce perdeu §610§c TCoins");
    DinheiroM.TirarElo(p, 5);
    p.sendMessage("§cElo -5");
    if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
  	  p.damage(99999.0D);
  	  CombatLog.MorreuCombat.remove(p.getName());
  	  Manager.addMatou(p.getKiller());
  	  DinheiroM.darDinheiro(p.getKiller(), 20);
  	  Manager.addMorreu(p);
        DinheiroM.darElo(p.getKiller(), 10);
        p.getKiller().sendMessage("§aElo +10");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        DinheiroM.TirarDinheiro(p, 10);
  	  p.sendMessage("§cVoce perdeu §610§c TCoins");
  	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
    }
  }

  @EventHandler
  public void DeathMSGAnimals(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    EntityDamageEvent damageEvent = p.getLastDamageCause();
    if (!(damageEvent instanceof EntityDamageByEntityEvent)) {
      return;
    }
    Entity damager = ((EntityDamageByEntityEvent)damageEvent).getDamager();
    if ((damager instanceof Animals))
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um animal!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um animal!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
    DinheiroM.TirarDinheiro(p, 10);
    p.sendMessage("§cVoce perdeu §610§c TCoins");
    DinheiroM.TirarElo(p, 5);
    p.sendMessage("§cElo -5");
    if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
  	  p.damage(99999.0D);
  	  CombatLog.MorreuCombat.remove(p.getName());
  	  Manager.addMatou(p.getKiller());
  	  DinheiroM.darDinheiro(p.getKiller(), 20);
  	  Manager.addMorreu(p);
        DinheiroM.darElo(p.getKiller(), 10);
        p.getKiller().sendMessage("§aElo +10");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        DinheiroM.TirarDinheiro(p, 10);
  	  p.sendMessage("§cVoce perdeu §610§c TCoins");
  	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
    }
  }

  @EventHandler
  public void DeathMSG(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (((e.getEntity() instanceof Player)) && ((p.getKiller() instanceof Player)) && (e.getDeathMessage().contains("was slain by")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7foi morto por " + p.getKiller().getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p.getKiller())) + " §7]" + " Usando §c" + NomeDosItens(p.getKiller().getItemInHand()) + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
    	  p.damage(99999.0D);
    	  CombatLog.MorreuCombat.remove(p.getName());
    	  Manager.addMatou(p.getKiller());
    	  DinheiroM.darDinheiro(p.getKiller(), 20);
    	  Manager.addMorreu(p);
          DinheiroM.darElo(p.getKiller(), 10);
          p.getKiller().sendMessage("§aElo +10");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          DinheiroM.TirarDinheiro(p, 10);
    	  p.sendMessage("§cVoce perdeu §610§c TCoins");
    	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
    	  if (p.getKiller().hasPermission("Torm.Boosters2")) {
    		  DinheiroM.darDinheiro(p.getKiller(), 40);
    		  p.getKiller().sendMessage("§aVoce ganhou §640§a TCoins");
    	  }
    	  if (p.getKiller().hasPermission("Torm.Boosters3")) {
    		  DinheiroM.darDinheiro(p.getKiller(), 60);
    		  p.getKiller().sendMessage("§aVoce ganhou §660§a TCoins");
    	  }
    	  if (p.getKiller().hasPermission("Torm.Boosters4")) {
    		  DinheiroM.darDinheiro(p.getKiller(), 80);
    		  p.getKiller().sendMessage("§aVoce ganhou §680§a TCoins");
    	  }
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  Listeners.getKs(p.getKiller());
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        	  if (p.getKiller().hasPermission("Torm.Boosters2")) {
        		  DinheiroM.darDinheiro(p.getKiller(), 40);
        		  p.getKiller().sendMessage("§aVoce ganhou §640§a TCoins");
        	  }
        	  if (p.getKiller().hasPermission("Torm.Boosters3")) {
        		  DinheiroM.darDinheiro(p.getKiller(), 60);
        		  p.getKiller().sendMessage("§aVoce ganhou §660§a TCoins");
        	  }
        	  if (p.getKiller().hasPermission("Torm.Boosters4")) {
        		  DinheiroM.darDinheiro(p.getKiller(), 80);
        		  p.getKiller().sendMessage("§aVoce ganhou §680§a TCoins");
        	  }
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7foi morto por " + p.getKiller().getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p.getKiller())) + "§7]" + " Usando §c" + NomeDosItens(p.getKiller().getItemInHand()) + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
  	  p.damage(99999.0D);
  	  CombatLog.MorreuCombat.remove(p.getName());
  	  Manager.addMatou(p.getKiller());
  	  DinheiroM.darDinheiro(p.getKiller(), 20);
  	  Manager.addMorreu(p);
        DinheiroM.darElo(p.getKiller(), 10);
        p.getKiller().sendMessage("§aElo +10");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        DinheiroM.TirarDinheiro(p, 10);
  	  p.sendMessage("§cVoce perdeu §610§c TCoins");
  	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
  	  if (p.getKiller().hasPermission("Torm.Boosters2")) {
  		  DinheiroM.darDinheiro(p.getKiller(), 40);
  		  p.getKiller().sendMessage("§aVoce ganhou §640§a TCoins");
  	  }
  	  if (p.getKiller().hasPermission("Torm.Boosters3")) {
  		  DinheiroM.darDinheiro(p.getKiller(), 60);
  		  p.getKiller().sendMessage("§aVoce ganhou §660§a TCoins");
  	  }
  	  if (p.getKiller().hasPermission("Torm.Boosters4")) {
  		  DinheiroM.darDinheiro(p.getKiller(), 80);
  		  p.getKiller().sendMessage("§aVoce ganhou §680§a TCoins");
  	  }
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  Listeners.getKs(p.getKiller());
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
      	  if (p.getKiller().hasPermission("Torm.Boosters2")) {
      		  DinheiroM.darDinheiro(p.getKiller(), 40);
      		  p.getKiller().sendMessage("§aVoce ganhou §640§a TCoins");
      	  }
      	  if (p.getKiller().hasPermission("Torm.Boosters3")) {
      		  DinheiroM.darDinheiro(p.getKiller(), 60);
      		  p.getKiller().sendMessage("§aVoce ganhou §660§a TCoins");
      	  }
      	  if (p.getKiller().hasPermission("Torm.Boosters4")) {
      		  DinheiroM.darDinheiro(p.getKiller(), 80);
      		  p.getKiller().sendMessage("§aVoce ganhou §680§a TCoins");
      	  }
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("went up in flames")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("dragon")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um dragao!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um dragao!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("ladder")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (e.getDeathMessage().contains("walked into a cactus"))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu Para um cacto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um cacto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (e.getDeathMessage().contains("walked into fire"))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Tentou correr mais morreu!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Tentou correr mais morreu!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (e.getDeathMessage().contains("Magma Cube"))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um magma cube!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um magma cube!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (e.getDeathMessage().contains("was struck by lightning"))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um raio!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um raio!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("went up in flames")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("walked into a fire whilst fighting")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was burnt to a crisp whilst fighting")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("burned to death")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Queimou ate a morte!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Queimou ate a morte!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was burnt to a crisp whilst fighting")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado enquanto lutava!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado enquanto lutava!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
        
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("walked into a fire whilst fighting")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado enquanto lutava!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu queimado enquanto lutava!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("tried to swim in lava")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu preso na lava!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu preso na lava!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("suffocated in a wall")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu sufocado no bloco!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu sufocado no bloco!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("drowned")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu afogado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu afogado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("drowned")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu afogado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu afogado!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("starved to death")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu de fome!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu de fome!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was pricked to death")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um cacto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um cacto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("walked into a cactus while trying to escape")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um cacto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um cacto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("fell from a high place")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Caio de um lugar muito alto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Caio de um lugar muito alto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("hit the ground too hard")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Caio de um lugar muito alto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Caio de um lugar muito alto!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("fell out of the world")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para o void!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para o void!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("died")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("blew up")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma explosao!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma explosao!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was blown up by")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma explosao!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma explosao!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("magic")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para magia!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para magia!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("withered away")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um whiter!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para um whiter!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was shot by")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma flecha!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma flecha!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was fireballed by")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma bola de fogo!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else {
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma bola de fogo!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
        DinheiroM.TirarDinheiro(p, 10);
        p.sendMessage("§cVoce perdeu §610§c TCoins");
        DinheiroM.TirarElo(p, 5);
        p.sendMessage("§cElo -5");
        if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
      	  p.damage(99999.0D);
      	  CombatLog.MorreuCombat.remove(p.getName());
      	  Manager.addMatou(p.getKiller());
      	  DinheiroM.darDinheiro(p.getKiller(), 20);
      	  Manager.addMorreu(p);
            DinheiroM.darElo(p.getKiller(), 10);
            p.getKiller().sendMessage("§aElo +10");
            DinheiroM.TirarElo(p, 5);
            p.sendMessage("§cElo -5");
            DinheiroM.TirarDinheiro(p, 10);
      	  p.sendMessage("§cVoce perdeu §610§c TCoins");
      	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
        }
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was pummeled by")))
    {
      if (p.hasPermission("Torm.Respawn"))
      {
        if (Main.TimerAndamento <= 300)
          e.setDeathMessage(null);
        else if (Main.TimerAndamento >= 300) {
          e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma EnderPearl!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
          DinheiroM.TirarDinheiro(p, 10);
          p.sendMessage("§cVoce perdeu §610§c TCoins");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
        	  p.damage(99999.0D);
        	  CombatLog.MorreuCombat.remove(p.getName());
        	  Manager.addMatou(p.getKiller());
        	  DinheiroM.darDinheiro(p.getKiller(), 20);
        	  Manager.addMorreu(p);
              DinheiroM.darElo(p.getKiller(), 10);
              p.getKiller().sendMessage("§aElo +10");
              DinheiroM.TirarElo(p, 5);
              p.sendMessage("§cElo -5");
              DinheiroM.TirarDinheiro(p, 10);
        	  p.sendMessage("§cVoce perdeu §610§c TCoins");
        	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
          }
        }
      }
      else
        e.setDeathMessage("§7" + p.getName() + " §7[§c" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) +"§7]" + " §7Morreu para uma EnderPearl!" + "\n" + "§c" + Main.Jogadores.size() + " §7Jogadores restantes" + "\n" + "§e" + p.getName() + " Saiu do servidor!");
      Manager.addMorreu(p);
      DinheiroM.TirarDinheiro(p, 10);
      p.sendMessage("§cVoce perdeu §610§c TCoins");
      DinheiroM.TirarElo(p, 5);
      p.sendMessage("§cElo -5");
      if (CombatLog.MorreuCombat.contains(p.getKiller().getName()) || CombatLog.MorreuCombat.contains(p.getName())) {
    	  p.damage(99999.0D);
    	  CombatLog.MorreuCombat.remove(p.getName());
    	  Manager.addMatou(p.getKiller());
    	  DinheiroM.darDinheiro(p.getKiller(), 20);
    	  Manager.addMorreu(p);
          DinheiroM.darElo(p.getKiller(), 10);
          p.getKiller().sendMessage("§aElo +10");
          DinheiroM.TirarElo(p, 5);
          p.sendMessage("§cElo -5");
          DinheiroM.TirarDinheiro(p, 10);
    	  p.sendMessage("§cVoce perdeu §610§c TCoins");
    	  p.getKiller().sendMessage("§aVoce ganhou §620§a TCoins");
      }
    }
  }
}