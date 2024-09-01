package com.naw.rest_demo.service;

import com.naw.rest_demo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);

    public String updateCloudVendor(CloudVendor cloudVendor);

    public String deleteCloudVendor(String cloudVendorId);

    public CloudVendor getCloudVendor(String cloudVendorId);

    public List<CloudVendor> getAllCloudVendors();

    public List<CloudVendor> getByVendorName(String cloudVendorName);
}
