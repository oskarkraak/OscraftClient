package com.oskarkraak.oscraftclient.events;

import com.oskarkraak.oscraftclient.EventManager;
import net.minecraft.client.util.math.MatrixStack;

public interface InGameHudRenderListener extends Listener {

    void onInGameHudRender(InGameHudRenderEvent event);

    class InGameHudRenderEvent extends Event {

        MatrixStack matrixStack;
        float tickDelta;

        public InGameHudRenderEvent(MatrixStack matrixStack, float tickDelta) {
            this.matrixStack = matrixStack;
            this.tickDelta = tickDelta;
        }

        @Override
        public void fire() {
            for (Listener l : EventManager.LISTENERS)
                if (l instanceof InGameHudRenderListener)
                    ((InGameHudRenderListener) l).onInGameHudRender(this);
        }

        public MatrixStack getMatrixStack() {
            return matrixStack;
        }

    }

}
