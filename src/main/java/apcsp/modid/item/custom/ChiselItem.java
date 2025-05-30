package apcsp.modid.item.custom;

import java.util.Map;

import apcsp.modid.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class ChiselItem extends Item{
    private static final Map<Block, Block> CHISEL_MAP =
        Map.of(
                Blocks.STONE, Blocks.STONE_BRICKS,
                Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                Blocks.OAK_LOG, ModBlocks.PINK_GARNET_BLOCK,
                Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK
        );

    public ChiselItem(Settings settings) {
        super(settings;)
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        
        if (CHISEL_MAP.containsKey(clickedBlock)) {
            
        }

        return super.useOnBlock(context);
    }
}
