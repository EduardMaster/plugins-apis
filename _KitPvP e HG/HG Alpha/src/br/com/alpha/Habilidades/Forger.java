/*  1:   */ package br.com.alpha.Habilidades;

/*  2:   */
/*  4:   */ import org.bukkit.Material;
/*  5:   */ import org.bukkit.entity.Player;
/*  6:   */ import org.bukkit.event.EventHandler;
/*  7:   */ import org.bukkit.event.Listener;
/*  8:   */ import org.bukkit.event.inventory.InventoryClickEvent;
/*  9:   */ import org.bukkit.inventory.Inventory;
/* 11:   */ import org.bukkit.inventory.ItemStack;

import br.com.alpha.ENUMs.KitsEnum;



/* 13:   */
/* 14:   */ public class Forger/* 15: */ implements Listener
/* 16: */ {
	/* 17: */ @SuppressWarnings("deprecation")
	@EventHandler
	/* 18: */ public void onInventoryClick(InventoryClickEvent event)
	/* 19: */ {
		/* 20:19 */ ItemStack currentItem = event.getCurrentItem();
		/* 21:20 */ Player p = (Player) event.getWhoClicked();
		 if ((currentItem != null) && (currentItem.getType() != Material.AIR) && (KitsEnum.getKit(p)==KitsEnum.FORGER)) {
			/* 24:23 */ int coalAmount = 0;
			/* 25:24 */ Inventory inv = event.getView().getBottomInventory();
			/* 26:25 */ for (ItemStack item : inv.getContents()) {
				/* 27:26 */ if ((item != null) && (item.getType() == Material.COAL)) {
					/* 28:27 */ coalAmount += item.getAmount();
					/* 29: */ }
				/* 30: */ }
			/* 31:30 */ if (coalAmount == 0) {
				/* 32:31 */ return;
				/* 33: */ }
			/* 34:33 */ int hadCoal = coalAmount;
			/* 35:34 */ if (currentItem.getType() == Material.COAL)
			/* 36: */ {
				/* 37:36 */ for (int slot = 0; slot < inv.getSize(); slot++)
				/* 38: */ {
					/* 39:38 */ ItemStack item = inv.getItem(slot);
					/* 40:39 */ if ((item != null) && (item.getType().name().contains("ORE")))
					/* 41: */ {
						/* 42:41 */ while ((item.getAmount() > 0) && (coalAmount > 0) && (
						/* 43:42 */ (item.getType() == Material.IRON_ORE) || (item.getType() == Material.GOLD_ORE)))
						/* 44: */ {
							/* 45:44 */ item.setAmount(item.getAmount() - 1);
							/* 46:45 */ coalAmount--;
							/* 47:46 */ if (item.getType() == Material.IRON_ORE) {
								/* 48:47 */ p.getInventory()
										.addItem(new ItemStack[] { new ItemStack(Material.IRON_INGOT) });
								/* 49:48 */ } else if (item.getType() == Material.GOLD_ORE) {
								/* 50:49 */ p.getInventory()
										.addItem(new ItemStack[] { new ItemStack(Material.GOLD_INGOT) });
								/* 51: */ }
							/* 52: */ }
						/* 53:52 */ if (item.getAmount() == 0) {
							/* 54:53 */ inv.setItem(slot, new ItemStack(0));
							/* 55: */ }
						/* 56: */ }
					/* 57: */ }
				/* 58: */ }
			/* 59:58 */ else if (currentItem.getType().name().contains("ORE"))
			/* 60: */ {
				/* 61:60 */ while ((currentItem.getAmount() > 0) && (coalAmount > 0) && (
				/* 62:61 */ (currentItem.getType() == Material.IRON_ORE)
						|| (currentItem.getType() == Material.GOLD_ORE)))
				/* 63: */ {
					/* 64:63 */ currentItem.setAmount(currentItem.getAmount() - 1);
					/* 65:64 */ coalAmount--;
					/* 66:65 */ if (currentItem.getType() == Material.IRON_ORE) {
						/* 67:66 */ p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_INGOT) });
						/* 68:67 */ } else if (currentItem.getType() == Material.GOLD_ORE) {
						/* 69:68 */ p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLD_INGOT) });
						/* 70: */ }
					/* 71: */ }
				/* 72:71 */ if (currentItem.getAmount() == 0) {
					/* 73:72 */ event.setCurrentItem(new ItemStack(0));
					/* 74: */ }
				/* 75: */ }
			/* 76:75 */ if (coalAmount != hadCoal) {
				/* 77:76 */ for (int slot = 0; slot < inv.getSize(); slot++)
				/* 78: */ {
					/* 79:78 */ ItemStack item = inv.getItem(slot);
					/* 80:79 */ if ((item != null) && (item.getType() == Material.COAL))
					/* 81: */ {
						/* 82:81 */ while ((coalAmount < hadCoal) && (item.getAmount() > 0))
						/* 83: */ {
							/* 84:83 */ item.setAmount(item.getAmount() - 1);
							/* 85:84 */ coalAmount++;
							/* 86: */ }
						/* 87:86 */ if (item.getAmount() == 0) {
							/* 88:87 */ inv.setItem(slot, new ItemStack(0));
							/* 89: */ }
						/* 90: */ }
					/* 91: */ }
				/* 92: */ }
			/* 93: */ }
		/* 94: */ }
	/* 95: */ }