package lance5057.tDefense.armor.renderers.heavy;

import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersBreastplate extends ArmorRenderer
{
	public ModelRenderer	BackPlate;
	public ModelRenderer	BreastPlate;
	public ModelRenderer	Plackart;
	public ModelRenderer	PauldronR;
	public ModelRenderer	ArmGuardR;
	public ModelRenderer	PauldronL;
	public ModelRenderer	ArmGuardL;
	public ModelRenderer	ArmL;
	public ModelRenderer	ArmR;
	public ModelRenderer	BreastPlateFront;

	public ModelTinkersBreastplate()
	{
		super(1f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.BreastPlate = new ModelRenderer(this, 0, 32);
		this.BreastPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BreastPlate.addBox(-4.0F, 0.1F, -3.6F, 8, 6, 4, 0.1F);
		this.bipedBody.addChild(this.BreastPlate);

		this.BreastPlateFront = new ModelRenderer(this, 22, 56);
		this.BreastPlateFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BreastPlateFront.addBox(-3.0F, 0.5F, -4.2F, 6, 4, 4, 0.1F);
		this.bipedBody.addChild(this.BreastPlateFront);

		this.Plackart = new ModelRenderer(this, 0, 42);
		this.Plackart.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Plackart.addBox(-4.0F, 5.0F, -3.0F, 8, 7, 6, 0.01F);
		this.bipedBody.addChild(this.Plackart);

		this.ArmGuardR = new ModelRenderer(this, 28, 44);
		this.ArmGuardR.mirror = true;
		this.ArmGuardR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ArmGuardR.addBox(-4.0F, -2.0F, -3.0F, 5, 6, 6, 0.0F);
		this.bipedRightArm.addChild(this.ArmGuardR);

		this.ArmGuardL = new ModelRenderer(this, 28, 44);
		this.ArmGuardL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ArmGuardL.addBox(-1.0F, -2.0F, -3.0F, 5, 6, 6, 0.0F);
		this.bipedLeftArm.addChild(this.ArmGuardL);

		this.PauldronR = new ModelRenderer(this, 24, 32);
		this.PauldronR.mirror = true;
		this.PauldronR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.PauldronR.addBox(-4.6F, -2.0F, -3.5F, 4, 5, 7, 0.0F);
		this.setRotateAngle(PauldronR, 0.0F, -0.0F, 0.4363323129985824F);
		this.bipedRightArm.addChild(this.PauldronR);

		this.ArmL = new ModelRenderer(this, 48, 34);
		this.ArmL.mirror = true;
		this.ArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ArmL.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.1F);
		this.setRotateAngle(ArmL, 0.0F, 0.0F, 0.0017453292519943296F);
		this.bipedLeftArm.addChild(this.ArmL);

		this.ArmR = new ModelRenderer(this, 48, 34);
		this.ArmR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ArmR.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.1F);
		this.bipedRightArm.addChild(this.ArmR);

		this.BackPlate = new ModelRenderer(this, 0, 56);
		this.BackPlate.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BackPlate.addBox(-4.0F, 0.0F, 1.0F, 8, 5, 3, 0.0F);
		this.setRotateAngle(BackPlate, -0.08726646006107329F, -0.0F, 0.0F);
		this.bipedBody.addChild(this.BackPlate);

		this.PauldronL = new ModelRenderer(this, 24, 32);
		this.PauldronL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.PauldronL.addBox(0.5F, -2.0F, -3.5F, 4, 5, 7, 0.0F);
		this.setRotateAngle(PauldronL, 0.0F, -0.0F, -0.4363323129985824F);
		this.bipedLeftArm.addChild(this.PauldronL);

		// this.ArmR.offsetX = this.ArmR.offsetX + 0.04f;

		this.bipedHead.isHidden = true;
		this.bipedHeadwear.isHidden = true;
		this.bipedCloak.isHidden = true;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		for(int i = 0; i < 10; i++)
		{
			String texture = ((ArmorCore) this.stack.getItem()).getTexture(i, stack);
			if(texture != "")
			{

				GL11.glPushMatrix();

				((ArmorCore) this.stack.getItem()).renderArmor(entity, f, f1, f2, f3, f4, f5, colors, stack, i);
				super.render(entity, f, f1, f2, f3, f4, f5);

				GL11.glPopMatrix();
			}
		}

		GL11.glPopMatrix();
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
