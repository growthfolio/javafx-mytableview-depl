package com.example.tablefx.test;

import java.util.concurrent.CountDownLatch;

import javafx.application.Platform;

/**
 * Utility to bootstrap JavaFX in tests.
 */
public final class FxTestUtils {
    private static boolean started;

    private FxTestUtils() {
    }

    public static void launch() {
        if (started) {
            return;
        }
        CountDownLatch latch = new CountDownLatch(1);
        Platform.startup(latch::countDown);
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        started = true;
    }
}
