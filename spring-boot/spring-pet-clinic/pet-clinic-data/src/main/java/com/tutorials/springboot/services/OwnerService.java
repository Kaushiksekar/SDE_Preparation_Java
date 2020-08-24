package com.tutorials.springboot.services;

import com.tutorials.springboot.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
