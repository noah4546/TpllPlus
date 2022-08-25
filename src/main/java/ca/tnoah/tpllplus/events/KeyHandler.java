package ca.tnoah.tpllplus.events;

import ca.tnoah.tpllplus.Main;
import ca.tnoah.tpllplus.util.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import java.awt.datatransfer.DataFlavor;
import java.util.regex.Pattern;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class KeyHandler {

    private Clipboard clipboard;
    private Pattern pattern = Pattern.compile("((\\-?|\\+?)?\\d+(\\.\\d+)?),\\s*((\\-?|\\+?)?\\d+(\\.\\d+)?)$");

    public KeyHandler() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {      
        if (KeyBindings.SEND_TPLL.isPressed()) {
            try {

                String clip = (String) clipboard.getData(DataFlavor.stringFlavor);
                Main.logger.info(clip);

                boolean match = pattern.matcher(clip).find();

                if (match) {
                    Minecraft.getMinecraft().player.sendChatMessage("/tpll " + clip);
                } else {
                    Main.logger.info("Clipboard was not a valid lat,lng");
                    Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Invalid lat,lng!"));
                }

            } catch (Exception ex) {
                Main.logger.warn(ex.getMessage());
                Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Invalid clipboard value!"));
            }
        }
    }

}
