package com.behzad.async.component;

import java.util.concurrent.CompletableFuture;

/**
 * Created by behzad on 5/25/17.
 */
public interface AsyncComponentInf {

    void callMe(CompletableFuture<String> p );
}
