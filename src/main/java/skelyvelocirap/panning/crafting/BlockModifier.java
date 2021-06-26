package skelyvelocirap.panning.crafting;

import net.minecraft.block.Block;

public class BlockModifier {
	Block block;
	float modifier;
	
	public BlockModifier(Block block, float modifier) {
		this.block = block;
		this.modifier = modifier;
	}
	
	public Block getBlock() {
		return block;
	}

	public float getModifer() {
		return modifier;
	}
}
