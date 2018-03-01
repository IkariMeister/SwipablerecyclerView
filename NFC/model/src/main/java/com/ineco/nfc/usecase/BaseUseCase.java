package com.ineco.nfc.usecase;

/**
 * Created by jcgarcia on 17/04/2017.
 */

public interface BaseUseCase<T> {
    void execute();
    T onResponse();
}
