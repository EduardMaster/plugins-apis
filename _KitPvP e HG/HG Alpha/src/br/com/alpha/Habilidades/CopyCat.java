package br.com.alpha.Habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import br.com.alpha.APIs.LoadKits;
import br.com.alpha.ENUMs.KitsEnum;


public class CopyCat implements Listener {
	@EventHandler
	public void onCopyCat(PlayerDeathEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player))) {
			Player p = e.getEntity();
			Player p2 = e.getEntity().getKiller();
			if (KitsEnum.getKit(p2) == KitsEnum.COPYCAT) {
				KitsEnum NovoKit = KitsEnum.getKit(p);
				KitsEnum.setKit(p2, NovoKit);
				LoadKits.loadKits(p2);
				p2.sendMessage("§aSeu novo kit agora será §a" + NovoKit);
			}
		}
	}
}
