package com.hypermedia.demo.service;

import com.hypermedia.demo.exceptions.CapabilityException;
import com.hypermedia.demo.model.Capability;
import com.hypermedia.demo.repository.CapabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CapabilityService {

    private final CapabilityRepository capabilityRepository;

    public List<Capability> listCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability getCapability(String capabilityId) {
        return Optional.ofNullable(capabilityRepository.findOne(capabilityId))
                .orElseThrow(() -> new CapabilityException("Capability with ID: "+capabilityId+" Not found"));
    }

    public Capability createCapability(Capability capability) {
        return capabilityRepository.insert(capability);
    }

    public Capability updateCapability(Capability capability) {
        return Optional.ofNullable(capabilityRepository.findOne(capability.getCapabilityId()))
                .map(capability1 -> capabilityRepository.save(capability))
                .orElseGet(() -> capabilityRepository.insert(capability));
    }

    public void deleteCapability(String capabilityId) {
        capabilityRepository.delete(
                Optional.ofNullable(capabilityRepository.findOne(capabilityId))
                        .orElseThrow(() -> new CapabilityException("Capability with ID: "+capabilityId+" Not found")));
    }

}
