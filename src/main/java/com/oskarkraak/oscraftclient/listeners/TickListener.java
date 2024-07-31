package com.oskarkraak.oscraftclient.listeners;

import com.oskarkraak.oscraftclient.EventManager;

public interface TickListener extends Listener {

    void onTick();

    class TickEvent extends Event {

       @Override
        public void fire() {
            for (Listener l : EventManager.LISTENERS)
                if (l instanceof TickListener)
                    ((TickListener) l).onTick();
        }

    }

}
