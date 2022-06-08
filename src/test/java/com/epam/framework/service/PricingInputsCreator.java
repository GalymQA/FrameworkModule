package com.epam.framework.service;

import com.epam.framework.model.ServerType;

public class PricingInputsCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.number.of.instances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    public static final String TESTDATA_VIRTUAL_MACHINE_CLASS = "testdata.virtual.machine.class";
    public static final String TESTDATA_INSTANCE_SERIES = "testdata.instance.series";
    public static final String TESTDATA_INSTANCE_TYPE = "testdata.instance.type";
    public static final String TESTDATA_GPU_TYPE = "testdata.GPU.type";
    public static final String TESTDATA_NUMBER_GPUs = "testdata.number.GPUs";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.SSD";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.committed.usage";

    public static ServerType withPricingInputsFromProperty() {
        return new ServerType(
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_VIRTUAL_MACHINE_CLASS),
                TestDataReader.getTestData(TESTDATA_INSTANCE_SERIES),
                TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_GPUs),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }

}
