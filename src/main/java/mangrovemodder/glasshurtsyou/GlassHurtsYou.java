package mangrovemodder.glasshurtsyou;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Material;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import java.util.Random;
public class GlassHurtsYou implements ModInitializer {
	@Override
	public void onInitialize() {
		// Block break event
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			// Glass check
			if (state.getMaterial() == Material.GLASS) {
				Random random = new Random();
				player.damage(DamageSource.GENERIC, random.nextInt(1, 3));// Damage player
				player.playSound(SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.BLOCKS, 1, random.nextFloat(1.0F, 1.3F));//Play sound for glass break
			}
		});
	}
}
