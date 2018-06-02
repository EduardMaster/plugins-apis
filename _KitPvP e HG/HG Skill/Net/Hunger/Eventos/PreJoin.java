package Net.Hunger.Eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDAdmin;
import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;
import Net.Hunger.Timer.Iniciando;

public class PreJoin implements Listener {

    public ArrayList<String> antilog = new ArrayList<String>();
    public ArrayList<String> NoLog = new ArrayList<String>();
    
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onQuitInv(PlayerQuitEvent e) {
    final Player p = e.getPlayer();
	 final String KitName = Habilidade.NomeDoKit(Habilidade.getAbility(p));
    e.setQuitMessage(null);
    if(Main.PreGame) {
    return;
    } else {
    Main.saiu.add(p.getName());
    if ((Main.saiu.contains(p.getName()))) {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    public void run() {
    if (p.isOnline()) {
    return;
    } else {
    Main.Jogadores.remove(p.getName());
    Main.saiu.remove(p.getName());
    ChecarVitoria.verificaWin();
    NoLog.add(p.getName());
    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
    public void run() {
    if(!Main.mortos.contains(p.getName()) && (!CMDAdmin.admin.contains(p.getName()) && (!Main.Watch.contains(p.getName())))) {
    Bukkit.broadcastMessage("§7[§a?§7] " + p.getName() + "§a(" + KitName + "§a) §7Demorou demais para relogar!");
    } else {
    return;
    }
    }
    },5L);
    }
    }
    },650L);
    }
    }
    }
    
    @EventHandler
    public void onAdm(PlayerJoinEvent e) {
    Player p = e.getPlayer();
    if((Main.PreGame) && (p.hasPermission("HungerGames.c.admin"))) {
    Bukkit.dispatchCommand(p, "admin");
    }
    if((Main.PreInvencibilidade) && (!Main.Jogadores.contains(p.getName()) && ((p.hasPermission("HungerGames.c.admin"))))) {
    Bukkit.dispatchCommand(p, "admin");
    }
    if((Main.Partida) && (!Main.Jogadores.contains(p.getName()) && ((p.hasPermission("HungerGames.c.admin"))))) {
    Bukkit.dispatchCommand(p, "admin");
    }
    }
    
    @EventHandler
    public void onCheck(PlayerLoginEvent e) {
    Player p = e.getPlayer();
    if(Main.PreGame) {
    if(Bukkit.getServer().getOnlinePlayers().length <= Bukkit.getMaxPlayers()) {
    e.allow();	
    } else if (p.hasPermission("Tag.Vip")) {
    e.allow();
    } else {
    e.setKickMessage("§a§lDesculpe servidor lotado!" + "\n" + "        §7Visite §a" + Main.site);
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
    }
    } else {
    if(Main.Jogadores.contains(p.getName())) {
    e.allow();
    } else {
    if(p.hasPermission("Tag.vip") && (Main.PreInvencibilidade)) {
    e.allow();
    p.getInventory().addItem(new ItemStack(Material.COMPASS));
    Main.Jogadores.add(p.getName());
    } else {
    e.setKickMessage("§a§lPARTIDA EM ANDAMENTO!" + "\n" + "        §7Visite §a" + Main.site);
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
    }
    }
    if(Main.Watch.contains(p.getName()) && (p.hasPermission("HungerGames.c.Watch"))) {
    e.allow();
    p.setAllowFlight(true);
    p.setFlying(true);
    p.sendMessage("§7[§a!§7] Você entrou no modo espectador");
    p.sendMessage("§7[§a!§7] Ultilize /ir para se teleportar até algum jogador!");
    
    p.getInventory().clear();
    p.setGameMode(GameMode.CREATIVE);
    ItemStack kit = new ItemStack(Material.SLIME_BALL);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aMenu De Transporte.");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(4, kit);
    
    Location loc = new Location(Bukkit.getWorld("world"), 10.0D, 120.0D, 10.0D, -90.0F, 0.0F);
    p.teleport(loc);
    for(Player pl : Bukkit.getOnlinePlayers()) {
    pl.hidePlayer(p);
    }
    }
    if(NoLog.contains(p.getName())) {
    e.setKickMessage("§a§lVOCÊ DEMOROU DEMAIS!" + "\n" + "        §7Visite §a" + Main.site);
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
    } else {
    if(p.hasPermission("HungerGames.c.Admin")) {
    e.allow();
    }
    }
    if(antilog.contains(p.getName())) {
    e.setKickMessage("§a§lVOCÊ SAIU EM PVP!" + "\n" + "        §7Visite §a" + Main.site);
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
    } else {
    if(p.hasPermission("HungerGames.c.Admin")) {
    e.allow();
    }
    }
    if(Main.mortos.contains(p.getName())) {
    e.setKickMessage("§a§lVOCÊ FOI MORTO!" + "\n" + "        §7Visite §a" + Main.site);
    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
    } else {
    if(p.hasPermission("HungerGames.c.Admin")) {
    e.allow();
    }
    }
    }
    }
    
    
    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
    event.setCancelled(true);
    }
    
    @EventHandler
    public void AntiCaps(AsyncPlayerChatEvent evt) {
    if (!evt.getPlayer().hasPermission("HungerGames.c.Admin")) {
    evt.setMessage(evt.getMessage().toLowerCase());
    }
    }

    @EventHandler
    public void onAntiLogDmg(EntityDamageByEntityEvent event) {
	if (((event.getDamager() instanceof Player)) && ((event.getEntity() instanceof Player))) {
	final Player player = (Player)event.getEntity();
	final Player target = (Player)event.getDamager();
    if(Main.Partida) {
    if ((!antilog.contains(player.getName())) && (!antilog.contains(target.getName()))) {
	antilog.add(player.getName());
    antilog.add(target.getName());
    Main.instance.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
	public void run() {
	if ((antilog.contains(player.getName())) && (antilog.contains(target.getName()))) {
	antilog.remove(player.getName());
	antilog.remove(target.getName());
    }
    }
    },450L);
    }
   }
  }
 }
}