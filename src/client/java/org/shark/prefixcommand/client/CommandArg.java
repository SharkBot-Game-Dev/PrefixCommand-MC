package org.shark.prefixcommand.client;

public class CommandArg {
    public String argName;
    public String argDescription;
    public String defaultValue;
    public String argValue;
    public boolean required;

    public CommandArg(String argInputName) {
        argName = argInputName;
    }

    public String getArgName() {
        return argName;
    }

    public String getArgDescription() {
        return argDescription;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getArgValue() {
        return argValue;
    }

    public boolean getRequired() {
        return required;
    }
}
