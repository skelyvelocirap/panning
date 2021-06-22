package skelyvelocirap.panning.data;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import skelyvelocirap.panning.Panning;
import skelyvelocirap.panning.setup.ModItems;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	

	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(ModItems.IRON_FLAKE.get(), 9).requires(Items.IRON_NUGGET).unlockedBy("has_item", has(ModItems.IRON_FLAKE.get())).save(consumer, modId("flake_crafting_iron"));
		ShapelessRecipeBuilder.shapeless(ModItems.GOLD_FLAKE.get(), 9).requires(Items.GOLD_NUGGET).unlockedBy("has_item", has(ModItems.GOLD_FLAKE.get())).save(consumer, modId("flake_crafting_gold"));
		ShapelessRecipeBuilder.shapeless(ModItems.DIAMOND_SHARD.get(), 9).requires(Items.DIAMOND).unlockedBy("has_item", has(ModItems.DIAMOND_SHARD.get())).save(consumer, modId("shard_crafting_diamond"));
		ShapelessRecipeBuilder.shapeless(ModItems.EMERALD_SHARD.get(), 9).requires(Items.EMERALD).unlockedBy("has_item", has(ModItems.EMERALD_SHARD.get())).save(consumer, modId("shard_crafting_emerald"));
		
		ShapedRecipeBuilder.shaped(Items.IRON_NUGGET).define('#', ModItems.IRON_FLAKE.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ModItems.IRON_FLAKE.get())).save(consumer, modId("iron_crafting_flake"));
		ShapedRecipeBuilder.shaped(Items.GOLD_NUGGET).define('#', ModItems.GOLD_FLAKE.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ModItems.GOLD_FLAKE.get())).save(consumer, modId("gold_crafting_flake"));
		ShapedRecipeBuilder.shaped(Items.DIAMOND).define('#', ModItems.DIAMOND_SHARD.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ModItems.DIAMOND_SHARD.get())).save(consumer, modId("diamond_crafting_shard"));
		ShapedRecipeBuilder.shaped(Items.EMERALD).define('#', ModItems.EMERALD_SHARD.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ModItems.EMERALD_SHARD.get())).save(consumer, modId("emerald_crafting_shard"));
		
		ShapedRecipeBuilder.shaped(ModItems.PAN.get()).define('i', Items.IRON_INGOT).define('s', Items.STICK).pattern(" s ").pattern("sis").pattern(" s ").unlockedBy("has_item", has(Items.IRON_INGOT)).save(consumer, modId("pan_crafting"));;
	}
	
	private static ResourceLocation modId(String path) {
		return new ResourceLocation(Panning.MODID, path);
	}
}
