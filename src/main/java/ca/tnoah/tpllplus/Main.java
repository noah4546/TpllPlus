package ca.tnoah.tpllplus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.tnoah.tpllplus.events.KeyHandler;
import ca.tnoah.tpllplus.proxy.CommonProxy;
import ca.tnoah.tpllplus.util.KeyBindings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = Reference.MODID,
    name = Reference.NAME,
    version = Reference.VERSION,
    useMetadata = true,
    clientSideOnly = true
)
public class Main {
    
    @Instance
    public static Main instance;

    public static final Logger logger = LogManager.getLogger(Reference.MODID);

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        
        KeyBindings.register();
        MinecraftForge.EVENT_BUS.register(new KeyHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
