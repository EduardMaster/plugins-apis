package br.com.alpha.InGame.Schematic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.alpha.MCAlpha;
import net.minecraft.server.v1_7_R4.IContainer;
import net.minecraft.server.v1_7_R4.NBTCompressedStreamTools;
import net.minecraft.server.v1_7_R4.NBTTagCompound;
import net.minecraft.server.v1_7_R4.TileEntity;

public class Schematic {

	private final static HashSet<Location> updates = new HashSet<>();

	private short[] blocks;
	private byte[] data;
	private short width;
	private short lenght;
	private short height;

	public Schematic(short[] blocks2, byte[] data, short width, short lenght, short height) {
		this.blocks = blocks2;
		this.data = data;
		this.width = width;
		this.lenght = lenght;
		this.height = height;
	}

	public short[] getBlocks() {
		return this.blocks;
	}

	public byte[] getData() {
		return this.data;
	}

	public short getWidth() {
		return this.width;
	}

	public short getLenght() {
		return this.lenght;
	}

	public short getHeight() {
		return this.height;
	}

	public static void start() {
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				if (!updates.isEmpty()) {
					if (Bukkit.getOnlinePlayers().length == 0) {
						updates.clear();
						return;
					}
					net.minecraft.server.v1_7_R4.World world = ((CraftWorld) Bukkit.getWorlds().get(0)).getHandle();
					for (Location location : updates) {
						world.notify(location.getBlockX(), location.getBlockY(), location.getBlockZ());
					}
					updates.clear();
				}
			}
		}.runTaskTimer(MCAlpha.mcAlpha, 1, 1);
	}

	public static Schematic loadSchematic(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		NBTTagCompound tag = NBTCompressedStreamTools.a(stream);

		short width = tag.getShort("Width");
		short length = tag.getShort("Length");
		short height = tag.getShort("Height");

		byte[] blockId = tag.getByteArray("Blocks");
		byte[] blockData = tag.getByteArray("Data");

		byte[] addId = new byte[0];
		short[] blocks = new short[blockId.length];

		if (tag.hasKey("AddBlocks")) {
			addId = tag.getByteArray("AddBlocks");
		}

		for (int index = 0; index < blockId.length; index++) {
			if ((index >> 1) >= addId.length) {
				blocks[index] = (short) (blockId[index] & 0xFF);
			} else {
				if ((index & 1) == 0) {
					blocks[index] = (short) (((addId[index >> 1] & 0x0F) << 8) + (blockId[index] & 0xFF));
				} else {
					blocks[index] = (short) (((addId[index >> 1] & 0xF0) << 4) + (blockId[index] & 0xFF));
				}
			}
		}

		return new Schematic(blocks, blockData, width, length, height);
	}

	public static HashSet<Block> assembleSchematic(World World, Location loc, Schematic schematic) {
		HashSet<Block> blockList = new HashSet<Block>();
		short[] blocks = schematic.getBlocks();
		byte[] blockData = schematic.getData();
		short length = schematic.getLenght();
		short width = schematic.getWidth();
		short height = schematic.getHeight();
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				for (int z = 0; z < length; ++z) {
					int index = y * width * length + z * width + x;
					Block block = new Location(loc.getWorld(), x + loc.getBlockX(), y + loc.getBlockY(), z + loc.getBlockZ()).getBlock();

					if (!block.getChunk().isLoaded()) {
						block.getChunk().load();
					}

					blockList.add(block);
					setBlock(loc.getWorld(), block.getX(), block.getY(), block.getZ(), blocks[index], blockData[index]);
				}
			}
		}
		return blockList;
	}

	public static List<Block> spawnBo2(Location location, File file) {
		BufferedReader reader;
		ArrayList<Block> blocks = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (!line.contains(",") || !line.contains(":")) {
					continue;
				}
				String[] parts = line.split(":");
				String[] coordinates = parts[0].split(",");
				String[] blockData = parts[1].split("\\.");

				setBlock(location.getWorld(), location.getBlockX() + Integer.valueOf(coordinates[0]), location.getBlockY() + Integer.valueOf(coordinates[2]), location.getBlockZ() + Integer.valueOf(coordinates[1]), Integer.valueOf(blockData[0]), blockData.length > 1 ? Byte.valueOf(blockData[1]) : 0);
				blocks.add(location.getWorld().getBlockAt(location.getBlockX() + Integer.valueOf(coordinates[0]), location.getBlockY() + Integer.valueOf(coordinates[2]), location.getBlockZ() + Integer.valueOf(coordinates[1])));
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blocks;
	}

	public static boolean setBlock(World world, int x, int y, int z, int blockId, byte data) {
		if (y >= 255 || y < 0) {
			return false;
		}
		net.minecraft.server.v1_7_R4.World w = ((CraftWorld) world).getHandle();
		net.minecraft.server.v1_7_R4.Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
		boolean b = a(chunk, x & 0x0f, y, z & 0x0f, net.minecraft.server.v1_7_R4.Block.getById(blockId), data);
		updates.add(new Location(Bukkit.getWorlds().get(0), x, y, z));
		return b;
	}

	private static boolean a(net.minecraft.server.v1_7_R4.Chunk chunk, int x, int y, int z, net.minecraft.server.v1_7_R4.Block block, int data) {
		int heightMapIndex = z << 4 | x;

		if (y >= chunk.b[heightMapIndex] - 1) {
			chunk.b[heightMapIndex] = -999;
		}

		int heightMap = chunk.heightMap[heightMapIndex];
		net.minecraft.server.v1_7_R4.Block oldBlock = chunk.getType(x, y, z);
		int oldData = chunk.getData(x, y, z);

		if (oldBlock == block && oldData == data) {
			return false;
		} else {
			boolean flag = false;
			net.minecraft.server.v1_7_R4.ChunkSection chunkSection = chunk.getSections()[y >> 4];

			if (chunkSection == null) {
				if (block == net.minecraft.server.v1_7_R4.Blocks.AIR) {
					return false;
				}

				chunkSection = chunk.getSections()[y >> 4] = new net.minecraft.server.v1_7_R4.ChunkSection(y >> 4 << 4, !chunk.world.worldProvider.g);
				flag = y >= heightMap;
			}

			int chunkXFixed = chunk.locX * 16 + x;
			int chunkZFixed = chunk.locZ * 16 + z;

			if (!chunk.world.isStatic) {
				oldBlock.f(chunk.world, chunkXFixed, y, chunkZFixed, oldData);
			}
			if (!(oldBlock instanceof IContainer)) {
				chunkSection.setTypeId(x, y & 15, z, block);
			}
			if (!chunk.world.isStatic) {
				oldBlock.remove(chunk.world, chunkXFixed, y, chunkZFixed, oldBlock, oldData);
			} else if (oldBlock instanceof IContainer && oldBlock != block) {
				chunk.world.p(chunkXFixed, y, chunkZFixed);
			}
			if (oldBlock instanceof IContainer) {
				chunkSection.setTypeId(x, y & 15, z, block);
			}
			if (chunkSection.getTypeId(x, y & 15, z) != block) {
				return false;
			} else {
				chunkSection.setData(x, y & 15, z, data);
				if (flag) {
					chunk.initLighting();
				}
				TileEntity tileEntity;

				if (oldBlock instanceof IContainer) {
					tileEntity = chunk.e(x, y, z);
					if (tileEntity != null) {
						tileEntity.u();
					}
				}
				if (!chunk.world.isStatic && (!chunk.world.captureBlockStates || (block instanceof net.minecraft.server.v1_7_R4.BlockContainer))) {
					block.onPlace(chunk.world, chunkXFixed, y, chunkZFixed);
				}

				if (block instanceof IContainer) {
					if (chunk.getType(x, y, z) != block) {
						return false;
					}
					tileEntity = chunk.e(x, y, z);
					if (tileEntity == null) {
						tileEntity = ((IContainer) block).a(chunk.world, data);
						chunk.world.setTileEntity(chunkXFixed, y, chunkZFixed, tileEntity);
					}

					if (tileEntity != null) {
						tileEntity.u();
					}
				}

				chunk.n = true;
				return true;
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static HashSet<Location> generateBorder(int radius, int radiusY, Material bedrock) {
		long start = System.currentTimeMillis();
		HashSet<Location> blocks = new HashSet<>();
		World world = Bukkit.getWorlds().get(0);
		for (int y = 0; y <= 128; y++) {
			for (int x = -radius; x <= radius; x++) {
				{
					loadChunk(x, radius);
					setBlock(world, x, y, radius, bedrock.getId(), (byte) 0);
					blocks.add(new Location(Bukkit.getWorld("world"), x, y, radius));
				}
				{
					loadChunk(x, -radius);
					setBlock(world, x, y, -radius, bedrock.getId(), (byte) 0);
					blocks.add(new Location(Bukkit.getWorld("world"), x, y, -radius));
				}
			}
			for (int z = -radius; z <= radius; z++) {
				{
					loadChunk(radius, z);
					setBlock(world, radius, y, z, bedrock.getId(), (byte) 0);
					blocks.add(new Location(Bukkit.getWorld("world"), radius, y, z));
				}
				{
					loadChunk(-radius, z);
					setBlock(world, -radius, y, z, bedrock.getId(), (byte) 0);
					blocks.add(new Location(Bukkit.getWorld("world"), -radius, y, z));
				}
			}
		}
		System.out.println("Borda gerada (" + (System.currentTimeMillis() - start) + " ms)...");
		return blocks;
	}

	private static void loadChunk(int x, int z) {
		Bukkit.getWorlds().get(0).getChunkAt(x >> 4, z >> 4).load();
	}

}
