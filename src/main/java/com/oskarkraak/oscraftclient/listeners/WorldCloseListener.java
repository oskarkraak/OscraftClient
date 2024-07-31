package com.oskarkraak.oscraftclient.listeners;

import com.oskarkraak.oscraftclient.EventManager;

public interface WorldCloseListener extends Listener {

    void onWorldClose();

    class WorldCloseEvent extends Event {

        @Override
        public void fire() {
            for (Listener l : EventManager.LISTENERS)
                if (l instanceof WorldCloseListener)
                    ((WorldCloseListener) l).onWorldClose();
        }

    }

}
