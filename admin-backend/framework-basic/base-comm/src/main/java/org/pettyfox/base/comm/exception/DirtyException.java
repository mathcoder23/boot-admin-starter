package org.pettyfox.base.comm.exception;

import lombok.Getter;
import org.pettyfox.base.comm.type.BaseEnum;
import org.pettyfox.base.comm.web.RestObjectResponseCode;

@Getter
public class DirtyException extends RuntimeException {
    private int bcode;
    private int code = RestObjectResponseCode.API_ERROR_BCODE;

    public DirtyException(String message) {
        super(message);
    }

    public <T extends Enum<T>> DirtyException(BaseEnum<T, Integer> baseEnum) {
        super(baseEnum.getName());
        bcode = baseEnum.getValue();
    }

    public DirtyException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DirtyException(String message, int code, int bcode) {
        super(message);
        this.code = code;
        this.bcode = bcode;
    }
}
