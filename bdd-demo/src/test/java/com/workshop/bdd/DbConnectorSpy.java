package com.workshop.bdd;

public class DbConnectorSpy extends DbConnector {
    private boolean connectDbCalled = false;

    @Override
    public Object connectDb() {
        connectDbCalled = true;
        return null;
    }

    public boolean isConnectDbCalled() {
        return connectDbCalled;
    }

    public void setConnectDbCalled(boolean connectDbCalled) {
        this.connectDbCalled = connectDbCalled;
    }
}
