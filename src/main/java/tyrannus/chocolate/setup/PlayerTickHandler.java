package tyrannus.chocolate.setup;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tyrannus.chocolate.chocolate;

public class PlayerTickHandler {
  /*  @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(TickEvent.PlayerTickEvent event)
    {
        // do client side stuff
        if (event.phase == TickEvent.Phase.START && event.player.world.isRemote) // only proceed if START phase otherwise, will execute twice per tick
        {
            EntityPlayer thePlayer = event.player;
            chocolate.proxy.handleMaterialAcceleration(thePlayer, ModBlocks.MELTED_CHOCOLATE.get().getDefaultState().getMaterial());
        }
    }*/
}
