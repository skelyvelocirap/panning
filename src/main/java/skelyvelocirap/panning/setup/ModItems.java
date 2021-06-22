package skelyvelocirap.panning.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import skelyvelocirap.panning.items.PanItem;
import skelyvelocirap.panning.setup.registries.Registration;

public class ModItems {
	public static final RegistryObject<Item> PAN = Registration.ITEMS.register("pan", () -> new PanItem(new Item.Properties().tab(ItemGroup.TAB_MISC)));
	
	
	public static final RegistryObject<Item> IRON_FLAKE = Registration.ITEMS.register("iron_flake", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	public static final RegistryObject<Item> GOLD_FLAKE = Registration.ITEMS.register("gold_flake", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	public static final RegistryObject<Item> DIAMOND_SHARD = Registration.ITEMS.register("diamond_shard", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	public static final RegistryObject<Item> EMERALD_SHARD = Registration.ITEMS.register("emerald_shard", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
	
	public static void register() {}
}
