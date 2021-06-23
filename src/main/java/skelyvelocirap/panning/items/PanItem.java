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
import skelyvelocirap.panning.setup.registries.PanningAction;

public class PanItem extends Item {
	
	public static int itemUseTicks = 100;
	
	public PanItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public int getUseDuration(ItemStack stack) {
		return itemUseTicks;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		return getUseDuration(stack);
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
		ItemStack inventoryStack = getItemInPan(stack);
		
		if(inventoryStack.isEmpty()) {
			World world = entity.level;
			if(!world.isClientSide) {
				if(entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity)entity;
					RayTraceResult traceResult = getPlayerPOVHitResult(world, (PlayerEntity)player, FluidMode.NONE);
					if(traceResult.getType() == RayTraceResult.Type.BLOCK) {
						BlockRayTraceResult blockTraceResult = (BlockRayTraceResult)traceResult;
						BlockPos pos = blockTraceResult.getBlockPos();
						if(player.distanceToSqr(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) < 64.0D) {
							if(PanningAction.blockHasResultForBiome(player.level, pos)) {
								inventoryStack = new ItemStack(world.getBlockState(pos).getBlock(), 1);
								inventoryStack.save(compound);
								compound.putLong("biome", pos.asLong());
								world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
							}
						}
					}
				}
			}
		}
		return super.onEntitySwing(stack, entity);
	}
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
		stack.setDamageValue(0);
		CompoundNBT compound = getNBTTagCompound(stack);
		ItemStack inventoryStack = getItemInPan(stack);
		if(entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity)entity;
			if(!world.isClientSide) {
				if(!inventoryStack.isEmpty()){
					if(PanningAction.inFluidForDrops(player)) {
						List<ItemStack> results = PanningAction.getDrops(player, BlockPos.of(compound.getLong("biome")), 1);
						for(int i = 0; i < results.size(); i++) {
							ItemEntity itemEntity = new ItemEntity(world, player.position().x, player.position().y, player.position().z, results.get(i));
							itemEntity.setInvulnerable(true);
							itemEntity.fireImmune();
							world.addFreshEntity(itemEntity);
							player.giveExperiencePoints(Math.round(PanningAction.getExperience(i)));
						}
						inventoryStack = ItemStack.EMPTY;
						inventoryStack.save(compound);
					}
				}
			}
		}
		return super.finishUsingItem(stack, world, entity);
	}
	
	@Override
	public void onUseTick(World world, LivingEntity entity, ItemStack stack, int ticks) {
		if(ticks % 3 == 0) {
			stack.setDamageValue(stack.getMaxDamage() - ticks);
		}
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if(PanningAction.inFluidForDrops(player)) {
			if(!getItemInPan(stack).isEmpty()) {
				player.startUsingItem(hand);
				//return ActionResult.sidedSuccess(stack, !(player.getUseItemRemainingTicks() > 0));
				if(player.getUseItemRemainingTicks() > 0) {
					return ActionResult.pass(stack);
				}
				return ActionResult.success(stack);
			}
		}
		return ActionResult.pass(stack);
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
		return getItemInPan(stack).isEmpty() ? false : true;
	}
	
	public ItemStack getItemInPan(ItemStack stack) {
		CompoundNBT compound = getNBTTagCompound(stack);
		return compound.contains("id") ? ItemStack.of(compound) : ItemStack.EMPTY;
	}
	
	/*public void saveItemType(Item item) {
		Registry.ITEM.get(new ResourceLocation(Item.getString("id")));
	}
	
	public ItemStack loadItemStack(ItemStack stack) {
		CompoundNBT compound = getNBTTagCompound(stack);
		Item item = Registry.ITEM.get(new ResourceLocation(compound.getString("id")));
	}*/
	
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
