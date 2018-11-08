package ca.celticminstrel.spawneredit;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.v1_7_R1.NBTTagCompound;
import net.minecraft.server.v1_7_R1.TileEntityMobSpawner;
import net.minecraft.server.v1_7_R1.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.craftbukkit.v1_7_R1.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class SpawnerOwner
  implements InventoryHolder, Listener
{
  private static final String TAG_SPAWN_LIMIT = "MaxNearbyEntities";
  private static final String TAG_MIN_DELAY = "MinSpawnDelay";
  private static final String TAG_MAX_DELAY = "MaxSpawnDelay";
  private CreatureSpawner source;
  private Inventory contents;
  private TileEntityMobSpawner nmsSource;
  private List<SpawnerWindow> watchers;
  
  public SpawnerOwner(CreatureSpawner cage)
  {
    this.contents = Bukkit.createInventory(this, InventoryType.ENCHANTING);
    this.source = cage;
    Location loc = this.source.getLocation();
    int x = loc.getBlockX();int y = loc.getBlockY();int z = loc.getBlockZ();
    this.nmsSource = ((TileEntityMobSpawner)((CraftWorld)this.source.getWorld()).getHandle().getTileEntity(x, y, z));
    this.watchers = new ArrayList();
    updateItem();
  }
  
  public Inventory getInventory()
  {
    updateItem();
    return this.contents;
  }
  
  public void addWatcher(SpawnerWindow who)
  {
    this.watchers.add(who);
  }
  
  public void removeWatcher(SpawnerWindow who)
  {
    this.watchers.remove(who);
  }
  
  public void update()
  {
    ItemStack item = this.contents.getItem(0);
    if ((item != null) && (item.getType() == Material.MONSTER_EGG))
    {
      EntityType entity = EntityType.fromId(item.getDurability());
      this.source.setSpawnedType(entity);
    }
    else
    {
      this.source.setSpawnedType(null);
    }
    this.source.update();
    for (SpawnerWindow who : this.watchers) {
      who.update();
    }
  }
  
  public void updateItem()
  {
    ItemStack item = new ItemStack(Material.MONSTER_EGG, 1);
    
    short type = this.source.getSpawnedType().getTypeId();
    item.setDurability(type);
    
    this.contents.setItem(0, item);
  }
  
  public int getMaxDelay()
  {
    NBTTagCompound tag = new NBTTagCompound();
    this.nmsSource.b(tag);
    return tag.getInt("MaxSpawnDelay");
  }
  
  public int getMinDelay()
  {
    NBTTagCompound tag = new NBTTagCompound();
    this.nmsSource.b(tag);
    return tag.getInt("MinSpawnDelay");
  }
  
  public int getLimit()
  {
    NBTTagCompound tag = new NBTTagCompound();
    this.nmsSource.b(tag);
    return tag.getInt("MaxNearbyEntities");
  }
  
  public void incrementMaxDelay(int amount)
  {
    amount *= 10;
    NBTTagCompound tag = new NBTTagCompound();
    this.nmsSource.b(tag);
    int current = tag.getInt("MaxSpawnDelay");
    int newVal = Math.max(1, current + amount);
    tag.setInt("MaxSpawnDelay", newVal);
    this.nmsSource.a(tag);
  }
  
  public void incrementMinDelay(int amount)
  {
    amount *= 10;
    NBTTagCompound tag = new NBTTagCompound();
    this.nmsSource.b(tag);
    int current = tag.getInt("MinSpawnDelay");
    int newVal = Math.max(0, current + amount);
    tag.setInt("MinSpawnDelay", newVal);
    this.nmsSource.a(tag);
  }
  
  public void incrementLimit(int amount)
  {
    NBTTagCompound tag = new NBTTagCompound();
    this.nmsSource.b(tag);
    int current = tag.getInt("MaxNearbyEntities");
    int newVal = Math.max(1, current + amount);
    tag.setInt("MaxNearbyEntities", newVal);
    this.nmsSource.a(tag);
  }
  
  public void decrementMaxDelay(int amount)
  {
    incrementMaxDelay(-amount);
  }
  
  public void decrementMinDelay(int amount)
  {
    incrementMinDelay(-amount);
  }
  
  public void decrementLimit(int amount)
  {
    incrementLimit(-amount);
  }
}
