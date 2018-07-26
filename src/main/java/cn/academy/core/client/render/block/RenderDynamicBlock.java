package cn.academy.core.client.render.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import cn.academy.core.client.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Vanilla mc block rendering pipeline caches block rendering. If you want to render some block
 * that renders dynamically and wants to use the original IIcon approach, use this on your TileEntity.
 * @author WeAthFolD
 */
@SideOnly(Side.CLIENT)
public class RenderDynamicBlock extends TileEntitySpecialRenderer {
    
    public static RenderBlocks renderBlocks = RenderBlocks.getInstance();

    @Override
    public void renderTileEntityAt(TileEntity t, double x,
            double y, double z, float pt) {
        Block blockType = t.getBlockType();
        
        Tessellator tes = Tessellator.instance;
        tes.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        
        renderBlocks.blockAccess = t.getWorldObj();
        
        {
            if (Minecraft.isAmbientOcclusionEnabled()) {
                GL11.glShadeModel(GL11.GL_SMOOTH);
            } else {
                GL11.glShadeModel(GL11.GL_FLAT);
            }
            RenderHelper.disableStandardItemLighting();
            
            RenderUtils.loadTexture(TextureMap.locationBlocksTexture);
            
            tes.startDrawingQuads();
            tes.setTranslation(x - t.xCoord, y - t.yCoord, z - t.zCoord);
            
            renderBlocks.renderBlockAllFaces(blockType, t.xCoord, t.yCoord, t.zCoord);
            tes.setTranslation(0, 0, 0);
            tes.draw();
            
            RenderHelper.enableStandardItemLighting();
        }
    }

}