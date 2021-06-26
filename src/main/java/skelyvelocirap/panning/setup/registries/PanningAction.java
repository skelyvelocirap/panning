package skelyvelocirap.panning.setup.registries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import skelyvelocirap.panning.crafting.BiomeModifier;
import skelyvelocirap.panning.crafting.BlockModifier;
import skelyvelocirap.panning.setup.ModItems;

public class PanningAction {
	static List<Pannable> possibleDrops;
	
	public static void registerDrops() {
		possibleDrops = new ArrayList<Pannable>();
		
		List<BlockModifier> BLOCKS = new ArrayList<BlockModifier>();
		List<BiomeModifier> BIOMES = new ArrayList<BiomeModifier>();
		
		
		Collections.addAll(BLOCKS, new BlockModifier(Blocks.SAND, 1.0F), new BlockModifier(Blocks.GRAVEL, 1.5F));
		Collections.addAll(BIOMES, new BiomeModifier(Biomes.SWAMP.location(), 1.0F), new BiomeModifier(Biomes.RIVER.location(), 2.0F));
		addPossibleDrop(BLOCKS, BIOMES, ModItems.IRON_FLAKE.get(), 0.075F, 0.5F, FluidTags.WATER, 0, 1, 11);
		addPossibleDrop(BLOCKS, BIOMES, Items.IRON_NUGGET, 0.0075F, 1.0F,FluidTags.WATER, 0, 1, 11);
		addPossibleDrop(BLOCKS, BIOMES, ModItems.GOLD_FLAKE.get(), 0.05F, 0.75F, FluidTags.WATER, 0, 1, 10);
		addPossibleDrop(BLOCKS, BIOMES, Items.GOLD_NUGGET, 0.005F, 1.25F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(BLOCKS, BIOMES, ModItems.DIAMOND_SHARD.get(), 0.04F, 1.5F, FluidTags.WATER, 0, 1, 8);
		addPossibleDrop(BLOCKS, BIOMES, Items.DIAMOND, 0.004F, 3.0F, FluidTags.WATER, 0, 1, 3);
		addPossibleDrop(BLOCKS, BIOMES, ModItems.EMERALD_SHARD.get(), 0.0012F, 2.0F, FluidTags.WATER, 0, 1, 7);
		addPossibleDrop(BLOCKS, BIOMES, Items.EMERALD, 0.00012F, 3.5F, FluidTags.WATER, 0, 1, 2);

		BLOCKS.clear();
		BIOMES.clear();
		
		

		Collections.addAll(BLOCKS, new BlockModifier(Blocks.NETHERRACK, 0.25F), new BlockModifier(Blocks.SOUL_SAND, 2.0F), new BlockModifier(Blocks.SOUL_SOIL, 2.5F));
		Collections.addAll(BIOMES, new BiomeModifier(Biomes.NETHER_WASTES.location(), 1.0F), new BiomeModifier(Biomes.SOUL_SAND_VALLEY.location(), 1.0F));	
		addPossibleDrop(BLOCKS, BIOMES, ModItems.GOLD_FLAKE.get(), 0.075F, 0.75F, FluidTags.LAVA, 0, 1, 9);
		addPossibleDrop(BLOCKS, BIOMES, Items.GOLD_NUGGET, 0.0075F, 1.25F, FluidTags.LAVA, 0, 1, 5);
		addPossibleDrop(BLOCKS, BIOMES, Items.GOLD_INGOT, 0.00075F, 2.25F, FluidTags.LAVA, 0, 1, 3);
		addPossibleDrop(BLOCKS, BIOMES, Items.QUARTZ, 0.125F, 4.5F, FluidTags.LAVA, 0, 1, 10);
		addPossibleDrop(BLOCKS, BIOMES, Items.NETHERITE_SCRAP, 0.0025F, 5.0F, FluidTags.LAVA, 0, 1, 1);
	}
	
	public static void addPossibleDrop(List<BlockModifier> foundIn, List<BiomeModifier> biomes, Item drop, float chance, float experience, ITag<Fluid> fluid, int panLevel, int min, int max) {
		
		possibleDrops.add(new Pannable(foundIn, biomes, drop, chance, fluid, experience, panLevel, min, max));
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
		Pannable drops = possibleDrops.get(id);
		for(BiomeModifier biomes : drops.getBiome()) {
			if(world.getBiome(pos).getRegistryName().equals(biomes.getBiome())) return true;
		}
		return false;
	}
	
	public static Pannable blockHasResultForBiome(World world, BlockPos pos) {
		for(int i = 0; i < possibleDrops.size(); i++) {
			if(world.getBlockState(pos).getBlock() == possibleDrops.get(i).getBlock()) {
				if(inBiomeForDrops(world, pos, i)) {
					return possibleDrops.get(i);
				}
			}
		}
		return null;
	}
}
