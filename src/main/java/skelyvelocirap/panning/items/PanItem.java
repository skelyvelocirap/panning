package skelyvelocirap.panning.items;

import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext.FluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import skelyvelocirap.panning.Panning;
import skelyvelocirap.panning.setup.registries.PanningAction;

public class PanItem extends Item {
	
	public PanItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		return 100;
	}
	
	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity) {
		return armorType == EquipmentSlotType.HEAD;
	}
	
	@Override
	public boolean isEnderMask(ItemStack stack, PlayerEntity player, EndermanEntity endermanEntity) {
		return true;
	}
	
	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		super.appendHoverText(stack, world, tooltip, flag);
	}
	
	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		CompoundNBT compound = getNBTTagCompound(stack);
		ItemStack inventoryStack = ItemStack.of((CompoundNBT)compound.get("pannedItem"));
		
		if(inventoryStack.isEmpty()) {
			World world = entity.level;
			if(!world.isClientSide) {
				if(entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity)entity;
					RayTraceResult traceResult = getPlayerPOVHitResult(world, (PlayerEntity)player, FluidMode.NONE);
					if(traceResult.getType() == RayTraceResult.Type.BLOCK) {
						BlockRayTraceResult blockTraceResult = (BlockRayTraceResult)traceResult;
						BlockPos pos = blockTraceResult.getBlockPos();
						if(PanningAction.inBiomeForDrops(player, pos)) {
							if(player.distanceToSqr(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) < 64.0D) {
								if(PanningAction.blockHasResult(player.level.getBlockState(pos).getBlock())) {
									inventoryStack = new ItemStack(world.getBlockState(pos).getBlock(), 1);
									compound.put("pannedItem", inventoryStack.serializeNBT());
									world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
								}
							}
						}
					}
				}
			}
		}
		return super.onEntitySwing(stack, entity);
	}
	@Override
	public ItemStack finishUsingItem(ItemStack p_77654_1_, World p_77654_2_, LivingEntity p_77654_3_) {
		Panning.LOGGER.debug("Finished");
		return super.finishUsingItem(p_77654_1_, p_77654_2_, p_77654_3_);
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		player.startUsingItem(hand);
		return ActionResult.sidedSuccess(player.getItemInHand(hand), true);
	}
	
	@Override
	public void onUseTick(World world, LivingEntity entity, ItemStack stack, int ticks) {
		CompoundNBT compound = getNBTTagCompound(stack);
		compound.putInt("progress", ticks);
		ItemStack inventoryStack = ItemStack.of((CompoundNBT)compound.get("pannedItem"));
		
		if(entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			if(ticks <= 1) {
				if(!world.isClientSide) {
					if(!inventoryStack.isEmpty()){
						List<ItemStack> results = PanningAction.getDrops(player, 1);
						for(int i = 0; i < results.size(); i++) {
							ItemEntity itemEntity = new ItemEntity(world, player.position().x, player.position().y, player.position().z, results.get(i));
							itemEntity.fireImmune();
							world.addFreshEntity(itemEntity);
							player.giveExperiencePoints(Math.round(PanningAction.getExperience(i)));
						}
						inventoryStack = ItemStack.EMPTY;
						compound.put("pannedItem", inventoryStack.serializeNBT());
					}
				}
			}
		}
		super.onUseTick(world, entity, stack, ticks);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return 1;
	}
	
	public CompoundNBT getNBTTagCompound(ItemStack stack) {
		CompoundNBT compound = stack.getOrCreateTag();
		return compound;
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return getItemInPan(stack) == ItemStack.EMPTY ? false : true;
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		CompoundNBT compound = getNBTTagCompound(stack);
		return compound.contains("progress") ? 1.0D - Double.valueOf(compound.getInt("progress")) / Double.valueOf(getUseDuration(stack)) : 1.0D;
	}
	
	public ItemStack getItemInPan(ItemStack stack) {
		return ItemStack.of(getNBTTagCompound(stack));
	}
	
	/*
	public static boolean touchesLiquid(IBlockReader reader, BlockPos pos, ITag<Fluid> fluid) {
      boolean flag = false;
      BlockPos.Mutable blockpos$mutable = pos.mutable();

      for(Direction direction : Direction.values()) {
         BlockState blockstate = reader.getBlockState(blockpos$mutable);
         if (direction != Direction.DOWN || isFluidType(blockstate, fluid)) {
            blockpos$mutable.setWithOffset(pos, direction);
            blockstate = reader.getBlockState(blockpos$mutable);
            if (isFluidType(blockstate, fluid) && !blockstate.isFaceSturdy(reader, pos, direction.getOpposite())) {
               flag = true;
               break;
            }
         }
      }

      return flag;
   }

   public static boolean isFluidType(BlockState blockState, ITag<Fluid> fluid) {
      return blockState.getFluidState().is(fluid);
   }
   */
}
