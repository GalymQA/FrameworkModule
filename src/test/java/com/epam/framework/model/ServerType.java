package com.epam.framework.model;

public class ServerType {

    private final String numberOfInstances;
    private final String operatingSystem;
    private final String virtualMachineClass;
    private final String instanceSeries;
    private final String instanceType;
    private final String GPUType;
    private final String numberGPUs;
    private final String localSSD;
    private final String datacenterLocation;
    private final String committedUsage;

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getVirtualMachineClass() {
        return virtualMachineClass;
    }

    public String getInstanceSeries() {
        return instanceSeries;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getGPUType() {
        return GPUType;
    }

    public String getNumberGPUs() {
        return numberGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public ServerType(String numberOfInstances,
                      String operatingSystem,
                      String virtualMachineClass,
                      String instanceSeries,
                      String instanceType,
                      String GPUType,
                      String numberGPUs,
                      String localSSD,
                      String datacenterLocation,
                      String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.virtualMachineClass = virtualMachineClass;
        this.instanceSeries = instanceSeries;
        this.instanceType = instanceType;
        this.GPUType = GPUType;
        this.numberGPUs = numberGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

}
