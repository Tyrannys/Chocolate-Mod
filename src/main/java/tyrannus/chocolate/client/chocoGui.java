package tyrannus.chocolate.client;

import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraftforge.client.event.GuiContainerEvent;

import javax.swing.text.JTextComponent;

public class chocoGui extends GuiContainerEvent {
    public chocoGui(ContainerScreen guiContainer) {
        super(guiContainer);
    }

    public void openGui() {
       // new JTextComponent.KeyBinding("Chocolate Gui", 221, "misc");
    }

    //public KeyBinding(String description, int keyCode, String category) {
    //      this(description, InputMappings.Type.KEYSYM, keyCode, category);
    //   }
}
