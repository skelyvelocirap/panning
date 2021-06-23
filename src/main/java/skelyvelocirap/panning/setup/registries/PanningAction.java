package skelyvelocirap.panning.setup.registries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import skelyvelocirap.panning.setup.ModItems;

public class PanningAction {
	static List<Pannable> possibleDrops;
	
	public static void registerDrops() {
		possibleDrops = new ArrayList<Pannable>();
		
		//SWAMP
		addPossibleDrop(Blocks.SAND, ModItems.IRON_FLAKE.get(), 0.075F, Biomes.SWAMP.location(), 0.5F, FluidTags.WATER, 0, 1, 15);
		addPossibleDrop(Blocks.SAND, Items.IRON_NUGGET, 0.0075F, Biomes.SWAMP.location(), 1.0F,FluidTags.WATER, 0, 1, 11);
		addPossibleDrop(Blocks.SAND, ModItems.GOLD_FLAKE.get(), 0.015F, Biomes.SWAMP.location(), 0.75F, FluidTags.WATER, 0, 1, 10);
		addPossibleDrop(Blocks.SAND, Items.GOLD_NUGGET, 0.0015F, Biomes.SWAMP.location(), 1.25F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.SAND, ModItems.DIAMOND_SHARD.get(), 0.012F, Biomes.SWAMP.location(), 1.5F, FluidTags.WATER, 0, 1, 8);
		addPossibleDrop(Blocks.SAND, Items.DIAMOND, 0.0012F, Biomes.SWAMP.location(), 3.0F, FluidTags.WATER, 0, 1, 3);
		addPossibleDrop(Blocks.SAND, ModItems.EMERALD_SHARD.get(), 0.0004F, Biomes.SWAMP.location(), 2.0F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.SAND, Items.EMERALD, 0.00004F, Biomes.SWAMP.location(), 3.5F, FluidTags.WATER, 0, 1, 2);
		
		addPossibleDrop(Blocks.GRAVEL, ModItems.IRON_FLAKE.get(), 0.075F, Biomes.SWAMP.location(), 0.5F, FluidTags.WATER, 0, 1, 15);
		addPossibleDrop(Blocks.GRAVEL, Items.IRON_NUGGET, 0.0075F, Biomes.SWAMP.location(), 1.0F,FluidTags.WATER, 0, 1, 11);
		addPossibleDrop(Blocks.GRAVEL, ModItems.GOLD_FLAKE.get(), 0.015F, Biomes.SWAMP.location(), 0.75F, FluidTags.WATER, 0, 1, 10);
		addPossibleDrop(Blocks.GRAVEL, Items.GOLD_NUGGET, 0.0015F, Biomes.SWAMP.location(), 1.25F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.GRAVEL, ModItems.DIAMOND_SHARD.get(), 0.012F, Biomes.SWAMP.location(), 1.5F, FluidTags.WATER, 0, 1, 8);
		addPossibleDrop(Blocks.GRAVEL, Items.DIAMOND, 0.0012F, Biomes.SWAMP.location(), 3.0F, FluidTags.WATER, 0, 1, 3);
		addPossibleDrop(Blocks.GRAVEL, ModItems.EMERALD_SHARD.get(), 0.0004F, Biomes.SWAMP.location(), 2.0F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.GRAVEL, Items.EMERALD, 0.00004F, Biomes.SWAMP.location(), 3.5F, FluidTags.WATER, 0, 1, 2);
		
		//RIVER
		addPossibleDrop(Blocks.SAND, ModItems.IRON_FLAKE.get(), 0.150F, Biomes.RIVER.location(), 0.5F, FluidTags.WATER, 0, 1, 15);
		addPossibleDrop(Blocks.SAND, Items.IRON_NUGGET, 0.0150F, Biomes.RIVER.location(), 1.0F, FluidTags.WATER, 0, 1, 11);
		addPossibleDrop(Blocks.SAND, ModItems.GOLD_FLAKE.get(), 0.030F, Biomes.RIVER.location(), 0.75F, FluidTags.WATER, 0, 1, 10);
		addPossibleDrop(Blocks.SAND, Items.GOLD_NUGGET, 0.003F, Biomes.RIVER.location(), 1.25F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.SAND, ModItems.DIAMOND_SHARD.get(), 0.024F, Biomes.RIVER.location(), 1.5F, FluidTags.WATER, 0, 1, 8);
		addPossibleDrop(Blocks.SAND, Items.DIAMOND, 0.0024F, Biomes.RIVER.location(), 3.0F, FluidTags.WATER, 0, 1, 3);
		addPossibleDrop(Blocks.SAND, ModItems.EMERALD_SHARD.get(), 0.0008F, Biomes.RIVER.location(), 2.0F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.SAND, Items.EMERALD, 0.00008F, Biomes.RIVER.location(), 3.5F, FluidTags.WATER, 0, 1, 2);
		
		addPossibleDrop(Blocks.GRAVEL, ModItems.IRON_FLAKE.get(), 0.150F, Biomes.RIVER.location(), 0.5F, FluidTags.WATER, 0, 1, 15);
		addPossibleDrop(Blocks.GRAVEL, Items.IRON_NUGGET, 0.0150F, Biomes.RIVER.location(), 1.0F, FluidTags.WATER, 0, 1, 11);
		addPossibleDrop(Blocks.GRAVEL, ModItems.GOLD_FLAKE.get(), 0.030F, Biomes.RIVER.location(), 0.75F, FluidTags.WATER, 0, 1, 10);
		addPossibleDrop(Blocks.GRAVEL, Items.GOLD_NUGGET, 0.003F, Biomes.RIVER.location(), 1.25F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.GRAVEL, ModItems.DIAMOND_SHARD.get(), 0.024F, Biomes.RIVER.location(), 1.5F, FluidTags.WATER, 0, 1, 8);
		addPossibleDrop(Blocks.GRAVEL, Items.DIAMOND, 0.0024F, Biomes.RIVER.location(), 3.0F, FluidTags.WATER, 0, 1, 3);
		addPossibleDrop(Blocks.GRAVEL, ModItems.EMERALD_SHARD.get(), 0.0008F, Biomes.RIVER.location(), 2.0F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(Blocks.GRAVEL, Items.EMERALD, 0.00008F, Biomes.RIVER.location(), 3.5F, FluidTags.WATER, 0, 1, 2);
		
		//NETHER WASTE
		addPossibleDrop(Blocks.GRAVEL, ModItems.GOLD_FLAKE.get(), 0.075F, Biomes.NETHER_WASTES.location(), 0.75F, FluidTags.LAVA, 0, 1, 9);
		addPossibleDrop(Blocks.GRAVEL, Items.GOLD_NUGGET, 0.0075F, Biomes.NETHER_WASTES.location(), 1.25F, FluidTags.LAVA, 0, 1, 5);
		addPossibleDrop(Blocks.GRAVEL, Items.GOLD_INGOT, 0.00075F, Biomes.NETHER_WASTES.location(), 2.25F, FluidTags.LAVA, 0, 1, 3);
		addPossibleDrop(Blocks.GRAVEL, Items.QUARTZ, 0.125F, Biomes.NETHER_WASTES.location(), 4.5F, FluidTags.LAVA, 0, 1, 10);
		addPossibleDrop(Blocks.GRAVEL, Items.NETHERITE_SCRAP, 0.0008F, Biomes.NETHER_WASTES.location(), 5.0F, FluidTags.LAVA, 0, 1, 1);
	}
	
	public static void addPossibleDrop(Block foundIn, Item drop, float chance, ResourceLocation biomes, float experience, ITag<Fluid> fluid, int panLevel, int min, int max) {
		possibleDrops.add(new Pannable(foundIn, drop, chance, biomes, fluid, experience, panLevel, min, max));
	}
	
	public static List<ItemStack> getDrops(PlayerEntity player, BlockPos pos, int panLevel) {
		Random random = new Random();
		List<ItemStack> drops = new ArrayList<>();
		for(int i = 0; i < possibleDrops.size(); i++) {
			Pannable drop = possibleDrops.get(i);
			if(inFluidForDrops(player)) {
				if(inBiomeForDrops(player.level, pos, i))
				if(panLevel > drop.getPanLevel()) {
					float chance = drop.getChance();
					if(chance >= random.nextFloat()) {
						int max = drop.getMax();
						int min = drop.getMin();
						int count = random.nextInt((max - min) + 1) + min;
						drops.add(new ItemStack(drop.getDrop(), count));
					}
				}
			}
		}
		return drops;
	}
	
	public static boolean inFluidForDrops(PlayerEntity player) {
		for(int i = 0; i < possibleDrops.size(); i++) {
			Pannable drop = possibleDrops.get(i);
			if(player.getFluidHeight(drop.getFluidType()) > 0.0D) {
				return true;
			}
		}
		return false;
	}
	
	public static float getExperience(int recipeId) {
		return possibleDrops.get(recipeId).getExperience();
	}
	
	public static boolean inBiomeForDrops(World world, BlockPos pos, int id) {
		return world.getBiome(pos).getRegistryName().equals(possibleDrops.get(id).getBiome());
	}
	
	public static boolean blockHasResultForBiome(World world, BlockPos pos) {
		for(int i = 0; i < possibleDrops.size(); i++) {
			if(world.getBlockState(pos).getBlock() == possibleDrops.get(i).getBlock()) {
				if(inBiomeForDrops(world, pos, i)) {
					return true;
				}
			}
		}
		return false;
	}
}
