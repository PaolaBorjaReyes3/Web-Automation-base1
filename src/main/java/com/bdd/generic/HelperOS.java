package com.bdd.generic;

public class HelperOS {

    private String osName = "os.name";

    public boolean isLinux() {
        return System.getProperty(this.osName).toLowerCase().contains("ux");
    }

    public boolean isWindows() {
        return System.getProperty(this.osName).toLowerCase().contains("win");
    }

    public boolean isMACOS() {
        return System.getProperty(this.osName).toLowerCase().contains("mac");
    }
}
