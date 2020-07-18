package com.neusoft.wallet.common.base;

import java.io.Serializable;

public interface BaseEntity<E extends Serializable> extends Serializable {
    E getId();
}
