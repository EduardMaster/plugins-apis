package Net.Hunger.Comandos;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import Net.Hunger.Main;
import Net.Hunger.Cheat.WrapperPlayServerEntityDestroy;
import Net.Hunger.Cheat.WrapperPlayServerNamedEntitySpawn;

import com.comphenix.protocol.wrappers.WrappedDataWatcher;

public class AuraCheck implements Listener {
	
  public Main plugin ;
  public AuraCheck(Main plugin){
  this.plugin = plugin;
  }
    
  private HashMap<Integer, Boolean> entitiesSpawned = new HashMap<Integer, Boolean>();
  private CommandSender invoker;
  private Player checked;
  private static Vector[] vectors = { new Vector(0.0D, 0.0D, 1.5D), new Vector(-1.5D, 0.0D, 0.0D), new Vector(1.5D, 0.0D, 0.0D), new Vector(0.0D, 0.0D, -1.5D), new Vector(1.5D, 0.0D, 1.5D), new Vector(-1.5D, 0.0D, -1.5D) };
  private long started;
  private long finished = 9223372036854775807L;
  
  public AuraCheck(Main plugin, Player checked)
  {
    this.plugin = plugin;
    this.checked = checked;
  }
  
  public void invoke(final CommandSender player)
  {
    this.invoker = player;
    this.started = System.currentTimeMillis();
    for (int i = 0; i < Math.min(vectors.length, this.plugin.getConfig().getInt("amountOfFakePlayers", 4)); i++)
    {
      WrapperPlayServerNamedEntitySpawn wrapper = getWrapper(this.checked.getLocation().add(vectors[i]).toVector(), this.plugin);
      this.entitiesSpawned.put(Integer.valueOf(wrapper.getEntityID()), Boolean.valueOf(false));
      wrapper.sendPacket(this.checked);
    }
    Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
    {
      public void run()
      {
        SimpleEntry<Integer, Integer> result = AuraCheck.this.end();
        AuraCheck.this.plugin.remove(AuraCheck.this.checked.getUniqueId());
        if (((AuraCheck.this.invoker instanceof Player)) && (!((Player)AuraCheck.this.invoker).isOnline())) {
          return;
        }
        double timeTaken = AuraCheck.this.finished != 9223372036854775807L ? (int)((AuraCheck.this.finished - AuraCheck.this.started) / 1000L) : AuraCheck.this.plugin.getConfig().getInt("ticksToKill", 10) / 20.0D;
        AuraCheck.this.invoker.sendMessage("§7[§a!§7] O jogador §a" + checked.getName() + "§7 Acertou (§a" + result.getKey() + "§7) de (§a" + result.getValue() + "§7)" + " Em: (§a" +  timeTaken + "§7) Segundos!");
      }
    }, plugin.getConfig().getInt("ticksToKill", 10));
  }
  
  public void markAsKilled(Integer val)
  {
    if (this.entitiesSpawned.containsKey(val))
    {
      this.entitiesSpawned.put(val, Boolean.valueOf(true));
      kill(val.intValue()).sendPacket(this.checked);
    }
    if (!this.entitiesSpawned.containsValue(Boolean.valueOf(false))) {
      this.finished = System.currentTimeMillis();
    }
  }
  
  public AbstractMap.SimpleEntry<Integer, Integer> end()
  {
    int killed = 0;
    for (Entry<Integer, Boolean> entry : this.entitiesSpawned.entrySet()) {
      if (((Boolean)entry.getValue()).booleanValue()) {
        killed++;
      } else if (this.checked.isOnline()) {
        kill(((Integer)entry.getKey()).intValue()).sendPacket(this.checked);
      }
    }
    int amount = this.entitiesSpawned.size();
    this.entitiesSpawned.clear();
    return new AbstractMap.SimpleEntry<Integer, Integer>(Integer.valueOf(killed), Integer.valueOf(amount));
  }
  
  public static WrapperPlayServerNamedEntitySpawn getWrapper(Vector loc, Main plugin)
  {
    WrapperPlayServerNamedEntitySpawn wrapper = new WrapperPlayServerNamedEntitySpawn();
    wrapper.setEntityID(Main.RANDOM.nextInt(20000));
    wrapper.setPosition(loc);
    wrapper.setPlayerUUID(UUID.randomUUID().toString());
    wrapper.setPlayerName("GarotoIGamer");
    wrapper.setYaw(0.0F);
    wrapper.setPitch(-45.0F);
    WrappedDataWatcher watcher = new WrappedDataWatcher();
    watcher.setObject(0, Byte.valueOf((byte)(plugin.getConfig().getBoolean("invisibility", true) ? Byte.valueOf((byte)32).byteValue() : 0)));
    watcher.setObject(6, Float.valueOf(0.5F));
    watcher.setObject(11, Byte.valueOf((byte)1));
    wrapper.setMetadata(watcher);
    return wrapper;
  }
  
  public static WrapperPlayServerEntityDestroy kill(int entity)
  {
    WrapperPlayServerEntityDestroy wrapper = new WrapperPlayServerEntityDestroy();
    wrapper.setEntities(new int[] { entity });
    return wrapper;
  }
}