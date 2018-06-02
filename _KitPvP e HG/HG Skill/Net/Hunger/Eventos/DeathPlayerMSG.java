package Net.Hunger.Eventos;

import org.bukkit.ChatColor;
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

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class DeathPlayerMSG implements Listener {
	
  public static String NomeDosItens(ItemStack i)
  {
    String nome = null;
    if (i.getType() == Material.AIR) {
      nome = "Soco";
    } else if (i.getType() == Material.WOOD_SWORD) {
      nome = "Espada de Madeira";
    } else if (i.getType() == Material.STONE_SWORD) {
      nome = "Espada de Pedra";
    } else if (i.getType() == Material.IRON_SWORD) {
      nome = "Espada de Ferro";
    } else if (i.getType() == Material.DIAMOND_SWORD) {
      nome = "Espada de Diamante";
    } else if (i.getType() == Material.GOLD_SWORD) {
      nome = "Espada de Ouro";
    } else if (i.getType() == Material.WOOD_AXE) {
      nome = "Machado de Madeira";
    } else if (i.getType() == Material.STONE_AXE) {
      nome = "Machado de Pedra";
    } else if (i.getType() == Material.IRON_AXE) {
      nome = "Machado de Ferro";
    } else if (i.getType() == Material.DIAMOND_AXE) {
      nome = "Machado de Diamante";
    } else if (i.getType() == Material.GOLD_AXE) {
      nome = "Machado de Ouro";
    } else if (i.getType() == Material.WOOD_SPADE) {
      nome = "Pa de Madeira";
    } else if (i.getType() == Material.STONE_SPADE) {
      nome = "Pa de Pedra";
    } else if (i.getType() == Material.IRON_SPADE) {
      nome = "Pa de Ferro";
    } else if (i.getType() == Material.DIAMOND_SPADE) {
      nome = "Pa de Diamante";
    } else if (i.getType() == Material.GOLD_SPADE) {
      nome = "Pa de Ouro";
    } else if (i.getType() == Material.WOOD_PICKAXE) {
      nome = "Picareta de Madeira";
    } else if (i.getType() == Material.STONE_PICKAXE) {
      nome = "Picareta de Pedra";
    } else if (i.getType() == Material.IRON_PICKAXE) {
      nome = "Picareta de Ferro";
    } else if (i.getType() == Material.DIAMOND_PICKAXE) {
      nome = "Picareta de Diamante";
    } else if (i.getType() == Material.GOLD_PICKAXE) {
      nome = "Picareta de Ouro";
    } else if (i.getType() == Material.STICK) {
      nome = "Graveto";
    } else if (i.getType() == Material.MAP) {
      nome = "Mapa";
    } else if (i.getType() == Material.MUSHROOM_SOUP) {
      nome = "Sopa";
    } else if (i.getType() == Material.RED_MUSHROOM) {
      nome = "Cogumelo";
    } else if (i.getType() == Material.BROWN_MUSHROOM) {
      nome = "Cogumelo";
    } else if (i.getType() == Material.BOWL) {
      nome = "Tigela";
    } else if (i.getType() == Material.COMPASS) {
      nome = "Bussola";
    } else {
      nome = i.getType().toString();
    }
    return nome;
  }
  	
  @EventHandler
  public void onDeath(PlayerDeathEvent event) {
  for (ItemStack drops : event.getDrops()) {
  Material m = drops.getType();
  if ((m.equals(Material.LEATHER)) || (m.equals(Material.FLINT)) || (m.equals(Material.WATCH)) || (m.equals(Material.BLAZE_ROD)) 
  || (m.equals(Material.STONE_PICKAXE)) || (m.equals(Material.WOOD_AXE)) || (m.equals(Material.FIREWORK)) || 
  (m.equals(Material.LEASH)) || (m.equals(Material.IRON_FENCE)) || (m.equals(Material.SNOW_BALL)) ||
  (m.equals(Material.SLIME_BALL)) || (m.equals(Material.STONE_AXE)) || (m.equals(Material.WOOD_HOE)) || (m.equals(Material.STICK)) || (m.equals(Material.FISHING_ROD)) || (m.equals(Material.ENDER_PEARL)) ||
  (m.equals(Material.CLAY_BALL)) || (m.equals(Material.PORTAL)) || (m.equals(Material.LEATHER_BOOTS)) || (m.equals(Material.NETHER_STAR) || (m.equals(Material.STONE_PLATE) ||
  (m.equals(Material.GRAVEL))))) {
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
    if ((damager instanceof Monster)) {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por um monstro!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por um monstro!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
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
    if ((damager instanceof Animals)) {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por um animal" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por um animal" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
  }
  
  @EventHandler
  public void DeathMSG(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (((e.getEntity() instanceof Player) && (p.getKiller() instanceof Player)) && (e.getDeathMessage().contains("was slain by")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " foi morto por " + ChatColor.GRAY + p.getKiller().getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(
            Habilidade.getAbility(p.getKiller())) + ")" + ChatColor.GRAY + " com " + NomeDosItens(p.getKiller().getItemInHand()) + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " foi morto por " + ChatColor.GRAY + p.getKiller().getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(
          Habilidade.getAbility(p.getKiller())) + ")" + ChatColor.GRAY + " com " + NomeDosItens(p.getKiller().getItemInHand()) + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("went up in flames")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("dragon")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por um dragão O_O!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por um dragão O_O!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("ladder")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (e.getDeathMessage().contains("walked into a cactus"))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (e.getDeathMessage().contains("walked into fire"))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Tentou correr mas morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Tentou correr mas morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (e.getDeathMessage().contains("Magma Cube"))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por uma magma cube!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por uma magma cube!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (e.getDeathMessage().contains("was struck by lightning"))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por um raio dos ceus!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por um raio dos ceus!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("went up in flames")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("walked into a fire whilst fighting")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was burnt to a crisp whilst fighting")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu queimado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("burned to death")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Queimou ate a morte!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Queimou ate a morte!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was burnt to a crisp whilst fighting")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu queimado enquanto lutava!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu queimado enquanto lutava!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("walked into a fire whilst fighting")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu queimado enquanto lutava!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu queimado enquanto lutava!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("tried to swim in lava")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu preso na lava!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu preso na lava!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("suffocated in a wall")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu sufocado por blocos!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu sufocado por blocos!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("drowned")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu afogado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu afogado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("drowned")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu afogado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }		
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu afogado!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("starved to death")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Estava na africa e morreu de fome!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Estava na africa e morreu de fome!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was pricked to death")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por um cacto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por um cacto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("walked into a cactus while trying to escape")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por um cacto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por um cacto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("fell from a high place")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Caiu de um lugar muito alto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Caiu de um lugar muito alto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("hit the ground too hard")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Caiu de um lugar muito alto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Caiu de um lugar muito alto!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("fell out of the world")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Caiu no buraco negro do void!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Caiu no buraco negro do void!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("died")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("blew up")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Acho que era tank mas morreu em uma explosao!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Acho que era tank mas morreu em uma explosao!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was blown up by")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Acho que era tank mas morreu em uma explosao!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Acho que era tank mas morreu em uma explosao!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("magic")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Estava brincando com uma bruxa!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Estava brincando com uma bruxa!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("withered away")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por 1 wither!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por 1 wither!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was shot by")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Foi acertado por uma flecha!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Foi acertado por uma flecha!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was fireballed by")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por uma bola de fogo!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por uma bola de fogo!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
    else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was pummeled by")))
    {
      if (p.hasPermission("HungerGames.Respawn"))
      {
        if (Main.Andamento <= 300) {
          e.setDeathMessage(null);
        } else if (Main.Andamento >= 300) {
          e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
            ")" + ChatColor.GRAY + " Morreu por uma EnderPearl!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
        }
      }
      else {
        e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.GREEN + "(" + Habilidade.NomeDoKit(Habilidade.getAbility(p)) + 
          ")" + ChatColor.GRAY + " Morreu por uma EnderPearl!" + "\n" + ChatColor.GREEN + Main.Jogadores.size() + ChatColor.GRAY + " Jogadores restantes" + "\n" + ChatColor.RED + p.getName() + " Saiu do servidor.");
      }
    }
  }
}