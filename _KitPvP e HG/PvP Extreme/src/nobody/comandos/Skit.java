package nobody.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Skit
  implements Listener, CommandExecutor
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public HashMap<String, ItemStack[]> itens = new HashMap();
  @SuppressWarnings({ "unchecked", "rawtypes" })
public HashMap<String, ItemStack[]> armor = new HashMap();
  
  public boolean isInt(String s)
  {
    try
    {
      Integer.parseInt(s);
      return true;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return false;
  }
  
  public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args)
  {
    Player p = (Player)Sender;
    if ((Label.equalsIgnoreCase("skit")) && 
      ((Sender instanceof Player)))
    {
      if (!p.hasPermission("tk.skit"))
      {
        p.sendMessage("§cSem Perms");
        return true;
      }
      if (Args.length == 0)
      {
        p.sendMessage("§a§m--------------------------------------------");
        p.sendMessage("");
        p.sendMessage("                §e§lExtreme§f§lKits");
        p.sendMessage("        §bComo criar um Kit para Eventos");
        p.sendMessage("");
        p.sendMessage("   §a1- Coloque os Items no seu Inventario que ira estar no Kit");
        p.sendMessage("   §a2- Digite o Comando: /Skit Criar [Kit]");
        p.sendMessage("   §a3- Enfim de o Comando: /Skit Aplicar [Kit] [Blocos]");
        p.sendMessage("   §aFim, Bom Jogo!");
        p.sendMessage("");
        p.sendMessage("§a§m--------------------------------------------");
        return true;
      }
      if (Args[0].equalsIgnoreCase("criar"))
      {
        if (Args.length == 1)
        {
          p.sendMessage("§cUse /Skit para ver o Tutorial!");
          return true;
        }
        String nome = Args[1];
        this.itens.put(nome, p.getInventory().getContents());
        this.armor.put(nome, p.getInventory().getArmorContents());
        p.sendMessage("§aVoc§ criou o Kit: §a" + Args[1]);
        return true;
      }
      if (Args[0].equalsIgnoreCase("aplicar"))
      {
        if (Args.length <= 2)
        {
          p.sendMessage("§cUse /Skit para ver o Tutorial!");
          return true;
        }
        String nome = Args[1];
        if ((!this.itens.containsKey(nome)) && (!this.armor.containsKey(nome)))
        {
          p.sendMessage("§aO Kit §c" + nome + " §aainda n§o foi Criado!");
          return true;
        }
        if (isInt(Args[2]))
        {
          int n = Integer.parseInt(Args[2]);
          for (Entity e : p.getNearbyEntities(n, n, n)) {
            if ((e instanceof Player))
            {
              Player p2 = (Player)e;
              p2.getInventory().setArmorContents((ItemStack[])this.armor.get(nome));
              p2.getInventory().setContents((ItemStack[])this.itens.get(nome));
            }
          }
          Bukkit.getServer().broadcastMessage("");
          Bukkit.getServer().broadcastMessage("   §eExtreme§bKits §8> O Kit §a" + nome + " §afoi Aplicado para Players em um Raio de §a" + n + " §eBlocos");
          Bukkit.getServer().broadcastMessage("");
          p.sendMessage("§aVoce aplicou o Kit §e" + nome + " §aPara Players em um Raio de §a" + n + " §eBlocos");
          return true;
        }
      }
    }
    return false;
  }
}
