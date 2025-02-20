package mrchumbucket.meatblock.mixin;

import mrchumbucket.meatblock.block.ModBlocks;
import mrchumbucket.meatblock.block.SlidingBlock;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "handleStatus", at = @At("HEAD"))
	public void meat_block$handleStatues(byte status, CallbackInfo ci) {
		if (status == 99 || status == 100) {
			SlidingBlock.addRegularParticles((Entity)(Object) this, status);
		}
	}
}
