package Net.Hunger.Habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Eventos.LoadKits;
import Net.Hunger.Manager.Habilidade;

public class CopyCat implements Listener {
	
   @EventHandler
    public void onCopyCat(PlayerDeathEvent e) {
	 if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player))) {
	   Player p = e.getEntity();
	    Player p2 = e.getEntity().getKiller();
	    if (CMDKit.CopyCat.contains(p2.getName())) {
		    String NovoKit = Habilidade.getAbility(p);
	        Habilidade.setAbility(p2, NovoKit);
	        LoadKits.CheckKits(p2);
	        p2.sendMessage("§7[§a!§7] Seu novo kit e §a" + NovoKit.toUpperCase());
	    }
		}
	   }
}
