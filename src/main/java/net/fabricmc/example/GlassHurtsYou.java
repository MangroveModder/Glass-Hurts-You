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
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			if (state.getMaterial() == Material.GLASS) {
				Random random = new Random();
				player.damage(DamageSource.GENERIC, random.nextInt(1, 3));
				player.playSound(SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.BLOCKS, 1, random.nextFloat(1.0F, 1.3F));
			}
		});
	}
}
