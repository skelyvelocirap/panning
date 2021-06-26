package skelyvelocirap.panning.crafting;

import net.minecraft.util.ResourceLocation;

public class BiomeModifier {
	ResourceLocation biome;
	float chanceModifier;
	
	public BiomeModifier(ResourceLocation biome, float chanceModifier) {
		this.biome = biome;
		this.chanceModifier = chanceModifier;
	}
	
	public ResourceLocation getBiome() {
		return biome;
	}
	
	public float getChanceModifier() {
		return chanceModifier;
	}
}
