package skelyvelocirap.panning.setup.registries;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import skelyvelocirap.panning.Panning;
import skelyvelocirap.panning.setup.ModItems;

public class Registration {
	//public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
	//public static final DeferredRegister<ContainerType<?>> CONTAINERS = create(ForgeRegistries.CONTAINERS);
	//public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = create(ForgeRegistries.TILE_ENTITIES);
	//public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = create(ForgeRegistries.RECIPE_SERIALIZERS);
	public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
	
	public static void Register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		//BLOCKS.register(modEventBus);
		//CONTAINERS.register(modEventBus);
		//TILE_ENTITIES.register(modEventBus);
		ITEMS.register(modEventBus);
		
		//ModBlocks.register();
		//ModContainers.register();
		ModItems.register();
		//ModTileEntityTypes.register();
		//ModRecipes.register();
	}
	
	private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
		return DeferredRegister.create(registry, Panning.MODID);
	}
}
