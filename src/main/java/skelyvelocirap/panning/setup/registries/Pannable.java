package skelyvelocirap.panning.setup.registries;

import java.util.ArrayList;
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
		this.foundIn = new ArrayList<BlockModifier>(foundIn);
		this.drop = drop;
		this.chance = chance;
		this.biome = new ArrayList<BiomeModifier>(biome);
		this.fluid = fluid;
		this.panLevel = panLevel;
		this.experience = experience;
		this.min = min;
		this.max = max;
	}
	
	public List<BlockModifier> getBlock() {
		return this.foundIn;
	}
	
	public Item getDrop() {
		return this.drop;
	}
	
	public float getChance() {
		return this.chance;
	}
	
	public List<BiomeModifier> getBiome(){
		return this.biome;
	}
	
	public ITag<Fluid> getFluidType() {
		return this.fluid;
	}
	
	public float getExperience() {
		return this.experience;
	}
	
	public int getPanLevel() {
		return this.panLevel;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public int getMax() {
		return this.max;
	}
	
}
