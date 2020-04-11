package gildiarz.mattermod.fluids;

import gildiarz.mattermod.Reference;
import gildiarz.mattermod.init.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBase extends Fluid
{
    private final String fluidName;
    private final Material material;

    public FluidBase(String name, Material material)
    {
        super(
            name, 
            new ResourceLocation(Reference.MODID + ":blocks/" + name + "_still"),   
            new ResourceLocation(Reference.MODID + ":blocks/" + name + "_flow")
        );

        this.setUnlocalizedName(name);

        this.fluidName = name;
        this.material = material;

        ModFluids.FLUIDS.add(this);
    }

    public String getFluidName()
    {
        return fluidName;
    }

    public Material getMaterial()
    {
        return material;
    }
}