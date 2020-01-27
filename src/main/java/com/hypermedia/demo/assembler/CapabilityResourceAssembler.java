package com.hypermedia.demo.assembler;

import com.hypermedia.demo.controller.CapabilityController;
import com.hypermedia.demo.model.Capability;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;



@Component
public class CapabilityResourceAssembler implements ResourceAssembler<Capability, Resource<Capability>> {

    @Override
    public Resource<Capability> toResource(Capability entity) {
        return new Resource<>(entity,
                linkTo(methodOn(CapabilityController.class).getCapabilityById(entity.getCapabilityId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities"),
                linkTo(methodOn(CapabilityController.class).deleteCapability(entity.getCapabilityId())).withRel("deleteThisCapability")
        );
    }
}
