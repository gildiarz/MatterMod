package gildiarz.mattermod.util.handlers;

import gildiarz.mattermod.MatterMod;
import gildiarz.mattermod.blocks.BlockFluidBase;
import gildiarz.mattermod.init.ModBlocks;
import gildiarz.mattermod.init.ModFluids;
import gildiarz.mattermod.init.ModItems;
import gildiarz.mattermod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler 
{
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
    {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) 
    {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
    }

    private static void registerFluids()
    {
        for(Fluid fluid : ModFluids.FLUIDS)
        {
            FluidRegistry.registerFluid(fluid);
            FluidRegistry.addBucketForFluid(fluid);
        }

	    ModFluids.initBlocksForFluids();

	    for(BlockFluidBase fluidBlock : ModFluids.FLUID_BLOCKS)
        {
            RenderHandler.registerCustomMeshesAndStates(fluidBlock, MatterMod.MODID + ":" + fluidBlock.getFluidName());
        }
    }
    
    public static void preInitRegistries(FMLPreInitializationEvent event)
    {
        registerFluids();
    }

    public static void initRegistries(FMLInitializationEvent event)
    {

    }

    public static void postInitRegistries(FMLPostInitializationEvent event)
    {
        
    }
}