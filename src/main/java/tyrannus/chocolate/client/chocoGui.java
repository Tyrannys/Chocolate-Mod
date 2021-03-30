package tyrannus.chocolate.client;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.event.GuiContainerEvent;

public class chocoGui extends GuiContainerEvent {
    public chocoGui(ContainerScreen guiContainer) {
        super(guiContainer);
    }

    public void openGui() {
        new KeyBinding("Chocolate Gui", 221, "misc");
    }

    //public KeyBinding(String description, int keyCode, String category) {
    //      this(description, InputMappings.Type.KEYSYM, keyCode, category);
    //   }
}
