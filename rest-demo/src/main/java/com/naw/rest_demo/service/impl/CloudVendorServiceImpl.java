package com.naw.rest_demo.service.impl;

import com.naw.rest_demo.exception.CloudVendorNotFoundException;
import com.naw.rest_demo.model.CloudVendor;
import com.naw.rest_demo.repository.CloudVendorRepository;
import com.naw.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);

        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        Optional<CloudVendor> cloudVendorOptional = cloudVendorRepository.findById(cloudVendorId);
        if (cloudVendorOptional.isEmpty()) {
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist.");
        }

        return cloudVendorOptional.get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String cloudVendorName) {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName(cloudVendorName);
        return cloudVendorList;
    }
}
