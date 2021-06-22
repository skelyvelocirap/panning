package skelyvelocirap.panning.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import skelyvelocirap.panning.Panning;
import skelyvelocirap.panning.data.client.ModItemModelProvider;

@Mod.EventBusSubscriber(modid = Panning.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
	private DataGenerators() {}
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent data) {
		DataGenerator generator = data.getGenerator();
		ExistingFileHelper existingFileHelper = data.getExistingFileHelper();
		
		generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
		
		//ModItemTagsProvider itemTags = new ModItemTagsProvider(generator, blockTags, existingFileHelper);
		//generator.addProvider(itemTags);
		
		generator.addProvider(new ModRecipeProvider(generator));
	}
}
