package gildiarz.mattermod;

import gildiarz.mattermod.creativetabs.ModTab;
import gildiarz.mattermod.proxy.CommonProxy;
import gildiarz.mattermod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MC_VERSIONS)
public class MatterMod
{
	public static Logger logger;

	public static final CreativeTabs MOD_TAB = new ModTab();

	//Enable buckets for mod fluids.
	static { FluidRegistry.enableUniversalBucket(); }

	@Instance
	public static MatterMod instance;

	@SidedProxy(serverSide = Reference.COMMON_PROXY_CLASS, clientSide = Reference.CLINET_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		logger.info("Start loading!");

		RegistryHandler.preInitRegistries(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries(event);

		logger.info("Finish loading!");
	}
}
