package com.hypermedia.demo.service;

import com.hypermedia.demo.model.Capability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CapabilityService {

//    private final CapabilityRepository capabilityRepository;

    public List<Capability> listCapabilities() {
        return Arrays.asList(getCapability());
//        return capabilityRepository.findAll();
    }

    public Capability getCapability(String capabilityId) {
        return getCapability();
//        return Optional.ofNullable(capabilityRepository.findOne(capabilityId))
//                .orElseThrow(() -> new CapabilityException("Capability with ID: "+capabilityId+" Not found"));
    }

    public Capability createCapability(Capability capability) {
        return getCapability();
//        return capabilityRepository.insert(capability);
    }

    public Capability updateCapability(Capability capability) {
        return getCapability();
//        return Optional.ofNullable(capabilityRepository.findOne(capability.getCapabilityId()))
//                .map(capability1 -> capabilityRepository.save(capability))
//                .orElseGet(() -> capabilityRepository.insert(capability));
    }

    public void deleteCapability(String capabilityId) {
        return;
//        capabilityRepository.delete(
//                Optional.ofNullable(capabilityRepository.findOne(capabilityId))
//                        .orElseThrow(() -> new CapabilityException("Capability with ID: "+capabilityId+" Not found")));
    }

    private Capability getCapability() {
        return Capability.builder()
                .capabilityId("sample")
                .numOfAvailableDevelopers(10)
                .numOfDevelopers(25)
                .techStack("Java")
                .build();
    }

}
