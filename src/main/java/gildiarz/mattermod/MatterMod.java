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

@Mod(modid = MatterMod.MODID, name = MatterMod.NAME, version = MatterMod.VERSION, acceptedMinecraftVersions = MatterMod.ACCEPTED_MC_VERSIONS, dependencies = MatterMod.DEPENDENCIES)
public class MatterMod
{
	public static final String MODID = "mattermod";
	public static final String NAME = "Matter Mod";
	public static final String VERSION = "0.0.1";
	public static final String ACCEPTED_MC_VERSIONS = "[1.12.2]";
	public static final String DEPENDENCIES = "required-after:cofhcore@[4.6.0,4.7.0);required-after:thermalfoundation@[2.6.0,2.7.0);required-after:codechickenlib@[3.1.7,);before:enderio;before:immersiveengineering";

	public static final String COMMON_PROXY_CLASS = "gildiarz.mattermod.proxy.CommonProxy";
	public static final String CLINET_PROXY_CLASS = "gildiarz.mattermod.proxy.ClientProxy";

	public static Logger logger;

	public static final CreativeTabs MOD_TAB = new ModTab();

	//Enable buckets for mod fluids.
	static { FluidRegistry.enableUniversalBucket(); }

	@Instance
	public static MatterMod instance;

	@SidedProxy(serverSide = COMMON_PROXY_CLASS, clientSide = CLINET_PROXY_CLASS)
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
