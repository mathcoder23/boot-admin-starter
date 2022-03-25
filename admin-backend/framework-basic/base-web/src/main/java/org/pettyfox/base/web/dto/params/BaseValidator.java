package org.pettyfox.base.web.dto.params;

import org.pettyfox.base.comm.exception.DirtyException;

import java.io.Serializable;

public interface BaseValidator extends Serializable {

    default void validator() throws DirtyException {

    }
}
