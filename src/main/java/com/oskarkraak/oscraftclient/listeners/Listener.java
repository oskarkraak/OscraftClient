package com.oskarkraak.oscraftclient.listeners;

import com.oskarkraak.oscraftclient.EventManager;

public interface Listener {

    abstract class Event {

        public abstract void fire();

    }

}
