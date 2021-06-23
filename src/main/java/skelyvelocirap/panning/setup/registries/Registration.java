package skelyvelocirap.panning.setup.registries;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import skelyvelocirap.panning.Panning;
import skelyvelocirap.panning.setup.ModItems;

public class Registration {
	public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
	
	public static void Register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ITEMS.register(modEventBus);
		
		ModItems.register();
	}
	
	private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
		return DeferredRegister.create(registry, Panning.MODID);
	}
}
