package Net.Hunger.Habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Cultivator implements Listener {
	 	
	  @EventHandler
	  public void BlockPlace(BlockPlaceEvent e)
	  {
	    World world = e.getPlayer().getWorld();

	    Block block = e.getBlock();
	    Player player = e.getPlayer();
	    if((Habilidade.getAbility(player).equalsIgnoreCase("cultivator"))) {
	      if (block.getType() == Material.CROPS) {
	        Location loc = block.getLocation();
	        block.setType(Material.CROPS);
	        block.setData((byte)7);
	      }
	      if (block.getType() == Material.SAPLING) {
	        Location loc = block.getLocation();
	        TreeType tipo = getTree(block.getData());
	        block.setType(Material.AIR);
	        world.generateTree(loc, tipo);
	      }
	    }
	  }
	  public TreeType getTree(int data) {
		    TreeType tretyp = TreeType.TREE;
		    switch (data) {
		    case 0:
		      tretyp = TreeType.TREE;
		      break;
		    case 1:
		      tretyp = TreeType.REDWOOD;
		      break;
		    case 2:
		      tretyp = TreeType.BIRCH;
		      break;
		    case 3:
		      tretyp = TreeType.JUNGLE;
		      break;
		    default:
		      tretyp = TreeType.TREE;
		    }
		    return tretyp;
		  }
	  public TreeType getTree2(int data) {
	    TreeType tretyp = TreeType.TREE;
	    switch (data) {
	    case 0:
	      tretyp = TreeType.BROWN_MUSHROOM;
	      break;
	    case 1:
	      tretyp = TreeType.BROWN_MUSHROOM;
	      break;
	    case 2:
	      tretyp = TreeType.BIRCH;
	      break;
	    case 3:
	      tretyp = TreeType.JUNGLE;
	      break;
	    default:
	      tretyp = TreeType.TREE;
	    }
	    return tretyp;
	  } 

	  public TreeType getTree1(int data)
	  {
	    TreeType tretyp = TreeType.TREE;
	    switch (data) {
	    case 0:
	      tretyp = TreeType.RED_MUSHROOM;
	      break;
	    case 1:
	      tretyp = TreeType.BROWN_MUSHROOM;
	      break;
	    case 2:
	      tretyp = TreeType.BIRCH;
	      break;
	    case 3:
	      tretyp = TreeType.JUNGLE;
	      break;
	    default:
	      tretyp = TreeType.TREE;
	    }
	    return tretyp;
	  }
}