package ca.tnoah.tpllplus.util;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {
    private static final String KEY_CATEGORY = "key.tpllplus.category";
    private static final String KEY_SEND = "key.tpllplus.send";

    public static final KeyBinding SEND_TPLL = new KeyBinding(KEY_SEND, KeyConflictContext.IN_GAME, Keyboard.KEY_NUMPADENTER, KEY_CATEGORY);

    public static void register() {
        ClientRegistry.registerKeyBinding(KeyBindings.SEND_TPLL);
    }
}
