package com.hypermedia.demo.controller;

import com.hypermedia.demo.assembler.CapabilityResourceAssembler;
import com.hypermedia.demo.model.Capability;
import com.hypermedia.demo.service.CapabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/api/v1/capability")
@RequiredArgsConstructor
@CrossOrigin
public class CapabilityController {

    private final CapabilityService capabilityService;
    private final CapabilityResourceAssembler capabilityResourceAssembler;

    @GetMapping(value = "/list")
    public List<Capability> getAllCapabilities() {
        List<Capability> capabilityList = capabilityService.listCapabilities();
        for (Capability capability : capabilityList) {
            capability.add(linkTo(methodOn(CapabilityController.class).getCapabilityById(capability.getCapabilityId())).withRel("getThisCapability"));
            capability.add(linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"));
        }
        return capabilityList;
    }

    @GetMapping(value = "/{id}")
    public Resource<Capability> getCapabilityById(@PathVariable String id) {
        return capabilityResourceAssembler.toResource(capabilityService.getCapability(id));
    }

    @PostMapping
    public Resource<Capability> createCapability(@RequestBody Capability capability) {
        return capabilityResourceAssembler.toResource(capabilityService.createCapability(capability));
    }

    @PutMapping
    public Resource<Capability> updateCapability(@RequestBody Capability capability) {
        return capabilityResourceAssembler.toResource(capabilityService.updateCapability(capability));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCapability(@PathVariable String id) {
        capabilityService.deleteCapability(id);
        return ResponseEntity.ok().build();
    }
}
