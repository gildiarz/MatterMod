package gildiarz.mattermod.init;

import java.util.ArrayList;
import java.util.List;

import gildiarz.mattermod.blocks.BlockFluidBase;
import gildiarz.mattermod.fluids.FluidBase;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class ModFluids 
{
    //All new fluids in the mod.
    public static final List<FluidBase> FLUIDS = new ArrayList<>();
    public static final List<BlockFluidBase> FLUID_BLOCKS = new ArrayList<>();

    //Fluids!
    public static final Fluid TEST_FLUID = new FluidBase("test_fluid", Material.LAVA);


    public static void initBlocksForFluids()
    {
//        new BlockFluidBase("test_fluid", TEST_FLUID, Material.LAVA);
        for (FluidBase fluidBase : FLUIDS)
        {
            new BlockFluidBase(fluidBase.getName(), fluidBase, fluidBase.getMaterial());
        }
    }
}