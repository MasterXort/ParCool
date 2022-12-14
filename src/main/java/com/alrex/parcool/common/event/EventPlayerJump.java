package com.alrex.parcool.common.event;

import com.alrex.parcool.common.capability.Parkourability;
import com.alrex.parcool.common.capability.Stamina;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventPlayerJump {
	@SubscribeEvent
	public static void onJump(LivingEvent.LivingJumpEvent event) {
		if (!(event.getEntity() instanceof PlayerEntity)) return;
		PlayerEntity player = (PlayerEntity) event.getEntity();
		if (!player.isLocalPlayer()) return;
		Parkourability parkourability = Parkourability.get(player);
		if (parkourability == null) return;
		Stamina stamina = Stamina.get(player);
		if (stamina == null) return;
		parkourability.getDive().onJump(player, parkourability, stamina);
	}
}