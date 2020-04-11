package gildiarz.mattermod.blocks;

import gildiarz.mattermod.init.ModBlocks;
import gildiarz.mattermod.init.ModFluids;
import gildiarz.mattermod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidBase extends BlockFluidClassic
{
    private String fluidName;

    public BlockFluidBase(String name, Fluid fluid, Material material) {
        super(fluid, material);

        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModFluids.FLUID_BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));

        this.fluidName = name;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) 
    {
        return EnumBlockRenderType.MODEL;
    }

    public String getFluidName()
    {
        return fluidName;
    }
}