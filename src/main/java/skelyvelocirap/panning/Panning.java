package skelyvelocirap.panning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import skelyvelocirap.panning.setup.PanningAction;
import skelyvelocirap.panning.setup.registries.Registration;


@Mod(Panning.MODID)
public class Panning
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "panning";

    public Panning() {
    	Registration.Register();
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
		PanningAction.registerDrops();
    }
}
