package tyrannus.chocolate.setup;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class PlayerTickHandler {
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(TickEvent.PlayerTickEvent event)
    {
        // do client side stuff
        if (event.phase == TickEvent.Phase.START && event.player.isLocalPlayer()) // only proceed if START phase otherwise, will execute twice per tick
        {
            Player thePlayer = event.player;

        }
    }
}
