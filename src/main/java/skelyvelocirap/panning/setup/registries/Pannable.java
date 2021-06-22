package skelyvelocirap.panning.setup.registries;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class Pannable {
	private Block foundIn;
	private Item drop;
	private float chance = 0.0F;
	private ResourceLocation biome;
	private ITag<Fluid> fluid;
	private int panLevel = 0;
	private float experience = 0;
	private int min = 1;
	private int max = 1;
	
	public Pannable(Block foundIn, Item drop, float chance, ResourceLocation biome, ITag<Fluid> fluid, float experience, int panLevel, int min, int max) {
		this.foundIn = foundIn;
		this.drop = drop;
		this.chance = chance;
		this.biome = biome;
		this.fluid = fluid;
		this.panLevel = panLevel;
		this.experience = experience;
		this.min = min;
		this.max = max;
	}
	
	public Block getBlock() {
		return foundIn;
	}
	
	public Item getDrop() {
		return drop;
	}
	
	public float getChance() {
		return chance;
	}
	
	public ResourceLocation getBiome(){
		return biome;
	}
	
	public ITag<Fluid> getFluidType() {
		return fluid;
	}
	
	public float getExperience() {
		return experience;
	}
	
	public int getPanLevel() {
		return panLevel;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
}
