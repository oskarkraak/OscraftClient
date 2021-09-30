package com.oskarkraak.oscraftclient.events;

import com.oskarkraak.oscraftclient.EventManager;

public interface KnockbackListener extends Listener {

    void onKnockback(KnockbackEvent event);

    class KnockbackEvent extends Event {

        private double x, y, z;

        public KnockbackEvent(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public void fire() {
            for (Listener l : EventManager.LISTENERS)
                if (l instanceof KnockbackListener)
                    ((KnockbackListener) l).onKnockback(this);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void setZ(double z) {
            this.z = z;
        }

    }

}
