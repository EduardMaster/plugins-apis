package Comandos;

import Main.Main;
import Utils.KitAPI;
import me.confuser.barapi.BarAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Kit
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cPrecisa ser um Player para usar esse comando");
      return true;
    }
    Player p = (Player)sender;
    if (args.length == 0)
    {
      p.sendMessage("§cUse /kit <kit> ou /kits");
      return true;
    }
    if (args[0].equalsIgnoreCase("pvp"))
    {
      if (p.hasPermission("kit.pvp"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.PvP(p);
          p.sendMessage("§7Voce pegou o kit: §bPvP");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lPvP", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("kangaroo"))
    {
      if (p.hasPermission("kit.kangaroo"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Kangaroo(p);
          p.sendMessage("§7Voce pegou o kit: §bKangaroo");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lKangaroo", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("viper"))
    {
      if (p.hasPermission("kit.viper"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Viper(p);
          p.sendMessage("§7Voce pegou o kit: §bViper");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lViper", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Snail"))
    {
      if (p.hasPermission("kit.snail"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Snail(p);
          p.sendMessage("§7Voce pegou o kit: §bSnail");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lSnail", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Reaper"))
    {
      if (p.hasPermission("kit.reaper"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Reaper(p);
          p.sendMessage("§7Voce pegou o kit: §bReaper");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lReaper", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Fisherman"))
    {
      if (p.hasPermission("kit.fisherman"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Fisherman(p);
          p.sendMessage("§7Voce pegou o kit: §bFisherman");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lFisherman", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Stomper"))
    {
      if ((Main.getInstace().loja.getString(p.getUniqueId() + ".Stomper").equals("true")) || (p.hasPermission("kit.stomper")))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Stomper(p);
          p.sendMessage("§7Voce pegou o kit: §bStomper");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lStomper", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Viking"))
    {
      if (p.hasPermission("kit.viking"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Vinking(p);
          p.sendMessage("§7Voce pegou o kit: §bViking");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lViking", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Ninja"))
    {
      if ((Main.getInstace().loja.getString(p.getUniqueId() + ".Ninja").equals("true")) || (p.hasPermission("kit.ninja")))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Ninja(p);
          p.sendMessage("§7Voce pegou o kit: §bNinja");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lNinja", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Boxer"))
    {
      if (p.hasPermission("kit.Boxer"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Boxer(p);
          p.sendMessage("§7Voce pegou o kit: §bBoxer");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lBoxer", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Deshfire"))
    {
      if (p.hasPermission("kit.Deshfire"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Deshfire(p);
          p.sendMessage("§7Voce pegou o kit: §bDeshfire");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lDeshfire", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Deshviper"))
    {
      if (p.hasPermission("kit.Deshviper"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Deshviper(p);
          p.sendMessage("§7Voce pegou o kit: §bDeshviper");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lDeshviper", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Forcefield"))
    {
      if (p.hasPermission("kit.Forcefield"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Forcefield(p);
          p.sendMessage("§7Voce pegou o kit: §bForcefield");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lForcefield", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Hulk"))
    {
      if (p.hasPermission("kit.Hulk"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Hulk(p);
          p.sendMessage("§7Voce pegou o kit: §bHulk");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lHulk", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Madman"))
    {
      if (p.hasPermission("kit.Madman"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Madman(p);
          p.sendMessage("§7Voce pegou o kit: §bMadman");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lMadman", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Ryu"))
    {
      if (p.hasPermission("kit.Ryu"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Ryu(p);
          p.sendMessage("§7Voce pegou o kit: §bRyu");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lRyu", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Seya"))
    {
      if (p.hasPermission("kit.Seya"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Seya(p);
          p.sendMessage("§7Voce pegou o kit: §bSeya");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lSeya", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Sonic"))
    {
      if (p.hasPermission("kit.Sonic"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Sonic(p);
          p.sendMessage("§7Voce pegou o kit: §bSonic");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lSonic", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Specialist"))
    {
      if (p.hasPermission("kit.Specialist"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.specialist(p);
          p.sendMessage("§7Voce pegou o kit: §bSpecialist");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lSpecialist", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Titan"))
    {
      if (p.hasPermission("kit.Titan"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Titan(p);
          p.sendMessage("§7Voce pegou o kit: §bTitan");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lTitan", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Turtle"))
    {
      if (p.hasPermission("kit.Turtle"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Turtle(p);
          p.sendMessage("§7Voce pegou o kit: §bTurtle");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lTurtle", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Urgal"))
    {
      if ((Main.getInstace().loja.getString(p.getUniqueId() + ".Urgal").equals("true")) || (p.hasPermission("kit.Urgal")))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Urgal(p);
          p.sendMessage("§7Voce pegou o kit: §bUrgal");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lUrgal", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Thor"))
    {
      if (p.hasPermission("kit.Thor"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Thor(p);
          p.sendMessage("§7Voce pegou o kit: §bThor");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lThor", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("TimeLord"))
    {
      if (p.hasPermission("kit.TimeLord"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.TimeLord(p);
          p.sendMessage("§7Voce pegou o kit: §bTimeLord");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lTimeLord", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("QuickDropper"))
    {
      if (p.hasPermission("kit.QuickDropper"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.quickdropper(p);
          p.sendMessage("§7Voce pegou o kit: §bQuickDropper");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lQuickDropper", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Poseidon"))
    {
      if ((Main.getInstace().loja.getString(p.getUniqueId() + ".Poseidon").equals("true")) || (p.hasPermission("kit.Poseidon")))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Poseidon(p);
          p.sendMessage("§7Voce pegou o kit: §bPoseidon");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lPoseidon", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Phantom"))
    {
      if ((Main.getInstace().loja.getString(p.getUniqueId() + ".Phantom").equals("true")) || (p.hasPermission("kit.Phantom")))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Phantom(p);
          p.sendMessage("§7Voce pegou o kit: §bPhantom");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lPhantom", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Camel"))
    {
      if (p.hasPermission("kit.Camel"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Camel(p);
          p.sendMessage("§7Voce pegou o kit: §bCamel");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lCamel", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("BurstMaster"))
    {
      if (p.hasPermission("kit.BurstMaster"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.BurstMaster(p);
          p.sendMessage("§7Voce pegou o kit: §bBurstMaster");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lBurstMaster", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    if (args[0].equalsIgnoreCase("Gladiator"))
    {
      if (p.hasPermission("kit.Gladiator"))
      {
        if (KitAPI.getKit(p) == "Nenhum")
        {
          KitAPI.Gladiator(p);
          p.sendMessage("§7Voce pegou o kit: §bGladiator");
          BarAPI.setMessage(p, "§7§lVoce pegou o kit: §b§lGladiator", 5);
          return true;
        }
        p.sendMessage("§cVoce ja esta usando um Kit");
        return true;
      }
      p.sendMessage("§cVoce nao tem permissao!");
      return true;
    }
    p.sendMessage("§cEsse kit §b" + args[0] + " §cnao existe");
    BarAPI.setMessage(p, "§7§lO Kit §b§l" + args[0] + " §7§lnao existe", 3);
    
    return false;
  }
}
