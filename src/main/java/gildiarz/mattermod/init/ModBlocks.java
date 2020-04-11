package gildiarz.mattermod.init;

import java.util.ArrayList;
import java.util.List;

import gildiarz.mattermod.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class ModBlocks 
{
    //All new blocks in the mod.
    public static final List<Block> BLOCKS = new ArrayList<>();

    //Blocks!
    public static final Block TEST_BLOCK = new BlockBase("test_block", Material.ROCK);
}