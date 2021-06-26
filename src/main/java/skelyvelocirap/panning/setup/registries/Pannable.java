package skelyvelocirap.panning.setup.registries;

import java.util.List;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import skelyvelocirap.panning.crafting.BiomeModifier;
import skelyvelocirap.panning.crafting.BlockModifier;

public class Pannable {
	private List<BlockModifier> foundIn;
	private List<BiomeModifier> biome;
	private Item drop;
	private float chance = 0.0F;
	private ITag<Fluid> fluid;
	private int panLevel = 0;
	private float experience = 0;
	private int min = 1;
	private int max = 1;
	
	public Pannable(List<BlockModifier> foundIn, List<BiomeModifier> biome, Item drop, float chance, ITag<Fluid> fluid, float experience, int panLevel, int min, int max) {
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
	
	public List<BlockModifier> getBlock() {
		return foundIn;
	}
	
	public Item getDrop() {
		return drop;
	}
	
	public float getChance() {
		return chance;
	}
	
	public List<BiomeModifier> getBiome(){
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
