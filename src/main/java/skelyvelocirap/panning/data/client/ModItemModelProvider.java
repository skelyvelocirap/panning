package skelyvelocirap.panning.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import skelyvelocirap.panning.Panning;

public class ModItemModelProvider extends ItemModelProvider{

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Panning.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		
		builder(itemGenerated, "iron_flake");
		builder(itemGenerated, "gold_flake");
		builder(itemGenerated, "diamond_shard");
		builder(itemGenerated, "emerald_shard");
	}

	private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
		return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
	}
	
}
